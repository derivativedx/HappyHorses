package com.perschmapples.horsepaths;

import com.sun.tools.javac.util.List;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Horse;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractAtEntityEvent;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.util.Vector;

import java.util.ArrayList;
import java.util.Arrays;

public class HorseMoveEvent implements Listener
{
    private ArrayList<Material> mmmmmmmlist = new ArrayList<>(Arrays.asList(Material.PODZOL, Material.COARSE_DIRT, Material.GRAVEL, Material.DIRT_PATH));

    @EventHandler
    public void onHorseWalk(PlayerMoveEvent e)
    {
        if(e.getPlayer().getVehicle() == null) return;

        if(e.getPlayer().getVehicle().getType().toString().contains("HORSE"))
        {
//            e.getPlayer().sendMessage("BLOCK: " + e.getPlayer().getVehicle().getLocation().subtract(0, 1, 0).getBlock().getType());
            if(mmmmmmmlist.contains(e.getPlayer().getVehicle().getLocation().subtract(0, 1, 0).getBlock().getType()))
            {
                Vector v = e.getPlayer()./*getVehicle().*/getVelocity();

                double xz = 28;
                double x = v.getX() * xz;
                double y = v.getY() * 1.3;
                double z = v.getZ() * xz;
//
                e.getPlayer().getVehicle().setVelocity(new Vector(x,y,z));
//                e.getPlayer().getVehicle().setVelocity(new Vector(v.getX()*2,v.getY(),v.getZ()*2));
            }
        }



//        e.getPlayer().sendMessage("x, z: " + e.getPlayer().getVehicle().getVelocity().getX() + ", " + e.getPlayer().getVehicle().getVelocity().getZ());
    }

    @EventHandler
    public void onClickHorseWithAppleGoldenYummy(PlayerInteractAtEntityEvent e)
    {
        if(!(e.getPlayer().getInventory().getItemInMainHand().getType() == Material.GOLDEN_APPLE)) return;
//        if(!e.getRightClicked().getType().toString().contains("HORSE")) return; // replaced with line below
        if(!(   e.getRightClicked().getType() == EntityType.HORSE ||
                e.getRightClicked().getType() == EntityType.SKELETON_HORSE ||
                e.getRightClicked().getType() == EntityType.ZOMBIE_HORSE)) return;
        if(!e.getPlayer().getInventory().getItemInMainHand().getItemMeta().equals(new ItemStack(Material.GOLDEN_APPLE).getItemMeta())) return;

        e.getPlayer().getInventory().getItemInMainHand().setAmount(e.getPlayer().getInventory().getItemInMainHand().getAmount() - 1);

        Horse h = (Horse) e.getRightClicked();
        h.setTamed(true);
        e.getPlayer().sendMessage(ChatColor.GOLD + "Horses " + ChatColor.BOLD + "LOVE " + ChatColor.GOLD + "golden apples!");

    }

}
