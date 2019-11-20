import java.util.*; 
import java.lang.*; 
import java.io.*; 

public class savings extends account {
   double fee = 0;
   double minDeposit = 0;
   double currentDeposit = 0;
   int maxWithdraw = 0;
   int currentWithdraw = 0;
   
   public savings(double fees, double minDeposits, int maxWithdraws) {
      fee = fees;
      minDeposit = minDeposits;
      maxWithdraw = maxWithdraws;
   }
   
   public int setup(double fees, double minDeposits, int maxWithdraws) {
      fee = fees;
      minDeposit = minDeposits;
      maxWithdraw = maxWithdraws;
      return 1;
   }
   
   public double deposit(double deposit) {
      currentDeposit = currentDeposit + deposit;
      balance = balance + deposit;
      return balance;
   }

   public double withdraw(double withdraw) {
      if (balance > withdraw) {
         if (currentWithdraw < maxWithdraw) {
            balance = balance - withdraw;
            currentWithdraw = currentWithdraw + 1;
         }
      }
      return balance;
   }
   
   public double monthlyCheck() {
      if (currentDeposit < minDeposit) {
         balance = balance - fee;
      }
      currentDeposit = 0;
      currentWithdraw = 0;
      return balance;
   }
}