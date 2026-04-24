package com.example.modules;

import net.minecraftforge.fml.common.gameevent.TickEvent;

public class Module {

    protected final String name;
    protected boolean enabled;
    
    public Module(String name, boolean enabled) {
        this.name = name;
        this.enabled = enabled;
    }

    public void toggle() {
        enabled = !enabled;
        System.out.println(name + " " + enabled);
    }

    public String getName() {
        return name;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void tick(TickEvent.PlayerTickEvent event) {}

    
}
