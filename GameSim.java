/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author 14313
 */
public class GameSim {

    private CircularDoublyLinkedList<Player> players;
    private Deck deck;
    private Card card;
    private int count = 0;

    public GameSim(CircularDoublyLinkedList<Player> players) {
        deck = new Deck();
        this.players = players;
        start();
    }

    private void start() {
        deck.shuffle();
        System.out.println("Let's play Uno \nFirst Card");
        deal(7, players, deck);
        card = drawFirstCard();
        realGame();
    }

    private void realGame() {
        Card nowCard = card;
        Player p = players.first();
        boolean valid = true;
        while (valid) {
            p.showHand();
            Card tester = card;
            nowCard = cardSelectorAndPlayer(tester, p);

            if (p.getHand().isEmpty()) {                
                valid = false;
                System.out.println(p + " wins.");
            }
            if (nowCard == null) {
                turnSelector(nowCard);
                p = players.first();
            } else {
                if (nowCard.getColour() == Colour.BLACK) {
                    System.out.println(p + " has played " + nowCard);
                    nowCard = new Card(p.getHand().get(0).getColour(), Face.WILD);
                    System.out.println("The colour is " + nowCard.getColour());
                } else {
                    System.out.println(p + " has played " + nowCard);
                }
                if (p.getHand().size() == 1) {
                    System.out.println(p + " says Uno.");
                }
                card = nowCard;
                turnSelector(nowCard);
                p = players.first();
            }
        }
    }

    private void turnSelector(Card c) {
        try {
            if (c.getFace() == Face.SKIP) {
                nextTurn();
                players.first().showHand();
                System.out.println(players.first() + " has skipped");
            }
            if (c.getFace() == Face.REVERSE) {
                System.out.println("Game has reversed the direction");
                count++;
            }
            nextTurn();
        } catch (NullPointerException e) {
            nextTurn();
        }
    }

    private Card cardSelectorAndPlayer(Card c, Player now) {
        boolean valid = false;
        Player p = now;
        Card cd1 = null;
        if (!valid) {
            cd1 = checkColourFromHand(p, c);
            if (p.getHand().contains(cd1)) {
                valid = true;
            }
        }
        if (!valid) {
            cd1 = checkFaceFromHand(p, c);
            if (p.getHand().contains(cd1)) {
                valid = true;
            }
        }
        if (!valid) {
            cd1 = checkWild(p);
            if (cd1 != null) {
                valid = true;
            }
        }
        if (!valid) {
            Card drawFromPile = deck.removeCard();
            boolean newValid = false;
            if (!newValid) {
                cd1 = drawFromPile;
                System.out.println(p.getName() + " has no play, draws " + cd1);
                p.addCard(cd1);
                if (c.getColour() == cd1.getColour()) {
                    newValid = true;
                }
                if (!newValid) {
                    if (c.getFace() == cd1.getFace()) {
                        newValid = true;
                    }
                }
            }
            //System.out.println();
            valid = newValid;
        }
        if (valid) {
            return p.removeCard(cd1);
        }
        System.out.println(p.getName() + " can't play it.");
        return null;
    }

    private void nextTurn() {
        if (count % 2 == 0) {
            players.rotateForward();
        } else {
            players.rotateBackward();
        }
    }

    public void show() {
        players.first().showHand();
    }

    private Card drawFirstCard() {
        Card crd = deck.removeCard();
        if (crd.getColour() == Colour.BLACK) {
            crd = deck.removeCard();
        }
        System.out.println(crd);
        return crd;
    }

    private Card checkWild(Player p) {
        for (Card c : p.getHand()) {
            if (c.getColour() == Colour.BLACK) {
                return c;
            }
        }
        return null;
    }

    private Card checkColourFromHand(Player p, Card c) {
        for (Card cd : p.getHand()) {
            if (cd.getColour() == c.getColour()) {
                return cd;
            }
        }
        return c;
    }

    private Card checkFaceFromHand(Player p, Card c) {
        for (Card cd : p.getHand()) {
            if (cd.getFace() == c.getFace()) {
                return cd;
            }
        }
        return c;
    }

    private void deal(int x, CircularDoublyLinkedList<Player> list, Deck d) {
        for (int i = 0; i < x; i++) {
            Player p = list.first();
            for (int j = 0; j < list.size(); j++) {
                if (j == 0) {
                    p.addCard(d.removeCard());
                } else {
                    list.rotateForward();
                    p = list.first();
                    p.addCard(d.removeCard());
                }
            }
        }
    }
}
