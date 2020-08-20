package com.asdev.classes;

public class shopping{
	
	public static class customer{
	int custid;
	String custName, city;
	product[] products;
	double totalAmount, totalDiscount, netAmount;

		public customer(int id, String name, String city, product[] products){
			this.custid = id;
			this.custName = name;
			this.city = city;
			this.products = products;
			this.totalAmount = getTotalAmount(this.products);
			this.totalDiscount = getTotalDiscount(this.products);
			this.netAmount = this.totalAmount - this.totalDiscount;
			}

		public double getTotalDiscount(product[] products){
			double discount = 0.0;
			for(int i=0; i<products.length; i++){
				discount += products[i].getDiscount()*products[i].getQunatity();
			}
			return discount;
		}

		public double getTotalAmount(product[] products){
			double price=0.0;
			for(int i=0; i<products.length; i++){
				price += products[i].getPrice()*products[i].getQunatity();
			}
			return price;
		}

		public void print(){
			System.out.println("Customer ID = "+ custid);
			System.out.println("Customer name = "+custName);
			System.out.println("Customer City = "+city);
			System.out.println("____________[SHOPPING LIST]______________________");
			for(int i = 0; i<this.products.length; i++){
				this.products[i].print();
				System.out.println("--------------------------------");
			}
			System.out.println("_________________________________________________");
			System.out.println("Total Amount = "+totalAmount);
			System.out.println("Total Discount = "+totalDiscount);
			System.out.println("Net Amount = "+netAmount);
		}
	}
	

	public static class product{
		int productID, qtn;
		String product;
		double discount, price;

		public product(int id, String name, double price, double discount, int qtn){
			this.productID = id;
			this.product = name;
			this.price = price;
			this.discount = discount;
			this.qtn = qtn;
		}

		public int getID(){
			return this.productID;
		}
		public int getQunatity(){
			return this.qtn;
		}
		public String getProduct(){
			return this.product;
		}
		public double getPrice(){
			return this.price;
		}
		public double getDiscount(){
			return this.discount;
		}

		public void print(){
			System.out.println("Priduct ID = "+productID);
			System.out.println("Product = "+product);
			System.out.println("Price = "+price);
			System.out.println("Discount = "+discount);
			System.out.println("Quantity = "+qtn);
		}
	}

	public static void main(String args[]){
		product chicken = new product(1, "Chicken", 100.0, 10.0, 2);
		product fish = new product(2, "Fish", 100.0, 10.0, 1);
		product[] shoppingList = {chicken, fish};
		customer aman = new customer(1, "Aman", "Pune", shoppingList);
		aman.print();
	}
}

/*

-----------------OUTPUT----------------------------

Customer ID = 1
Customer name = Aman
Customer City = Pune
____________[SHOPPING LIST]______________________
Priduct ID = 1
Product = Chicken
Price = 100.0
Discount = 10.0
Quantity = 2
--------------------------------
Priduct ID = 2
Product = Fish
Price = 100.0
Discount = 10.0
Quantity = 1
--------------------------------
_________________________________________________
Total Amount = 300.0
Total Discount = 30.0
Net Amount = 270.0



*/