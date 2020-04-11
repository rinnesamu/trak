/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package minheap;

/**
 *
 * @author kamaj
 */
public class Menu {
//main alkaa-----------------------------------------------------------------------------
        public static void main(String[] args) {

                        printMenu();

        }
//main loppuu --------------------------------------------------------------------------
//printMenu alkaa------------------------------------------------------------------
        private static void printMenu() {
                char select;
                MinHeap search = new MinHeap(100);
                String data;
                do {

                        System.out.println("\n\t\t\t1. Lisää avain.");
                        System.out.println("\t\t\t2. Poista pienin.");
                        System.out.println("\t\t\t3. Käy kaikki alkiot läpi suuruusjärjestyksessä");
                        System.out.println("\t\t\t4. lopetus ");
                        System.out.print("\n\n"); // tehdään tyhjiä rivejä
                        select = Lue.merkki();
                        switch (select) {
                        case '1':
                            System.out.println("Anna uusi avain (merkkijono)");
                            data = new String(Lue.rivi());
                            search.insertValue(data);
                            break;
                        case '2':
                        		Node deleted = search.deleteMin();
                                if(deleted!=null){
                                    System.out.println("Avain " + deleted.getData() + " poistettiin");
                                }
                                else
                                    System.out.println("Tyhjästä ei voi poistaa");
                                                           
                            break;
                        case '3':
                            search.print();
                            char h = Lue.merkki(); // pysäytetään kontrolli
                            break;
                        case '4':
                            break;
                        }
                }
                while (select != '4');
        }
//printMenu loppuu ----------------------------------------------------------------
}

