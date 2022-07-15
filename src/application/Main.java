package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import entities.Client;
import entities.Order;
import entities.OrderItem;
import entities.Product;
import entities.enums.OrderStatus;


public class Main {

	public static void main(String[] args) throws ParseException {
		// TODO Auto-generated method stub

		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		System.out.println("Enter cliente data: ");
		System.out.print("Name: ");
		String nameClient = sc.nextLine();
		System.out.print("Email: ");
		String emailClient = sc.nextLine();
		System.out.print("Birth date (DD/MM/YYYY): ");
		Date birthDate = sdf.parse(sc.nextLine());
		
		Client client = new Client(nameClient, emailClient, birthDate);
		
		System.out.println("Enter order data: ");
		System.out.print("Status: ");
		OrderStatus orderStatus = OrderStatus.valueOf(sc.nextLine());
		
		System.out.print("How many items to this order? ");
		int orderItems = sc.nextInt();
		
		Order order = new Order(new Date(), orderStatus, client);
		
		for(int i = 1; i <= orderItems; i++) {
			System.out.println("Enter #" + i + " item data: ");
			System.out.print("Product name: ");
			sc.nextLine();
			String nameProduct = sc.nextLine();
			System.out.print("Product price: ");
			double priceProduct = sc.nextDouble();
			System.out.print("Quantity: ");
			int quantityProduct = sc.nextInt();
			
			Product product = new Product(nameProduct, priceProduct);
			
			OrderItem orderItem = new OrderItem(quantityProduct, priceProduct, product);
			
			order.addItem(orderItem);
		}
		
		System.out.println("");
		System.out.println(order);
		
		
		sc.close();
	}

}
