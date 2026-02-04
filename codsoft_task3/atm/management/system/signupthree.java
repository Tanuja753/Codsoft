package atm.management.system;

import java.awt.*;
import java.awt.event.*;
import java.util.Random;

import javax.swing.*;

public class signupthree extends JFrame implements ActionListener{
    
    JRadioButton r1,r2,r3,r4;
    JCheckBox c1,c2,c3,c4,c5,c6,c7;
    JButton submit,cancel;
    String formno;
    signupthree(String formno){
        this.formno=formno;
        setLayout(null);
        JLabel l1 = new JLabel("Page 3: Account Details");
        l1.setFont(new Font("Raleway",Font.BOLD,22));
        l1.setBounds(280,40,400,40);
        add(l1);

        JLabel type = new JLabel("Account type");
        type.setFont(new Font("Raleway",Font.BOLD,22));
        type.setBounds(100,140,200,30);
        add(type);

        r1= new JRadioButton("Saving Account");
        r1.setFont(new Font("Raleway",Font.BOLD,16));
        r1.setBackground(Color.white);
        r1.setBounds(100,180,150,20);
        add(r1);

        r2= new JRadioButton("Fixed Deposite Account");
        r2.setFont(new Font("Raleway",Font.BOLD,16));
        r2.setBackground(Color.white);
        r2.setBounds(350,180,250,20);
        add(r2);

        r3= new JRadioButton("Current Account");
        r3.setFont(new Font("Raleway",Font.BOLD,16));
        r3.setBackground(Color.white);
        r3.setBounds(100,220,150,20);
        add(r3);

        r4= new JRadioButton("Recurring Deposite Account");
        r4.setFont(new Font("Raleway",Font.BOLD,16));
        r4.setBackground(Color.white);
        r4.setBounds(350,220,250,20);
        add(r4);

        ButtonGroup groupaccount= new ButtonGroup();
        groupaccount.add(r1);
        groupaccount.add(r2);
        groupaccount.add(r3);
        groupaccount.add(r4);

        JLabel card = new JLabel("Card no:");
        card.setFont(new Font("Raleway",Font.BOLD,22));
        card.setBounds(100,300,200,30);
        add(card);

        JLabel number = new JLabel("XXXX-XXXX-XXXX-4104");
        number.setFont(new Font("Raleway",Font.BOLD,22));
        number.setBounds(330,300,300,30);
        add(number);

        JLabel cardno = new JLabel("your sixteen digit card no:");
        cardno.setFont(new Font("Raleway",Font.BOLD,12));
        cardno.setBounds(100,330,200,15);
        add(cardno);

        JLabel pin = new JLabel("pin no:");
        pin.setFont(new Font("Raleway",Font.BOLD,22));
        pin.setBounds(100,370,200,30);
        add(pin);

        JLabel pnumber = new JLabel("XXXX");
        pnumber.setFont(new Font("Raleway",Font.BOLD,22));
        pnumber.setBounds(330,370,200,30);
        add(pnumber);

        JLabel pinno = new JLabel("your four digit card no:");
        pinno.setFont(new Font("Raleway",Font.BOLD,12));
        pinno.setBounds(100,400,200,15);
        add(pinno);

        JLabel service = new JLabel("Services Required");
        service.setFont(new Font("Raleway",Font.BOLD,22));
        service.setBounds(100,450,400,30);
        add(service);

        c1 = new JCheckBox("ATM CARD");
        c1.setBackground(Color.white);
        c1.setFont(new Font("Raleway",Font.BOLD,16));
        c1.setBounds(100,500,200,30);
        add(c1);
        c2 = new JCheckBox("internet banking");
        c2.setBackground(Color.white);
        c2.setFont(new Font("Raleway",Font.BOLD,16));
        c2.setBounds(350,500,200,30);
        add(c2);
        c3 = new JCheckBox("mobile banking");
        c3.setBackground(Color.white);
        c3.setFont(new Font("Raleway",Font.BOLD,16));
        c3.setBounds(100,550,200,30);
        add(c3);
        c4 = new JCheckBox("email and sms alerts");
        c4.setBackground(Color.white);
        c4.setFont(new Font("Raleway",Font.BOLD,16));
        c4.setBounds(350,550,200,30);
        add(c4);
        c5 = new JCheckBox("checkbook");
        c5.setBackground(Color.white);
        c5.setFont(new Font("Raleway",Font.BOLD,16));
        c5.setBounds(100,600,200,30);
        add(c5);
        c6 = new JCheckBox("E- statement");
        c6.setBackground(Color.white);
        c6.setFont(new Font("Raleway",Font.BOLD,16));
        c6.setBounds(350,600,200,30);
        add(c6);
        c7 = new JCheckBox("I hereby Declared that the abouve enterd details are correct to the best of my knowledge");
        c7.setBackground(Color.white);
        c7.setFont(new Font("Raleway",Font.BOLD,12));
        c7.setBounds(100,680,500,30);
        add(c7);
        
        submit = new JButton("Submit");
        submit.setBackground(Color.black);
        submit.setForeground(Color.white);
        submit.setFont(new Font("Raleway",Font.BOLD,14));
        submit.setBounds(250,720,100,30);
        submit.addActionListener(this);
        add(submit);

        cancel = new JButton("Cancel");
        cancel.setBackground(Color.black);
        cancel.setForeground(Color.white);
        cancel.setFont(new Font("Raleway",Font.BOLD,14));
        cancel.setBounds(420,720,100,30);
        cancel.addActionListener(this);
        add(cancel);

        getContentPane().setBackground(Color.white);
        
        

        setSize(850,820);
        setLocation(350,0);
        setVisible(true);
    }
    public void actionPerformed(ActionEvent ae){
            if(ae.getSource() ==submit){
                String accounttype=null;
                if(r1.isSelected()){
                    accounttype = "Saving Account";
                }else if(r2.isSelected()){
                    accounttype ="Fixed deposite account";
                }else if(r3.isSelected()){
                    accounttype ="current account";
                }else if(r4.isSelected()){
                    accounttype ="reccuring deposite account";
                }
                Random random = new Random();
                String cardno = "" + Math.abs((random.nextLong() % 90000000L)+5040936000000000L);
                String pinno = ""  + Math.abs((random.nextLong()% 9000L)+1000L);
                String facility ="";
                if(c1.isSelected()){
                    facility = facility +"AtM CARD";
                }else if(c2.isSelected()){
                    facility= facility+"internet banking";
                }else if(c3.isSelected()){
                    facility= facility+"mobile banking";
                }else if(c4.isSelected()){
                    facility= facility+"email and sms alerts";
                }else if(c5.isSelected()){
                    facility= facility+"checkbook";
                }else if(c6.isSelected()){
                    facility= facility+"E- statement";
                }

                try{
                    if(accounttype.equals("")){
                        JOptionPane.showMessageDialog(null,"Account type is required");
                    }else{
                        conn c= new conn();
                        String query = "insert into signupthree values('"+formno+"','"+accounttype+"','"+cardno+"','"+pinno+"','"+facility+"')";
                        String query2 = "insert into login values('"+formno+"','"+cardno+"','"+pinno+"')";
                        c.s.executeUpdate(query);
                        c.s.executeUpdate(query2);
                        JOptionPane.showMessageDialog(null,"Card NO : "+cardno+"\nPIN: "+pinno);
                        setVisible(false);
                        new deposite(pinno).setVisible(false);

                    }
                

                }catch(Exception e){
                    System.out.println(e);
                }
            }else if(ae.getSource() ==cancel){
                setVisible(false);
                new login().setVisible(true);
            }
        }

         
    public static void main(String []args){
        new signupthree("");
    }
}
