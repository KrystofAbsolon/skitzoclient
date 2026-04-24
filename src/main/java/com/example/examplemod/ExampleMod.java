package com.example.examplemod;

import java.util.HashMap;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent;

import org.apache.logging.log4j.Logger;

import com.example.gui.TabGUI;
import com.example.gui.TabInput;
import com.example.modules.Flight;
import com.example.modules.Module;
import com.example.modules.Sprint;

@Mod(modid = ExampleMod.MODID, name = ExampleMod.NAME, version = ExampleMod.VERSION)
public class ExampleMod
{
    public static final String MODID = "skitzoclient";
    public static final String NAME = "Skitzo Client";
    public static final String VERSION = "1.0";

    public static HashMap<String, Module> modules = new HashMap<>();

    @EventHandler
    public void init(FMLInitializationEvent event) {
        modules.put("Flight", new Flight());
        modules.put("Sprint", new Sprint());

        MinecraftForge.EVENT_BUS.register(new TabGUI());
        MinecraftForge.EVENT_BUS.register(new TabInput());
    }

    @Mod.EventBusSubscriber
    public static class Events {
        @SubscribeEvent
        public static void onPlayerTick(TickEvent.PlayerTickEvent event) {
            modules.values()
            .forEach(m -> m.tick(event));
        }
    }
}
