package de.dafeist.ucaddons.commands;

import java.io.IOException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.util.ArrayList;
import java.util.List;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;

import de.dafeist.ucaddons.utils.ControlPanelUtils;
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

public class cpconnect extends CommandBase{

	@Override
	public String getName() {
		return "cpconnect";
	}

	@Override
	public String getUsage(ICommandSender sender) {
		return "/cpconnect [username] [password]";
	}
	
    public boolean checkPermission(MinecraftServer server, ICommandSender sender) {
    return true;
    }
    
    public List<String> getCommandAliases() {
    List<String> list = new ArrayList<>();
    return list;
    }
    
	@Override
	public void execute(MinecraftServer server, ICommandSender sender, String[] args) throws CommandException {
		try {
			if(args.length != 2) return;
			ControlPanelUtils.registerconnect(args[0], args[1]);
			(Minecraft.getMinecraft()).player.sendMessage((ITextComponent)new TextComponentString(Utils.prefix + " CP-Daten erfolgreich registriert!"));
		} catch (InvalidKeyException | NoSuchAlgorithmException | InvalidKeySpecException | NoSuchPaddingException
				| InvalidAlgorithmParameterException | IllegalBlockSizeException | BadPaddingException
				| IOException e) {
			e.printStackTrace();
		}
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
