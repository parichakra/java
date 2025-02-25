import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EvenOddChecker {
    public static void main(String[] args) {
        // Create JFrame
        JFrame frame = new JFrame("Even or Odd Checker");
        frame.setSize(300, 150);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new FlowLayout());
        
        // Create components
        JTextField inputField = new JTextField(10);
        JButton checkButton = new JButton("Check");
        JTextField resultField = new JTextField(10);
        resultField.setEditable(false);
        
        // Add action listener to button
        checkButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    int number = Integer.parseInt(inputField.getText());
                    if (number % 2 == 0) {
                        resultField.setText("Even Number");
                    } else {
                        resultField.setText("Odd Number");
                    }
                } catch (NumberFormatException ex) {
                    resultField.setText("Invalid Input");
                }
            }
        });
        
        // Add components to frame
        frame.add(new JLabel("Enter Number:"));
        frame.add(inputField);
        frame.add(checkButton);
        frame.add(new JLabel("Result:"));
        frame.add(resultField);
        
        // Set frame visibility
        frame.setVisible(true);
    }
}