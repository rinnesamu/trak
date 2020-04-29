/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package usingjcapi;

import java.util.*;
/**
 *
 * @author kamaj
 */
public class UsingJCAPI {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        ArrayList<TrafficCard> cardUsers = new ArrayList<TrafficCard>();
        RandomString rString = new RandomString(10);
        float genBalance;
        TrafficCard myCard;
        Random r = new Random();
        int i;
        for (i = 0; i < 10; i++) {
            genBalance = ((float) r.nextInt(1000) / 10);
            myCard = new TrafficCard(r.nextInt(100), rString.nextString(), genBalance);
            cardUsers.add(myCard);
        }
        
        Iterator itr = cardUsers.iterator();
        while (itr.hasNext()) {
            System.out.println(itr.next());
        }
        //teht19
        System.out.println();
        System.out.println("Sorting cards by number");
        Collections.sort(cardUsers);
        //cardUsers.sort(null);
        itr = cardUsers.iterator();
        while (itr.hasNext()) {
            System.out.println(itr.next());
        }
        
        // teht 20
        System.out.println();
        System.out.println("Sorting cards by Name");
        Collections.sort(cardUsers, new NameComparator());
        //cardUsers.sort(null);
        itr = cardUsers.iterator();
        while (itr.hasNext()) {
            System.out.println(itr.next());
        }
        System.out.println();
        System.out.println("Sorting cards by Balance");
        Collections.sort(cardUsers, new BalanceComparator());
        //cardUsers.sort(null);
        itr = cardUsers.iterator();
        while (itr.hasNext()) {
            System.out.println(itr.next());
        }
        
        // teht21
        
        System.out.println();
        System.out.println("Sorting cards by number with lambda");
        Collections.sort(cardUsers, (TrafficCard card1, TrafficCard card2) ->{
            return card1.mTravellerNumber - card2.mTravellerNumber;
        });
        
        itr = cardUsers.iterator();
        while(itr.hasNext()) {
            System.out.println(itr.next());
        }
        
        //teht 22
        System.out.println();
        System.out.println("Printing all cards where number is under 70 and balance is between 20 and 80");
        
        cardUsers.stream()
        .filter(t -> t.mTravellerNumber < 70 && t.mBalance >= 20 && t.mBalance <= 80)
        .forEach(e -> System.out.println(e.toString()));

    }
    
}
