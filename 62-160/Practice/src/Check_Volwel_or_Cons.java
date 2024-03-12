import java.util.Scanner;

public class Check_Volwel_or_Cons {
    public static void main(String[] args) {

        boolean isVolwel=false;
        Scanner input = new Scanner(System.in);
        System.out.print("Enter a Character: ");
        char ch= input.next().charAt(0);
        input.close();
        switch (ch){
            case'a':
            case'e':
            case'i':
            case'o':
            case'u':
            case'A':
            case'E':
            case'I':
            case'O':
            case'U':isVolwel = true;
        }
        if (isVolwel==true){
            System.out.println(ch+" is a Vowel");
        }
        else
        {
            if ((ch>='a'&&ch<='z')||(ch>='A'&&ch<='Z'))
                System.out.println(ch+" is a Consonant");
            else
                System.out.println("Input is not an alphabet");
        }
    }
}
