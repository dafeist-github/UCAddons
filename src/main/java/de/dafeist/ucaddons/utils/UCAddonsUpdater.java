package de.dafeist.ucaddons.utils;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import java.net.URLConnection;
import java.nio.charset.Charset;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.SystemUtils;

import net.minecraft.client.Minecraft;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextComponentString;

public class UCAddonsUpdater {
	
    private static final File UPDATE_FILE = new File(System.getProperty("java.io.tmpdir"), "UCAddons_update.jar");

	public static void update() throws MalformedURLException, IOException, KeyManagementException, NoSuchAlgorithmException {
	    if(!SystemUtils.IS_OS_WINDOWS) {
	    	(Minecraft.getMinecraft()).player.sendMessage((ITextComponent)new TextComponentString(Utils.prefix + " UCAddons kann nur mit Windows automatisch updated werden, bitte lade das Update manuell unter https:/dafeist.de/downloads/UCAddons.jar herunter!"));
	    	return;
	    }
	    downloadFileFromURL("https://dafeist.de/downloads/UCAddons.jar", UPDATE_FILE.getAbsolutePath());
	    Runtime.getRuntime().addShutdownHook(new Thread(() -> {
                try {
					overwriteJar();
				} catch (IOException e) {
					e.printStackTrace();
				}

        }));
	    
	}

    private static void overwriteJar() throws IOException {
        String batContent = "@echo off\n" +
                "\n" +
                "set /a \"i=0\"\n" +
                "set /a \"x=60\"\n" +
                "set from_file=" + UPDATE_FILE.getAbsolutePath() + "\n" +
                "set to_file=" + Minecraft.getMinecraft().mcDataDir + "\\mods\\UCAddons.jar" + "\n" +
                "\n" +
                "echo update-file: %from_file%\n" +
                "echo to-file: %to_file%\n" +
                "\n" +
                ":delete_loop\n" +
                "\ttimeout /T 1 > nul\n" +
                "\n" +
                "\t2>nul (\n" +
                "\t  move /Y \"%from_file%\" \"%to_file%\"\n" +
                "\t) && (\n" +
                "\t\techo success!\n" +
                "\t\texit\n" +
                "\t) || (\n" +
                "\t\tset /a \"i = i + 1\"\n" +
                "\t\t\n" +
                "\t\tif %i% leq 10 (\n" +
                "\t\t\tset /a \"x = x - 1\"\n" +
                "\t\t\techo jar not available; waiting... [%x% tries left]\n" +
                "\t\t\tgoto delete_loop\n" +
                "\t\t)\n" +
                "\t\t\n" +
                "\t\techo 10 times tried, canceled update\n" +
                "\t\texit\n" +
                "\t)";

        File batchFile = new File(System.getProperty("java.io.tmpdir"), "UCAddons_update.bat");
        FileUtils.write(batchFile, batContent, Charset.defaultCharset());

        Process proc = Runtime.getRuntime().exec("cmd /c start \"\" " + batchFile.getAbsolutePath());
        try {
            proc.waitFor();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            Logger.LOGGER.catching(e);
        }
	
}
	public static void downloadFileFromURL(String search, String path) throws IOException {
	    InputStream inputStream = null;
	    OutputStream outputStream = null;
	    try {
	        URL url = new URL(search);
	        String USER_AGENT = "Mozilla/5.0";
	        URLConnection con = url.openConnection();
	        con.setRequestProperty("User-Agent", USER_AGENT);
	        int contentLength = con.getContentLength();
	        inputStream = con.getInputStream();
	        outputStream = new FileOutputStream(path);
	        byte[] buffer = new byte[2048];
	        int length;
	        int downloaded = 0; 
	        while ((length = inputStream.read(buffer)) != -1) {
	            outputStream.write(buffer, 0, length);
	            downloaded+=length;
	        }
	    } catch (Exception ex) {
	    }
	    outputStream.close();
	    inputStream.close();
	}
}
