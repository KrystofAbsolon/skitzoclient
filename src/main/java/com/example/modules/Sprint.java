package com.example.modules;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent;
import net.minecraft.entity.player.EntityPlayer;

public class Sprint extends Module {

    public Sprint() {
        super("Sprint", false);
    }

    @Override
    public void tick(TickEvent.PlayerTickEvent event) {
        if(enabled) {
            EntityPlayer player = event.player;
            player.setSprinting(true);
        }
    }
}