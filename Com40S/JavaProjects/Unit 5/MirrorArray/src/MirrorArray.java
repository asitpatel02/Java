
import java.util.ArrayList;

/**
 *
 * @author 312679-Shruti Panchal
 * Unit 5 - Test
 */
public class MirrorArray {

    private int[] arr, mirrorArr;

    public MirrorArray() {
        setArr(new int[7]);
        setMirrorArr(new int[arr.length]);
    }

    public int[] getArr() {
        return arr;
    }

    public int[] getMirrorArr() {
        return mirrorArr;
    }

    public void setArr(int[] arr) {
        this.arr = arr;
    }

    public void setMirrorArr(int[] mirrorArr) {
        this.mirrorArr = mirrorArr;
    }
    
    public void initArr() {
        ArrayList<Integer> n = new ArrayList<Integer>();
        int num;
        for (int i = 0; i < arr.length; i++) {
            num = (int) ((20 - 1 + 1) * Math.random() + 1);            
            while (n.contains(num)) {
                num = (int) ((20 - 1 + 1) * Math.random() + 1);                
            }
                n.add(num);
                System.out.println(n);
                arr[i] = num;
                //System.out.println(arr[i]);           

        }
    }

    public void mirrorArray() {
        for (int i = 0; i < arr.length; i++) {
            mirrorArr[mirrorArr.length - (i + 1)] = arr[i];
        }
    }

    public void displayArrays() {
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
        for (int i = 0; i < mirrorArr.length; i++) {
            System.out.println(mirrorArr[i]);
        }
    }

    public static void main(String[] args) {
        MirrorArray a1 = new MirrorArray();
        a1.initArr();
        a1.mirrorArray();
        a1.displayArrays();
    }

}
