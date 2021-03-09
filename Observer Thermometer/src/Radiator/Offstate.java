package Radiator;

public class Offstate implements RadiatorState{
    private int POWER = 0;


    @Override
    public void turnUp(Radiator r) {
        System.out.println("Turning up");
        r.setPowerState(new Power1State());
    }

    @Override
    public void turnDown(Radiator r) {
        System.out.println("System already off");
    }

    @Override
    public int getPower() {
        return POWER;
    }
}
