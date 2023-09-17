package Oppg3;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws InterruptedException {
        int KAPASITET = 4;
        HamburgerBrett brett = new HamburgerBrett(KAPASITET);

        Kokk[] kokker = new Kokk[4];
        Servitor[] servitorer = new Servitor[2];
        Kokk k1 = new Kokk("Nils", brett);
        Kokk k2 = new Kokk("Arne", brett);
        Kokk k3 = new Kokk("Janne", brett);
        Kokk k4 = new Kokk("Mathilde", brett);
        kokker[0] = k1;
        kokker[1] = k2;
        kokker[2] = k3;
        kokker[3] = k4;
        Servitor s1 = new Servitor("Jon", brett);
        Servitor s2 = new Servitor("Kent", brett);
        servitorer[0] = s1;
        servitorer[1] = s2;

        System.out.println("I denne simuleringen har vi:");
        System.out.println(kokker.length + " kokker: " + Arrays.toString(kokker));
        System.out.println(servitorer.length + " servitorer: " + Arrays.toString(servitorer));
        System.out.println("Vi starter:");

        for(Kokk t : kokker){
            t.start();
        }
        for(Servitor t : servitorer){
            t.start();
        }


        try {
            Thread.sleep(15000);                 //1000 milliseconds is one second.
        } catch(InterruptedException ex) {
            Thread.currentThread().interrupt();
        }

        for(Kokk t : kokker){
            t.stopp();
            //t.join();
        }
        for(Servitor t : servitorer){
            t.stopp();
            // Burde man ha t.join(); også her?
        }
    }
}
