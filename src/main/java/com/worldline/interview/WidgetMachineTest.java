package com.worldline.interview;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class WidgetMachineTest {

    private WidgetMachine widgetMachine;
    private SteamEngine steamEngine;
    private InternalCombustionEngine combustionEngine;

    @Before
    public void setUp() {
        steamEngine = new SteamEngine();
        combustionEngine = new InternalCombustionEngine();
    }

    @Test
    public void testSteamEngineProduction() {
        steamEngine.fillFuel(FuelType.WOOD, 10);
        widgetMachine = new WidgetMachine(steamEngine);
        widgetMachine.startEngine();
        double cost = widgetMachine.produceWidgets(5); // 5 widgets with batch size 2
        assertEquals(13.05, cost, 0.01); // 3 batches * £4.35
    }

    @Test
    public void testSteamEngineFailsWithoutFuel() {
        WidgetMachine machine = new WidgetMachine(steamEngine);
        assertThrows(IllegalStateException.class, machine::startEngine);
    }

    @Test
    public void testInternalCombustionEngineProduction() {
        combustionEngine.fillFuel(FuelType.PETROL, 20);
        widgetMachine = new WidgetMachine(combustionEngine);
        widgetMachine.startEngine();
        double cost = widgetMachine.produceWidgets(16); // 16 widgets with batch size 8
        assertEquals(18.00, cost, 0.01); // 2 batches * £9.00
    }

    @Test
    public void testInternalCombustionEngineWithoutFuel() {
        WidgetMachine machine = new WidgetMachine(combustionEngine);
        assertThrows(IllegalStateException.class, machine::startEngine);
    }

    @Test
    public void testInvalidFuelType() {
        assertThrows(IllegalArgumentException.class, () -> combustionEngine.fillFuel(FuelType.WOOD, 10));
    }
}


