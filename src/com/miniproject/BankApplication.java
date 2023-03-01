package com.miniproject;

import java.util.Scanner;

import com.miniproject.BankAccount;

public class BankApplication {


    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter your 'Name' of Bank account:");
        String name=sc.nextLine();
        System.out.println("Enter your 'CustomerId' to access your Bank account:");
        String customerId=sc.nextLine();
        BankAccount obj1=new BankAccount(name,customerId);
        obj1.menu();
    }
}

class BankAccount{
    double bal;
    double prevTrans;
    String customerName;
    String customerId;

    BankAccount(String customerName,String customerId){
        this.customerName=customerName;
        this.customerId=customerId;
    }


    void deposit(double amount){
        if(amount!=0){
            bal+=amount;
            prevTrans=amount;
        }
    }

    void withdraw(double amt){
        if(amt!=0 && bal>=amt){
            bal-=amt;
            prevTrans=-amt;
        }
        else if(bal<amt){
            System.out.println("Bank balance insufficient");
        }
    }

    void getPreviousTrans(){
        if(prevTrans>0){
            System.out.println("Deposited: "+prevTrans);
        }
        else if(prevTrans<0){
            System.out.println("Withdrawn: "+Math.abs(prevTrans));
        }
        else{
            System.out.println("No transaction occured");
        }
    }

    void menu(){
        char option;
        Scanner sc=new Scanner(System.in);
        System.out.println("Welcome "+customerName+" to BOI Bank Panvel");
        System.out.println("Your ID:"+customerId);
        System.out.println("\n");
        System.out.println("a) Check Balance");
        System.out.println("b) Deposit Amount");
        System.out.println("c) Withdraw Amount");
        System.out.println("d) Previous Transaction");
        System.out.println("e) Exit");

        do{
           
            System.out.println("Choose an option");
            option=sc.next().charAt(0);
            System.out.println("\n");

            switch (option){
                case 'a':

                    System.out.println("Balance ="+bal);
                    System.out.println("___________________________");
                   
                    break;
                case 'b':

                    System.out.println("Enter a amount to deposit :");
                    double amt=sc.nextDouble();
                    deposit(amt);
                   System.out.println("___________________________");
                    break;
                case 'c':
                    System.out.println("Enter a amount to Withdraw :");
                    double amtW=sc.nextDouble();
                    withdraw(amtW);
                    System.out.println("___________________________");
                    break;
                case 'd':
                    System.out.println("Previous Transaction:");
                    getPreviousTrans();
                    System.out.println("___________________________");
                    break;
                case 'e':
                    System.out.println("___________________________");
                    break;
                default:
                    System.out.println("Choose a correct option to proceed");
                    break;
            }

        }while(option!='e');

        System.out.println("Thank you for using our banking services");
    }

}
