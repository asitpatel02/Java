package CH11;
// Code Listing 11-4 pg#748

/**
   This program demonstrates how the Integer.parseInt
   method throws an exception.
*/

public class ParseIntError
{
   public static void main(String[] args)
   {
       String str = "abcde";
       int number;

       try
       {
          number = Integer.parseInt(str);
       }
       catch (NumberFormatException e)
       { 
          System.out.println("Conversion error: " +
                             e.getMessage());
       }
   }
}