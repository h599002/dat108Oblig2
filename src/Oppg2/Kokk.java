package Oppg2;

import java.util.Random;

public class Kokk extends Thread{

    private String navn;
    private long tid;
    private boolean fortsette = true;
    private HamburgerBrett brett;

    // for å generere tilfeldig tid per burger mellom 1.5 og 5 sek
    // ikke nødvendig, men gøy
    private int MAX = 5000;
    private int MIN = 1500;

    // Har med brett i konstruktøren sånn at alle kan jobbe med samme brett
    public Kokk(String navn, HamburgerBrett brett){
        this.navn = navn;
        this.brett = brett;
        tid = (long) ((Math.random() * (MAX - MIN)) + MIN);
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
            boolean god = false;
            while(!god) {
                Hamburger hmb = new Hamburger();
                god = brett.leggPaa(hmb);
                if(!god) {
                    System.out.println(navn + " (kokk)  er klar med hamburger " + hmb.toString() + ", men brettet er fullt. Venter!");
                    try {
                        sleep(1000);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
            }

        }

    }
}
