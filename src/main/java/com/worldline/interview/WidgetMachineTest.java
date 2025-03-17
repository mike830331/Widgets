package com.worldline.interview;

import org.junit.Before;
import org.junit.Test;


import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class WidgetMachineTest {
    private WidgetMachine widgetMachine;
    private SteamEngine steamEngine;

    @Before
    public void setUp() {
        steamEngine = new SteamEngine();
        steamEngine.fillFuel("wood", 10);
        widgetMachine = new WidgetMachine(steamEngine);
    }

    @Test
    public void testSteamEngineProduction() {
        widgetMachine.startEngine();
        double cost = widgetMachine.produceWidgets(5); // 5 widgets with batch size 2
        assertEquals(13.05, cost, 0.01); // 3 batches * £4.35
    }

    @Test
    public void testSteamEngineFailsWithoutFuel() {
        SteamEngine emptyEngine = new SteamEngine();
        WidgetMachine machine = new WidgetMachine(emptyEngine);
        assertThrows(IllegalStateException.class, machine::startEngine);
    }
}


