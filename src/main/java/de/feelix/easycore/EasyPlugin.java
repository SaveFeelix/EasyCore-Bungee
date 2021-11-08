package de.feelix.easycore;

import de.feelix.easycore.utils.Register;
import net.md_5.bungee.api.CommandSender;
import net.md_5.bungee.api.ProxyServer;
import net.md_5.bungee.api.plugin.Plugin;

/**
 * Default Plugin Class to create a {@link net.md_5.bungee.api.plugin.Plugin}
 */
public abstract class EasyPlugin extends Plugin {

    /**
     * Reference to the ServerConsole
     */
    public static final CommandSender console = ProxyServer.getInstance().getConsole();

    /**
     * Reference to the {@link de.feelix.easycore.utils.Register} Class to register Commands/Listener
     */
    protected final Register register = new Register(this);

    @Override
    public abstract void onLoad();
    @Override
    public abstract void onEnable();
    @Override
    public abstract void onDisable();

    /**
     * Prepared Method to init Commands
     */
    public abstract void initCommands();

    /**
     * Prepared Method to init Listeners
     */
    public abstract void initListeners();

    /**
     * Prepared Method to init Utils
     */
    public abstract void initUtils();

    /**
     * Prepared Method to init Configs
     */
    public abstract void initConfigs();
}
