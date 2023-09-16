package Oppg2;

public class Main {

    public static void main(String[] args) {
        HamburgerBrett brett = new HamburgerBrett();
        brett.leggPaa(new Hamburger());
        brett.leggPaa(new Hamburger());
        brett.leggPaa(new Hamburger());
        brett.leggPaa(new Hamburger());
        System.out.println(brett.toString());

    }
}
