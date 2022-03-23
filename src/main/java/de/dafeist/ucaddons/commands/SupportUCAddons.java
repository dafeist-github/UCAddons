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
     
     
     
     public class SupportUCAddons extends CommandBase {
	   @Override
       public String getName() {
       return "SupportUCAddons";
       }
     
       @Override
       public String getUsage(ICommandSender sender) {
       return "/SupportUCAddons";
       }
     
       
       public List<String> getCommandAliases() {
       List<String> list = new ArrayList<>();
       return list;
       }
     
       
       public void execute(MinecraftServer server, ICommandSender sender, String[] args) {
       (Minecraft.getMinecraft()).player.sendMessage((ITextComponent)new TextComponentString(Utils.prefix + " Für Spenden(PaySafeCard, PayPal) wende dich bitte über Instagram-DM an dafeist_gaming oder zur Not im Forum an DaFeist"));
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
