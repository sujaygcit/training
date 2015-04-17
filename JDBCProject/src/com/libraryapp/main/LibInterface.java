package com.libraryapp.main;

import java.util.Scanner;

import com.libraryapp.util.BranchUtil;

public class LibInterface {

	public int Page1() {
		System.out
				.println("Welcome to the GCIT Library Management System. Which category of a user are you?");
		System.out.println("1) Librarian");
		System.out.println("2) Administrator");
		System.out.println("3) Borrower");
		Scanner in = new Scanner(System.in);
		return (Integer.parseInt(in.next()));

	}

	public int Page2() {
		System.out.println("1) Enter the branch you manage");
		System.out.println("2) Quit to the previous page");
		Scanner in = new Scanner(System.in);
		int choice = Integer.parseInt(in.next());
		if (choice == 1) {
			BranchUtil br = new BranchUtil();
			br.getAllBranches();
			return (Integer.parseInt(in.next()));
		} else if (choice == 2) {
			Page1();
			return -1;
		}
		return 0;
	}

	public int Page3() {
		System.out.println("1) Add/Update/Delete Book and Author");
		System.out.println("2) Add/Update/Delete Publisher");
		System.out.println("3) Add/Update/Delete Branches");
		System.out.println("4) Add/Update/Delete Borrowers");
		System.out.println("5) Over-ride due date for a book loan");
		Scanner in = new Scanner(System.in);
		return (Integer.parseInt(in.next()));

	}

	public static void main(String[] args) {

		int choice = 0;
		LibInterface lib = new LibInterface();
		choice = lib.Page1();
		if (choice == 1) {
			int lib_choice = lib.Page2();
		}
		if (choice == 2) {
			int admin_choice = lib.Page3();
			if (admin_choice == 1) {
				// int editBook_choice = Page31();
				// if(editBook_choice == 1){

			}
		}
	}
}
