package com.example.modules;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent;
import net.minecraft.entity.player.EntityPlayer;

public class Flight extends Module {

    public Flight() {
        super("Flight", false);
    }

    @Override
        public void tick(TickEvent.PlayerTickEvent event) {
            if(enabled) {
                EntityPlayer player = event.player;
                player.capabilities.isFlying = true;
                player.sendPlayerAbilities();
            }
            else {
                EntityPlayer player = event.player;
                player.capabilities.isFlying = false;
                player.sendPlayerAbilities();
            }

        }
    }