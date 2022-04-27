import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import java.awt.event.*;
import java.awt.*;
import java.net.MalformedURLException;

public class weather{
    
    public static void main(String[] args) throws MalformedURLException {

        //Main body Frame
        JFrame fr = new JFrame("Weather App");
        Image icon = Toolkit.getDefaultToolkit().getImage("assets/icon.png");  
        fr.setIconImage(icon);  
        fr.setLayout(null);
        fr.setSize(800,600);
        fr.getContentPane().setBackground(new Color(162, 224, 246));
       
        
        JLabel nlabel = new JLabel("Rounded Corners");
        nlabel.setHorizontalAlignment(JLabel.CENTER);
        LineBorder line = new LineBorder(Color.black, 2, true);
        nlabel.setBorder(line);

        //Label for welcome text
        JLabel headingLabel = new JLabel();
        headingLabel.setText("<html><H1>Welcome to the Weather Application</H1></html>");
        headingLabel.setBounds(200, 55, 500,30);

        JLabel placeLabel = new JLabel();
        placeLabel.setText("<html><H2>Enter city name: </H2></html>");
        placeLabel.setBounds(100, 195, 500,30);

        //Label for showing selecting element from dropdown
        JLabel label = new JLabel();
        label.setBounds(380, 250, 190, 30); 

        JTextField textField = new JTextField();
        textField.setBounds(290,200, 200,30);       
    
        //Button
        Icon buttonIcon = new ImageIcon("assets/button.png");
        JButton b=new JButton(buttonIcon);
        b.setBounds(320,350,102,48); 
        b.setBorderPainted(false);
        b.setFocusPainted(false);
        b.addActionListener(new ActionListener() {  
            public void actionPerformed(ActionEvent e) {       
                label.setText(textField.getText());            
            } 
        }); 

        

        
        
        fr.add(b);
        fr.add(nlabel);
        fr.add(label);
        fr.add(headingLabel);
        fr.add(placeLabel);
        fr.add(textField);
        fr.setVisible(true);
        fr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
    }
}
