package Oppg3;

public class Servitor extends Thread{

    private String navn;
    private long tid;
    private boolean fortsette = true;
    private final HamburgerBrett brett;

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
            Hamburger hmb = brett.taAv();
            System.out.println(navn + " (servitor) tok av " + hmb.toString());
        }


    }
    @Override
    public String toString() {
        return navn;
    }
}
