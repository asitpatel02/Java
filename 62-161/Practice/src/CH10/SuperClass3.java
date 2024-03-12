package CH10;
// Code Listing 10-15 pg#677
public class SuperClass3
{
   /**
      This method displays an int.
      @param arg An int.
   */

   public void showValue(int arg)
   {
      System.out.println("SUPERCLASS: " +
            "The int argument was " + arg);
   }

   /**
      This method displays a String.
      @param arg A String.
   */

   public void showValue(String arg)
   {
      System.out.println("SUPERCLASS: " +
         "The String argument was " + arg);
   }
}