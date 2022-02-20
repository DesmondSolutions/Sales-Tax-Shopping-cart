/*Second main function. The code can be run from here by getting the user inputs
* on the command line or console. The program will ask the user to input the items
* in which they want to calculate their sales tax. Items will be put in one after the
* other. At the end, the program will calculate the sales tax and display the results.
*
* NB: Make sure the inputs should match the once given in the task instructions since
* the program has been configured to work only for those products.
* */
package com.company.main;

import com.company.business.logic.SalesTax;
import com.company.model.Product;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class App {

    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        SalesTax salesTax = new SalesTax();

        //important declarations
        double totalPurchase = 0;
        double purchaseTaxInclusive= 0;
        double taxesPaid = 0;

        //list to hold products or items for shopping-cart.
        List<Product> inputCart = new ArrayList<>();
        //list to hold products or items for shopping-cart after taxes.
        List<Product> outputCart = new ArrayList<>();

        System.out.println("\nWELCOME TO THE SALES TAX CALCULATOR APP\n");

        while(true) {
            System.out.println("Please enter the name of a product you wish to add to your cart: ");
            String productName = scanner.nextLine();
            System.out.println("Enter the quantity you need: ");
            int quantity = scanner.nextInt();
            System.out.println("Enter the price: ");
            double price = scanner.nextDouble();

            //create the product object and add the untaxed product to cart
            Product untaxedProduct = new Product(quantity, productName, price);
            inputCart.add(untaxedProduct);

            /*computation of sales tax here. Calculate sales tax and add to another list which holds
            items that have already been taxed. The add tax method from the salesTax class performs
            this computation and returns a product object
            */
            outputCart.add(salesTax.addTax(untaxedProduct));

            System.out.println("Do you wish to add more products? type y for yes or any key no ");
            String reply = scanner.next();
            scanner.nextLine();
            if (!reply.equalsIgnoreCase("y")) {
                break;
            }
        }

        //INPUT DISPLAY
        totalPurchase = salesTax.totalPurchasePriceWithoutTax(inputCart);
            System.out.println("\nINPUT RECEIPT WITHOUT TAX");
            salesTax.print(inputCart); //printing the inputs

        //OUTPUT DISPLAY
        purchaseTaxInclusive = salesTax.totalPurchasePriceWithTax(outputCart);
        taxesPaid = salesTax.totalSalesTaxPaid(totalPurchase, purchaseTaxInclusive);
        System.out.println("\nPrinting new receipt for cart1 with tax included");
        salesTax.print(outputCart);
        System.out.println("Sales tax: " + String.format("%.2f", taxesPaid));
        System.out.println("Total: " + String.format("%.2f", purchaseTaxInclusive));
        }
    }

