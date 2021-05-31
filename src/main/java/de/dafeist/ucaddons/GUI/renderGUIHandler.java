package de.dafeist.ucaddons.GUI;

import org.lwjgl.util.Color;

import de.dafeist.ucaddons.utils.FactionUtils;
import de.dafeist.ucaddons.utils.Utils;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.gui.ScaledResolution;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class renderGUIHandler {
	private ScaledResolution sclRes;
	String res;
	
   @SubscribeEvent
   public void onRenderGui(RenderGameOverlayEvent.Text event) {
		if(Utils.CPInfoEnabled == true) {
		FontRenderer fontrenderer = Minecraft.getMinecraft().fontRenderer;
		sclRes = new ScaledResolution(Minecraft.getMinecraft());
		if(sclRes.getScaledHeight() == 360) {
		fontrenderer.drawString("PayDay: " + Utils.PayDayTime, sclRes.getScaledWidth() - sclRes.getScaledWidth() / 7, sclRes.getScaledHeight() / 2 - 10, 65280);
		fontrenderer.drawString("Durst: " + Utils.Thirst, sclRes.getScaledWidth() - sclRes.getScaledWidth() / 7, sclRes.getScaledHeight() / 2, 65280);
		fontrenderer.drawString("Bargeld: " + Utils.BarMoney, sclRes.getScaledWidth() - sclRes.getScaledWidth() / 7, sclRes.getScaledHeight() / 2 + 10, 65280);
		fontrenderer.drawString("Bankgeld: " + Utils.BankMoney, sclRes.getScaledWidth() - sclRes.getScaledWidth() / 7, sclRes.getScaledHeight() / 2 + 20, 65280);
		if(FactionUtils.isCopOrFBI == true) {
			if(Utils.TazerEnabled == true) {
				String res = "an";
				fontrenderer.drawString("Tazer: an", sclRes.getScaledWidth() - sclRes.getScaledWidth() / 7, sclRes.getScaledHeight() / 2 + 30, 0xF0);
			} else if(Utils.TazerEnabled == false) {
				String res = "aus";
				fontrenderer.drawString("Tazer: aus", sclRes.getScaledWidth() - sclRes.getScaledWidth() / 7, sclRes.getScaledHeight() / 2 + 30, 0xF0);
			}
		}
		} else if(sclRes.getScaledHeight() == 270) {
			fontrenderer.drawString("PayDay: " + Utils.PayDayTime, sclRes.getScaledWidth() - sclRes.getScaledWidth() / 6 - 10, sclRes.getScaledHeight() / 2 - 10, 65280);
			fontrenderer.drawString("Durst: " + Utils.Thirst, sclRes.getScaledWidth() - sclRes.getScaledWidth() / 6 - 10, sclRes.getScaledHeight() / 2, 65280);
			fontrenderer.drawString("Bargeld: " + Utils.BarMoney, sclRes.getScaledWidth() - sclRes.getScaledWidth() / 6 - 10, sclRes.getScaledHeight() / 2 + 10, 65280);
			fontrenderer.drawString("Bankgeld: " + Utils.BankMoney, sclRes.getScaledWidth() - sclRes.getScaledWidth() / 6 - 10, sclRes.getScaledHeight() / 2 + 20, 65280);
			if(FactionUtils.isCopOrFBI == true) {
				if(Utils.TazerEnabled == true) {
					String res = "an";
					fontrenderer.drawString("Tazer: an", sclRes.getScaledWidth() - sclRes.getScaledWidth() / 6 - 10, sclRes.getScaledHeight() / 2 + 30, 0xF0);
				} else if(Utils.TazerEnabled == false) {
					String res = "aus";
					fontrenderer.drawString("Tazer: aus", sclRes.getScaledWidth() - sclRes.getScaledWidth() / 6 - 10, sclRes.getScaledHeight() / 2 + 30, 0xF0);
				}
			}
		} else if(sclRes.getScaledHeight() == 240) {
			fontrenderer.drawString("PayDay: " + Utils.PayDayTime, sclRes.getScaledWidth() - sclRes.getScaledWidth() / 5 - 6, sclRes.getScaledHeight() / 2 - 10, 65280);
			fontrenderer.drawString("Durst: " + Utils.Thirst, sclRes.getScaledWidth() - sclRes.getScaledWidth() / 5 - 6, sclRes.getScaledHeight() / 2, 65280);
			fontrenderer.drawString("Bargeld: " + Utils.BarMoney, sclRes.getScaledWidth() - sclRes.getScaledWidth() / 5 - 6, sclRes.getScaledHeight() / 2 + 10, 65280);
			fontrenderer.drawString("Bankgeld: " + Utils.BankMoney, sclRes.getScaledWidth() - sclRes.getScaledWidth() / 5 - 6, sclRes.getScaledHeight() / 2 + 20, 65280);
			if(FactionUtils.isCopOrFBI == true) {
				if(Utils.TazerEnabled == true) {
					String res = "an";
					fontrenderer.drawString("Tazer: an", sclRes.getScaledWidth() - sclRes.getScaledWidth() / 5 - 6, sclRes.getScaledHeight() / 2 + 30, 0xF0);
				} else if(Utils.TazerEnabled == false) {
					String res = "aus";
					fontrenderer.drawString("Tazer: aus", sclRes.getScaledWidth() - sclRes.getScaledWidth() / 5 - 6, sclRes.getScaledHeight() / 2 + 30, 0xF0);
				}
			}
		} else if(sclRes.getScaledHeight() == 345) {
			fontrenderer.drawString("PayDay: " + Utils.PayDayTime, sclRes.getScaledWidth() - sclRes.getScaledWidth() / 6, sclRes.getScaledHeight() / 2 - 10, 65280);
			fontrenderer.drawString("Durst: " + Utils.Thirst, sclRes.getScaledWidth() - sclRes.getScaledWidth() / 6, sclRes.getScaledHeight() / 2, 65280);
			fontrenderer.drawString("Bargeld: " + Utils.BarMoney, sclRes.getScaledWidth() - sclRes.getScaledWidth() / 6, sclRes.getScaledHeight() / 2 + 10, 65280);
			fontrenderer.drawString("Bankgeld: " + Utils.BankMoney, sclRes.getScaledWidth() - sclRes.getScaledWidth() / 6, sclRes.getScaledHeight() / 2 + 20, 65280);
			if(FactionUtils.isCopOrFBI == true) {
				if(Utils.TazerEnabled == true) {
					String res = "an";
					fontrenderer.drawString("Tazer: an", sclRes.getScaledWidth() - sclRes.getScaledWidth() / 6, sclRes.getScaledHeight() / 2 + 30, 0xF0);
				} else if(Utils.TazerEnabled == false) {
					String res = "aus";
					fontrenderer.drawString("Tazer: aus", sclRes.getScaledWidth() - sclRes.getScaledWidth() / 6, sclRes.getScaledHeight() / 2 + 30, 0xF0);
				}
			}
		} else if(sclRes.getScaledHeight() == 540) {
			fontrenderer.drawString("PayDay: " + Utils.PayDayTime, sclRes.getScaledWidth() - sclRes.getScaledWidth() / 10 - 10, sclRes.getScaledHeight() / 2 - 10, 65280);
			fontrenderer.drawString("Durst: " + Utils.Thirst, sclRes.getScaledWidth() - sclRes.getScaledWidth() / 10 - 10, sclRes.getScaledHeight() / 2, 65280);
			fontrenderer.drawString("Bargeld: " + Utils.BarMoney, sclRes.getScaledWidth() - sclRes.getScaledWidth() / 10 - 10, sclRes.getScaledHeight() / 2 + 10, 65280);
			fontrenderer.drawString("Bankgeld: " + Utils.BankMoney, sclRes.getScaledWidth() - sclRes.getScaledWidth() / 10 - 10, sclRes.getScaledHeight() / 2 + 20, 65280);
			if(FactionUtils.isCopOrFBI == true) {
				if(Utils.TazerEnabled == true) {
					String res = "an";
					fontrenderer.drawString("Tazer: an", sclRes.getScaledWidth() - sclRes.getScaledWidth() / 10 - 10, sclRes.getScaledHeight() / 2 + 30, 0xF0);
				} else if(Utils.TazerEnabled == false) {
					String res = "aus";
					fontrenderer.drawString("Tazer: aus", sclRes.getScaledWidth() - sclRes.getScaledWidth() / 10 - 10, sclRes.getScaledHeight() / 2 + 30, 0xF0);
				}
			}
		} else if(sclRes.getScaledHeight() == 509) {
			fontrenderer.drawString("PayDay: " + Utils.PayDayTime, sclRes.getScaledWidth() - sclRes.getScaledWidth() / 9 - 6, sclRes.getScaledHeight() / 2 - 10, 65280);
			fontrenderer.drawString("Durst: " + Utils.Thirst, sclRes.getScaledWidth() - sclRes.getScaledWidth() / 9 - 6, sclRes.getScaledHeight() / 2, 65280);
			fontrenderer.drawString("Bargeld: " + Utils.BarMoney, sclRes.getScaledWidth() - sclRes.getScaledWidth() / 9 - 6, sclRes.getScaledHeight() / 2 + 10, 65280);
			fontrenderer.drawString("Bankgeld: " + Utils.BankMoney, sclRes.getScaledWidth() - sclRes.getScaledWidth() / 9 - 6, sclRes.getScaledHeight() / 2 + 20, 65280);
			if(FactionUtils.isCopOrFBI == true) {
				if(Utils.TazerEnabled == true) {
					String res = "an";
					fontrenderer.drawString("Tazer: an", sclRes.getScaledWidth() - sclRes.getScaledWidth() / 9 - 6, sclRes.getScaledHeight() / 2 + 30, 0xF0);
				} else if(Utils.TazerEnabled == false) {
					String res = "aus";
					fontrenderer.drawString("Tazer: aus", sclRes.getScaledWidth() - sclRes.getScaledWidth() / 9 - 6, sclRes.getScaledHeight() / 2 + 30, 0xF0);
				}
			}
		}
		
		}
  }
}