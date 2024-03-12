package CH10;
// Code Listing 10-9 pg#664

public class SubClass2 extends SuperClass2
{
   /**
      Constructor
   */

   public SubClass2()
   {
      super(10); 
      System.out.println("This is the " +
                 "subclass constructor.");
   }
}