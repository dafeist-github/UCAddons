       package de.dafeist.ucaddons;
     
       import java.io.IOException;
       import java.security.InvalidAlgorithmParameterException;
       import java.security.InvalidKeyException;
       import java.security.NoSuchAlgorithmException;
       import java.security.spec.InvalidKeySpecException;
import java.util.ArrayList;
import java.util.HashMap;

import javax.crypto.BadPaddingException;
       import javax.crypto.IllegalBlockSizeException;
       import javax.crypto.NoSuchPaddingException;

import de.dafeist.ucaddons.GUI.renderGUIHandler;
import de.dafeist.ucaddons.Thread.ControlPanel;
import de.dafeist.ucaddons.utils.ControlPanelUtils;
import de.dafeist.ucaddons.utils.FactionUtils;
import de.dafeist.ucaddons.utils.HouseUtils;
import de.dafeist.ucaddons.utils.Logger;
import de.dafeist.ucaddons.utils.Utils;
import net.minecraft.client.Minecraft;
       import net.minecraft.client.tutorial.TutorialSteps;
       import net.minecraftforge.common.MinecraftForge;
       import net.minecraftforge.common.config.Configuration;
       import net.minecraftforge.fml.common.Loader;
       import net.minecraftforge.fml.common.Mod;
       import net.minecraftforge.fml.common.Mod.EventHandler;
       import net.minecraftforge.fml.common.Mod.Instance;
       import net.minecraftforge.fml.common.event.FMLInitializationEvent;
       import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
       import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import scala.Int;
       
       @Mod(modid = "ucaddons", name = "UCAddons", version = "1.0.6", clientSideOnly = true, acceptedMinecraftVersions = "[1.12.2]")
       public class UCAddons {
       public static boolean FirstServerJoin = true;
       public static final String MODID = "ucaddons";
       public static final String NAME = "UCAddons";
       public static final String VERSION = "1.0.6";
       public static HashMap<Int, ArrayList> houseCoordsMap = new HashMap<Int, ArrayList>();
       public static ArrayList house1 = new ArrayList();
       public static Configuration config;
       
       @Instance
       private static UCAddons instance;
       
       public static UCAddons getInstance() {
       return instance;
       }
       
       @EventHandler
       public void preinit(FMLPreInitializationEvent event) throws InvalidKeyException, NoSuchAlgorithmException, InvalidKeySpecException, NoSuchPaddingException, InvalidAlgorithmParameterException, IllegalBlockSizeException, BadPaddingException, IOException {
       Logger.LOGGER.info("Started UCAddons preinit");
       Logger.LOGGER.info("Loading Config");
       config = new Configuration(event.getSuggestedConfigurationFile());
       ConfigHandler.init(config);
       ControlPanelUtils.init();
       MedicUtils.init();
       FactionUtils.init();
       }
       
       @EventHandler
       public void init(FMLInitializationEvent event) {
    	   try {
       Logger.LOGGER.info("Started UCAddons init");
       Logger.LOGGER.info("Searching for compatible Mods");
       if (Loader.isModLoaded("ucutils")) {
         Utils.UCUtilsActivated = true;
         Logger.LOGGER.info("Found UCUtils, Compatibility activated!");
         }

    	   } catch(Exception e) {
    		   e.printStackTrace();
    	   }
       }
       
       @EventHandler
       public void postinit(FMLPostInitializationEvent event) throws IOException {
       Logger.LOGGER.info("Started UCAddons postinit");
       Minecraft.getMinecraft().getTutorial().setStep(TutorialSteps.NONE);
       Logger.LOGGER.info("Registering Events");
       MinecraftForge.EVENT_BUS.register(new renderGUIHandler());
       MinecraftForge.EVENT_BUS.register(new de.dafeist.ucaddons.EventHandler());
       HouseUtils.init();
       Logger.LOGGER.info("Registering Commands");
       CommandHandler.init();
       ControlPanel.init();
       }
     }
