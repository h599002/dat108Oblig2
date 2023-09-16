package Oppg2;

import java.util.Arrays;

public class HamburgerBrett {

    private final int MAKS = 4;
    private int antall;
    private Hamburger[] brett;

    public HamburgerBrett() {
        brett = new Hamburger[MAKS];
        antall = 0;
    }

    public synchronized boolean leggPaa(Hamburger burger) {
        if (antall < MAKS){
            brett[antall] = burger;
            antall++;
            return true;
        } else {
            return false;
        }
    }
    public synchronized Hamburger taAv(){
        Hamburger hmb = null;
        if(antall>0){
          hmb = brett[antall-1];
          brett[antall-1] = null;
          antall --;
        }
        return hmb;
    };

    @Override
    public String toString() {
        return Arrays.toString(brett);
    }
}
