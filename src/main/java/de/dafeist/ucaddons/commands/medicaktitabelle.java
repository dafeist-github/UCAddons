package de.dafeist.ucaddons.commands;

import java.util.ArrayList;
import java.util.List;

import net.minecraft.client.Minecraft;
import net.minecraft.command.CommandBase;
import net.minecraft.command.ICommand;
import net.minecraft.command.ICommandSender;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextComponentString;

public class medicaktitabelle extends CommandBase {
	   @Override
       public String getName() {
       return "medicaktitabelle";
       }
     
       @Override
       public String getUsage(ICommandSender sender) {
       return "/medicaktitabelle";
       
       }
     
       
       public List<String> getCommandAliases() {
       List<String> list = new ArrayList<>();
       return list;
       }
     
       
       public void execute(MinecraftServer server, ICommandSender sender, String[] args) {
		   Minecraft.getMinecraft().player.sendMessage((ITextComponent)new TextComponentString("--§aUCAddons--"));
		   Minecraft.getMinecraft().player.sendMessage((ITextComponent)new TextComponentString("Anaesthesie -> 0,4"));
		   Minecraft.getMinecraft().player.sendMessage((ITextComponent)new TextComponentString("Geburt -> 0,8")); 
		   Minecraft.getMinecraft().player.sendMessage((ITextComponent)new TextComponentString("Operation -> 0,7"));
		   Minecraft.getMinecraft().player.sendMessage((ITextComponent)new TextComponentString("KU -> 0,3"));
		   Minecraft.getMinecraft().player.sendMessage((ITextComponent)new TextComponentString("BGT -> 0,4"));
		   Minecraft.getMinecraft().player.sendMessage((ITextComponent)new TextComponentString("RDE/Sonstiges -> 0,5"));
		   Minecraft.getMinecraft().player.sendMessage((ITextComponent)new TextComponentString("Grossereignis -> 0,6"));
		   Minecraft.getMinecraft().player.sendMessage((ITextComponent)new TextComponentString("Ausbildung -> 0,6"));
		   Minecraft.getMinecraft().player.sendMessage((ITextComponent)new TextComponentString("Fachaerzte -> 0,2"));
		   Minecraft.getMinecraft().player.sendMessage((ITextComponent)new TextComponentString("Beschwerden -> 0,3")); 
		   Minecraft.getMinecraft().player.sendMessage((ITextComponent)new TextComponentString("Revives -> 0,1"));
       }
     
       
       public boolean checkPermission(MinecraftServer server, ICommandSender sender) {
       return true;
       }
     
       
       public List<String> getTabCompletionOptions(MinecraftServer server, ICommandSender sender, String[] args, BlockPos targetPos) {
       List<String> list = new ArrayList<>();
       return list;
       }
     
       
       public boolean isUsernameIndex(String[] args, int index) {
       return false;
       }
     
       
       public int compareTo(ICommand o) {
       return 0;
       }
}
