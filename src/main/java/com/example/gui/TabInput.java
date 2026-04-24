package com.example.gui;

import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.InputEvent;

import java.util.ArrayList;

import org.lwjgl.input.Keyboard;

import com.example.examplemod.ExampleMod;

public class TabInput {

    private static ArrayList<String> options;
    @SubscribeEvent
    public void onKey(InputEvent.KeyInputEvent event) {
        options = new ArrayList<>(ExampleMod.modules.keySet());

        if (Keyboard.isKeyDown(Keyboard.KEY_DOWN)) {
            TabGUI.selected++;
            if (TabGUI.selected >= options.size()) TabGUI.selected = 0;
        }

        if (Keyboard.isKeyDown(Keyboard.KEY_UP)) {
            TabGUI.selected--;
            if (TabGUI.selected < 0) TabGUI.selected = options.size() - 1;
        }

        if (Keyboard.isKeyDown(Keyboard.KEY_RIGHT)) {
            ExampleMod.modules.get(options.get(TabGUI.selected)).toggle();
        }
    }
}