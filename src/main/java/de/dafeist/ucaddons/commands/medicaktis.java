package de.dafeist.ucaddons.commands;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.io.FileUtils;

import com.google.gson.Gson;
import com.google.gson.stream.JsonReader;

import de.dafeist.ucaddons.MedicUtils;
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

public class medicaktis extends CommandBase {
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
  		return "medicaktis";
  	}

  	@Override
  	public String getUsage(ICommandSender sender) {
  		return "/medicaktis [add/remove/get] [number/reason]";
  	}

  	@Override
  	public void execute(MinecraftServer server, ICommandSender sender, String[] args) throws CommandException {
  		if(args.length > 0 && args.length < 3) {
  			if(args[0].equalsIgnoreCase("get")) {
  				try {
  					String AktiPoints = FileUtils.readFileToString(MedicUtils.file).replaceAll("\"", "").replaceAll("\n", "");
  		  			Minecraft.getMinecraft().player.sendMessage((ITextComponent)new TextComponentString(Utils.prefix + " Du hast §a" + AktiPoints + " Aktipunkte"));
				} catch (IOException e) {
					e.printStackTrace();
				}
  			} else if(args[0].equalsIgnoreCase("add")) {
  					if(args.length == 2) {
  						if(MedicUtils.aktiMap.containsKey(args[1])) {
  							Double pointsToAdd = MedicUtils.aktiMap.get(args[1]);
  							Double currentPoints;
							try {
							currentPoints = Double.parseDouble(FileUtils.readFileToString(MedicUtils.file).replaceAll("\"", ""));
							String STRcurrentPoints = String.valueOf(currentPoints).replaceAll("\"", "");
							currentPoints = Double.parseDouble(STRcurrentPoints);
  							Double finalPoints = currentPoints + pointsToAdd;
  							String STRfinalPoints = String.valueOf(finalPoints).replaceAll("\"", "");
  							Gson gson = new Gson();
  							List<String> finalPointsList = new ArrayList<>();
  							finalPointsList.add(gson.toJson(String.valueOf(finalPoints)));
  							FileUtils.writeLines(MedicUtils.file, StandardCharsets.UTF_8.toString(), finalPointsList);
  							Minecraft.getMinecraft().player.sendMessage((ITextComponent)new TextComponentString(Utils.prefix + " Erfolgreich, du hast nun §a" + STRfinalPoints + " Aktipunkte"));
							} catch (NumberFormatException | IOException e) {
								e.printStackTrace();
							}
  						} else {
  	  			  			Minecraft.getMinecraft().player.sendMessage((ITextComponent)new TextComponentString(Utils.prefix + " Aktivität wurde nicht gefunden, um eine Liste zu erhalten gebe /medicaktitabelle ein"));
  						}
  					} else {
  			  			Minecraft.getMinecraft().player.sendMessage((ITextComponent)new TextComponentString(Utils.prefix + " Bitte gebe an, welche Aktivität du erledigt hast"));
  					}
  			} else if(args[0].equalsIgnoreCase("remove")) {
  				if(args.length == 2) {
  					try {
  						String arg1 = args[1].replace(",", ".");
						Double currentPoints = Double.parseDouble(FileUtils.readFileToString(MedicUtils.file).replaceAll("\"", ""));
						Double pointsToRemove = Double.parseDouble(arg1);
						String STRcurrentPoints = String.valueOf(currentPoints).replaceAll("\"", "");
						currentPoints = Double.parseDouble(STRcurrentPoints);
						if(currentPoints >= pointsToRemove) {
							MedicUtils.file.delete();
							MedicUtils.file.createNewFile();
  							Double finalPoints = currentPoints - pointsToRemove;
  							String STRfinalPoints = String.valueOf(finalPoints).replaceAll("\"", "");
  							Gson gson = new Gson();
  							List<String> finalPointsList = new ArrayList<>();
  							finalPointsList.add(gson.toJson(String.valueOf(finalPoints)));
  							FileUtils.writeLines(MedicUtils.file, StandardCharsets.UTF_8.toString(), finalPointsList);
  							Minecraft.getMinecraft().player.sendMessage((ITextComponent)new TextComponentString(Utils.prefix + " Erfolgreich, du hast nun §a" + STRfinalPoints + " Aktipunkte"));
							
						} else {
	  			  			Minecraft.getMinecraft().player.sendMessage((ITextComponent)new TextComponentString(Utils.prefix + " Du kannst nicht mehr Punkte entfernen als du hast"));
						}
					} catch (NumberFormatException e) {
						e.printStackTrace();
					} catch (IOException e) {
						e.printStackTrace();
					}
  					
  				} else {
  					Minecraft.getMinecraft().player.sendMessage((ITextComponent)new TextComponentString(Utils.prefix + " Wieviele Aktipunkte du entfernen möchtest"));
  				}
  			}
  		} else {
  			Minecraft.getMinecraft().player.sendMessage((ITextComponent)new TextComponentString(Utils.prefix + " Ungültige Argumente. Benutze /medicaktis [add/remove/get] [number/reason/-]"));
  		}
  	}
}
