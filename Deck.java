/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author 14313
 */
public class Deck {

    private SinglyLinkedList<Card> set;

    public Deck() {
        set = new SinglyLinkedList<>();
        createCards();
    }

    private void createCards() {
        Colour[] colour = Colour.values();
        Face[] face = Face.values();
        for (int i = 0; i < colour.length; i++) {
            for (int j = 0; j < face.length; j++) {
                if (colour[i] != Colour.BLACK && face[j] != Face.WILD) {
                    Card c = new Card(colour[i], face[j]);
                    set.addFirst(c);
                    set.addFirst(c);
                }
            }
        }
        Card d = new Card(Colour.BLACK, Face.WILD);
        for (int i = 0; i < 4; i++) {
            set.addFirst(d);
        }
    }

    public void shuffle() {
        for (int j = 0; j < 6; j++) {
            SinglyLinkedList<Card> set1 = new SinglyLinkedList<>();
            SinglyLinkedList<Card> set2 = new SinglyLinkedList<>();
            for (int i = 0; i < 50; i++) {
                set1.addFirst(set.removeFirst());
            }
            for (int i = 0; i < 50; i++) {
                set2.addFirst(set.removeFirst());
            }
            for (int i = 0; i < 50; i++) {
                set.addFirst(set1.removeFirst());
                set.addFirst(set2.removeFirst());

            }
        }
    }

    public Card removeCard() {
        return set.removeFirst();
    }

    public void seeCards() {
        System.out.println(set);
        System.out.println(set.getSize());
    }
}
