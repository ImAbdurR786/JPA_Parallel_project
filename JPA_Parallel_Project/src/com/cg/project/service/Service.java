package com.cg.project.service;

import com.cg.project.bean.Customer;
import com.cg.project.dao.DAO;

public class Service {
    DAO dao = new DAO();


    public void create(Customer c) {
        dao.beginTransaction();
        dao.createAccount(c);
        dao.commitTransaction();
    }

    public void deposite(long accountdeposit, int deposite) {
        Customer customer = dao.checkAccount(accountdeposit);
        int balance = deposite + customer.getBalance();
        customer.setBalance(balance);
        dao.beginTransaction();
        dao.deposite(customer);
        dao.commitTransaction();
    }

    public boolean contain(long accountdeposit) {
       Customer customer = dao.checkAccount(accountdeposit);
       if(customer==null){
       return false;}
       else
       return true;
    }

    public int withdraw(long accountwithdraw, int withdraw) {
        Customer customer = dao.checkAccount(accountwithdraw);
        if(customer.getBalance()>withdraw){
            int balance = customer.getBalance() - withdraw;
            customer.setBalance(balance);
            dao.beginTransaction();
            dao.withdraw(customer);
            dao.commitTransaction();
            return 1;
            
        }
        else 
            return -1;
}

    public int fundTransfer(Long from, Long to, int money) {
        Customer fromCustomer = dao.checkAccount(from);
        int fBalance = fromCustomer.getBalance();
            if(money<fBalance) {
			Customer toCustomer = dao.checkAccount(to);
                         int totalMoney = toCustomer.getBalance() + money;
			 toCustomer.setBalance(totalMoney);
			 int totalMony = fBalance - money;
			 fromCustomer.setBalance(totalMony);
                         dao.beginTransaction();
                         dao.fundTransfer(toCustomer,fromCustomer);
                         dao.commitTransaction();
			return 1;
			}
		else 
			return -1;
    }

    public boolean checkPin(int pin, Long accountNo) {
       Customer customer =  dao.checkAccount(accountNo);
       int existPin = customer.getPin();
       if(existPin == pin){
       return true;}
       else
           return false;
    }

    public int showbalance(long showaccount) {
     Customer customer = dao.checkAccount(showaccount);
     return customer.getBalance();
    }
    
}



