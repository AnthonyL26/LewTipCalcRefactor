import java.util.Scanner;
import java.text.DecimalFormat;
public class TipCalculatorRunner {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        DecimalFormat formatter = new DecimalFormat("#.##");

        System.out.println("Welcome to the Tip Calculator!"); //Welcome

        System.out.print("How many people are in your group? "); // Group Size
        int groupSize =  scan.nextInt();
        scan.nextLine();

        System.out.print("What's the tip percentage? (0-100): "); //Tip Percent
        double tipPercent = (double) scan.nextInt()/100;
        scan.nextLine();

        TipCalculator calculator = new TipCalculator(groupSize, tipPercent);

        double userInput = 0;
        while (userInput != -1) { // Make it so loop ends when -1 is entered
            calculator.addMeal(userInput);
            System.out.print("Enter a cost in dollars and cents, e.g. 12.50 (-1 to end): ");
            userInput = scan.nextDouble();
            scan.nextLine();
        }
        System.out.println("---------------------------------");

        //Print Commands to display the information
        System.out.println("Total Bill Before Tip: " + formatter.format(calculator.getTotalBillBeforeTip()));
        System.out.println("Tip Percentage: " + formatter.format(calculator.getTipPercentage()));
        System.out.println("Total Tip: " + formatter.format(calculator.tipAmount()));
        System.out.println("Total Bill With Tip: " + formatter.format(calculator.totalBill()));
        System.out.println("Per Person Cost Before Tip: " + formatter.format(calculator.perPersonCostBeforeTip()));
        System.out.println("Tip Per Person: " + formatter.format(calculator.perPersonTipAmount()));
        System.out.println("Total Cost Per Person: " + formatter.format(calculator.perPersonTotalCost()));

    }

}
