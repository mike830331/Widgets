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

        int totalBatches = (int) Math.ceil((double) quantity / engine.getBatchSize());
        double totalCost = totalBatches * engine.getCostPerBatch();

        engine.stop();
        return totalCost;
    }

    public void startEngine() {
        engine.start();
    }
}


