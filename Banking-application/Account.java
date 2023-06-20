
package oops;


public abstract class Account {
    private int accNumber;
    protected double balance;
    //default constructor 
    public Account(){
        
    }
    
  
    
    public Account(int accNumber){
        this.accNumber=accNumber;
      balance=0;
    }
   
    //getter methods
    public double getBalance(){
        return this.balance;
    }
  
    public int getaccNumber(){
        return this.accNumber;
    }
    //Abstract
    /*Function to deposit funds into the account as long as the amount parameter is>0
    Apply transaction fee for the CheckingAccount
    */
    public abstract void deposit(double amount); // implemneted in sub class
    /* Function to withdraw funds from the Account as long as 
    1, Amount to withdraw must be>0
    2.Amount to withdraw must be <=balance
    */
    public abstract void withdraw(double amount);// implemneted in sub class
    
}
