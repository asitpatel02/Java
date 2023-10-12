
import static com.sun.java.accessibility.util.AWTEventMonitor.addWindowListener;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

/*
 * GUI Stopwatch - Kidware Chapeter 1 - Programming Games with Java
 */
/**
 *
 * @author 312679
 */
public class Stopwatch extends JFrame {

    //extending JFrames means that we can use all the JFrame controls
    //instance variables
    //CONTROLS
    JButton startButton = new JButton();
    JButton stopButton = new JButton();
    JButton exitButton = new JButton();

    JLabel startLabel = new JLabel();
    JLabel stopLabel = new JLabel();
    JLabel elapsedLabel = new JLabel();

    JTextField startTextField = new JTextField();
    JTextField stopTextField = new JTextField();
    JTextField elapsedTextField = new JTextField();

    //time var
    private long startTime;
    private long stopTime;
    private double elapsedTime;

    public Stopwatch() {
        //this is a constructor (special method)
        //it builds or 'constructs' your object, which is a stopwatch
        //has the same name as the class
        //pupose: initialize properties

        setTitle("Stopwatch App");
        //setSize(300,100);
        getContentPane().setLayout(new GridBagLayout());
        GridBagConstraints gridConstraints = new GridBagConstraints();

        //set up our start button
        startButton.setText("Start timing");
        gridConstraints.gridx = 0;
        gridConstraints.gridy = 0;
        getContentPane().add(startButton, gridConstraints);
        //actionlistner
        startButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                startButtonActionPerformed(e);//can be called anything
            }
        });

        //set up the stop button
        stopButton.setText("Stop timing");
        gridConstraints.gridx = 0;
        gridConstraints.gridy = 1;
        getContentPane().add(stopButton, gridConstraints);
        //actionlistner
        stopButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                stopButtonActionPerformed(e);
            }
        });

        //set up the exit button
        exitButton.setText("Exit");
        gridConstraints.gridx = 0;
        gridConstraints.gridy = 2;
        getContentPane().add(exitButton, gridConstraints);
        //actionlistner
        exitButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                exitButtonActionPerformed(e);
            }
        });

        //set up our start label
        startLabel.setText("Start time");
        gridConstraints.gridx = 1;
        gridConstraints.gridy = 0;
        getContentPane().add(startLabel, gridConstraints);

        //set up the stop label
        stopLabel.setText("Stop time");
        gridConstraints.gridx = 1;
        gridConstraints.gridy = 1;
        getContentPane().add(stopLabel, gridConstraints);

        //set up the elapsed label
        elapsedLabel.setText("Elapsed time(sec)");
        gridConstraints.gridx = 1;
        gridConstraints.gridy = 2;
        getContentPane().add(elapsedLabel, gridConstraints);

        //set up the start textfield 
        startTextField.setText("");
        startTextField.setColumns(15);
        gridConstraints.gridx = 2;
        gridConstraints.gridy = 0;
        getContentPane().add(startTextField, gridConstraints);

        //set up the stop textfield 
        stopTextField.setText("");
        stopTextField.setColumns(15);
        gridConstraints.gridx = 2;
        gridConstraints.gridy = 1;
        getContentPane().add(stopTextField, gridConstraints);

        //set up the elapsed textfield 
        elapsedTextField.setText("");
        elapsedTextField.setColumns(15);
        gridConstraints.gridx = 2;
        gridConstraints.gridy = 2;
        getContentPane().add(elapsedTextField, gridConstraints);

        pack();
        
        //stop program when window closed================================================
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                exitForm(e);
            }
        });

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        
    }//end of Constructor

    public void exitForm(WindowEvent e) {
        System.exit(0);
    }
        //================================================================================

    //user methods/////
    private void startButtonActionPerformed(ActionEvent e) {
        //HELPER method only for this file//
        //this is a HELPER METHOD..ie only used in this class
        //declared PRIVATE instead of PUBLIC
        //click of start timing button
        startTime = System.currentTimeMillis();
        startTextField.setText(String.valueOf(startTime));
        stopTextField.setText("");
        elapsedTextField.setText("");
    }

    private void stopButtonActionPerformed(ActionEvent e) {
        //click of stop timing button
        stopTime = System.currentTimeMillis();
        stopTextField.setText(String.valueOf(stopTime));
        elapsedTime = (stopTime - startTime) / 1000.0;
        elapsedTextField.setText(String.valueOf(elapsedTime));
    }

    private void exitButtonActionPerformed(ActionEvent e) {
        System.exit(0);
    }
    //end user methods/////

    public static void main(String[] args) {
        new Stopwatch().setVisible(true);
    }

}//END class
