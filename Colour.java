/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author 14313
 */
public enum Colour {
    BLUE("Blue"), RED("Red"), GREEN("Green"), YELLOW("Yellow"), BLACK("Wild");
    private String colour;

    private Colour(String colour) {
        this.colour = colour;
    }

    public String getColour() {
        return colour;
    }
}
