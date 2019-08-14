package com.cg.project.bean;

@Entity
@Table
public class Customer {
    @Id
    private long accountNo;
    private String name;
    private String mobileno;
    private int pin;
    private int balance;

    public Customer(String name, String mobileno, int pin, int balance) {
        this.name = name;
        this.mobileno = mobileno;
        this.pin = pin;
        this.balance = balance;
    }

    public long getAccountNo() {
        return accountNo;
    }

    public void setAccountNo(long accountNo) {
        this.accountNo = accountNo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMobileno() {
        return mobileno;
    }

    public void setMobileno(String mobileno) {
        this.mobileno = mobileno;
    }

    public int getPin() {
        return pin;
    }

    public void setPin(int pin) {
        this.pin = pin;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    @Override
    public String toString() {
        return "Customer{" + "accountNo=" + accountNo + ", name=" + name + ", mobileno=" + mobileno + ", pin=" + pin + ", balance=" + balance + '}';
    }
    
}
