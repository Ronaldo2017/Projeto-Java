package application;

import model.enums.entities.Client;
import model.enums.entities.Order;
import model.enums.entities.OrderItem;
import model.enums.entities.Product;
import model.enums.OrderStatus;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

public class Program {
	public static void main(String[] args) throws ParseException {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

		System.out.println("Enter cliente data:");
		System.out.print("Name: ");
		String name = sc.nextLine();
		System.out.print("E-mail: ");
		String emial = sc.nextLine();
		System.out.print("Birth date (DD/MM/YYYY): ");
		Date orderDate = sdf.parse(sc.next());

		//instancia o cliente, com os dados digitados
		Client client = new Client(name, emial, orderDate);

		System.out.println("Enter order data: ");
		System.out.print("Status: ");
		OrderStatus status = OrderStatus.valueOf(sc.next());

		Order order = new Order(new Date(), status, client);

		System.out.println("How many items to this order? ");
		int n = sc.nextInt();

		for (int i = 1; i <= n; i++) {
			System.out.println("Enter #" + i + " item data:");
			System.out.print("Product name: ");
			sc.nextLine();
			String nameProd = sc.nextLine();
			System.out.print("Product price: ");
			double price = sc.nextDouble();

			//passo 1, instancia o produto
			Product product = new Product(nameProd, price);

			System.out.println("Quantity: ");
			int quantity = sc.nextInt();

			//instancia o pedido, passo 2
			OrderItem orderItem = new OrderItem(quantity, price, product);
			//associando o produto, adicionando
			order.addItem(orderItem);

		}

		System.out.println();
		System.out.println("ORDER SUMMARY:");
		System.out.println(order);

		sc.close();
	}
}
