     package de.dafeist.ucaddons;
     
     import java.io.File;
     import net.minecraftforge.common.MinecraftForge;
     import net.minecraftforge.common.config.Configuration;
     import net.minecraftforge.fml.client.event.ConfigChangedEvent;
     import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
     
     public class ConfigHandler
     {
       public static Configuration config;
       
       public ConfigHandler(File configFile) {
       MinecraftForge.EVENT_BUS.register(this);
       config = UCAddons.config;
       config.load();
       redefineConfigs();
       }
       
       public static void redefineConfigs() {
      if (config.hasChanged())
         config.save(); 
       }
       
       @SubscribeEvent
       public void onConfigurationChangedEvent(ConfigChangedEvent.OnConfigChangedEvent event) {
       if (event.getModID().equalsIgnoreCase("ucaddons"))
         redefineConfigs(); 
       }
       public static void init(Configuration config) {
       config.load();
       config.getBoolean("showHKasse", "house", false, "Zeigt die HKasse an wenn ein Haus registriert ist");
       config.getBoolean("showDrugLager", "house", false, "Zeigt das DrugLager an wenn ein Haus registriert ist");
       config.getBoolean("cordChecker", "house", false, "Nur aktivieren wenn du showHKasse oder showDrugLager brauchst");
       config.getBoolean("AltF4Command", "Fun", false, "Crasht das Game sofort wenn man den Command ausfuehrt");
       
         
       config.save();
       }
     }
