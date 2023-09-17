package Oppg3;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class HamburgerBrett {

    private BlockingQueue<Hamburger> brett;

    public HamburgerBrett(int kapasitet) {
        brett = new ArrayBlockingQueue<>(kapasitet);
    }

    public boolean leggPaa(Hamburger burger) {
        return brett.offer(burger);
    }
    public Hamburger taAv(){
        try{
            return brett.take();
        } catch (InterruptedException e){
            Thread.currentThread().interrupt();
            throw new RuntimeException(e);
        }
    };

    @Override
    public String toString() {
        return brett.toString();
    }
}

