package me.aleiv.core.paper.commands;

import org.bukkit.Material;
import org.bukkit.command.CommandSender;

import co.aikar.commands.BaseCommand;
import co.aikar.commands.annotation.CommandAlias;
import co.aikar.commands.annotation.CommandPermission;
import co.aikar.commands.annotation.Subcommand;
import lombok.NonNull;
import me.aleiv.core.paper.Core;

@CommandAlias("global")
@CommandPermission("admin.perm")
public class GlobalCMD extends BaseCommand {

    private @NonNull Core instance;

    public GlobalCMD(Core instance) {
        this.instance = instance;

    }

    @Subcommand("clear")
    public void clear(CommandSender sender){

        var game = instance.getGame();
        game.getMaterials().clear();
        sender.sendMessage("Cleared materials.");

    }

    @Subcommand("add")
    public void add(CommandSender sender, Material material){

        var game = instance.getGame();
        game.getMaterials().add(material);
        sender.sendMessage("Added " + material + " material.");

    }
}
