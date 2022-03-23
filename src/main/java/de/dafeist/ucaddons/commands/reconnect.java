     package de.dafeist.ucaddons.commands;
     
     import java.util.ArrayList;
     import java.util.List;

import de.dafeist.ucaddons.utils.Logger;
import de.dafeist.ucaddons.utils.Utils;
import net.minecraft.client.Minecraft;
     import net.minecraft.client.gui.GuiMainMenu;
     import net.minecraft.client.gui.GuiScreen;
     import net.minecraft.client.multiplayer.GuiConnecting;
     import net.minecraft.client.multiplayer.ServerData;
     import net.minecraft.command.CommandBase;
     import net.minecraft.command.CommandException;
     import net.minecraft.command.ICommand;
     import net.minecraft.command.ICommandSender;
     import net.minecraft.server.MinecraftServer;
     import net.minecraft.util.math.BlockPos;
     import net.minecraft.util.text.ITextComponent;
     import net.minecraft.util.text.TextComponentString;
     
     public class reconnect extends CommandBase {
		   @Override
       public String getName() {
       return "reconnect";
       }
     
       @Override
       public String getUsage(ICommandSender sender) {
       return "/reconnect";
       }
     
       
       public List<String> getCommandAliases() {
       List<String> list = new ArrayList<>();
       return list;
       }
     
       
       public void execute(MinecraftServer server, ICommandSender sender, String[] args) throws CommandException {
       ServerData SVD = Minecraft.getMinecraft().getCurrentServerData();
       if (Minecraft.getMinecraft().isSingleplayer()) {
    	   
         Minecraft.getMinecraft().player.sendMessage((ITextComponent)new TextComponentString(Utils.prefix + " Reconnect funktioniert nur im Multiplayer-Modus"));
         } else {
         Minecraft.getMinecraft().displayGuiScreen((GuiScreen)new GuiConnecting((GuiScreen)new GuiMainMenu(), Minecraft.getMinecraft(), SVD));
         Logger.LOGGER.info("Reconnected the current Server");
         } 
       }
     
       
       public boolean checkPermission(MinecraftServer server, ICommandSender sender) {
       return true;
       }
     
       
       public List<String> getTabCompletionOptions(MinecraftServer server, ICommandSender sender, String[] args, BlockPos targetPos) {
       List<String> list = new ArrayList<>();
       return null;
       }
     
       
       public boolean isUsernameIndex(String[] args, int index) {
       return false;
       }
     
       
       public int compareTo(ICommand o) {
       return 0;
       }
     }

 