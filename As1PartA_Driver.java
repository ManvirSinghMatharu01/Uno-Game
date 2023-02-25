/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author 14313
 */
public class As1PartA_Driver {

    public static void main(String[] args) {
        CircularDoublyLinkedList<Player> players = new CircularDoublyLinkedList<>();
        Deck d = new Deck();
        Player p = new Player("Nala");
        Player s = new Player("Simba");
        Player k = new Player("Pumba");
        Player r = new Player("Timon");
        players.addFirst(p);
        players.addFirst(s);
        players.addFirst(k);
        players.addFirst(r);       
        GameSim g = new GameSim(players);
        
    }
}
