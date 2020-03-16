package HW1;

import java.util.Scanner;

public class helloWorld {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		System.out.println("Nhập tên của bạn: ");
		String name = sc.nextLine();
		System.out.println("Hello " + name);
		sc.close();
	}

}
