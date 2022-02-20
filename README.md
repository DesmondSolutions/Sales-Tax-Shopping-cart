#App to calculate the tax of shopping carts

## Task

You get this information from your product owner:  
Basic sales tax is applicable at a rate of 10% on all goods, except books, food, and medical products that are exempt. 
Import duty is an additional sales tax applicable on all imported goods at a rate of 5%, with no exemptions.
When I purchase items I receive a receipt which lists the name of all the items and their price (including tax), 
finishing with the total cost of the items, and the total amounts of sales taxes paid.
The rounding rules for sales tax are that for a tax rate of n%, a shelf price of p contains (np/100 rounded up to the nearest 0.05) amount of sales tax.

Example: input/output pairs:

shopping-cart1.txt
> 1 book at 12.49  
> 1 music CD at 14.99  
> 1 chocolate bar at 0.85

receipt1.txt
> 1 book: 12.49  
> 1 music CD: 16.49  
> 1 chocolate bar: 0.85  
> Sales Taxes: 1.50  
> Total: 29.83

shopping-cart2.txt
> 1 imported box of chocolates at 10.00  
> 1 imported bottle of perfume at 47.50

receipt2.txt
> 1 imported box of chocolates: 10.50  
> 1 imported bottle of perfume: 54.65  
> Sales Taxes: 7.65  
> Total: 65.15

shopping-cart.txt
> 1 imported bottle of perfume at 27.99  
> 1 bottle of perfume at 18.99  
> 1 packet of headache pills at 9.75  
> 3 box of imported chocolates at 11.25

receipt3.txt
> 1 imported bottle of perfume: 32.19  
> 1 bottle of perfume: 20.89  
> 1 packet of headache pills: 9.75  
> 3 imported box of chocolates: 35.45  
> Sales Taxes: 7.80  
> Total: 98.28
