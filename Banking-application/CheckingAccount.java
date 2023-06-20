/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package oops;

/**
 *
 * @author Venu Gopal
 */
public class CheckingAccount extends Account {
    //Defaukt Transaction fee
    private static  double FEE=2.5;
    //default constructor
    public CheckingAccount(){
        super();
    }
    /*Paraameter constructor to initialise chekcing account with a custom account number and a customer transaction fee*/
    
    public CheckingAccount(int accountNumber,double fee){
       super(accountNumber);
       FEE=fee;
       
    }
    public void deposit(double amount){
        //First chekc amount
        if(amount>0){
            balance+=amount;
            System.out.printf("Amount %.2f deposited\n",amount);
            //Apply transaction fee
            balance-=FEE;
             System.out.printf("Fee %.2f applied\n",FEE);
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
            if((amount+FEE)<=balance){
                
                System.out.printf("Amount of %.2f withdrwan from Account/n",amount);
                balance-=amount;
                balance-=FEE;
                   System.out.printf("Fee of %.2f applied/n",FEE);
                      System.out.printf("Current Balance is: %.2f /n",balance);
            }
        }
        else{
            System.out.println("Negative amount cannot be withdrawal");
        }
    }
}
