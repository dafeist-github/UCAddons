package de.dafeist.ucaddons.utils;

import java.io.EOFException;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.FileAttribute;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.io.FileUtils;

import com.google.gson.Gson;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;

import net.minecraft.client.Minecraft;

public class FactionUtils {
	
	public static boolean isCopOrFBI = false;
	
    static File dir = new File((Minecraft.getMinecraft()).mcDataDir + "\\UCAddons");
    public static File file = new File((Minecraft.getMinecraft()).mcDataDir + "\\UCAddons\\isFBIorCop.json");
    static Path dirPath = Paths.get((Minecraft.getMinecraft()).mcDataDir + "\\UCAddons", new String[0]);
	
	public static void init() throws IOException {
	      if (!dir.exists()) {
	          Files.createDirectory(dirPath, (FileAttribute<?>[])new FileAttribute[0]);
	          }
	        if (!file.exists()) {
	          file.createNewFile();
	          }
	        Gson gson = new Gson();
	        List<String> jsonList = new ArrayList<>();
	           JsonReader reader = new JsonReader(new FileReader(file));
	           reader.setLenient(true);
	           try {
	           if(reader.hasNext()) {
	               JsonToken nextToken = reader.peek();
	               if(nextToken.equals(JsonToken.END_DOCUMENT)) {
	            	   reader.close();
	            	   return;
	               } else if(nextToken.equals(JsonToken.STRING)) {
	            	   isCopOrFBI = true;
	               }
	           } 
	           } catch(EOFException e) {
	        	   reader.close();
	        	   return;
	           }

	        
	}
}
