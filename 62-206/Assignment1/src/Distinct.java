/*
1. Write a java method(only) that takes an array of int values and determines if all numbers are different from each
   other(that is, they are distinct)

   Name : Asit Patel
   Student ID: 190309

 */

public class Distinct {
    
    public static void main(String[] args) {
        System.out.println(allDistinct(new int[] {2, 3, 1, 4, 5}));  // true
        System.out.println(allDistinct(new int[] {2, 3, 1, 2, 5}));  // false
    }
    public static boolean allDistinct(int[] arr) {
        for(int i = 0; i < arr.length; ++i) {          // go through all elements of array
            for(int j = i+1; j < arr.length; ++j) {   // check the element
                if(arr[i] == arr[j]) {              // if duplicate element is found return false
                    return false;
                }
            }
        }
        return true;    // if no duplicates were found return true
    }
}