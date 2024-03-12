
import java.util.Scanner;

public class lab7Q1
{
    public static void main(String[]args)
    {
        Scanner keyboard = new Scanner(System.in);
        
        // int variable
        int NumberOfStudents;
        int stdHigh=0; 
        int count=1;
        
        // double Variable
        double score;
        double min=100;
        double Average=0;

        System.out.print("Professor please enter the number of students in the class: ");
        NumberOfStudents = keyboard.nextInt();

        while ( NumberOfStudents <= 0 )
        {
            System.out.print("please enter a positive value for the number of students: ");
            NumberOfStudents = keyboard.nextInt();
        }

        while ( count <= NumberOfStudents )
        {
            System.out.print("Please enter the Score of the student " + count + ": ");
            score = keyboard.nextDouble();

            Average = Average + score;
            if ( score > 75 )
            {
                stdHigh++;
            }
            if ( score < min )
            {
                min = score;
            }
            count++;
        }

        Average = (Average / NumberOfStudents);

        System.out.printf("The Average score of the students is: %.2f", Average);
        System.out.print("\nThe min score : " + min);
        System.out.println("\nThe number of students who got more than 75 are : " + stdHigh);

    }
}