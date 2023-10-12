
/**
 *
 * @author 312679-Shruti Panchal
 */
public class StringEquality {

    private String wordOne, wordTwo;

    public StringEquality() {
        wordOne = "";             
        wordOne = "";             
    }

    public StringEquality(String one, String two) {
           setWords(one,two);
    }

    public void setWords(String one, String two) {
         this.wordOne = one;
         this.wordTwo = two;
    }

    public boolean checkEquality() {    
        return wordOne.equals(wordTwo);
    
    }

    @Override
    public String toString() {
        if (checkEquality()){
            return wordOne + " has the same letters as " +wordTwo;
        }
        else{
            return wordOne + " does not have the same letters as " +wordTwo;
        }
    }
    
    public static void main(String[] args) {
        StringEquality s1 = new StringEquality("hello","goodbye");
        System.out.println(s1);
        StringEquality s2 = new StringEquality("A B C","ABC");
        System.out.println(s2);
        StringEquality s3 = new StringEquality("Samae","same");
        System.out.println(s3);
        StringEquality s5 = new StringEquality("one","two");
        System.out.println(s5);
        StringEquality s6 = new StringEquality("5","6");
        System.out.println(s6);
        StringEquality s7 = new StringEquality("Equal","Equal");
        System.out.println(s7);        
    }
    
}
