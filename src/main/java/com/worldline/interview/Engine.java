package com.worldline.interview;

import java.util.Set;

public abstract class Engine {
    protected boolean running = false;
    protected FuelType fuelType;
    protected double fuelLevel = 0;
    private final int batchSize;

    protected Engine(int batchSize) {
        this.batchSize = batchSize;
    }

    public abstract Set<FuelType> getSupportedFuels();

    public abstract double getFuelCost(FuelType fuelType); // Delegates cost calculation to subclasses

    public void fillFuel(FuelType fuelType, double amount) {
        if (!getSupportedFuels().contains(fuelType)) {
            throw new IllegalArgumentException("Invalid fuel type: " + fuelType);
        }
        this.fuelType = fuelType;
        this.fuelLevel = amount;
    }

    public void start() {
        if (fuelType == null || fuelLevel <= 0) {
            throw new IllegalStateException("Engine must have fuel before starting.");
        }
        running = true;
    }

    public void stop() {
        running = false;
    }

    public boolean isRunning() {
        return running;
    }

    public double getCostPerBatch() {
        if (fuelType == null) {
            throw new IllegalStateException("Cannot calculate cost without fuel.");
        }
        return getFuelCost(fuelType); // Calls subclass method for fuel cost
    }

    public int getBatchSize() {
        return batchSize;
    }
}

