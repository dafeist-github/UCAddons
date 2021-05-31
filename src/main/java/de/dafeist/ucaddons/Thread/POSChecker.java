     package de.dafeist.ucaddons.Thread;
     
     import com.google.gson.stream.JsonReader;

import de.dafeist.ucaddons.UCAddons;

import java.io.File;
     import java.io.FileReader;
     import net.minecraft.client.Minecraft;
     import net.minecraftforge.common.config.Configuration;
     import org.apache.commons.io.FileUtils;

     public class POSChecker extends Thread {
       public void run() {
       File file = new File((Minecraft.getMinecraft()).mcDataDir + "\\UCAddons\\House.json");
         while (true) {
           try {
           Thread.sleep(500);
           JsonReader reader = new JsonReader(new FileReader(file));
           String X = String.valueOf((Minecraft.getMinecraft()).player.getPosition().getX());
           String Y = String.valueOf((Minecraft.getMinecraft()).player.getPosition().getY());
           String Z = String.valueOf((Minecraft.getMinecraft()).player.getPosition().getZ());
           String LF = FileUtils.readFileToString(file);
           if (LF.contains("X" + X) && LF.contains("Y" + Y) && LF.contains("Z" + Z)) {
             Configuration config = UCAddons.config;
             config.load();
             if (config.getBoolean("showHKasse", "house", false, "Zeigt die HKasse an wenn ein Haus registriert ist") == true) {
               (Minecraft.getMinecraft()).player.sendChatMessage("/hkasse");
               }
             if (config.getBoolean("showDrugLager", "house", false, "Zeigt das DrugLager an wenn ein Haus registriert ist") == true) {
               (Minecraft.getMinecraft()).player.sendChatMessage("/drogenlager");
               }
             Thread.sleep(30000L);
             } 
           reader.close();
         } catch (InterruptedException|java.io.IOException e) {
           e.printStackTrace();
           } 
         } 
       }
     }


