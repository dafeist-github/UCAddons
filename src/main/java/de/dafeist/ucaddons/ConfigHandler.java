     package de.dafeist.ucaddons;

import de.dafeist.ucaddons.utils.Logger;
import net.minecraftforge.common.config.Config;
import net.minecraftforge.common.config.ConfigManager;
import net.minecraftforge.fml.client.event.ConfigChangedEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

	 @Config(modid = UCAddons.MODID, name = UCAddons.NAME)
	 @Mod.EventBusSubscriber
     public class ConfigHandler {
    	 
		 @Config.Name("showHKasse")
		 @Config.Comment("Zeigt die HKasse an wenn ein Haus registriert ist")
		 public static boolean showHKasse = false;
		 
		 @Config.Name("showDrugLager")
		 @Config.Comment("Zeigt das DrugLager an wenn ein Haus registriert ist")
		 public static boolean showDrugLager = false;
		 
		 @Config.Name("cordChecker")
		 @Config.Comment("Nur aktivieren wenn du showHKasse oder showDrugLager brauchst")
		 public static boolean cordChecker = false;
		 
		 @Config.Name("AltF4Command")
		 @Config.Comment("Crasht das Game sofort wenn man den Command ausfuehrt")
		 public static boolean AltF4Command = false;
		 
		 @Config.Name("AnzeigeViolett")
		 @Config.Comment("Hiermit wird die Farbe der Anzeige zu Violett gesetzt")
		 public static boolean PurpleGUI = false;
		 
		    @SubscribeEvent
		    public static void onConfigChange(ConfigChangedEvent event) {
		    	Logger.LOGGER.info("Detected Config change, reloading...");
		    	ConfigManager.sync(UCAddons.MODID, Config.Type.INSTANCE);
     		}
	 }
		  
