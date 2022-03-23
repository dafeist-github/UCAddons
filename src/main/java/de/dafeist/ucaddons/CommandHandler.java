     package de.dafeist.ucaddons;
     
import de.dafeist.ucaddons.commands.SupportUCAddons;
import de.dafeist.ucaddons.commands.altf4;
import de.dafeist.ucaddons.commands.cpconnect;
import de.dafeist.ucaddons.commands.cpconnectinfo;
import de.dafeist.ucaddons.commands.geknebelt;
import de.dafeist.ucaddons.commands.medicaktis;
import de.dafeist.ucaddons.commands.medicaktitabelle;
import de.dafeist.ucaddons.commands.reconnect;
import de.dafeist.ucaddons.commands.registerOwnHouse;
import de.dafeist.ucaddons.commands.reinf;
import de.dafeist.ucaddons.commands.toggleCPinfo;
import de.dafeist.ucaddons.commands.togglefbiorcop;
import de.dafeist.ucaddons.commands.ucaddonsdiscord;
import de.dafeist.ucaddons.commands.ucaddonsinfo;
import net.minecraft.command.ICommand;
import net.minecraftforge.client.ClientCommandHandler;
     
     public class CommandHandler {
       public static void init() {
       ClientCommandHandler.instance.registerCommand((ICommand)new registerOwnHouse());
       ClientCommandHandler.instance.registerCommand((ICommand)new SupportUCAddons());
       ClientCommandHandler.instance.registerCommand((ICommand)new reinf());
       //ClientCommandHandler.instance.registerCommand((ICommand)new grreinf());
       ClientCommandHandler.instance.registerCommand((ICommand)new reconnect());
       ClientCommandHandler.instance.registerCommand((ICommand)new cpconnect());
       ClientCommandHandler.instance.registerCommand((ICommand)new cpconnectinfo());
       ClientCommandHandler.instance.registerCommand((ICommand)new ucaddonsdiscord());
       ClientCommandHandler.instance.registerCommand((ICommand)new ucaddonsinfo());
       ClientCommandHandler.instance.registerCommand((ICommand)new toggleCPinfo());
       ClientCommandHandler.instance.registerCommand((ICommand)new togglefbiorcop());
       ClientCommandHandler.instance.registerCommand((ICommand)new geknebelt());
       ClientCommandHandler.instance.registerCommand((ICommand)new medicaktis());
       ClientCommandHandler.instance.registerCommand((ICommand)new medicaktitabelle());
       //ClientCommandHandler.instance.registerCommand((ICommand)new ulink());
       //ClientCommandHandler.instance.registerCommand((ICommand)new ulogin());
         
       if (ConfigHandler.AltF4Command == true) {
         ClientCommandHandler.instance.registerCommand((ICommand)new altf4()); 
         
       }
       }
     }
