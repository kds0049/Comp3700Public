import java.util.*; 
import java.lang.*; 
import java.io.*; 

public class account {
   double balance = 0;

   public account() {}

   public double deposit(double deposit) {
      balance = balance + deposit;
      return balance;
   }

   public double withdraw(double withdraw) {
      balance = balance - withdraw;
      return balance;
   }
}