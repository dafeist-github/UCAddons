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
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.util.ArrayList;
import java.util.List;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;

import org.apache.commons.io.FileUtils;

import com.google.gson.Gson;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;

import net.minecraft.client.Minecraft;

public class ControlPanelUtils {
	public static String key = "[PRIVATE]"; 
    static File dir = new File((Minecraft.getMinecraft()).mcDataDir + "\\UCAddons");
    static File file = new File((Minecraft.getMinecraft()).mcDataDir + "\\UCAddons\\CP.json");
    static Path dirPath = Paths.get((Minecraft.getMinecraft()).mcDataDir + "\\UCAddons", new String[0]);
	
    public static void init() throws IOException, InvalidKeyException, NoSuchAlgorithmException, InvalidKeySpecException, NoSuchPaddingException, InvalidAlgorithmParameterException, IllegalBlockSizeException, BadPaddingException {
    		CryptoUtils cryptoUtils = new CryptoUtils();
	      if (!dir.exists()) {
	          Files.createDirectory(dirPath, (FileAttribute<?>[])new FileAttribute[0]);
	          }
	        if (!file.exists()) {
	          file.createNewFile();
	          }
	           JsonReader reader = new JsonReader(new FileReader(file));
	           reader.setLenient(true);
	           try {
	           if(reader.hasNext()) {
	               JsonToken nextToken = reader.peek();
	               if(nextToken.equals(JsonToken.END_DOCUMENT)) {
	            	   reader.close();
	            	   return;
	               }
	           } 
	           } catch(EOFException e) {
	        	   reader.close();
	        	   return;
	           }       
	           String ENCRYPTEDuname = reader.nextString();
	           String ENCRYPTEDpw = reader.nextString();
	           Utils.decCPuname = cryptoUtils.decrypt(key, ENCRYPTEDuname);
	           Utils.decCPpw = cryptoUtils.decrypt(key, ENCRYPTEDpw);
	           reader.close();
    }
    
    public static void registerconnect(String uname, String pw) throws IOException, InvalidKeyException, NoSuchAlgorithmException, InvalidKeySpecException, NoSuchPaddingException, InvalidAlgorithmParameterException, IllegalBlockSizeException, BadPaddingException {
	      if (!dir.exists()) {
	          Files.createDirectory(dirPath, (FileAttribute<?>[])new FileAttribute[0]);
	          }
	        if (!file.exists()) {
	          file.createNewFile();
	          }
	        CryptoUtils cryptoUtils = new CryptoUtils();
	        String ENCRYPTEDuname = cryptoUtils.encrypt(key, uname);
	        String ENCRYPTEDpw = cryptoUtils.encrypt(key, pw);
	        Gson gson = new Gson();
	        List<String> jsonList = new ArrayList<>();
	        jsonList.add(gson.toJson(ENCRYPTEDuname));	      
	        jsonList.add(gson.toJson(ENCRYPTEDpw));
	        FileUtils.writeLines(file, StandardCharsets.UTF_8.toString(), jsonList);
	}
}
