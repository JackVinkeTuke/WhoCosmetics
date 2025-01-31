package mc.craig.software.cosmetics.forge.data;

import mc.craig.software.cosmetics.WhoCosmetics;
import mc.craig.software.cosmetics.common.WCBlocks;
import mc.craig.software.cosmetics.common.WCItems;
import net.minecraft.data.DataGenerator;
import net.minecraftforge.common.data.LanguageProvider;

public class LangProviderEnglish extends LanguageProvider {

    public LangProviderEnglish(DataGenerator gen) {
        super(gen, WhoCosmetics.MOD_ID, "en_us");
    }

    @Override
    protected void addTranslations() {
        add(WCItems.BOW_TIE.get(), "Bowtie");
        add(WCItems.FEZ.get(), "Fez");
        add(WCItems.ANTLERS.get(), "Antlers");
        add(WCItems.ASTRAKHAN.get(), "Astrakhan");
        add(WCItems.CELERY.get(), "Stick of Celery");
        add(WCItems.CRICKET_JACKET.get(), "Cricket Jacket");
        add(WCItems.EYE_STALK.get(), "Dalek Eyestalk");
        add(WCItems.FEATHER_HAT.get(), "Feather Hat");
        add(WCItems.FRUIT_HAT.get(), "Fruit Hat");
        add(WCItems.GASMASK.get(), "Gasmask");
        add(WCItems.MAGNOLI.get(), "Magnoli Glasses");
        add(WCItems.MONDAS.get(), "Mondas Cyber-Helmet");
        add(WCItems.RAINBOW_SCARF.get(), "Rainbow Scarf");
        add(WCItems.RED_SCARF.get(), "Red Scarf");
        add(WCItems.SASH.get(), "Sash of Rassilon");
        add(WCItems.SATCHEL.get(), "Satchel");
        add(WCItems.SECOND_JACKET.get(), "Smart Jacket");
        add(WCItems.VELVET_COAT.get(), "Velvet Jacket");
        add(WCItems.THREED_GLASSES.get(), "Glasses");
        add(WCItems.STRAW_HAT.get(), "Straw Hat");
        add(WCItems.STETSON.get(), "Stetson");
        add(WCItems.SCARF.get(), "Scarf");
        add(WCItems.TENTH_COAT.get(), "Trenchcoat");
        add(WCItems.RAINBOW_COAT.get(), "Rainbow Coat");
        add(WCItems.ACES_BAT.get(), "Ace's Bat");
        add(WCItems.UMBRELLA_MISSY.get(), "Umbrella");
        add(WCItems.UMBRELLA.get(), "Umbrella");

        add(WCItems.SONIC_10.get(), "Sonic Screwdriver");
        add(WCItems.SONIC_12.get(), "Sonic Screwdriver");
        add(WCItems.SONIC_13.get(), "Sonic Screwdriver");
        add(WCItems.SONIC_RIVER.get(), "Sonic Screwdriver");
        add(WCItems.SONIC_TROWEL.get(), "Sonic Trowel");
        add(WCItems.TOP_HAT.get(), "Top Hat");

        add(WCItems.SPACE_FEET.get(), "Spacesuit (Feet)");
        add(WCItems.SPACE_HELMET.get(), "Spacesuit (Helmet)");
        add(WCItems.SPACE_LEGS.get(), "Spacesuit (Legs)");
        add(WCItems.SPACE_CHEST.get(), "Spacesuit (Chest)");

        add(WCBlocks.CORAL_CHAIR.get(), "Coral Chair");


        add("itemGroup.whocosmetics.whocosmetics", "WhoCosmetics");
        add("itemGroup.whocosmetics", "WhoCosmetics");
    }
}
