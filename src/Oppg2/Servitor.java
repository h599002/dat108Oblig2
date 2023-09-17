package Oppg2;

public class Servitor extends Thread{

    private String navn;
    private long tid;
    private boolean fortsette = true;
    private HamburgerBrett brett;

    private int MAX = 3000;
    private int MIN = 1000;

    public Servitor(String navn, HamburgerBrett brett){
        this.navn = navn;
        this.brett = brett;
        tid = (long) ((Math.random() * (MAX - MIN)) + MIN);
    }


    public void stopp(){
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
                Hamburger hmb = brett.taAv();
                if(hmb == null){
                    System.out.println(navn + " (servitør) ønsker å ta av hamburger, men brettet er tomt. Venter!");
                    try {
                        sleep(1000);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }

                } else {
                    god = true;
                    System.out.println(navn + " (servitør) tok av hamburger " + hmb.toString() + "." + brett.toString());

                }
            }

        }


    }
    @Override
    public String toString() {
        return navn;
    }
}
