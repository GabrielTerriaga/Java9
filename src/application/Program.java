package application;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;
import entities.Employee;

public class Program {

	public static void main(String[] args) {

		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		//Lista
		List<Employee> list = new ArrayList<>();
		
		System.out.print("How many employees will be registred? ");
		int nE = sc.nextInt();
		
		for (int i = 1; i <= nE; i++) {
			System.out.println();
			System.out.println("Employee #" + i + ":");
			
			System.out.print("Id: ");
			int id = sc.nextInt();
			
			System.out.print("Name: ");
			sc.nextLine();
			String name = sc.nextLine();
			
			System.out.print("Salary: ");
			double salary = sc.nextDouble();
			
			list.add(new Employee(id, name, salary));
		}
		
		//Update
		System.out.println();
		System.out.print("Enter the employee id that will have salary increase: ");
		int id = sc.nextInt();
		Employee emp = list.stream().filter(x -> x.getId() == id).findFirst().orElse(null);
		
		//Validação de ID
		if (emp == null) {
			System.out.println("ID INCORRETO!");
		}
		else {
			System.out.print("Enter the percentage: ");
			double percentage = sc.nextDouble();
			emp.increaseSalary(percentage);
		}
		
		System.out.println();
		System.out.println("List of employyes: ");
		for (Employee x : list) {
			System.out.println(x);
		}
		
		sc.close();
	}

}
