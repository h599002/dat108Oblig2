package Oppg3;

import java.util.Random;
import java.util.concurrent.BlockingQueue;

public class Kokk extends Thread{

    private String navn;
    private long tid;
    private boolean fortsette = true;
    private final HamburgerBrett brett;

    // for å generere tilfeldig tid per burger mellom 1.5 og 5 sek
    // ikke nødvendig, men gøy
    private int MAX = 5000;
    private int MIN = 1500;

    // Har med brett i konstruktøren sånn at alle kan jobbe med samme brett
    public Kokk(String navn, HamburgerBrett brett){
        this.navn = navn;
        tid = (long) ((Math.random() * (MAX - MIN)) + MIN);
        this.brett = brett;
    }

    public void stopp() {
        fortsette = false;
    }
    @Override
    public void run() {

        while(fortsette){
            try {
                sleep(tid);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            Hamburger hmb = new Hamburger();
            brett.leggPaa(hmb);
            System.out.println(navn + " (kokk)  la på hamburger" + hmb.toString() + ". Brett: " + brett.toString());
        }

    }

    @Override
    public String toString() {
        return navn;
    }
}
