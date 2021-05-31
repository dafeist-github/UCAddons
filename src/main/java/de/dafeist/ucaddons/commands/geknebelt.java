package de.dafeist.ucaddons.commands;

import java.util.ArrayList;
import java.util.List;

import de.dafeist.ucaddons.utils.Utils;
import net.minecraft.client.Minecraft;
import net.minecraft.command.CommandBase;
import net.minecraft.command.CommandException;
import net.minecraft.command.ICommand;
import net.minecraft.command.ICommandSender;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextComponentString;

public class geknebelt extends CommandBase {

	@Override
	public String getName() {
		return "geknebelt";
	}

	@Override
	public String getUsage(ICommandSender sender) {
		return "/geknebelt";
	}
	
    public List<String> getCommandAliases() {
    List<String> list = new ArrayList<>();
    return list;
    }

	@Override
	public void execute(MinecraftServer server, ICommandSender sender, String[] args) throws CommandException {
		if(Utils.geknebelt == true) {
			Utils.geknebelt = false;
	        Minecraft.getMinecraft().player.sendMessage((ITextComponent)new TextComponentString(Utils.prefix + " Geknebelten-Modus erfolgreich deaktiviert"));
		} else {
			Utils.geknebelt = true;
	        Minecraft.getMinecraft().player.sendMessage((ITextComponent)new TextComponentString(Utils.prefix + " Geknebelten-Modus erfolgreich aktiviert"));
		}
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
