public class Application {
    public static void main(String [] args)
    {
        SavingsAccount saver1 = new SavingsAccount(2000.00);
        SavingsAccount saver2 = new SavingsAccount(3000.00);
        int i;

        SavingsAccount.modifyInterestRate(0.04);
        for (i = 1; i < 13; i++)
        {
            System.out.println("Month "+ i + ": \n");
            System.out.printf("Saver 1: $%.2f\n", saver1.calculateMonthlyInterest());
            System.out.printf("Saver 2: $%.2f\n\n", saver2.calculateMonthlyInterest());
            System.out.println(" ");
        }

        SavingsAccount.modifyInterestRate(0.05);
        System.out.println("One month after new interest rate:\n");
        System.out.printf("Saver 1: $%.2f\n", saver1.calculateMonthlyInterest());
        System.out.printf("Saver 2: $%.2f\n\n", saver2.calculateMonthlyInterest());
    }
}
