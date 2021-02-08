package me.olliem5.ferox;

import me.olliem5.ferox.api.event.EventProcessor;
import me.olliem5.ferox.api.hud.ComponentManager;
import me.olliem5.ferox.api.module.ModuleManager;
import me.olliem5.ferox.api.theme.ThemeManager;
import me.olliem5.ferox.impl.commands.EchoCommand;
import me.olliem5.ferox.impl.gui.screens.click.ClickGUIWindow;
import me.olliem5.ferox.impl.gui.screens.editor.HUDEditorWindow;
import me.yagel15637.venture.manager.CommandManager;
import net.minecraftforge.common.MinecraftForge;

public final class StartupHelper {
    public static void startupFerox() {
        MinecraftForge.EVENT_BUS.register(new EventProcessor());
        Ferox.EVENT_BUS.subscribe(new EventProcessor());
        Ferox.log("Event Processor Initialized!");

        ModuleManager.init();
        Ferox.log("Modules Initialized!");

        ComponentManager.init();
        Ferox.EVENT_BUS.subscribe(new ComponentManager());
        Ferox.log("HUD Initialized!");

        ClickGUIWindow.initGui();
        Ferox.log("ClickGUI Windows Initialized!");

        HUDEditorWindow.initGui();
        Ferox.log("HUDEditor Windows Initialized!");

        ThemeManager.init();
        Ferox.log("Global GUI Themes Initialized!");

        initCommandManager();
        Ferox.log("Commands Initialized!");
    }

    private static void initCommandManager() {
        CommandManager.addCommands(
                new EchoCommand()
        );
    }
}
