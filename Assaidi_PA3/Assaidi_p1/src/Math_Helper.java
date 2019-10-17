import java.util.Scanner;
import java.security.SecureRandom;
import java.lang.Float;

public class Math_Helper {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String continu = "y";

        while(continu.charAt(0) == 'y')
        {
            genQuestions();
            System.out.println("Would you like to start a new session? (y or n)");
            continu = input.next();
        }
    }


    public static void genResponse(int choice, int type)
    {
        if(type == 1)
        {
            switch(choice)
                {
                    case 1:
                        System.out.println("Very good!");
                        break;
                    case 2:
                        System.out.println("Excellent!");
                        break;
                    case 3:
                        System.out.println("Nice work!");
                        break;
                    case 4:
                        System.out.println("Keep up the good work!");
                        break;
                }
        }else if(type == 0)
        {
            switch(choice)
                {
                    case 1:
                        System.out.println("No. Please try again.");
                        break;
                    case 2:
                        System.out.println("Wrong. Try once more.");
                        break;
                    case 3:
                        System.out.println("Don’t give up!");
                        break;
                    case 4:
                        System.out.println("No. Keep trying.");
                        break;
                }
        }
    }


    public static void genQuestions()
    {
        Scanner input = new Scanner(System.in);
        SecureRandom rand = new SecureRandom();
        int difficulty = difficultyLevel();
        int type = problemType();
        int num1 = rand.nextInt(difficulty);
        int num2 = rand.nextInt(difficulty);
        int response, percentage, type5;
        float  answer = 0, userAns;
        int numAnswered = 0, correct = 0, incorrect = 0;
        double raw_score;
        while (numAnswered < 10)
        {
            if(type == 1) {
                System.out.println("How much is " + num1 + " plus " + num2 + "?");
                answer = (float) num1 + num2;
            }else if(type == 2)
            {
                System.out.println("How much is " + num1 + " times " + num2 + "?");
                answer = (float) num1 * num2;
            }else if(type == 3)
            {
                System.out.println("How much is " + num1 + " minus " + num2 + "?");
                answer = (float) num1 - num2;
            }else if(type == 4)
            {
                System.out.println("How much is " + num1 + " divided by " + num2 + "?");
                answer = (float) num1 / num2;
            }else if(type == 5)
            {
                type5 = rand.nextInt(4) + 1;
                switch(type5)
                {
                    case 1:
                        System.out.println("How much is " + num1 + " plus " + num2 + "?");
                        answer = (float) num1 + num2;
                        break;
                    case 2:
                        System.out.println("How much is " + num1 + " times " + num2 + "?");
                        answer = (float) num1 * num2;
                        break;
                    case 3:
                        System.out.println("How much is " + num1 + " minus " + num2 + "?");
                        answer = (float) num1 - num2;
                        break;
                    case 4:
                        System.out.println("How much is " + num1 + " divided by " + num2 + "?");
                        answer = (float) num1 / num2;
                        break;
                }
            }
            userAns = input.nextFloat();
            if (Float.compare(answer, userAns) < 0.1)
            {
                correct++;
                numAnswered++;
                response = rand.nextInt(4);
                response++;
                genResponse(response, 1);
            }else
            {
                numAnswered++;
                incorrect++;
                response = rand.nextInt(4);
                response++;
                genResponse(response, 0);
            }
            num1 = rand.nextInt(difficulty);
            num2 = rand.nextInt(difficulty);
        }
        raw_score = (double)correct/10.0;
        percentage = (int)(raw_score*100);
        System.out.println("Number of correct answers: " + correct);
        System.out.println("Number of incorrect answers: " + incorrect);
        if(percentage >= 75)
            System.out.println("Congratulations, you are ready to go to the next level!\n");
        else
            System.out.println("Please ask your teacher for extra help.\n");
    }

    public static int difficultyLevel()
    {
        Scanner input = new Scanner(System.in);
        int level;
        System.out.println("\nWhich difficulty level would you like? (1 to 4)");
        level = input.nextInt();
        switch(level)
        {
            case 1:
                return 10;
            case 2:
                return 100;
            case 3:
                return 1000;
            case 4:
                return 10000;
            default:
                return 0;
        }
    }

    public static int problemType()
    {
        Scanner input = new Scanner(System.in);
        System.out.println("Which kind of problems would you like to solve? (Enter option number)");
        System.out.println("Option 1: Addition");
        System.out.println("Option 2: Multiplication");
        System.out.println("Option 3: Subtraction");
        System.out.println("Option 4: Division");
        System.out.println("Option 5: Mixed Questions\n");
        return input.nextInt();
    }
}
