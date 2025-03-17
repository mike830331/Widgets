package com.worldline.interview;

public class WidgetMachine {
    private final Engine engine;

    public WidgetMachine(Engine engine) {
        this.engine = engine;
    }

    public double produceWidgets(int quantity) {
        if (!engine.isRunning()) {
            throw new IllegalStateException("Engine must be running before production.");
        }

        int batchSize = engine.getBatchSize();
        double costPerBatch = engine.getCostPerBatch();

        int totalBatches = (int) Math.ceil((double) quantity / batchSize);
        double totalCost = totalBatches * costPerBatch;

        engine.stop();
        return totalCost;
    }

    public void startEngine() {
        if (engine == null) {
            throw new IllegalStateException("Engine is not initialized.");
        }
        engine.start();
    }
}


