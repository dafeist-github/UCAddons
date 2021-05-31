     package de.dafeist.ucaddons.commands;
     
     import java.util.ArrayList;
     import java.util.List;
     import net.minecraft.client.Minecraft;
     import net.minecraft.command.CommandBase;
     import net.minecraft.command.ICommand;
     import net.minecraft.command.ICommandSender;
     import net.minecraft.server.MinecraftServer;
     import net.minecraft.util.math.BlockPos;
     
     public class reinf extends CommandBase {
       @Override
       public String getName() {
       return "reinf";
       }
     
       @Override
       public String getUsage(ICommandSender sender) {
       return "/reinf";
       }
     
       
       public List<String> getCommandAliases() {
       List<String> list = new ArrayList<>();
       return list;
       }
     
       
       public void execute(MinecraftServer server, ICommandSender sender, String[] args) {
       (Minecraft.getMinecraft()).player.sendChatMessage("/reinforcement");
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
 