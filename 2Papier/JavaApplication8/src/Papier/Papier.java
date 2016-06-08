/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Papier;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Papier {

    public static void main(String[] args) throws FileNotFoundException {

//        File wymiary = new File("wymiary.txt");
//        Scanner odczyt = new Scanner("wymiary.txt");
//        String text = odczyt.next();
//        System.out.println(text);
        int papier = 0;
        int ribbon = 0;
        int licznik = 0;
        //int min;
        FileReader fr = null;
        String linia = "";

        // OTWIERANIE PLIKU:
        try {
            fr = new FileReader("wymiary.txt");
        } catch (FileNotFoundException e) {
            System.out.println("BŁĄD PRZY OTWIERANIU PLIKU!");
            System.exit(1);
        }

        BufferedReader bfr = new BufferedReader(fr);
        // ODCZYT KOLEJNYCH LINII Z PLIKU:
        try {
            while ((linia = bfr.readLine()) != null) {

                String[] split = linia.split("x");
                int l = Integer.valueOf(split[0]);
                int w = Integer.valueOf(split[1]);
                int h = Integer.valueOf(split[2]);
                papier += 2 * l * w + 2 * w * h + 2 * h * l + minimalny(l, w, h, false);
                ribbon += minimalny(l, w, h, true);
                //  System.out.println("l:" + l + " w: " + w + " h: " + h + " min: " + minimalny(l, w, h, false) + " papier: "+ papier + "  wstążka: " + ribbon);
                System.out.println("l:" + l + " w: " + w + " h: " + h + " min: " + minimalny(l, w, h, true) + " wstążka: " + ribbon);
                        // Integer.valueOf() przydatna metoda zmienia stringi inty

                //    System.out.println(linia);
            }
            System.out.println("a oto ilosc papieru: " + papier + "  no i oczywiscie wstażki: " + ribbon);
        } catch (IOException e) {
            System.out.println("BŁĄD ODCZYTU Z PLIKU!");
            System.exit(2);
        }

        // ZAMYKANIE PLIKU
        try {
            fr.close();
        } catch (IOException e) {
            System.out.println("BŁĄD PRZY ZAMYKANIU PLIKU!");
            System.exit(3);
        }
    }

    public static int minimalny(int l, int w, int h, boolean wstazka) {
        int pole = 0;
        int rib = 0;
        if (l >= w && l >= h) {
            pole = w * h;
            rib = 2 * w + 2 * h + l * h * w;
        }
        if (w >= l && w >= h) {
            pole = l * h;
            rib = 2 * l + 2 * h + l * h * w;
        }
        if (h >= w && h >= l) {
            pole = w * l;
            rib = 2 * w + 2 * l + l * h * w;
        }
        if (wstazka == false) {
            return pole;
        } else {
            return rib;
        }
    }

}
