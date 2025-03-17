package com.worldline.interview;

public class SteamEngine implements Engine {
    private boolean running = false;
    private String fuelType;
    private double fuelLevel = 0;
    private static final int BATCH_SIZE = 2;

    @Override
    public void fillFuel(String fuelType, double amount) {
        if (!fuelType.equals("wood") && !fuelType.equals("coal")) {
            throw new IllegalArgumentException("Invalid fuel type for Steam Engine");
        }
        this.fuelType = fuelType;
        this.fuelLevel = amount;
    }

    @Override
    public void start() {
        if (fuelType == null) {
            throw new IllegalStateException("Engine must be initialized with fuel before starting.");
        }
        if (fuelLevel <= 0) {
            throw new IllegalStateException("Fuel level must be greater than zero.");
        }
        running = true;
    }

    @Override
    public void stop() {
        running = false;
    }

    @Override
    public boolean isRunning() {
        return running;
    }

    @Override
    public double getCostPerBatch() {
        if ("wood".equals(fuelType)) return 4.35;
        if ("coal".equals(fuelType)) return 5.65;
        return 0;
    }

    @Override
    public int getBatchSize() {
        return BATCH_SIZE;
    }
}


