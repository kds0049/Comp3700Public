import java.util.*; 
import java.lang.*; 
import java.io.*; 

public class checking extends account {
   double fee = 0;

   public checking(double fees) {
      fee = fees;
   }
   
   public double withdraw(double withdraw) {
      if (withdraw > balance) {
         balance = balance - fee;
      }
      balance = balance - withdraw;
      return balance;
   }
}