package Radiator;

public class Power2State implements RadiatorState{
    private int POWER = 2;

    @Override
    public void turnUp(Radiator r) {
        System.out.println("Turning up");
        r.setPowerState(new Power3State(r));
    }

    @Override
    public void turnDown(Radiator r) {
        System.out.println("Turning down");
        r.setPowerState(new Power1State());
    }

    @Override
    public int getPower() {
        return POWER;
    }
}
