package com.worldline.interview;

public interface Engine {
    void fillFuel(String fuelType, double amount);
    void start();
    void stop();
    boolean isRunning();
    double getCostPerBatch();
    int getBatchSize();
}

