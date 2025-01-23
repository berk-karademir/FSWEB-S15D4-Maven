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
        checkForPalindrome("3553");
        br();
        checkForPalindrome("12345");
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

        System.out.println();
        System.out.println("------------ *** TASK 2 OUTPUTS *** ------------");
        System.out.println("----- with STRING INPUTS  -----");

        WorkintechList<String>educatorList = new WorkintechList<>();
        educatorList.add("Gökhan");
        educatorList.add("Emre");
        educatorList.add("Zeynep");
        educatorList.add("Ömer");
        educatorList.add("Dogancan");
        educatorList.add("Emrah");

        System.out.println("Was 'Berk' able to add for the second time ? " + educatorList.add("Ömer"));// !!! duplicate, eklememeli
        System.out.println("Was 'Emre' able to add for the second time ? " + educatorList.add("Emre"));// !!! duplicate, eklememeli
        System.out.println("So, size of Educator List must be 6 ? " + (educatorList.size() == 6 ? "True" : "False"));

        System.out.println("Full educatorList: " + educatorList);
        educatorList.sort();
        System.out.println("Full educatorList after sort method call: " + educatorList);
        System.out.println("Did 'Zeynep' get removed ? " + educatorList.remove("Zeynep"));
        System.out.println("Did 'Ahmet' get removed ? " + educatorList.remove("Ahmet"));
        System.out.println("So, size of Educator List must be 5 now ? " + (educatorList.size() == 5 ? "True" : "False"));
        System.out.println("Final status of educatorList: " + educatorList);





        System.out.println();
        System.out.println("----- another example with STRING INPUTS  -----");

        WorkintechList<String> list = new WorkintechList<>();

        // Türkçe karakterler içeren bir liste
        list.add("Elma");
        list.add("Armut");
        list.add("üzüm");
        list.add("İncir");
        list.add("ıhlamur");
        list.add("Çilek");
        list.add("ÜzÜm");
        list.add("geyik");
        list.add("Geyik");
        list.add("şeftali");
        list.add("Zeytin");
        list.add("Ğeyik");

        System.out.println("Sıralamadan Önce:");
        list.forEach(System.out::println);

        // Sıralama işlemi
        list.sort();

        System.out.println("\nSıralamadan Sonra:");
        list.forEach(System.out::println);


        System.out.println();
        WorkintechList<String> turkishList = new WorkintechList<>();

        // Eleman ekleme işlemleri
        System.out.println("Eleman ekleme:");
        System.out.println("Ali eklendi mi? " + turkishList.add("Ali"));
        System.out.println("Gamze eklendi mi? " + turkishList.add("Gamze"));
        System.out.println("Ayşe eklendi mi? " + turkishList.add("Ayşe"));
        System.out.println("Zeynep eklendi mi? " + turkishList.add("Zeynep"));
        System.out.println("Ali tekrar eklendi mi? " + turkishList.add("Ali")); // Aynı eleman tekrar eklenemez
        System.out.println("Mehmet eklendi mi? " + turkishList.add("Mehmet"));
        System.out.println("Ğamze eklendi mi? " + turkishList.add("Ğamze"));

        System.out.println("Liste: " + turkishList);

        System.out.println("\nListe sıralanıyor...");
        turkishList.sort();
        System.out.println("Sıralanmış liste: " + turkishList);

        System.out.println("\nEleman silme:");
        System.out.println("Ayşe silindi mi? " + turkishList.remove("Ayşe"));
        System.out.println("Fatma silindi mi? " + turkishList.remove("Fatma")); // Listede olmayan eleman
        System.out.println("Liste: " + turkishList);

        System.out.println("\nListe sıralanıyor...");
        turkishList.sort();
        System.out.println("Sıralanmış liste: " + turkishList);

        System.out.println("\nBoş liste üzerinde sıralama:");
        WorkintechList<String> emptyList = new WorkintechList<>();
        emptyList.sort();
        System.out.println("Boş liste: " + emptyList);





        System.out.println();
        System.out.println("----- with INTEGER INPUTS  -----");

        WorkintechList<Integer> integerList = new WorkintechList<>();
        integerList.add(150);
        integerList.add(20);
        integerList.add(5);
        integerList.add(-50);
        integerList.add(-10);
        System.out.println("Integer liste: " + integerList);
        integerList.sort();
        System.out.println("Sıralanmış integer liste: " + integerList);




        System.out.println("------------ *** TASK 3 OUTPUTS *** ------------");
        convertDecimalToBinary(5);
        convertDecimalToBinary(6);
        convertDecimalToBinary(13);
    }

    // ----------------------------------  TASK 1  -------------------------------------------
// seçenekler: -StringBuilder, char[] arrayi ,for döngüsü // iterator, Stream API, StringChecker
    public static boolean checkForPalindrome(String input) {

// null veya boşluk inputlarını kabul etmemek istersek:
        if (input == null || input.isBlank()) {
            System.out.println("You did not type an input!");
            return false;
        }

        System.out.println("Original input, before any process: " + input);


        // Noktalamaları, boşlukları kaldır ve TR'ye göre küçük harfe dönüştür
        input = input.replaceAll("[\\p{Punct}\\s]", "").toLowerCase(Locale.ENGLISH);
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

//        // 6-) StringChecker
//        StringBuilder reversed = new StringBuilder(input.length());
//        for (char c : input.toCharArray()) {
//            reversed.insert(0, c); // Efficiently build the reversed string
//        }
//
//        boolean isPalindrome = input.contentEquals(reversed);
//        System.out.println("Are " + input + " and " + reversed + " equals? >>> " + isPalindrome);
//        return isPalindrome;
        String reverse = new StringBuilder(input).reverse().toString();
        return input.equals(reverse);
    }




    // ----------------------------------  TASK 3  -------------------------------------------
    public static String convertDecimalToBinary(int decimalNumber) {
        // Kalanları saklamak için bir List oluştur
        List<Integer> remainders = new ArrayList<>();

        // Decimal sayı sıfır olana kadar işlemi yap
        while (decimalNumber > 0) {
            int remainder = decimalNumber % 2; // 2'ye bölünmeden kalan
            remainders.add(remainder); // Kalanı listeye ekle
            decimalNumber = decimalNumber / 2; // Sayıyı 2'ye böl
        }

        // Listeyi ters çevir
        Collections.reverse(remainders);

        // Liste elemanlarını String'e dönüştür ve birleştir
        StringBuilder binaryString = new StringBuilder();
        for (int bit : remainders) {
            binaryString.append(bit);
        }
        System.out.println("Binary format of " + decimalNumber + " is: " + binaryString);
        return binaryString.toString();
    }


}