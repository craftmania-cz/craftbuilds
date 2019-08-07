package cz.craftmania.builds;

import cz.craftmania.builds.listeners.BlockListener;
import cz.craftmania.builds.listeners.ChatListener;
import cz.craftmania.builds.listeners.LoginListener;
import cz.craftmania.builds.sql.SQLManager;
import cz.craftmania.builds.tasks.ATCheckerTask;
import org.bukkit.entity.Player;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.ArrayList;

public final class Main extends JavaPlugin {

    private static Main instance;
    private SQLManager sql;
    public ArrayList<Player> at_list = new ArrayList<>();
    private String idServer;

    @Override
    public void onEnable() {

        // Instance
        instance = this;

        // Config
        getConfig().options().copyDefaults(true);
        saveDefaultConfig();

        // ID serveru z configu
        idServer = getConfig().getString("server");

        // HikariCP
        initDatabase();

        // Listeners
        loadListeners();
        loadCommands();

        // Tasks
        getServer().getScheduler().runTaskTimerAsynchronously(this, new ATCheckerTask(), 200, 1200);

    }

    @Override
    public void onDisable() {

        // Deaktivace MySQL
        sql.onDisable();

        instance = null;
    }

    public static Main getInstance() {
        return instance;
    }

    private void loadListeners() {
        PluginManager pm = getServer().getPluginManager();
        pm.registerEvents(new LoginListener(), this);
        pm.registerEvents(new ChatListener(), this);
        pm.registerEvents(new BlockListener(), this);
    }

    private void loadCommands() {

    }

    public SQLManager getMySQL() {
        return sql;
    }

    private void initDatabase() {
        sql = new SQLManager(this);
    }

    public String getIdServer() {
        return idServer;
    }
}
