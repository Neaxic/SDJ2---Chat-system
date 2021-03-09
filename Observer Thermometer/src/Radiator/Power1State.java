package Radiator;

import External.Thermometer;

public class Power1State implements RadiatorState {
        private int POWER = 1;

        @Override
        public void turnUp(Radiator r) {
                System.out.println("Turning up");
                r.setPowerState(new Power2State());

        }

        @Override
        public void turnDown(Radiator r) {
                System.out.println("Turning down");
                r.setPowerState(new Offstate());
        }

        @Override
        public int getPower() {
                return POWER;
        }
}


