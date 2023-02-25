/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author 14313
 */
public class Card {

    private Colour colour;
    private Face face;

    public Card(Colour colour, Face face) {
        this.colour = colour;
        this.face = face;
    }

    public Colour getColour() {
        return colour;
    }

    public Face getFace() {
        return face;
    }

    public String toString() {
        return colour.getColour() + " " + face.getFace();
    }
}
