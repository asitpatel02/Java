package Assignments_3;


import javax.swing.*;

public class Letter_Counter {

    // Main class
    public static void main(String[] args) {

        //Input Variables
        String input0 ,input ,InputChar;
        char c;
        int i=0,count=0;

        //Input String
        input0 = JOptionPane.showInputDialog("Enter a string: ");
        input = input0.toLowerCase();

        //Input Character to Count
        InputChar=JOptionPane.showInputDialog("Enter Character you want to count: ");
        c=InputChar.charAt(0);//read first letter

        //While loop
        while(i<input.length())
        {
            if(input.charAt(i)==c)
                count++;
            i++;
        }

        //Output
        JOptionPane.showMessageDialog(null,c+" Occurs "+count+" Times");

        //Exit
        System.exit(0);
    }
}

