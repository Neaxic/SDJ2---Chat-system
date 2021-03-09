package Radiator;

public class Power3State implements RadiatorState{
    private int POWER = 3;
    Thread t0;

    public Power3State(Radiator r){
        t0 = new Thread(()->{
            try {
                Thread.sleep(20000);
                this.turnDown(r);
            } catch (InterruptedException e) {
                System.out.println("Sleep interrupted");
            }
        }
        );

        t0.setDaemon(true);
        t0.start();
    }

    @Override
    public void turnUp(Radiator r) {
        System.out.println("Cant turn more up");
    }

    @Override
    public void turnDown(Radiator r) {
        System.out.println("Turning down");
        t0.interrupt();
        r.setPowerState(new Power2State());
    }

    @Override
    public int getPower() {
        return POWER;
    }
}
