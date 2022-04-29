package org.example;

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.io.IOException;
import java.util.List;


public class weather extends Main{

    public static void main(String[] args) {


        //Main body Frame
        JFrame fr = new JFrame("Weather App");
        Image icon = Toolkit.getDefaultToolkit().getImage("org/example/assets/icon.png");
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
        label.setBounds(0, 0, 1500, 310);

        JPanel panel = new JPanel();


        JTextField textField = new JTextField();
        textField.setBounds(280,200, 200,30);

        //Button
        Icon buttonIcon = new ImageIcon("org/example/assets/button.png");
        JButton b=new JButton(buttonIcon);
        b.setBounds(320,250,102,48);
        b.setBorderPainted(false);
        b.setFocusPainted(false);
        b.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                panel.setBounds(0,0,800,400);
                panel.setBackground(new Color(162, 224, 246));
                b.setVisible(false);
                headingLabel.setVisible(false);
                placeLabel.setVisible(false);
                textField.setVisible(false);

                //label.setText(textField.getText());
                String name = textField.getText();
                System.out.print(name);
                try {
                    List<String> data = getWeatherInfo(name);
//                    String temp = "";
//                   for(String x:data){
//                       temp = ""+x+"\n";
//                   }

                    final StringBuilder builder = new StringBuilder();
                    data.forEach((val)->{
                        builder.append(val + " ");

                    });
                    String output = builder.toString();
                    label.setText(output);
                    System.out.print(output);
                    data.forEach(System.out::println);

                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                } catch (InterruptedException ex) {
                    throw new RuntimeException(ex);
                }
            }
        });


        fr.add(b);
        fr.add(label);
        fr.add(headingLabel);
        fr.add(placeLabel);
        fr.add(textField);
        fr.add(panel);
        fr.setVisible(true);
        fr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
