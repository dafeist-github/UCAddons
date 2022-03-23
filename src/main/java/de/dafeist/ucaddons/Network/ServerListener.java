     package de.dafeist.ucaddons.Network;
     
     import java.io.DataInputStream;
     import java.io.DataOutputStream;
     import java.io.IOException;
     import java.net.Socket;
     import java.net.UnknownHostException;

import de.dafeist.ucaddons.UCAddons;
import de.dafeist.ucaddons.utils.Logger;
import net.minecraft.client.Minecraft;
     
     public class ServerListener
       extends Thread
     {
       public void run() {
         try {
         Logger.LOGGER.info("Connecting to the UCAddons Server");
         Socket client = new Socket("45.81.235.216", 1001);
         DataOutputStream out = new DataOutputStream(client.getOutputStream());
         out.writeUTF("L: " + (Minecraft.getMinecraft()).player.getUniqueID() + " " + (Minecraft.getMinecraft()).player.getDisplayNameString() + UCAddons.VERSION);
         out.flush();
           while (true) {
           Thread.sleep(800L);
           DataInputStream in = new DataInputStream(client.getInputStream());
           if (in.read() == -1) {
             in.close();
               break;
             } 
           if (in.readUTF().equals("Registration accepted")) {
             Logger.LOGGER.info("Registration accepted");
             }
           in.close();
           out.close();
           client.close();
           } 
       } catch (UnknownHostException e) {
         Logger.LOGGER.warn("Couldnt connect to the UCAddons Server: Unknown Host");
       } catch (IOException e) {
    	 Logger.LOGGER.warn("Couldnt connect to the UCAddons Server: IOException");
       } catch (InterruptedException e) {
    	 Logger.LOGGER.warn("Couldnt connect to the UCAddons Server: InterruptedException");
         } 
       }
     }
