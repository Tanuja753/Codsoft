package atm.management.system;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

import javax.swing.*;

public class login extends JFrame implements ActionListener{
    JButton log,signup,clear;
    JTextField cardtextfield;
    JPasswordField pintextfield;
    login(){
        setTitle("AUTOMATED TELLER MACHINE");

        setLayout(null);

        ImageIcon i1= new ImageIcon(ClassLoader.getSystemResource("icons/logo.jpg"));
        Image i2= i1.getImage().getScaledInstance(100,100,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel lable= new JLabel(i3);
        lable.setBounds(70,10,100,100);
        add(lable);

        JLabel text= new JLabel("WELCOME TO ATM");
        text.setFont(new Font("osward", Font.BOLD,38));
        text.setBounds(200,40,400,40);
        add(text);

        JLabel cardno= new JLabel("CARD NO");
        cardno.setFont(new Font("Raleway", Font.BOLD,38));
        cardno.setBounds(120,150,150,30);
        add(cardno);

        cardtextfield = new JTextField();
        cardtextfield.setBounds(300,150,230,30);
        cardtextfield.setFont(new Font("Arial",Font.BOLD,14));
        add(cardtextfield);

        JLabel pin= new JLabel("PIN");
        pin.setFont(new Font("Raleway", Font.BOLD,38));
        pin.setBounds(120,220,250,40);
        //pintextfield.setFont(new Font("Arial",Font.BOLD,14));
        add(pin);

        pintextfield = new JPasswordField();
        pintextfield.setBounds(300,220,230,30);
        add(pintextfield);

        log =new JButton("SIGN IN");
        log.setBounds(300,300,100,30);
        log.setBackground(Color.black);
        log.setForeground(Color.white);
        log.addActionListener(this);
        add(log);

        clear =new JButton("Clear");
        clear.setBounds(430,300,100,30);
        clear.setBackground(Color.black);
        clear.setForeground(Color.white);
        clear.addActionListener(this);
        add(clear);

        signup =new JButton("SIGN UP");
        signup.setBounds(300,350,230,30);
        signup.setBackground(Color.black);
        signup.setForeground(Color.white);
        signup.addActionListener(this);
        add(signup);
        

        getContentPane().setBackground(Color.white);
    
        setSize(800,480);
        setVisible(true);
        setLocation(350,200);

    }


    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == clear){
            cardtextfield.setText("");
            pintextfield.setText("");
        }else if(ae.getSource() == log){
            conn c =new conn();
            String cardno = cardtextfield.getText();
            String pinno = pintextfield.getText();
            String query = "select * from login where card_no = '"+cardno+"' and pin_no = '"+pinno+"'";
            try{
                ResultSet rs=c.s.executeQuery(query);
                if(rs.next()){
                    setVisible(false);
                    new transaction(pinno).setVisible(true);
                }else{
                    JOptionPane.showMessageDialog(null,"incorrect card no or pin");
                }
            }catch(Exception e){
                System.out.println(e);
            }
        }else if(ae.getSource() == signup){
            setVisible(false);
            new signup().setVisible(true);
        }
    }
    public static void main(String []args){
        new login();
    }
}