package com.example.modules;
import net.minecraftforge.event.entity.living.LivingFallEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.EntityPlayer;

public class NoFall extends Module {

    public NoFall() {
        super("NoFall", false);
    }

    @Override
    public void onEvent(Object event) {
        if(event instanceof LivingFallEvent) {
            LivingFallEvent e = (LivingFallEvent)event;
            e.setCanceled(enabled);
        }
    }
}