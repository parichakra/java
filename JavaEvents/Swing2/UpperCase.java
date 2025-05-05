import javax.swing.*;
import java.awt.event.* ;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class UpperCase implements ActionListener{
    JFrame f;
    JButton b;
    JTextField t;

    public UpperCase(){
        f= new JFrame("Uppercase");
        f.setSize(500,600);

        t= new JTextField();
        t.setBounds(100,200,350,75);

        b= new JButton("Click");
        b.setBounds(100,450,150,75);

        f.add(t);
        f.add(b);

        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setLayout(null);
        f.setVisible(true);
        b.addActionListener(this);
    }

    @Override
    public void actionPerformed( ActionEvent e){
        String text = t.getText();

        if(text != null && ! text.trim().isEmpty()){
            t.setText(text.toUpperCase()); 
        }
            t.setBackground( Color.RED);
    }
    
    

    public static void main(String [] args){
        new UpperCase();
    }

}