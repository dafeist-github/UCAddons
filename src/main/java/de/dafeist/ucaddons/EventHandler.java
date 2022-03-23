package de.dafeist.ucaddons;
     
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import com.google.gson.Gson;

import de.dafeist.ucaddons.Network.ServerListener;
import de.dafeist.ucaddons.Thread.POSChecker;
import de.dafeist.ucaddons.utils.FactionUtils;
import de.dafeist.ucaddons.utils.FormatUtils;
import de.dafeist.ucaddons.utils.Logger;
import de.dafeist.ucaddons.utils.UCAddonsUpdater;
import de.dafeist.ucaddons.utils.Utils;
import net.minecraft.client.Minecraft;
import net.minecraft.client.tutorial.TutorialSteps;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextComponentString;
import net.minecraftforge.client.event.ClientChatEvent;
import net.minecraftforge.client.event.ClientChatReceivedEvent;
import net.minecraftforge.client.event.RenderLivingEvent;
import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.event.entity.EntityJoinWorldEvent;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
      
      public class EventHandler {
        @SubscribeEvent
        public void chatReadEngine(ClientChatReceivedEvent event) throws IOException {
        	if(event.getMessage().getUnformattedText().endsWith("Dein Tazer ist nun nicht mehr bereit!") || event.getMessage().getUnformattedText().endsWith("Dein Tazer muss sich noch aufladen...")) {
        		if(Utils.TazerEnabled == false && FactionUtils.isCopOrFBI == true) {
        			Utils.TazerEnabled = true;
        		} else if(Utils.TazerEnabled == true && FactionUtils.isCopOrFBI == true) {
        			Utils.TazerEnabled = false;
        		}
        	}
        }
        
        @SubscribeEvent
        public void onMessageSend(ClientChatEvent event) throws IOException {
        	if(event.getMessage().equalsIgnoreCase("/tazer") && Utils.TazerEnabled == false && FactionUtils.isCopOrFBI == true) {
        		Utils.TazerEnabled = true;
        	} else if(event.getMessage().equalsIgnoreCase("/tazer") && Utils.TazerEnabled == true && FactionUtils.isCopOrFBI == true) {
        		Utils.TazerEnabled = false;
        	} else if(event.getMessage().contains("/fbank drop")) {
        		if(Integer.valueOf(FormatUtils.extractNumber(event.getMessage().toString())) > 1000) {
        			(Minecraft.getMinecraft()).player.sendMessage((ITextComponent)new TextComponentString(Utils.prefix + "Du solltest maximal in 1000er Schritten in die fbank einzahlen"));
        			event.setMessage("/");
        			event.setCanceled(true);
        		}
        	} else if(Utils.geknebelt == true && !event.getMessage().startsWith("/")) {
        		event.setMessage("/w " + event.getMessage());
        	}
        }
        
        
        @SubscribeEvent
        public void onServerLoginEvent(EntityJoinWorldEvent event) {
            if (UCAddons.FirstServerJoin == true) {
 	        Logger.LOGGER.info("Checking for Updates...");
 	        try {
 				 Logger.LOGGER.info("Searching for UCAddons Updates...");
 				 final String USER_AGENT = "Mozilla/5.0";
 				 System.setProperty("javax.net.ssl.trustStorePassword", "changeit");
 				 Connection.Response Page = Jsoup.connect("https://dafeist.de/UCAddonsVersionCheck.php")
 						 .sslSocketFactory(CertFix.socketFactory())
 						 .ignoreHttpErrors(true)
 				         .method(Connection.Method.POST)  
 				         .userAgent(USER_AGENT)  
 				         .execute(); 
 				Document html = Page.parse();
 				String latestVersionString = html.selectFirst("body").parent().children().text();
 				String currentVersionString = UCAddons.VERSION;
 				latestVersionString = latestVersionString.replace(".", "");
 				currentVersionString = currentVersionString.replace(".", "");
 				int latestVersion = Integer.parseInt(latestVersionString);
 				int currentVersion = Integer.parseInt(currentVersionString);
 				if(latestVersion > currentVersion) {
 					Logger.LOGGER.info("UCAddons Update found, downloading Update...");
 					Connection.Response Page2 = Jsoup.connect("https://dafeist.de/ucaddonschangelog.php")
							 .sslSocketFactory(CertFix.socketFactory())
	 						 .ignoreHttpErrors(true)
	 				         .method(Connection.Method.POST)  
	 				         .userAgent(USER_AGENT)  
	 				         .execute(); 
	 				Document html2 = Page2.parse();
	 				String changelog = html2.text();
					(Minecraft.getMinecraft()).player.sendMessage((ITextComponent)new TextComponentString(Utils.prefix + changelog));
 					UCAddonsUpdater.update();
 					Utils.lockUpdater = true;
 				} else {
 					Logger.LOGGER.info("UCAddons is already up to date, latest version: " + latestVersionString);
 				}
 	       } catch(Exception e) {
 	    	   e.printStackTrace();
 	       }
 				
        	try {
               UCAddons.FirstServerJoin = false;
	         ServerListener serverListener = new ServerListener();
	 	        serverListener.start();
 	     Minecraft.getMinecraft().getTutorial().setStep(TutorialSteps.NONE);
	      if (Minecraft.getMinecraft().isSingleplayer()) {
            return;
          }
	     if (event.getEntity().getDisplayName().equals((Minecraft.getMinecraft()).player.getDisplayName()) && event.getEntity() instanceof net.minecraft.entity.player.EntityPlayer) {
 	        if ((Minecraft.getMinecraft().getCurrentServerData()).serverIP.equalsIgnoreCase("unicacity.de")) {
 	          Utils.onUnicaCity = true;
	        } else if ((Minecraft.getMinecraft().getCurrentServerData()).serverIP.equalsIgnoreCase("server.unicacity.de")) {
	        Utils.onUnicaCity = true;
	        } else {
            Utils.onUnicaCity = false;
            } 
 	      if (Utils.onUnicaCity == true) {
 	        if (ConfigHandler.cordChecker == true) {
 	          POSChecker pOSChecker = new POSChecker();
 	          pOSChecker.start();
              } 
 	      } 
	     }
        	} catch(Exception e) {
	        	e.printStackTrace();
	        }
            }
        }
        
        
        @SubscribeEvent
        public void NameFormatEvent(PlayerEvent.NameFormat event) {
        	if(event.getEntity().getName().contains("DaFeist")) {
        		//event.setDisplayname("§6[§4UCAddons§6]§2 DaFeist");
        	}
        }
        
      }

