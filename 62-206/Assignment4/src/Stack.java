public class Stack {
    public static boolean isEmpty;
    Vector vector;
    public Stack() {
        vector = new Vector();
    }
    public void push(int num)
    {
        vector.push(num);
    }
    public void pop()
    {
        vector.pop();
    }
    public boolean isEmpty()
    {
        return vector.isEmpty();
    }
    public int top()
    {
        return vector.top();
    }
    public int length()
    {
        return vector.length();
    }
}
