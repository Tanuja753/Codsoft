import java.util.*;

class NumberGame{
    public static void main(String []args){
        Random obj = new Random();
        int randomNum=obj.nextInt(100)+1;
        int attempt=10;
        boolean flag = false;
        Scanner sc = new Scanner(System.in);

        System.out.println(" Guess the number between 1 and 100");
        System.out.println("You have 10 attempts");
        while(attempt > 0 && flag != true){
            System.out.print("Enter your guess: ");
            int userNum=sc.nextInt();
            if(userNum == randomNum){
                System.out.println(" Correct Number! You won!");
                flag = true;
                break;
            }
            else if(userNum > randomNum){
                System.out.println("High Number");
            }
            else if(userNum < randomNum){
                System.out.println("Low Number");
            }
            attempt--;
            System.out.println("Attempts left: " + attempt);
            System.out.println();
        }
         if(flag == false){
                System.out.println(" Game Over! The correct number was: " + randomNum);
            }

        sc.close();

        }

       
}