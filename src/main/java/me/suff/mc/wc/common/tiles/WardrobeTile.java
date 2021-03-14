package me.suff.mc.wc.common.tiles;

import io.netty.buffer.Unpooled;
import me.suff.mc.wc.common.WCTiles;
import net.minecraft.block.BlockState;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.ISidedInventory;
import net.minecraft.inventory.ItemStackHelper;
import net.minecraft.inventory.container.Container;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.network.NetworkManager;
import net.minecraft.network.PacketBuffer;
import net.minecraft.network.play.server.SUpdateTileEntityPacket;
import net.minecraft.tileentity.ITickableTileEntity;
import net.minecraft.tileentity.LockableLootTileEntity;
import net.minecraft.util.Direction;
import net.minecraft.util.NonNullList;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.StringTextComponent;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.items.CapabilityItemHandler;
import net.minecraftforge.items.IItemHandler;
import net.minecraftforge.items.wrapper.SidedInvWrapper;

import javax.annotation.Nullable;
import java.util.stream.IntStream;

public class WardrobeTile extends LockableLootTileEntity implements ISidedInventory, ITickableTileEntity {
    private NonNullList< ItemStack > stacks = NonNullList.withSize(9, ItemStack.EMPTY);
    private float openAmount = 0.0F;
    private boolean isOpen = false;

    public WardrobeTile() {
        super(WCTiles.WARDROBE.get());
    }


    public float getOpenAmount() {
        return openAmount;
    }

    public boolean isOpen() {
        return isOpen;
    }

    public void setOpen(boolean open) {
        isOpen = open;
        sendUpdates();
    }

    public void sendUpdates() {
        world.updateComparatorOutputLevel(pos, getBlockState().getBlock());
        world.notifyBlockUpdate(pos, world.getBlockState(pos), world.getBlockState(pos), 3);
        markDirty();
    }

    @Override
    public SUpdateTileEntityPacket getUpdatePacket() {
        return new SUpdateTileEntityPacket(this.pos, 8, this.getUpdateTag());
    }

    @Override
    public CompoundNBT getUpdateTag() {
        return this.write(new CompoundNBT());
    }

    @Override
    public void onDataPacket(NetworkManager net, SUpdateTileEntityPacket pkt) {
        this.read(getBlockState(), pkt.getNbtCompound());
    }

    @Override
    public int getSizeInventory() {
        return stacks.size();
    }

    @Override
    public boolean isEmpty() {
        for (ItemStack itemstack : this.stacks)
            if (!itemstack.isEmpty())
                return false;
        return true;
    }

    @Override
    public int getInventoryStackLimit() {
        return 64;
    }

    @Override
    public Container createMenu(int id, PlayerInventory player) {
        return new WardrobeContainer(id, player, new PacketBuffer(Unpooled.buffer()).writeBlockPos(this.getPos()));
    }

    @Override
    public ITextComponent getDisplayName() {
        return new StringTextComponent("Wardrobe");
    }

    @Override
    protected ITextComponent getDefaultName() {
        return null;
    }

    @Override
    protected NonNullList< ItemStack > getItems() {
        return this.stacks;
    }

    @Override
    protected void setItems(NonNullList< ItemStack > stacks) {
        this.stacks = stacks;
    }

    @Override
    public boolean isItemValidForSlot(int index, ItemStack stack) {
        return true;
    }

    @Override
    public int[] getSlotsForFace(Direction side) {
        return IntStream.range(0, this.getSizeInventory()).toArray();
    }

    @Override
    public boolean canInsertItem(int index, ItemStack stack, @Nullable Direction direction) {
        return this.isItemValidForSlot(index, stack);
    }

    @Override
    public boolean canExtractItem(int index, ItemStack stack, Direction direction) {
        return true;
    }

    private final LazyOptional< ? extends IItemHandler >[] handlers = SidedInvWrapper.create(this, Direction.values());

    @Override
    public < T > LazyOptional< T > getCapability(Capability< T > capability, @Nullable Direction facing) {
        if (!this.removed && facing != null && capability == CapabilityItemHandler.ITEM_HANDLER_CAPABILITY)
            return handlers[facing.ordinal()].cast();
        return super.getCapability(capability, facing);
    }

    @Override
    public void remove() {
        super.remove();
        for (LazyOptional< ? extends IItemHandler > handler : handlers)
            handler.invalidate();
    }

    @Override
    public void read(BlockState state, CompoundNBT nbt) {
        isOpen = nbt.getBoolean("isOpen");
        openAmount = nbt.getFloat("openAmount");
        if (!this.checkLootAndRead(nbt)) {
            this.stacks = NonNullList.withSize(this.getSizeInventory(), ItemStack.EMPTY);
        }
        ItemStackHelper.loadAllItems(nbt, this.stacks);
        super.read(state, nbt);
    }

    @Override
    public CompoundNBT write(CompoundNBT compound) {
        compound.putBoolean("isOpen", isOpen);
        compound.putFloat("openAmount", openAmount);
        if (!this.checkLootAndWrite(compound)) {
            ItemStackHelper.saveAllItems(compound, this.stacks);
        }
        return super.write(compound);
    }


    @Override
    public void tick() {
        if (isOpen) {
            this.openAmount += 0.1F;
        } else {
            this.openAmount -= 0.1F;
        }

        if (this.openAmount > 1.0F) {
            this.openAmount = 1.0F;
        }

        if (this.openAmount < 0.0F) {
            this.openAmount = 0.0F;
        }
    }


}
