import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.event.*;
import java.awt.*;


public class weather{
    
    public static void main(String[] args) {

        //Main body Frame
        JFrame fr = new JFrame("Weather App");
        Image icon = Toolkit.getDefaultToolkit().getImage("assets/icon.png");
        fr.setIconImage(icon);  
        fr.setLayout(null);
        fr.setSize(800,400);
        fr.getContentPane().setBackground(new Color(162, 224, 246));

        //Label for welcome text
        JLabel headingLabel = new JLabel();
        headingLabel.setText("<html><H1>Welcome to the Weather Application</H1></html>");
        headingLabel.setBounds(200, 55, 500,30);

        JLabel placeLabel = new JLabel();
        placeLabel.setText("<html><H2>Enter city/country name: </H2></html>");
        placeLabel.setBounds(278, 145, 500,30);

        //Label for showing selecting element from dropdown
        JLabel label = new JLabel();
        label.setBounds(200, 250, 190, 30); 

        JTextField textField = new JTextField();
        textField.setBounds(280,200, 200,30);       
    
        //Button
        Icon buttonIcon = new ImageIcon("assets/button.png");
        JButton b=new JButton(buttonIcon);
        b.setBounds(320,250,102,48); 
        b.setBorderPainted(false);
        b.setFocusPainted(false);
        b.addActionListener(new ActionListener() {  
            public void actionPerformed(ActionEvent e) {       
                label.setText(textField.getText());            
            } 
        }); 

       
        fr.add(b);
        fr.add(label); 
        fr.add(headingLabel);
        fr.add(placeLabel);
        fr.add(textField);
        fr.setVisible(true);
        fr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
    }
}
