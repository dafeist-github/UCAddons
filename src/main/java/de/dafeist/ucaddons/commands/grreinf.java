package de.dafeist.ucaddons.commands;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import de.dafeist.ucaddons.utils.HouseUtils;
import de.dafeist.ucaddons.utils.Logger;
import de.dafeist.ucaddons.utils.Utils;
import net.minecraft.client.Minecraft;
import net.minecraft.command.CommandBase;
import net.minecraft.command.CommandException;
import net.minecraft.command.ICommand;
import net.minecraft.command.ICommandSender;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.math.BlockPos;

public class grreinf extends CommandBase {
    
      
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
		return "grreinf";
	}

	@Override
	public String getUsage(ICommandSender sender) {
		return "/grreinf";
	}

	@Override
	public void execute(MinecraftServer server, ICommandSender sender, String[] args) throws CommandException {
        if(Utils.onUnicaCity == true) {
		(Minecraft.getMinecraft()).player.sendChatMessage("/gr REINFORCEMENT: " + (Minecraft.getMinecraft()).player.getPosition().getX() + " " + (Minecraft.getMinecraft()).player.getPosition().getY() + " " + (Minecraft.getMinecraft()).player.getPosition().getZ());
       Logger.LOGGER.info("Sent Reinforcement in GR-Chat");
        }
	}
}
