     package de.dafeist.ucaddons.commands;
     
     import java.util.ArrayList;
     import java.util.List;
     import net.minecraft.command.CommandBase;
     import net.minecraft.command.ICommand;
     import net.minecraft.command.ICommandSender;
     import net.minecraft.server.MinecraftServer;
     import net.minecraft.util.math.BlockPos;
     import net.minecraftforge.fml.client.FMLClientHandler;
import net.minecraftforge.fml.common.FMLCommonHandler;
    
     public class altf4 extends CommandBase
     {
       public String getCommandName() {
       return "altf4";
       }
     
       
       public String getCommandUsage(ICommandSender sender) {
       return "/altf4";
       }
     
       
       public List<String> getCommandAliases() {
       List<String> list = new ArrayList<>();
       return list;
       }
     
       
       public void execute(MinecraftServer server, ICommandSender sender, String[] args) {
    	   FMLCommonHandler.instance().exitJava(0, true);
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
		return "altf4";
	}


	@Override
	public String getUsage(ICommandSender sender) {
		return "/altf4";
	}
     }
