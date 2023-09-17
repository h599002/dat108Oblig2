package Oppg3;

public class Hamburger {
    private int nummer;
    private static int antall = 1;

    public Hamburger(){
        nummer = antall;
        antall++;
    }


    @Override
    public String toString() {
        return "◖" + nummer + "◗";
    };
}

