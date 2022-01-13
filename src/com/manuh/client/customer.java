package com.manuh.client;

import java.util.Scanner;

public class customer {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		@SuppressWarnings("resource")
		Scanner sc=new Scanner(System.in);
        System.out.println("Customer_Name:");
        String name=sc.nextLine();
        System.out.println("Customer_PhoneNo:");
        String PhoneNo=sc.nextLine();
        System.out.println("City:");
        String city=sc.nextLine();
        System.out.println("Bill_ID:");
        int Bill_ID=sc.nextInt();
        System.out.println("Bill_Date:");
        String Bill_Date=sc.next();
        sc.nextLine();
        
        System.out.println("\nName\t\t: " +name + "\n"+ "PhoneNo\t\t: "+ PhoneNo);
        System.out.println("City\t\t: "+city);
        System.out.println("Bill_ID\t\t: "+Bill_ID);
        System.out.println("Bill_Date\t: "+Bill_Date);
        
       
	}

}
