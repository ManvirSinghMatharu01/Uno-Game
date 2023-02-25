/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author 14313
 */
import java.util.Scanner;

public class As1PartB_Driver {

    public static void main(String[] args) {
        Account a = new Account();
        Scanner kb = new Scanner(System.in);
        System.out.println("Make a selection \n1. Buy Shares \n2. Sell Shares \n3. Quit");
        int user = kb.nextInt();
        while (user < 3) {
            if (user == 1) {
                System.out.println("Enter the number of shares to buy: ");
                int num = kb.nextInt();
                System.out.println("Enter the purchase price per share:");
                int price = kb.nextInt();
                a.buyShares(num, price);
            }
            if (user == 2) {
                System.out.println("Enter the number of shares to sell: ");
                int num = kb.nextInt();
                System.out.println("Enter the selling price per share:");
                int price = kb.nextInt();
                a.sellShares(num, price);
            }
            System.out.println(a + "\n-----------------------------------1");
            System.out.println("Make a selection \n1. Buy Shares \n2. Sell Shares \n3. Quit");
            user = kb.nextInt();
        }
        System.out.println("End of Program.");
    }
}
