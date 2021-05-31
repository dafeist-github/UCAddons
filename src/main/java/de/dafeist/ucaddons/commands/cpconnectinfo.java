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

public class cpconnectinfo extends CommandBase {
	   @Override
       public String getName() {
       return "cpconnectinfo";
       }
     
       @Override
       public String getUsage(ICommandSender sender) {
       return "/cpconnectinfo";
       }
     
       public List<String> getCommandAliases() {
       List<String> list = new ArrayList<>();
       return list;
       }
     
       
       public void execute(MinecraftServer server, ICommandSender sender, String[] args) {
       Minecraft.getMinecraft().player.sendMessage((ITextComponent)new TextComponentString(Utils.prefix + " Wenn du dich mit dem cp connectest, beachte bitte folgendes:"));
       Minecraft.getMinecraft().player.sendMessage((ITextComponent)new TextComponentString("-§6Dein Passwort wird nicht an irgendwelche Server gesendet, sondern NUR an die offizielle UnicaCity Website"));
       Minecraft.getMinecraft().player.sendMessage((ITextComponent)new TextComponentString("-§6Dein Passwort und dein Benutzername werden verschlüsselt auf deinem Gerät gespeichert, deshalb solltest du auf keinem Fall den UCAddons Ordner in .minecraft an andere Personen senden, auch wenn deine Daten verschlüsselt sind"));
       Minecraft.getMinecraft().player.sendMessage((ITextComponent)new TextComponentString("-§6Hier wird die JSoup Library genutzt die unter der MIT-Lizenz steht"));

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
