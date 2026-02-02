package atm.management.system;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

public class transaction extends JFrame implements ActionListener{
    JButton deposite,withdrawal,fastcash,ministatement,pinchange,balanceenquiry,exit;
    String pinno;
    transaction(String pinno){
        this.pinno=pinno;
        setLayout(null);

        ImageIcon i1= new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2= i1.getImage().getScaledInstance(900,900,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0,0,900,900);
        add(image);

        JLabel text = new JLabel("please select your transaction");
        text.setBounds(210,300,700,35);
        text.setForeground(Color.white);
        text.setFont(new Font("Raleway",Font.BOLD,16));
        image.add(text);

        deposite=new JButton("Deposite");
        deposite.setBounds(170,415,150,30);
        deposite.addActionListener(this);
        image.add(deposite);

        withdrawal=new JButton(" Cash withdrawal");
        withdrawal.setBounds(355,415,150,30);
        withdrawal.addActionListener(this);
        image.add(withdrawal);

        fastcash=new JButton("fastcash");
        fastcash.setBounds(170,450,150,30);
        fastcash.addActionListener(this);
        image.add(fastcash);

        ministatement=new JButton("mini statement");
        ministatement.setBounds(355,450,150,30);
        ministatement.addActionListener(this);
        image.add(ministatement);

        pinchange=new JButton("pin change");
        pinchange.setBounds(170,485,150,30);
        pinchange.addActionListener(this);
        image.add(pinchange);

        balanceenquiry=new JButton("balance enquiry");
        balanceenquiry.setBounds(355,485,150,30);
        balanceenquiry.addActionListener(this);
        image.add(balanceenquiry);

        exit=new JButton("exit");
        exit.setBounds(355,520,150,30);
        exit.addActionListener(this);
        image.add(exit);

        setSize(900,900);
        setLocation(300,0);
        setUndecorated(true);
        setVisible(true);
        
    }
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == exit){
            System.exit(0);
        }else if(ae.getSource() ==deposite){
            setVisible(false);
            new deposite(pinno).setVisible(true);
        }else if(ae.getSource() ==withdrawal){
            setVisible(false);
            new withdrawal(pinno).setVisible(true);
        }else if(ae.getSource() ==fastcash){
            setVisible(false);
            new fastcash(pinno).setVisible(true);
        }else if(ae.getSource() ==pinchange){
            setVisible(false);
            new pinchange(pinno).setVisible(true);
        }else if(ae.getSource() ==balanceenquiry){
            setVisible(false);
            new balanceenquiry(pinno).setVisible(true);
        }else if(ae.getSource() ==ministatement){
            new ministatement(pinno).setVisible(true);
        }
    }
    public static void main(String []args){
        new transaction("");
    }
}
