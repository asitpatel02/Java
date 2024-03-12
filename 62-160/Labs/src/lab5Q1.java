
import javax.swing.*;

public class lab5Q1 {
    public static void main(String[] args) {
        JOptionPane.showMessageDialog(null, "Good Morning! This program converts miles to kilometers\n");

        Double mile;
        String Mile;
        Mile=JOptionPane.showInputDialog("Enter Miles");
        mile = Double.parseDouble(Mile);

        double km;
        km = mile*1.60;

        JOptionPane.showMessageDialog(null,mile+" Miles Convert in "+km+" kilometre ");

        System.exit(0);
    }
}
