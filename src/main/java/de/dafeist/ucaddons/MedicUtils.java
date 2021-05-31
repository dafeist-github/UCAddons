package de.dafeist.ucaddons;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.FileAttribute;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.apache.commons.io.FileUtils;

import com.google.gson.Gson;

import net.minecraft.client.Minecraft;

public class MedicUtils {
	public static HashMap<String, Double> aktiMap = new HashMap<String, Double>();
    public static File dir = new File((Minecraft.getMinecraft()).mcDataDir + "\\UCAddons");
    public static File file = new File((Minecraft.getMinecraft()).mcDataDir + "\\UCAddons\\MedicAktis.json");
    public static Path dirPath = Paths.get((Minecraft.getMinecraft()).mcDataDir + "\\UCAddons", new String[0]);
	
	public static void init() {
		aktiMap.put("An‰sthesie", 0.4);
		aktiMap.put("Geburt", 0.8);
		aktiMap.put("Operation", 0.7);
		aktiMap.put("KU", 0.3);
		aktiMap.put("BGT", 0.4);
		aktiMap.put("RDE", 0.5);
		aktiMap.put("Sonstiges", 0.5);
		aktiMap.put("Groﬂereignis", 0.6);
		aktiMap.put("Ausbildung", 0.6);
		aktiMap.put("Fach‰rzte", 0.2);
		aktiMap.put("Beschwerden", 0.3);
		aktiMap.put("Revive", 0.1);  
	       if (!dir.exists()) {
	         try {
				Files.createDirectory(dirPath, (FileAttribute<?>[])new FileAttribute[0]);
			} catch (IOException e) {
				e.printStackTrace();
			}
	         }
	       if (!file.exists()) {
	         try {
				file.createNewFile();
				Gson gson = new Gson();
				List<String> standardFileData = new ArrayList<>();
				standardFileData.add(gson.toJson("0"));
				FileUtils.writeLines(file, StandardCharsets.UTF_8.toString(), standardFileData);
			} catch (IOException e) {
				e.printStackTrace();
			}
	         }
	       
	}
	
}
