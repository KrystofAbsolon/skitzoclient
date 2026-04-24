package com.example.modules;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent;
import net.minecraft.client.Minecraft;
import net.minecraft.client.multiplayer.PlayerControllerMP;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;

public class KillAura extends Module {

    public KillAura() {
        super("KillAura", false);
    }

    @Override
    public void onEvent(Object event) {
        if(event instanceof TickEvent.ClientTickEvent && enabled) {
            EntityPlayer player = Minecraft.getMinecraft().player;
            PlayerControllerMP pc = Minecraft.getMinecraft().playerController;
            if(player != null) {
                for (Entity e : player.getEntityWorld().loadedEntityList) {
                    if (e instanceof EntityLivingBase && e != player) {
                        double dist = player.getDistance(e);
                        if (dist <= 6.0 && pc != null) {
                            pc.attackEntity(player, e);
                        }
                    }
                }
            }
        }
    }
}