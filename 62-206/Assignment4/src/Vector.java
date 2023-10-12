public class Vector {
    private int size, capacity;
    private int []a;
    public Vector() {
        size = 1;
        this.capacity = size;
        a = new int[capacity];
    }

    public Vector(int[] arr) {
        this.size = arr.length;
        this.capacity = size;
        a = new int[capacity];
        System.arraycopy(arr, 0, a, 0, size);
    }
    public void upgrade() {
        capacity *= 2;
        int []b = new int[capacity];
        if (size >= 0) System.arraycopy(a, 0, b, 0, size);
        a = b;
    }
    public void push(int num) {
        if(size == capacity) {
            upgrade();
        }
        a[size] = num;
        size++;
    }
    public void pop() {
        if(size > 0)
            size--;
    }
    public boolean isEmpty() {
        return (size == 0);
    }

    public int top() {
        if(!isEmpty())
            return a[size - 1];
        return -1;
    }
    public int length()
    {
        return size;
    }
}