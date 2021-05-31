     package de.dafeist.ucaddons.utils;
     
     import com.google.gson.Gson;
     import com.google.gson.stream.JsonReader;
     import com.google.gson.stream.JsonToken;
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
     import net.minecraft.client.Minecraft;
     import org.apache.commons.io.FileUtils;
     
     public class HouseUtils {
     static File dir = new File((Minecraft.getMinecraft()).mcDataDir + "\\UCAddons");
     static File file = new File((Minecraft.getMinecraft()).mcDataDir + "\\UCAddons\\House.json");
     static Path dirPath = Paths.get((Minecraft.getMinecraft()).mcDataDir + "\\UCAddons", new String[0]);
       
       public static void init() throws IOException {
       if (!dir.exists()) {
         Files.createDirectory(dirPath, (FileAttribute<?>[])new FileAttribute[0]);
         }
       if (!file.exists()) {
         file.createNewFile();
         }
       }
       
       public static void registerHouse(String X, String Y, String Z) throws NumberFormatException, IOException {
       Gson gson = new Gson();
       List<String> jsonList = new ArrayList<>();
       JsonReader reader = new JsonReader(new FileReader(file));
       reader.setLenient(true);
         try {
         jsonList.add(gson.toJson("X" + X));
         jsonList.add(gson.toJson("Y" + Y));
         jsonList.add(gson.toJson("Z" + Z));
         while (reader.hasNext()) {
           JsonToken nextToken = reader.peek();
           Logger.LOGGER.info(nextToken);
           if (nextToken.equals(JsonToken.STRING)) {
             jsonList.add(gson.toJson(reader.nextString()));
             }
           nextToken = reader.peek();
           if (nextToken.equals(JsonToken.END_DOCUMENT))
             throw new EOFException(); 
           } 
         } catch (EOFException e) {
         reader.close();
       }  reader.close();
       FileUtils.writeLines(file, StandardCharsets.UTF_8.toString(), jsonList);
       }
     }
