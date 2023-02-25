/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author 14313
 */
public class Account {

    private Queue<Integer> shares;
    private int assets = 0;

    public Account() {
        shares = new ArrayQueue<>();
    }

    public void buyShares(int number, int value) {
        for (int i = 0; i < number; i++) {
            shares.enqueue(value);
            assets += value;
        }
    }

    public void sellShares(int number, int value) {
        int capitalGain = 0;
        for (int i = 0; i < number; i++) {
            int shareThen = shares.dequeue();
            int profitOrLoss = value - shareThen;
            capitalGain +=  profitOrLoss;
        }
        int sold = number * value;
        assets = assets - sold + capitalGain;
        System.out.println("Capital gain is $ "+ capitalGain);
    }

    public int getTotalValue() {
        return assets;
    }

    public int getTotalShares() {
        return shares.size();
    }

    public String toString() {
        return "\nTotal shares: " + this.getTotalShares()
                + "\nTotal shares value: $" + this.getTotalValue();
    }
}
