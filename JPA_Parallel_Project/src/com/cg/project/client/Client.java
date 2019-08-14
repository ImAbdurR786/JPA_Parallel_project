/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cg.project.client;

import com.cg.project.bean.Customer;
import com.cg.project.service.Service;
import java.util.Scanner;
import java.util.regex.Pattern;

/**
 *
 * @author Raja
 */
public class Client {
    
public static void main(String args[]){
                                                                                          
            //Accepting the input from the User.
		Scanner sc = new Scanner(System.in);
                long accountNo;
                Customer c;
                Service s = new Service();
                do {
                    //Printing the menu bar.
		System.out.println("***************************************************************************");
		System.out.println("1. Create Account \n 2. Show Balance \n 3. Deposite "
				+ "\n 4. Withdraw \n 5. Fund Transfer \n 6. Print Transcaction \n 7. Exit");
		System.out.println("***************************************************************************");
                System.out.println("Choose any option : ");
		int n = sc.nextInt();
		
		// According to input from user the method is called using switch case.
		switch(n) {

         case 1:
		double a = Math.random()%100;            // Creating a random number
		accountNo =(long)(a*1234567898);    // Mutliplying with a dummy no. to get dummy account no.
                String name;
		do{System.out.println("Enter the Name");
		name = sc.next();
                }while(!Pattern.matches("([A-Z])*([a-z])*", name));
	
		System.out.println("Enter the Number");
		String number = sc.next();
		if(number.length() == 10) {
		System.out.println("Enter the pin.");
		int pin = sc.nextInt();
		System.out.println("Enter the Balance to be deposit.");
		int deposit = sc.nextInt();
		c = new Customer(name,number,pin,deposit); 
                c.setAccountNo(accountNo);
		c.setBalance(deposit);
                s.create(c);
		System.out.println("Your account is Created Successfully");
		System.out.println("Account number is :" + c.getAccountNo());
		}
            break;
        
         case 2:
               System.out.println("Enter the Account no.");
		Long showaccount = sc.nextLong();
			if(s.contain(showaccount)){
                            System.out.println("Enter the pin");
                            int pin = sc.nextInt();
                            if(s.checkPin(pin,showaccount)){
                                System.out.println( s.showbalance(showaccount));
                         }else{
                                System.out.println("Pin is not correct");
                            }
                        }else{
                         System.out.println("No such AccountNo Exist");
                        }
                        break;
                        
         case 3:
             
        System.out.println("Enter the account number");
	long accountdeposit = sc.nextLong();
        if(s.contain(accountdeposit)){
	System.out.println("Enter the amount to be deposite");	
	int deposite = sc.nextInt();
        s.deposite(accountdeposit,deposite);
	System.out.println("Successfully Deposited");
	//s.trans("Deposite "+deposite,accountdeposit);
	
	}else
		System.out.println("No such Account Number");
        break;
                
         case 4:
             
             System.out.println("Enter the account number");
		long accountwithdraw = sc.nextLong();
                
		if(s.contain(accountwithdraw)){
		System.out.println("Enter the amount to be withdraw");	
		int withdraw = sc.nextInt();
		int result = s.withdraw(accountwithdraw,withdraw);
                if(result == 1){
                System.out.println("Successfully Withdraw");
                }else 
                {System.out.println("Insufficient Balance");}
        	 }else
			System.out.println("No such Account Number");
		break;
                
         case 5:
             Long to;
                System.out.println("Enter your account number.");
		Long from = sc.nextLong();
                
		if(s.contain(from)) {
		do{System.out.println("Enter account number to transfer the money.");
		to = sc.nextLong();
                }while(!s.contain(to));
                
                if(from.equals(to)){
                    System.out.println("Both account number must be different");
                }else{
		
                System.out.println("Enter the money to be transfer");
		int money = sc.nextInt();
		if(s.fundTransfer(from,to,money) == 1){
                 System.out.println("Successfully Transfer");}
                else{
                    System.out.println("Insufficient Money");
                }
		}
		}else 
			System.out.println("Invalid Account Number");
     break;
     
//         case 6:
//                System.out.println("Enter the Account Number");
//		long transAcc = sc.nextLong();
//		
//		if(s.getTrans().containsValue(transAcc))
//		{
//			System.out.println(s.get(s.getTrans(),transAcc));
//			
//		}
//		else {
//			System.out.println("No such Account");
//		}
//             
//             break;
             
		case 7: System.exit(0);
		default :
			System.out.println("Enter the valid choice");
		
		}}while(true);
	} 
}    
