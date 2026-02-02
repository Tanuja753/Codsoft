package atm.management.system;

import javax.swing.*;
import java.awt.*;
import java.sql.ResultSet;

public class ministatement extends JFrame{
    String pinno;
    ministatement(String pinno){
        this.pinno=pinno;
        setLayout(null);
        setTitle("mini statement");

        JLabel mini = new JLabel();
        add(mini);

        JLabel bank = new JLabel("Indian Bank");
        bank.setBounds(150,20,100,20);
        add(bank);


        JLabel card = new JLabel("Indian card");
        card.setBounds(150,20,100,20);
        add(card);

        JLabel balance = new JLabel();
        balance.setBounds(20,400,300,20);
        add(balance);

        try{
            conn c =new conn();
            ResultSet rs=c.s.executeQuery("select * from login where pin_no = '"+pinno+"'");
            while(rs.next()){
                card.setText("Card Number: "+rs.getString("card_no").substring(0,4)+"XXXXXXXX"+rs.getString("card_no").substring(12));
            }

        }catch(Exception e){
            System.out.println(e);
        }

        try{
            conn c =new conn();
            int bal =0;
            ResultSet rs=c.s.executeQuery("select * from bank where pin_no = '"+pinno+"'");
            while(rs.next()){
                mini.setText(mini.getText()+"<html>"+rs.getString("date")+"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"+rs.getString("type")+"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"+rs.getString("amount")+"<br><br><html>");
                if(rs.getString("type").equals("deposite")){
                        bal +=Integer.parseInt(rs.getString("amount"));
                    }else{
                        bal -=Integer.parseInt(rs.getString("amount")); 
                }
            }
            balance.setText("your current account balance is RS "+bal);
        }catch(Exception e){
            System.out.println(e);
        }
        mini.setBounds(20,140,400,200);


        setSize(400,600);
        setLocation(20,20);
        getContentPane().setBackground(Color.white);
        setVisible(true);
    }
    public static void main(String []args){
        new ministatement("");
    }
}
