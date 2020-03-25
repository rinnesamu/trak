/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package sortingdemos;

/**
 *
 * @author kamaj
 */
import java.util.Random;

public class SortAlgorithms {
    final static int MAX=300000;
    static long counter = 0;

    public static void main(String[] args) {

    	counter = 0;
        selectSort();
        counter = 0;
        mergeSort();
        counter = 0;
        quickSortLoop();
    }

    public static void selectSort() {

        int[] taul = new int[MAX]; //taul tallettaa lajiteltavat tiedot
        int i, j, k, apu, pienin;
        Random r = new Random(); //luodaan satunnaislukugeneraattori
        System.out.println("Generoidaan syöttöaineisto: ");
        for (i=0;i<MAX;i++) {

            taul[i] = r.nextInt(1000); //generoidaan luvut
            System.out.print(taul[i]+" ");
            if (i>0 && i%40==0) // rivinvaihto
                System.out.println();
        }
        System.out.println("\nSuoritetaan valintalajittelu, paina Enter ");
        Lue.merkki();
        
        counter++; //ulompi loop
        for (i=0;i<MAX;i++) {
            pienin=i;
            counter++; //sisempi loop
            for (j=i+1;j<MAX;j++) {
                /* löytyykö taulukon loppupäästä pienempää alkiota? */
                if (taul[j] < taul[pienin]) {
                    pienin=j;
                }
                counter++; //if lause
                counter++; //sisempi loop
            }
            
            if (pienin != i) {
                /* jos löytyi suoritetaan alkioiden vaihto */
                apu=taul[pienin];
                taul[pienin]=taul[i];
                taul[i]=apu;
            }
            counter++; //if lause
            counter++; //ulompi loop
        }
        
        System.out.println();
        for (i=0;i<MAX;i++) {
            System.out.print(taul[i]+" ");
            if (i>0 && i%40==0) // rivinvaihto
                System.out.println();
        }
        System.out.println("\nKuittaa tulos, paina Enter. Vertailuja: " + counter);
        Lue.merkki();

    }

    public static void mergeSort() {
        int[] a= new int[MAX];
        int i;
        Random r = new Random(); //luodaan satunnaislukugeneraattori
        System.out.println("\nGeneroidaan syöttöaineisto: ");
        for (i=0;i<MAX;i++) {
            a[i] = r.nextInt(1000); //generoidaan luvut
            System.out.print(a[i]+" ");
            if (i>0 && i%40==0) // rivinvaihto
                System.out.println();
        }
        System.out.println("\nSuoritetaan lomituslajittelu, paina Enter ");
        Lue.merkki();

        mergeSort(a, 0, MAX-1);
        for (i=0;i<MAX;i++) {
            System.out.print(a[i]+" ");
            if (i>0 && i%40==0) // rivinvaihto
                System.out.println();     
        }
        System.out.println("\nKuittaa tulos, paina Enter. Vertailuja: " + counter);
        Lue.merkki();
    }

    private static int[] tau = new int[MAX]; // aputaulukko (ei varata tätä pinosta!)

    //oletus: osataulukot t[p..q] ja t[q+1...r] ovat järjestyksess„
    public static void merge(int t[], int p, int q, int r) {
        //i osoittaa 1. osataulukkoa, j osoittaa 2. osataulukkoa
        // k osoittaa aputaulukkoa, johon yhdiste kirjoitetaan.
        int i=p, j=q+1, k=0;
        counter = counter + 2; //eka while vertailu, kaksi vertailua
        while(i<q+1 && j<r+1) {
        	counter++; //if lause
                if (t[i]<t[j]) {
                        tau[k++]=t[i++];
                }
                else {
                        tau[k++]=t[j++];
                }
                
                counter = counter + 2; //toinen while vertailu, kaksi vertailua
                
        }
        //toinen osataulukko käsitelty, siirretään toisen käsittelemättömät
        counter++; //eka while vertailu
        while (i<q+1) {
            tau[k++]=t[i++];
            counter++; //toka while vertailu
        }
        counter++; //eka while vertailu
        while (j<r+1) {
                tau[k++]=t[j++];
                counter++; //tokawhile vertailu
        }
        //siirretään yhdiste alkuperäiseen taulukkoon
        counter++; //eka for
        for (i=0;i<k;i++) {
                t[p+i]=tau[i];
                counter++; //toka for
        }
    }

    public static void mergeSort(int t[],  int alku,  int loppu) {
        int ositus;
        long la, ll, lt;
        counter++; //if vertailu
        if (alku<loppu) { //onko väh. 2 alkiota, että voidaan suorittaa ositus

                la=alku; ll=loppu;
                lt=(la+ll)/2;
                ositus=(int)lt;
                mergeSort(t, alku, ositus);//lajitellaan taulukon alkupää
                mergeSort(t, ositus+1, loppu);//lajitellaan taulukon loppupää
                merge(t, alku, ositus, loppu);//yhdistetään lajitellut osataulukot
        }

    }
    
    public static void quickSortLoop() {
        int taulukko[] = new int[MAX];
        Random r = new Random();

        for (int i = 0; i < MAX; i++) {
            taulukko[i] = r.nextInt(1000);
            System.out.print(taulukko[i] + " ");
            if (i > 0 && i % 40 == 0) {// rivinvaihto
                System.out.println();
            }
        }
        System.out.println("\nJärjestellään käyttämällä Quicksorttia, paina Enter");
        Lue.merkki();
        qs(taulukko, MAX);
        System.out.println("Valmis");
        System.out.println("Vertailujen lukumäärä: " + counter);
    }

    public static void quickSort(int table[], int lo0, int hi0) {
        int lo = lo0;
        int hi = hi0;
        int mid, swap;

        mid = table[ (lo0 + hi0) / 2];
        counter++; //eka while alkaa
        while (lo <= hi) {
        	counter++; //toka while alkaa
            while (table[lo] < mid) {
                ++lo;
                counter++; //toka while loppuu
            }

            counter++; //kolmas while alkaa
            while (table[hi] > mid) {
                --hi;
                counter++; //kolmas while loppuu
            }

            counter++; //if lause
            if (lo <= hi) {
                swap = table[lo];
                table[lo] = table[hi];
                ++lo;
                table[hi] = swap;
                --hi;
            }
            counter++; //eka while loppuu
        }

        counter++; //if lause
        if (lo0 < hi) {
            quickSort(table, lo0, hi);
        }
        counter++; //if lause
        if (lo < hi0) {
            quickSort(table, lo, hi0);
        }
    }

    public static void qs(int table[], int values) {
        quickSort(table, 0, values - 1);

        System.out.println("\nJärjestetty aineisto:\n");
        for (int i = 0; i < values; i++) {
            System.out.print(table[i] + " ");
            if (i > 0 && i % 40 == 0) { // rivinvaihto
                System.out.println();
            }
        }
    }

}

