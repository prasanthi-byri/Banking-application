/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package oops;

/**
 *
 * @author Venu Gopal
 */
// has an interest rate
//a method to apply interest-profit
public class SavingsAccount extends Account {
    //interest rate
    private double interestRate;
    //default constructor
    public SavingsAccount(){
        super();
    }
    //parameter constructir to initialise savings account with a custimer account number andinterest rate
    public SavingsAccount(int accountNumber,double interestRate){
        super(accountNumber);
        this.interestRate=interestRate;
    }
    //getter function
    public double getInterestRate(){
        return this.interestRate;
    }
    public void setInterestRate(double interestRate){
        this.interestRate=interestRate;
    }
    public double calcInterest(){
        return balance*interestRate;
    }
    public void applyInterest(){
     double interest=calcInterest();
     System.out.printf("Interest amount %.2f added to balance/n",interest);
     deposit(interest);
    }
      public void deposit(double amount){
        //First chekc amount
        if(amount>0){
            balance+=amount;
            System.out.printf("Amount %.2f deposited\n",amount);
          
             
               System.out.printf("Current Balance is %.2f deposited\n",balance);
        }
        else{
            System.out.println("A negative amount cannot be deposited");
        }
        
    }
    public void withdraw(double amount){
        // Same check
        if(amount>0){
            //check sufficient balance
            if((amount)<=balance){
                
                System.out.printf("Amount of %.2f withdrwan from Account/n",amount);
                balance-=amount;
               
                      System.out.printf("Current Balance is: %.2f /n",balance);
            }
        }
        else{
            System.out.println("Negative amount cannot be withdrawal");
        }
    }
}
