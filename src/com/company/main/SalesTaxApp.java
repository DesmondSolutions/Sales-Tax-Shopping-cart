/*This is the main function. All the items in the carts have already been added.
All you have to do is run the code and see the results. */
package com.company.main;

import com.company.business.logic.SalesTax;
import com.company.model.Product;

import java.util.ArrayList;
import java.util.List;

public class SalesTaxApp {

    public static void main(String[] args){
        Product book = new Product(1, "book(s)", 12.49);
        Product cd = new Product(1, "music CD(s)", 14.99);
        Product chocolate = new Product(1, "chocolate bar(s)", 0.85);

        Product importedChocolate = new Product(1, "imported box(es) of chocolate", 10.00);
        Product importedPerfume = new Product(1, "imported bottle(s) of perfume", 47.50);

        Product importedPerfume2 = new Product(1, "imported bottle(s) of perfume", 27.99);
        Product perfume = new Product(1, "bottle(s) of perfume", 18.99);
        Product headAchePill = new Product(1, "packet(s) of headache pills", 9.75);
        Product importedChocolate2 = new Product(3, "box(es) of imported chocolate", 11.25);

        SalesTax salesTax = new SalesTax();

        //INPUT CART1
        double totalPurchase1 = 0;
        double purchaseTaxInclusive1 = 0;
        double taxesPaid1 = 0;

        //list to hold products or items for shopping-cart1.
        List<Product> cart1 = new ArrayList<>();

        cart1.add(book);
        cart1.add(cd);
        cart1.add(chocolate);
        totalPurchase1 = salesTax.totalPurchasePriceWithoutTax(cart1);
        System.out.println("cart1 receipt without tax");
        salesTax.print(cart1); //printing the inputs


        //OUTPUT CART1

        //list to hold products or items for shopping-cart1 after taxes.
        List<Product> cart1withTax = new ArrayList<>();
        cart1withTax.add(salesTax.addTax(book));
        cart1withTax.add(salesTax.addTax(cd));
        cart1withTax.add(salesTax.addTax(chocolate));
        purchaseTaxInclusive1 = salesTax.totalPurchasePriceWithTax(cart1withTax);
        taxesPaid1 = salesTax.totalSalesTaxPaid(totalPurchase1, purchaseTaxInclusive1);
        System.out.println("\nPrinting new receipt for cart1 with tax included");
        salesTax.print(cart1withTax);
        System.out.println("Sales tax: " + String.format("%.2f", taxesPaid1));
        System.out.println("Total: " + String.format("%.2f", purchaseTaxInclusive1) + "\n");



        //INPUT CART2
        double totalPurchase2 = 0;
        double purchaseTaxInclusive2 = 0;
        double taxesPaid2 = 0;

        //list to hold products or items for shopping-cart2.
        List<Product> cart2 = new ArrayList<>();
        cart2.add(importedChocolate);
        cart2.add(importedPerfume);
        totalPurchase2 = salesTax.totalPurchasePriceWithoutTax(cart2);
        System.out.println("cart2 receipt without tax");
        salesTax.print(cart2); //printing the inputs


        //OUTPUT CART2
        List<Product> cart2withTax = new ArrayList<>();
        cart2withTax.add(salesTax.addTax(importedChocolate));
        cart2withTax.add(salesTax.addTax(importedPerfume));

        purchaseTaxInclusive2 = salesTax.totalPurchasePriceWithTax(cart2withTax);
        taxesPaid2 = salesTax.totalSalesTaxPaid(totalPurchase2, purchaseTaxInclusive2);
        System.out.println("\nPrinting new receipt for cart2 with tax included");
        salesTax.print(cart2withTax);
        System.out.println("Sales tax: " + String.format("%.2f", taxesPaid2));
        System.out.println("Total: " + String.format("%.2f", purchaseTaxInclusive2) + "\n");


        //INPUT CART3
        double totalPurchase3 = 0;
        double purchaseTaxInclusive3 = 0;
        double taxesPaid3 = 0;

        //list to hold products or items for shopping-cart3.
        List<Product> cart3 = new ArrayList<>();
        cart3.add(importedPerfume2);
        cart3.add(perfume);
        cart3.add(headAchePill);
        cart3.add(importedChocolate2);
        totalPurchase3 = salesTax.totalPurchasePriceWithoutTax(cart3);
        System.out.println("cart3 receipt without tax");
        salesTax.print(cart3); //printing the inputs


        //OUTPUT CART3

        List<Product> cart3withTax = new ArrayList<>();
        cart3withTax.add(salesTax.addTax(importedPerfume2));
        cart3withTax.add(salesTax.addTax(perfume));
        cart3withTax.add(salesTax.addTax(headAchePill));
        cart3withTax.add(salesTax.addTax(importedChocolate2));
        purchaseTaxInclusive3 = salesTax.totalPurchasePriceWithTax(cart3withTax);
        taxesPaid3 = salesTax.totalSalesTaxPaid(totalPurchase3, purchaseTaxInclusive3);
        System.out.println("\nPrinting new receipt for cart3 with tax included");
        salesTax.print(cart3withTax);
        System.out.println("Sales tax: " + String.format("%.2f", taxesPaid3));
        System.out.println("Total: " + String.format("%.2f", purchaseTaxInclusive3) + "\n");


    }
}
