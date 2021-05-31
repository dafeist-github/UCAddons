package de.dafeist.ucaddons.commands;

import java.util.ArrayList;
import java.util.List;

import de.dafeist.ucaddons.utils.Utils;
import net.minecraft.client.Minecraft;
import net.minecraft.command.CommandBase;
import net.minecraft.command.ICommand;
import net.minecraft.command.ICommandSender;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextComponentString;

public class ucaddonsinfo extends CommandBase{
	   public String getCommandName() {
	        return "ucaddonsinfo";
	        }
	      
	        
	        public String getCommandUsage(ICommandSender sender) {
	        return "/ucaddonsinfo";
	        }
	      
	        
	        public List<String> getCommandAliases() {
	        List<String> list = new ArrayList<>();
	        return list;
	        }
	      
	        
	        public void execute(MinecraftServer server, ICommandSender sender, String[] args) {
	        Minecraft.getMinecraft().player.sendMessage((ITextComponent)new TextComponentString(Utils.prefix + " Diese Mod sendet deine IP-Adresse, deinen Username, deine UCAddons Version und deine UUID an meinen Server und lädt dort auch Daten herunter, genauso wie zum UnicaCity ControlPanel Server deine selbst eingegebenen Daten gesendet werden. Wenn du diese Mod benutzst, akzeptierst du dies automatisch."));
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


			@Override
			public String getName() {
				return "ucaddonsinfo";
			}


			@Override
			public String getUsage(ICommandSender sender) {
				return "ucaddonsinfo";
			}


}
