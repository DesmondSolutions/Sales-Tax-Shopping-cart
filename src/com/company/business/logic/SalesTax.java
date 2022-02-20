/*This is the service method. ALl the business logic is done here.
* In this case, its calculation of sales tax and adding the sales tax
* to the products. All items that are added to the cart are stored in
* a List. So the List holds objects of our model 'Product' */

package com.company.business.logic;

import com.company.model.Product;

import java.util.List;

public class SalesTax {

    //Calculate basic sales tax at 10% of product price
    public double basicTax(Product product){
        return product.getQuantity() * product.getPrice() * 0.10;
    }

    //calculate import duty at 5% of product price
    public double importTax(Product product){
        return product.getQuantity() * product.getPrice() * 0.05;

    }

    /*convenience method to add tax to the cart items. This method works as follows
    * -It checks if the productName contains the keyword 'imported'. If true, it adds a 5%
    * import duty to the productPrice.
    * -For the second level of check, it checks if the imported good qualifies for sales tax.
    * In this case, its just two products. 'perfume' and 'music cd'. if true, it adds 10% sales
    * tax to the productPrice and returns a new product with the updated price.
    * - The last layer of check is for goods that are not imported. It charges the regular 10%
    * (if the good qualifies) or it just returns the list unchanged if the product did not qualify
    * for any of the taxes (food, medical supplies and books).
    *  */
    public Product addTax(Product product){
        double pricePlusImportTax = 0;
        double pricePlusBasicTax = 0;
        double pricePlusBasicPlusImportTax = 0;

        if(product.getProductName().contains("imported")){
            pricePlusImportTax = (product.getPrice() * product.getQuantity()) + importTax(product);
            product = new Product (product.getQuantity(), product.getProductName(), pricePlusImportTax);

            if(product.getProductName().contains("perfume") ||  product.getProductName().contains("music")){
                pricePlusBasicPlusImportTax = pricePlusImportTax + basicTax(product);
                product = new Product (product.getQuantity(), product.getProductName(),
                        pricePlusBasicPlusImportTax);
            }
        }
        if(!product.getProductName().contains("imported")   &&  product.getProductName().contains("perfume")
                || product.getProductName().contains("music")){
            pricePlusBasicTax = (product.getPrice() * product.getQuantity()) + basicTax(product);
            product = new Product (product.getQuantity(), product.getProductName(),
                    pricePlusBasicTax);
        }
        return product;
    }


    //iterate through List and print the output
    public void print(List<Product> products){
        for(Product tempProduct : products){
            System.out.println(tempProduct.getQuantity() + " " + tempProduct.getProductName()
                    + ": " + String.format("%.2f", tempProduct.getPrice()));
        }
    }

    //iterate through list and get the total value for the purchase by summing the prices
    public double totalPurchasePriceWithoutTax(List<Product> products){
        double total = 0;
        for(Product tempProduct : products){
            total = total + tempProduct.totalPrice(tempProduct.getQuantity());
        }
        return total;
    }

    //iterate through list and get the total value after tax has been added
    public double totalPurchasePriceWithTax(List<Product> products){
        double total = 0;
        for(Product tempProduct : products){
            total = total + tempProduct.getPrice();
        }
        return total;
    }
    //get net tax after purchase
    public double totalSalesTaxPaid(double totalPurchaseWithoutTax, double totalPurchaseWithTax){
        return totalPurchaseWithTax - totalPurchaseWithoutTax;
    }
}


