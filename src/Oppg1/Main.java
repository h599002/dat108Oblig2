package Oppg1;

import javax.swing.*;

public class Main {
    private static String melding = "Hallo verden!";
    private static Boolean fortsette = true;
    public static void main(String[] args) {


        Thread printlnTraad = new Thread() {
            @Override
            public void run() {
                while (fortsette) {
                    System.out.println(melding);
                    try {
                        Thread.sleep(3000);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
        };

        Thread endreMeldingtraad = new Thread() {
            @Override
            public void run() {
                while(fortsette) {
                    melding = JOptionPane.showInputDialog("Skriv inn melding, quit om du vil avslutte.");
                    if(melding.equalsIgnoreCase("quit")){
                        fortsette = false;
                    }
                }
            }
        };

        printlnTraad.start();
        endreMeldingtraad.start();
    }

}
