package org.example;


import java.sql.SQLOutput;
import java.util.*;

public class Main {
    static void br() {
        System.out.println("----------------------------------------------------------");
    }
    public static void main(String[] args) {
        System.out.println("------------ *** TASK 1 OUTPUTS *** ------------");
        br();
        checkForPalindrome("TEST İNPUT !'^;.,;:  öÖçÇşŞiİğĞüÜ");
        br();
        checkForPalindrome("A man, a plan, a canal: Panama");
        br();
        checkForPalindrome("EY EDİP ADANADA PİDE YE !..");
        br();
        checkForPalindrome("      RACE CAR");
        br();
        checkForPalindrome("      ĞÜ madam üğ");
        br();
        checkForPalindrome(" kayak !'^.+'%");
        br();
        checkForPalindrome("MARABAYIN");
        br();
        checkForPalindrome(" cİvİc ::;;??___!!!!");
        br();
        checkForPalindrome("ŞOK'A KOŞ");
        br();
        checkForPalindrome("");
        br();
        checkForPalindrome("             ");


    }
// seçenekler: -StringBuilder, char[] arrayi ,for döngüsü // iterator, Stream API, StringChecker
    public static boolean checkForPalindrome(String input) {

// null veya boşluk inputlarını kabul etmemek istersek:
        if (input == null || input.isBlank()) {
            System.out.println("You did not type an input!");
            return false;
        }

        System.out.println("Original input, before any process: " + input);


        // Noktalamaları, boşlukları kaldır ve TR'ye göre küçük harfe dönüştür
        input = input.replaceAll("[\\p{Punct}\\s]", "").toLowerCase(Locale.forLanguageTag("tr-TR"));
        System.out.println("Cleaned and formatted version: " + input);


//  1-) String builder ile:
//
//        String reversed = new StringBuilder(input).reverse().toString();
//        System.out.println("Cleaned + reversed version: " + reversed);
//        boolean isPalindrome = input.equals(reversed);
//        System.out.println("Are " + input + " and " + reversed + " equals ? " + (input.equals(reversed) ? true : false));
//        return isPalindrome;


//     2-) char[] arrayi ile:
//
//        char[] charArray = input.toCharArray();
//        String reversed = "";
//
//        for (int i = charArray.length - 1; i >= 0; i--) {
//            reversed += charArray[i];
//        }
//        boolean isPalindrome = input.equals(reversed);
//        System.out.println("Are " + input + " and " + reversed + " equals ? " + (input.equals(reversed) ? true : false));
//        return isPalindrome;


//        // 3-) FOR loop veya Iterator ile
//            String reversed = "";
//            for ( int i = 0 ; i < input.length() ; i++) {
//                reversed += input.charAt(i);
//            }
//       //Palindrom kontrolü
//      boolean isPalindrome = input.equals(reversed);
//
//        if(isPalindrome) {
//            System.out.println("Are " + input + " and " + reversed + " equals ? " + true);
//            return true;
//        } else {
//            return false;
//        }


//     // 4-) Stream API ile ( char[] 'a çok benziyor )
//        String reversed = new StringBuilder(input)
//                .reverse()
//                .toString();
//
//       //Palindrom kontrolü
//        boolean isPalindrome = input.equals(reversed.toString());
//        System.out.println("Are " + input + " and " + reversed + " equals? " + isPalindrome);
//        return isPalindrome;

////       // 5-) char arrayi ve iterator kullanarak:
//// Char array oluştur ve iterator kullanarak ters çevirme
//        char[] charArray = input.toCharArray();
//        StringBuilder reversed = new StringBuilder();
//        Iterator<Character> iterator = new String(input).chars().mapToObj(c -> (char) c).iterator();
//
//        while (iterator.hasNext()) {
//            reversed.insert(0, iterator.next());
//        }
//
//        // Palindrom kontrolü
//        boolean isPalindrome = input.contentEquals(reversed);
//        System.out.println("Are " + input + " and " + reversed + " equals? >>> " + isPalindrome);
//        return isPalindrome;
//

        // 6-) StringChecker
        StringBuilder reversed = new StringBuilder(input.length());
        for (char c : input.toCharArray()) {
            reversed.insert(0, c); // Efficiently build the reversed string
        }

        boolean isPalindrome = input.contentEquals(reversed);
        System.out.println("Are " + input + " and " + reversed + " equals? >>> " + isPalindrome);
        return isPalindrome;
    }
}