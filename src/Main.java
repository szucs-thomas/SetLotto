import java.util.HashSet;
import java.util.Random;
import java.util.Scanner;
import java.util.Set;

public class Main {
    public static boolean tartalmaz(Set<Integer> tippek, int tipp) {
        boolean tartalmaz = false;
        for (Integer i : tippek) {
            if (i == tipp) {
                tartalmaz = true;
                break;
            }
        }
        return tartalmaz;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random ran = new Random();

        Set<Integer> nyeroszamok = new HashSet<>();     // nem ismétlődhet.
        Set<Integer> tippek = new HashSet<>();

        for (int i = 0; i < 7; i++) {
            int szam;
            do {
                szam = ran.nextInt(35) + 1;
            } while (nyeroszamok.contains(szam));
            nyeroszamok.add(szam);
        }
        /*System.out.println("Nyeroszamok:");   // megmutatja a generált nyerőszámokat.
        for (Integer s : nyeroszamok) {
            System.out.println(s);
        }*/
        for (int i = 0; i < 7; i++) {
            boolean ujra;
            int tipp;
            do {
                System.out.print("Kérem tippeljen 1-35-ig számokat.: ");
                tipp = sc.nextInt();
                ujra = tartalmaz(tippek, tipp);

                if (ujra && tipp != 0) {
                    System.out.println("Ez a tipp már volt, adj meg másikat.");
                } else if (tipp < 1 || tipp > 35) {
                    System.out.println("Kérlek 1-35-ig adj meg számokat.");
                    ujra = true;
                }
            } while (ujra);
            tippek.add(tipp);
        }
        
       /* System.out.println("Tippek"); // kiirja a megadott tippeket.
        for (Integer i : tippek) {
            System.out.println(i);
        }*/
        System.out.println("Találat: ");
        tippek.retainAll(nyeroszamok);  // a tippekben csak az marad baenne ami megvan a nyerőszámokban is.
        for (Integer i : tippek) {
            System.out.println(i);
        }


    }
}