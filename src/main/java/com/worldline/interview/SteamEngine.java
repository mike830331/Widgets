package com.worldline.interview;

import java.util.EnumSet;
import java.util.Set;

public class SteamEngine extends Engine {

    public SteamEngine() {
        super(2);
    }

    @Override
    public Set<FuelType> getSupportedFuels() {
        return EnumSet.of(FuelType.WOOD, FuelType.COAL);
    }

    @Override
    public double getFuelCost(FuelType fuelType) {
        return switch (fuelType) {
            case WOOD -> 4.35;
            case COAL -> 5.65;
            default -> throw new IllegalArgumentException("Unsupported fuel for Steam Engine");
        };
    }
}


