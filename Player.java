/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author 14313
 */
import java.util.ArrayList;

public class Player {

    private String name;
    private ArrayList<Card> hand;

    public Player() {
        name = "unkown";
        hand = new ArrayList<>();
    }

    public Player(String name) {
        this.name = name;
        hand = new ArrayList<>();
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
    
    public ArrayList<Card> getHand(){
        return hand;
    }

    public void showHand() {
        System.out.println("");
        System.out.print(this.toString()+"'s hand: ( ");
        for (Card c : hand) {
            if (c != hand.get(hand.size() - 1)) {
                System.out.print(c + ", ");
            } else {
                System.out.print(c + " )");
            }
        }
        //System.out.println("");
        System.out.println("");
    }

    public void addCard(Card card) {
        hand.add(card);
    }

    public Card removeCard(Card card) {
        hand.remove(card);
        return card;
    }

    public String toString() {
        return name;
    }
}
