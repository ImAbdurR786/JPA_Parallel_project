package com.cg.project.dao;

import com.cg.project.bean.Customer;
import javax.persistence.EntityManager;

import com.cg.project.bean.Customer;

public class DAO {
	EntityManager entity=UtilJava.getEntityManager();

	public void createAccount(Customer customer) {
		entity.persist(customer);

	}

	public void showBalance() {
            
	}

	public void printTransactions() {


	}
	public void commitTransaction() {
		entity.getTransaction().commit();
		
	}

	public void beginTransaction() {
		entity.getTransaction().begin();
}
         public Customer checkAccount(long accountNo) {
          Customer customer = (Customer) entity.find(Customer.class, new Long(accountNo));
          return customer;
    }
         
        public void deposite(Customer customer) {
              entity.merge(customer);
           }
        public void withdraw(Customer customer) {
            entity.merge(customer);
        }

    public void fundTransfer(Customer toCustomer, Customer fromCustomer) {
        entity.merge(toCustomer);
        entity.merge(fromCustomer);
    }
        
}