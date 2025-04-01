package com.worldline.interview;

import java.util.EnumSet;
import java.util.Set;

public class InternalCombustionEngine extends Engine {

    public InternalCombustionEngine() {
        super(8);
    }

    @Override
    public Set<FuelType> getSupportedFuels() {
        return EnumSet.of(FuelType.PETROL, FuelType.DIESEL);
    }

    @Override
    public double getFuelCost(FuelType fuelType) {
        return switch (fuelType) {
            case PETROL -> 9.00;
            case DIESEL -> 12.00;
            default -> throw new IllegalArgumentException("Unsupported fuel for Internal Combustion Engine");
        };
    }
}


