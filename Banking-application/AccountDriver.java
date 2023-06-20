/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package oops;

/**
 *
 * @author Venu Gopal
 */
import java.util.Scanner;

public class AccountDriver {
    //Entry point of program

    public static void main(String[] args){
    Scanner sc=new Scanner(System.in);
    //Create array of Accounts
    Account accounts[]=new Account[10];
    int numAccs=0;
    int choice;
    do{
         choice= menu(sc);
        System.out.println();
        if(choice==1){
            accounts[numAccs++]=createAccount(sc);
        }
        else if(choice==2){
            doDeposit(accounts,numAccs,sc);
        }
        else if(choice==3){
            dowWithdraw(accounts,numAccs,sc);
        }
        else if(choice==4){
            applyInterest(accounts,numAccs,sc);
        }
        else{
            System.out.println("GoodBye!");
        }
        System.out.println();
    }while(choice!=5);
    
}
    //Account choice
    public static int accountMenu(Scanner sc){
        System.out.println("Select Account type");
          System.out.println("1.Checking Account");
            System.out.println("2.Savings Account");
            int choice;
            do{
                  System.out.println("Enter choice");
                  choice=sc.nextInt();
            }while(choice<1 || choice>2);
            return choice;
    }
    //search for account
    public static int searchAccount(Account accounts[],int count,int accountNumber){
        for(int i=0;i<count;i++){
            if(accounts[i].getaccNumber()==accountNumber){
                return i;  
        }
        }
     return -1; 
    }
    //Function to perform Depost on a selected account
    public static void doDeposit(Account accounts[], int count,Scanner sc){
         
        //Get the account number
        System.out.println("\nPlease enter account number");
        int accountNumber=sc.nextInt();
        
        //search for account
        int index=searchAccount(accounts,count,accountNumber);
        //Amount
        if(index>=0){
          System.out.println("Please enter deposit Amount:");
          double amount=sc.nextDouble();
          accounts[index].deposit(amount);
        }
        else{
              System.out.println("No account exist with AccountNumber: "+accountNumber);
        }
    }
    public static void dowWithdraw(Account accounts[],int count,Scanner sc){
        
     System.out.println("\nPlease enter account number");
          int accountNumber=sc.nextInt();
        
        //search for account
        int index=searchAccount(accounts,count,accountNumber);
        //Amount
        if(index>=0){
          System.out.println("Please enter deposit Amount:");
          double amount=sc.nextDouble();
          accounts[index].withdraw(amount);
        }
        else{
              System.out.println("No account exist with AccountNumber: "+accountNumber);
        }
    }
    public static void applyInterest(Account accounts[],int count,Scanner sc){
        
     System.out.println("\nPlease enter account number");
        int accountNumber=sc.nextInt();
        
        //search for account
        int index=searchAccount(accounts,count,accountNumber);
        //Amount
        if(index>=0){
        //must be instance if saving accoint
          if(accounts[index] instanceof SavingsAccount){
         ((SavingsAccount) accounts[index]).applyInterest();}
        }
        else{
              System.out.println("No account exist with AccountNumber: "+accountNumber);
        }
    }
    //function to create new account
    public static Account createAccount(Scanner sc){
        Account account=null;
        int choice=accountMenu(sc);
        int accountNumber;
          System.out.print("ENter Account Number");
          accountNumber=sc.nextInt();
        if(choice==1){//chekcing account
              System.out.println("Enter transaction fee");
          double fee=sc.nextDouble();
          account=new CheckingAccount(accountNumber,fee);
        }else{
            //savings account
              System.out.println("Please enter interest rate");
              double ir=sc.nextDouble();
              account=new SavingsAccount(accountNumber,ir);   
        }
        return account;
    }
    /*Menu to display options and get the users selection */
    public static  int menu(Scanner sc){
        System.out.println("Bank Account Menu");
          System.out.println("1.Create New Account");
            System.out.println("2.Deposit Funds");
              System.out.println("3.Withdraw Funds");
              System.out.println("4.Apply Interest");
                System.out.println("5.Quit");
                
         int choice;
         do{
             System.out.print("Enter choice: ");
             choice=sc.nextInt();
         }while(choice<1 || choice>5);
         return choice;
    }
}
