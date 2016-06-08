/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pietra;

import java.util.Scanner;

public class Pietra {

    public static void main(String[] args) {
        boolean pierwszy = true;
        int piwnica = 0;
        Scanner input = new Scanner(System.in);
        String poziomy = input.nextLine(); // zmienna przechowyjaca instrukcje
        int polecenia = poziomy.length();
        int licznik = 0; //poziom piwnicy na ktorym znajduje sie mikolaj
        for (int i = 0; polecenia > i; i++) {

            if (poziomy.charAt(i) == '(') {
                licznik++;
            } else if (poziomy.charAt(i) == ')') {
                licznik--;
            }
            //    System.out.println(i + "   Poziom    "+ licznik);
            if (pierwszy == true && licznik < 0) {
                piwnica = i + 1;
                pierwszy = false;
            }
        }
        
        if (pierwszy == false) {
            System.out.println("do pwinicy mikolaj pierwsyz raz dostarczyl prezent: " +piwnica);
        }
        System.out.println("Mikolaju jestes na: " + licznik);
    }

}
