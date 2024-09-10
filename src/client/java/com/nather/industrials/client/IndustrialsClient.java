package com.nather.industrials.client;

import net.fabricmc.api.ClientModInitializer;

public class IndustrialsClient implements ClientModInitializer {

    @Override
    public void onInitializeClient() {
        ModItems.initialize();
    }
}
