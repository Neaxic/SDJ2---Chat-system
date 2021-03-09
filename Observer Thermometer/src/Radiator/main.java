package Radiator;

public class main {
    public static void main(String[] args) throws InterruptedException {
        Radiator rad = new Radiator();
        rad.turnUp();
        System.out.println(rad.getPower());
        rad.turnUp();
        rad.turnUp();
        rad.turnDown();



        System.out.println(rad.getPower());


        Thread.sleep(3000);
        System.out.println(rad.getPower());

    }



}
