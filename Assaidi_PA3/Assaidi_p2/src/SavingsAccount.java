public class SavingsAccount {
    private static double annualInterestRate;
    private double savingsBalance;

    public SavingsAccount(double balance)
    {
        this.savingsBalance = balance;
    }

    public static void modifyInterestRate(double newRate)
    {
        annualInterestRate = newRate;
    }

    public double calculateMonthlyInterest()
    {
        double interest = 0;
        interest = this.savingsBalance * (annualInterestRate / 12);
        this.savingsBalance += interest;
        return this.savingsBalance;
    }
}
