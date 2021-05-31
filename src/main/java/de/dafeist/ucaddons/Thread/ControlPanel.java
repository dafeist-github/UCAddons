package de.dafeist.ucaddons.Thread;

import java.io.IOException;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.Map;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import de.dafeist.ucaddons.CarUtils;
import de.dafeist.ucaddons.UCAddons;
import de.dafeist.ucaddons.utils.Logger;
import de.dafeist.ucaddons.utils.UCAddonsUpdater;
import de.dafeist.ucaddons.utils.Utils;
import net.minecraft.client.Minecraft;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextComponentString;

public class ControlPanel extends Thread {
	public void run() {
		while(true) {
			try {
		 final String USER_AGENT = "Mozilla/5.0";		 
		 String loginActionUrl = "https://cp.unicacity.de/login.php";  
		 String profileURL = "https://cp.unicacity.de/profil";
		 String username = Utils.decCPuname;
		 if(username != null) {
		 String password = Utils.decCPpw;
		 HashMap<String, String> cookies = new HashMap<>();  
		 HashMap<String, String> formData = new HashMap<>(); 
		 formData.put("name", username);  
		 formData.put("password", password);
		 System.setProperty("javax.net.ssl.trustStorePassword", "changeit");
		 Connection.Response homePage = Jsoup.connect(loginActionUrl)
				 .validateTLSCertificates(false)
				 .ignoreHttpErrors(true)
		         .cookies(cookies)  
		         .data(formData)  
		         .method(Connection.Method.POST)  
		         .userAgent(USER_AGENT)  
		         .execute(); 
		 Map<String, String> cks = homePage.cookies();
		 Connection.Response profilePage = Jsoup.connect(profileURL)
				 .validateTLSCertificates(false)
				 .cookies(cks)
				 .data(formData)
				 .ignoreHttpErrors(true)
				 .method(Connection.Method.POST)
				 .userAgent(USER_AGENT)
				 .execute();
			Document html = profilePage.parse();
			String BarMoney = html.selectFirst("div:containsOwn($)").parent().children().text();
			BarMoney = BarMoney.replace("Bargeld ", "");
			Utils.BarMoney = BarMoney;
			String BankMoney = html.select("div:containsOwn($)").get(1).parent().children().text();
			BankMoney = BankMoney.replace("Bank ", "");
			Utils.BankMoney = BankMoney;
			String PayDayTime = html.selectFirst("p:containsOwn(/60 Minuten)").parent().children().text();
			PayDayTime = PayDayTime.replace("PayDay: ", "");
			PayDayTime = PayDayTime.replace(" Minuten", " min");
			Utils.PayDayTime = PayDayTime;
			String Thirst = html.selectFirst("p:containsOwn(/20.0)").parent().children().text();
			Thirst = Thirst.replace("Durst ", "");
			Utils.Thirst = Thirst;
			String BimborginiTank = html.selectFirst("p:containsOwn(/100l)").parent().children().text();
			if(Double.parseDouble(BimborginiTank.replace("/100l", "").replace("l", "")) <= 5) {
				CarUtils.lockTank = true;
				Minecraft.getMinecraft().player.sendMessage((ITextComponent)new TextComponentString(Utils.prefix + " Du hast nurnoch " + BimborginiTank + " Tank"));
			} else if(Double.parseDouble(BimborginiTank.replace("/100l", "").replace("l", "")) > 50) {
				CarUtils.lockTank = false;
			}
			
			if(Utils.PayDayTime == "55/60 min") {
				Minecraft.getMinecraft().player.sendMessage((ITextComponent)new TextComponentString(Utils.prefix + " 5 Minuten noch bis zum PayDay!"));
			}
			
		 }
		} catch(Exception e) {
			e.printStackTrace();
		}
		try {
			if(Utils.lockUpdater == false) {
			 Logger.LOGGER.info("Searching for UCAddons Updates...");
			 final String USER_AGENT = "Mozilla/5.0";
			 System.setProperty("javax.net.ssl.trustStorePassword", "changeit");
			 Connection.Response Page = Jsoup.connect("https://dafeist.de/UCAddonsVersionCheck.php")
					 .ignoreHttpErrors(true)
			         .method(Connection.Method.POST)  
			         .userAgent(USER_AGENT)  
			         .execute(); 
			Document html = Page.parse();
			String latestVersionString = html.selectFirst("body").parent().children().text();
			String currentVersionString = UCAddons.VERSION;
			latestVersionString = latestVersionString.replace(".", "");
			currentVersionString = currentVersionString.replace(".", "");
			int latestVersion = Integer.parseInt(latestVersionString);
			int currentVersion = Integer.parseInt(currentVersionString);
			if(latestVersion > currentVersion && Utils.lockUpdater == false) {
				Logger.LOGGER.info("UCAddons Update found, downloading Update...");
				UCAddonsUpdater.update();
				Utils.lockUpdater = true;
			} else {
				Logger.LOGGER.info("UCAddons is already up to date, latest version: " + latestVersionString);
			}
			}
			Thread.sleep(25000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (KeyManagementException e) {
			e.printStackTrace();
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		}
		 }
	
	public static void init() {
		Logger.LOGGER.info("ControlPanel-Sync started!");
		Thread cpsync = new Thread(new ControlPanel());
		cpsync.start();
	}
}
