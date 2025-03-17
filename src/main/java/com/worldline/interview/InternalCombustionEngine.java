package com.worldline.interview;

public class InternalCombustionEngine implements Engine {
    private boolean running = false;
    private String fuelType;
    private static final int BATCH_SIZE = 8;

    @Override
    public void fillFuel(String fuelType, double amount) {
        if (!fuelType.equals("petrol") && !fuelType.equals("diesel")) {
            throw new IllegalArgumentException("Invalid fuel type for Internal Combustion Engine");
        }
        this.fuelType = fuelType;
    }

    @Override
    public void start() {
        if (fuelType == null) {
            throw new IllegalStateException("Engine must be filled with fuel before starting.");
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
        if ("petrol".equals(fuelType)) return 9.00;
        if ("diesel".equals(fuelType)) return 12.00;
        return 0;
    }

    @Override
    public int getBatchSize() {
        return BATCH_SIZE;
    }
}


