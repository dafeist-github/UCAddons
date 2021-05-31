     package de.dafeist.ucaddons.commands;
     
     import java.io.IOException;
     import java.util.ArrayList;
     import java.util.List;

import de.dafeist.ucaddons.utils.HouseUtils;
import de.dafeist.ucaddons.utils.Utils;
import net.minecraft.client.Minecraft;
     import net.minecraft.command.CommandBase;
     import net.minecraft.command.ICommand;
     import net.minecraft.command.ICommandSender;
     import net.minecraft.server.MinecraftServer;
     import net.minecraft.util.math.BlockPos;
     import net.minecraft.util.text.ITextComponent;
     import net.minecraft.util.text.TextComponentString;

     public class registerOwnHouse extends CommandBase {
	   @Override
       public String getName() {
       return "registerOwnHouse";
       }
     
       @Override
       public String getUsage(ICommandSender sender) {
       return "/registerOwnHouse [X] [Y] [Z]";
       }
     
       public List<String> getCommandAliases() {
       List<String> list = new ArrayList<>();
       return list;
       }
     
       
       public void execute(MinecraftServer server, ICommandSender sender, String[] args) {
         try {
        HouseUtils.registerHouse(args[0], args[1], args[2]);
        Minecraft.getMinecraft().player.sendMessage((ITextComponent)new TextComponentString(Utils.prefix + " Haus erfolgreich registriert"));
       } catch (IOException e) {
         e.printStackTrace();
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

