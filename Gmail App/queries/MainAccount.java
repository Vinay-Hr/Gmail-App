package com.te.gmailApp.queries;

import java.util.Scanner;

public class MainAccount {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		for (;;) {
			System.out.println("1.Login\n 2.Register\n 3.Exit");
			int a = sc.nextInt();
			switch (a) {
			case 1:
				new LoginRegister().login();
				break;
			case 2:
				new LoginRegister().Register();
				break;
			default:
				System.exit(a);

			}

		}

	}

}
