/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package atm;

/**
 *
 * 
 */
public class MyAtm {
    private double balance;
     private double amount;
     private final String number = "1234";
    public double getBalance(){
        return balance;
    }
  
    public MyAtm(){
        balance = 0.0;
    }
        
    public String getNumber(){
        return number;
    }
    
    public void withdraw(){
        if(amount > balance){
            System.out.println("Can't withdraw the amount!");
        }
        else{
            balance = balance - amount;
        }
    }
    public void deposit(){
        if(amount < 0)
            System.out.println("Cannot deposit negative amounts!");
        else balance = balance + amount;
    }
    public double getAmount(){
        return amount;
    }
    public void setAmount(double Amount){
        this.amount = Amount;
    }
}
