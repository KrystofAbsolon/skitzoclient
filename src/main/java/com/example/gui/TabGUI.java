package com.example.gui;
import java.util.ArrayList;

import com.example.examplemod.ExampleMod;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Gui;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class TabGUI {

    public static int selected = 0;

    private ArrayList<String> options; 

    @SubscribeEvent
    public void onRender(RenderGameOverlayEvent.Text event) {
        options = new ArrayList<>(ExampleMod.modules.keySet());

        Minecraft mc = Minecraft.getMinecraft();

        int x = 5;
        int y = 5;

        for (int i = 0; i < options.size(); i++) {

            int color = (ExampleMod.modules.get(options.get(i)).isEnabled()) ? 0xFF00FF00 : 0xFFFFFFFF;
            if(i == selected)
                color = 0xFFFFFF00;

            mc.fontRenderer.drawString(options.get(i), x, y + (i * 10), color);
        }
    }
}