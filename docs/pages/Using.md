# Using
<hr />

1. [Basics](#basics)
1. [Commands & Listener](#commands--listener)
<hr />
<hr />

## Basics
Here I explain how to create a default Plugin with the EasyCore-API.

Normally you use the class JavaPlugin to create a default Plugin.<br />
<u>Plugin:</u>
<details>
    <summary>Code Example</summary>

```java
import net.md_5.bungee.api.ProxyServer;
import net.md_5.bungee.api.chat.TextComponent;

public class MyPlugin extends JavaPlugin {
    @Override
    public void onEnable() {
        System.out.println("Plugin enabled");
        // or
        ProxyServer.getInstance().getConsole().sendMessage(new TextComponent("Plugin enabled"));
    }

    @Override
    public void onDisable() {
        System.out.println("Plugin disabled");
        // or
        ProxyServer.getInstance().getConsole().sendMessage(new TextComponent("Plugin disabled"));
    }
}
```
</details>
<hr />

Here you can use my API to create a Plugin.</br >
<u>EasyPlugin:</u>
<details>
    <summary>Code Example</summary>

```java
import de.feelix.easycore.EasyPlugin;

public class MyPlugin extends EasyPlugin {
    @Override
    public void onLoad() {
    }

    @Override
    public void onEnable() {

    }

    @Override
    public void onDisable() {

    }

    @Override
    public void initCommands() {

    }

    @Override
    public void initListeners() {

    }

    @Override
    public void initUtils() {

    }

    @Override
    public void initConfigs() {

    }
}
```
</details>
<hr />
<hr />

## Commands & Listener

You can also use my API to register Commands/Listener

<details>
<summary>Example to create a CommandClass</summary>

```java
import de.feelix.easycore.commands.abstracts.CommandExecutor;
import de.feelix.easycore.commands.interfaces.ICommandInformation;
import net.md_5.bungee.api.CommandSender;
import org.jetbrains.annotations.NotNull;

public class MyCommand extends CommandExecutor {
    public MyCommand(@NotNull ICommandInformation information) {
        super(information);
    }

    @Override
    public void execute(CommandSender commandSender, String[] strings) {
        // Your Code
    }
}
```
</details>
<br />

<details>
<summary>Example to create a ICommandInformationClass</summary>

```java
import de.feelix.easycore.commands.interfaces.ICommandInformation;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.Arrays;
import java.util.List;

public class MyCommandInformation implements ICommandInformation {
    @Override
    public @NotNull String getCommandName() {
        return "mycommand";
    }

    @Override
    public @Nullable String getCommandPermission() {
        return "my.command.permission.which.can.be.null";
    }

    @Override
    public @Nullable List<String> getCommandAliases() {
        return Arrays.asList("aliases", "also", "can", "be", "null");
    }
} 
```
</details>
<br />

<details>
<summary>Example to register a Command/Listener</summary>

```java
import de.feelix.easycore.EasyPlugin;
import de.feelix.easycore.commands.abstracts.CommandExecutor;
import de.feelix.easycore.commands.interfaces.ICommandInformation;
import de.feelix.easycore.exceptions.RegisterCommandException;
import de.feelix.easycore.utils.Register;
import jdk.Exported;
import net.md_5.bungee.api.CommandSender;
import net.md_5.bungee.api.chat.TextComponent;
import net.md_5.bungee.api.event.LoginEvent;
import net.md_5.bungee.api.plugin.Listener;
import net.md_5.bungee.event.EventHandler;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class MyMainClass extends EasyPlugin {

    // .....


    @Override
    public void onEnable() {
        initListener();
        initCommands();

        // You can also create a Register object in initUtils()
    }

    @Override
    public void initListener() {
        Register register = new Register(this);

        register.registerListener(new MyListener());
    }

    @Override
    public void initCommands() {
        Register register = new Register(this);
        try {
            register.registerCommand(new MyCommand(new MyCommandInformation()));
        } catch (RegisterCommandException e) {
            // Will be thrown, if the Command is not registered in the plugin.yml
            e.printStackTrace();
        }
    }

    // .....
}

// CommandClass
public class MyCommand extends CommandExecutor {
    public MyCommand(@NotNull ICommandInformation information) {
        super(information);
    }

    @Override
    public void execute(CommandSender commandSender, String[] strings) {
        // Your Code
    }
}

// CommandInformation
public class MyCommandInformation implements ICommandInformation {
    @Override
    public @NotNull String getCommandName() {
        return "mycommand";
    }

    @Override
    public @Nullable String getCommandPermission() {
        return "my.command.permission.which.can.be.null";
    }

    @Override
    public @Nullable List<String> getCommandAliases() {
        return Arrays.asList("aliases", "also", "can", "be", "null");
    }
}

// Listener
public class MyListener implements Listener {
    @EventHandler
    public void onLogin(LoginEvent event) {
        // I don't know what event.getConnection() returns xD
        MyMainClass.console.sendMessage(new TextComponent(event.getConnection().getName()));
    }
}

```
</details>

<hr />
<hr />