public class VectorMain {
    public static int[] span2(int[] X){
        int[] I = new int[X.length];
        Stack S = new Stack();
        for (int i = 0; i < X.length; i++) {
            while (!S.isEmpty() && X[S.top()] <= X[i])
                S.pop();
            if(S.isEmpty())
                I[i] = i + 1;
            else
                I[i] = i - S.top();
            S.push(i);
        }
        return I;
    }

    public static void main(String[] args) {
        int[] input = new int[10];

        for(int i=0; i<10; i++) {
            input[i]= (int) (Math.random()*10);
        }

        long nano_startTime= System.nanoTime();
        long milli_startTime= System.currentTimeMillis();
        int[] A = span2(input);
        long nano_endTime= System.nanoTime();
        long milli_endTime= System.currentTimeMillis();


        System.out.print("Input Stack: ");
        for (int i : input)
            System.out.print(i + " ");
        System.out.println();

        System.out.println("Array length: " +span2(input).length);
        System.out.println("Is Vector is empty: " +Stack.isEmpty);

        System.out.print("Stack Output: ");
        for (int i : A)
            System.out.print(i + " ");
        System.out.println();

        System.out.println("Time taken in nano seconds: " + (nano_endTime - nano_startTime));
        System.out.println("Time taken in milli seconds: " + (milli_endTime - milli_startTime));

    }
}