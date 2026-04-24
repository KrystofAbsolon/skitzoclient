package com.example.modules;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.EntityPlayer;

public class Flight extends Module {

    public Flight() {
        super("Flight", false);
    }

    @Override
        public void onEvent(Object event) {
            if(event instanceof TickEvent.ClientTickEvent) {
                EntityPlayer player = Minecraft.getMinecraft().player;
                if(player != null) {
                    if(enabled)
                        player.capabilities.isFlying = true;
                    else
                        player.capabilities.isFlying = false;
                    player.sendPlayerAbilities();
                }
            }
        }
    }