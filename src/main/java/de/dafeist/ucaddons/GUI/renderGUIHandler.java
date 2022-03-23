package de.dafeist.ucaddons.GUI;

import de.dafeist.ucaddons.ConfigHandler;
import de.dafeist.ucaddons.utils.Utils;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.gui.ScaledResolution;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class renderGUIHandler {
	private ScaledResolution sclRes;
	
   @SubscribeEvent
   public void onRenderGui(RenderGameOverlayEvent.Text event) {
	   if(Utils.CPInfoEnabled == true) {
		   	int color = 65280;
		   	if(ConfigHandler.PurpleGUI == true) color = 6684927;
	        final FontRenderer fontrenderer = Minecraft.getMinecraft().fontRenderer;
	        final ScaledResolution sclRes = new ScaledResolution(Minecraft.getMinecraft());
	        final int offsetAndMargin = (int) (fontrenderer.FONT_HEIGHT + (fontrenderer.FONT_HEIGHT/4.0f));
	        GlStateManager.pushMatrix();
	        GlStateManager.scale(1, 1, 1);
	        GlStateManager.translate(
	        sclRes.getScaledWidth() - 8,
	        sclRes.getScaledHeight() / 2.0f, 0);
	        renderWithXOffset("PayDay: " + Utils.PayDayTime, 0, fontrenderer, color);
	        renderWithXOffset("Durst: " + Utils.Thirst, offsetAndMargin, fontrenderer, color);
	        renderWithXOffset("Bargeld: " + Utils.BarMoney, offsetAndMargin * 2, fontrenderer, color);
	        renderWithXOffset("Bankgeld: " + Utils.BankMoney, offsetAndMargin * 3, fontrenderer, color);
	        GlStateManager.popMatrix();
	        GlStateManager.color(1, 1, 1);
	   /*FontRenderer fontrenderer = Minecraft.getMinecraft().fontRenderer;
	   sclRes = new ScaledResolution(Minecraft.getMinecraft());
	   double val1 = sclRes.getScaledHeight() / 50 + 1;
	   if(sclRes.getScaleFactor() < 3) val1 = val1 + 4; 
        GlStateManager.pushMatrix();
        GlStateManager.translate(sclRes.getScaledWidth() - fontrenderer.getStringWidth("PayDay: " + Utils.PayDayTime) - 5, sclRes.getScaledHeight() / 2 + val1, 0);
        GlStateManager.scale(1, 1, 1);
        fontrenderer.drawString("PayDay: " + Utils.PayDayTime, 0, 0, 65280);
        GlStateManager.popMatrix();
        GlStateManager.pushMatrix();
        GlStateManager.translate(sclRes.getScaledWidth() - fontrenderer.getStringWidth("PayDay: " + Utils.PayDayTime) - 5, sclRes.getScaledHeight() / 2, 0);
        GlStateManager.scale(1, 1, 1);
        fontrenderer.drawString("Durst: " + Utils.Thirst, 0, 0, 65280);
        GlStateManager.popMatrix();
        GlStateManager.pushMatrix();
        GlStateManager.translate(sclRes.getScaledWidth() - fontrenderer.getStringWidth("PayDay: " + Utils.PayDayTime) - 5, sclRes.getScaledHeight() / 2 - val1, 0);
        GlStateManager.scale(1, 1, 1);
        fontrenderer.drawString("Bargeld: " + Utils.BarMoney, 0, 0, 65280);
        GlStateManager.popMatrix();
        GlStateManager.pushMatrix();
        GlStateManager.translate(sclRes.getScaledWidth() - fontrenderer.getStringWidth("PayDay: " + Utils.PayDayTime) - 5, sclRes.getScaledHeight() / 2 - 2*val1, 0);
        GlStateManager.scale(1, 1, 1);
        fontrenderer.drawString("Bankgeld: " + Utils.BankMoney, 0, 0, 65280);
        GlStateManager.popMatrix();*/

	   }
	   
		/*if(Utils.CPInfoEnabled == true) {
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
		} else if(sclRes.getScaledHeight() == 768) {
			fontrenderer.drawString("PayDay: " + Utils.PayDayTime, sclRes.getScaledWidth() - sclRes.getScaledWidth() / 9 - 6, sclRes.getScaledHeight() / 2 - 10, 65280);
			fontrenderer.drawString("Durst: " + Utils.Thirst, sclRes.getScaledWidth() - sclRes.getScaledWidth() / 9 - 6, sclRes.getScaledHeight() / 2, 65280);
			fontrenderer.drawString("Bargeld: " + Utils.BarMoney, sclRes.getScaledWidth() - sclRes.getScaledWidth() / 9 - 6, sclRes.getScaledHeight() / 2 + 10, 65280);
			fontrenderer.drawString("Bankgeld: " + Utils.BankMoney, sclRes.getScaledWidth() - sclRes.getScaledWidth() / 9 - 6, sclRes.getScaledHeight() / 2 + 20, 65280);
			if(FactionUtils.isCopOrFBI == true) {
				if(Utils.TazerEnabled == true) {
					String res = "an";
					fontrenderer.drawString("Tazer: an", sclRes.getScaledWidth() - sclRes.getScaledWidth() / 12 - 6, sclRes.getScaledHeight() / 2 + 30, 0xF0);
				} else if(Utils.TazerEnabled == false) {
					String res = "aus";
					fontrenderer.drawString("Tazer: aus", sclRes.getScaledWidth() - sclRes.getScaledWidth() / 12 - 6, sclRes.getScaledHeight() / 2 + 30, 0xF0);
				}
			}
		} else if(sclRes.getScaledHeight() == 1017) {
			fontrenderer.drawString("PayDay: " + Utils.PayDayTime, sclRes.getScaledWidth() - sclRes.getScaledWidth() / 9, sclRes.getScaledHeight() / 2 - 10, 65280);
			fontrenderer.drawString("Durst: " + Utils.Thirst, sclRes.getScaledWidth() - sclRes.getScaledWidth() / 9, sclRes.getScaledHeight() / 2, 65280);
			fontrenderer.drawString("Bargeld: " + Utils.BarMoney, sclRes.getScaledWidth() - sclRes.getScaledWidth() / 9, sclRes.getScaledHeight() / 2 + 10, 65280);
			fontrenderer.drawString("Bankgeld: " + Utils.BankMoney, sclRes.getScaledWidth() - sclRes.getScaledWidth() / 9, sclRes.getScaledHeight() / 2 + 20, 65280);
			if(FactionUtils.isCopOrFBI == true) {
				if(Utils.TazerEnabled == true) {
					String res = "an";
					fontrenderer.drawString("Tazer: an", sclRes.getScaledWidth() - sclRes.getScaledWidth() / 12 - 6, sclRes.getScaledHeight() / 2 + 30, 0xF0);
				} else if(Utils.TazerEnabled == false) {
					String res = "aus";
					fontrenderer.drawString("Tazer: aus", sclRes.getScaledWidth() - sclRes.getScaledWidth() / 12 - 6, sclRes.getScaledHeight() / 2 + 30, 0xF0);
				}
			}
		
		}
  }*/
	   
	   
	   
	   
	   /*int val1 = sclRes.getScaledWidth() / 7;
	   int val2 = sclRes.getScaledHeight() / 2;
	   int val3 = sclRes.getScaledHeight() / 25;
		fontrenderer.drawString("PayDay: " + Utils.PayDayTime, sclRes.getScaledWidth() - val1, val2 - val3, 65280);
		fontrenderer.drawString("Durst: " + Utils.Thirst, sclRes.getScaledWidth() - val1, val2, 65280);
		fontrenderer.drawString("Bargeld: " + Utils.BarMoney, sclRes.getScaledWidth() - val1, val2 + val3, 65280);
		fontrenderer.drawString("Bankgeld: " + Utils.BankMoney, sclRes.getScaledWidth() - val1, val2 + val3, 65280);
		*/
	   
	   
		
	   //int val1 = Minecraft.getMinecraft().displayWidth / 7;
	   //int val2 = Minecraft.getMinecraft().displayHeight / 2;
	   //int val3 = Minecraft.getMinecraft().displayHeight / 25;
	//fontrenderer.drawString("PayDay: " + Utils.PayDayTime, Minecraft.getMinecraft().displayWidth - val1, val2 - val3, 65280);
	//fontrenderer.drawString("Durst: " + Utils.Thirst, Minecraft.getMinecraft().displayWidth - val1, val2, 65280);
	//fontrenderer.drawString("Bargeld: " + Utils.BarMoney, Minecraft.getMinecraft().displayWidth - val1, val2 + val3, 65280);
	//fontrenderer.drawString("Bankgeld: " + Utils.BankMoney, Minecraft.getMinecraft().displayWidth - val1, val2 + val3, 65280);
	   
	   
	   
   }
   
   private static void renderWithXOffset(final String string, final int y, final FontRenderer fontrenderer, final int color) {
       fontrenderer.drawString(string, -fontrenderer.getStringWidth("PayDay: " + Utils.PayDayTime), y, color);
   }
   
}