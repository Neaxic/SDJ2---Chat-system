package External;

import Radiator.Radiator;
import temperature.mediator.TemperatureModel;

public class Thermometer implements Runnable{
    private String id;
    private double t;
    private int d;
    private TemperatureModel model;
    private int power = 0;

    public int getMaxValue() {
        return maxValue;
    }

    public int getMinValue() {
        return minValue;
    }

    private Radiator r;
    private int maxValue = 20;
    private int minValue = -20;

    public Thermometer(String id, double t, int d, TemperatureModel model) {
        this.id = id;
        this.t = t;
        this.d = d;
        this.model = model;
    }

    private double temperature(double t, int p, int d, double t0, int s)
    {
        double tMax = Math.min(11 * p + 10, 11 * p + 10 + t0);
        tMax = Math.max(Math.max(t, tMax), t0);
        double heaterTerm = 0;
        if (p > 0)

        {
            double den = Math.max((tMax * (20 - 5 * p) * (d + 5)), 0.1);
            heaterTerm = 30 * s * Math.abs(tMax - t) / den;
        }
        double outdoorTerm = (t - t0) * s / 250.0;
        this.t = Math.min(Math.max(t - outdoorTerm + heaterTerm, t0), tMax);
        return t;
    }

    @Override
    public void run() {
        while(true){
            temperature(t,2,d,0,6);
            model.addTemperature(id,t);
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public String GetId() {
        return this.id;
    }




    public boolean isCriticalTemp() {
        if (t > maxValue || t < minValue) {
            return true;
        } else return false;
    }

    public void setMaxValue(int maxValue) {
        this.maxValue = maxValue;
    }

    public void setMinValue(int minValue) {
        this.minValue = minValue;
    }
}
