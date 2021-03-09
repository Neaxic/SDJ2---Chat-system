package Radiator;

public class Radiator {
    private RadiatorState currentState = new Offstate();
    private int power;

    public void turnUp (){
        currentState.turnUp(this);

    };

    public void turnDown() {
        currentState.turnDown(this);
    };

    public int getPower() {
        return currentState.getPower();
    };

    //SPØRG
    public void setPowerState(RadiatorState state)  {
        this.currentState = state;

    }
}
