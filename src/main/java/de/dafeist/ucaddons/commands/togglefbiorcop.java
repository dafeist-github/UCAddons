package de.dafeist.ucaddons.commands;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.io.FileUtils;

import com.google.gson.Gson;

import de.dafeist.ucaddons.utils.FactionUtils;
import de.dafeist.ucaddons.utils.Logger;
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

public class togglefbiorcop extends CommandBase {
	
    public List<String> getCommandAliases() {
    List<String> list = new ArrayList<>();
    return list;
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
		return "toggleFBIorCop";
	}

	@Override
	public String getUsage(ICommandSender sender) {
		return "/toggleFBIorCop";
	}

	@Override
	public void execute(MinecraftServer server, ICommandSender sender, String[] args) throws CommandException {
		if(FactionUtils.isCopOrFBI == true) {
			FactionUtils.isCopOrFBI = false;
		} else if(FactionUtils.isCopOrFBI == false) {
			FactionUtils.isCopOrFBI = true;
		}
        Gson gson = new Gson();
        List<String> jsonList = new ArrayList<>();
        if(FactionUtils.isCopOrFBI == true) {
            jsonList.add(gson.toJson("true"));
            try {
				FileUtils.writeLines(FactionUtils.file, StandardCharsets.UTF_8.toString(), jsonList);
				Minecraft.getMinecraft().player.sendMessage((ITextComponent)new TextComponentString(Utils.prefix + " Der Cop-oder-FBI Modus wurde erfolgreich angeschaltet"));
			} catch (IOException e) {
				e.printStackTrace();
			}
        } else if(FactionUtils.isCopOrFBI == false) {
        	FactionUtils.file.delete();
        	Minecraft.getMinecraft().player.sendMessage((ITextComponent)new TextComponentString(Utils.prefix + " Der Cop-oder-FBI Modus wurde erfolgreich ausgeschaltet"));
        }
     
		
	}
}
