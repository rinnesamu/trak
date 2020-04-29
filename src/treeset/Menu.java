/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package treeset;

import java.util.Iterator;
import java.util.TreeSet;

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
                TreeSet<Integer> tree = new TreeSet<Integer>();
                Integer data;
                do {

                        System.out.println("\n\t\t\t1. Lisää avain.");
                        System.out.println("\t\t\t2. Etsi avaimella.");
                        System.out.println("\t\t\t3. Käy puu läpi (inOrder).");
                        System.out.println("\t\t\t4. lopetus ");
                        System.out.print("\n\n"); // tehdään tyhjiä rivejä
                        select = Lue.merkki();
                        switch (select) {
                        case '1':
                            System.out.println("Anna uusi avain (merkkijono)");
                            data = new Integer(Lue.rivi());
                            tree.add(data);
                            break;
                        case '2':                           
                                System.out.println("Anna etsittävä avain (merkkijono)");
                                data = new Integer(Lue.rivi());
                                if (tree.contains(data) == true){
                                    System.out.println("Avain löytyi.");
                                }
                                else
                                    System.out.println("Avainta ei löytynyt.");
                                                           
                            break;
                        case '3':
                        	Iterator<Integer> i = tree.iterator();
                            while(i.hasNext()) {
                                System.out.print(i.next() + " ");
                            }
                            System.out.println();
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

