package atm.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class balanceenquiry extends JFrame implements ActionListener{
    String pinno;
    JButton back;
    balanceenquiry(String pinno){
        this.pinno=pinno;
        setLayout(null);

        ImageIcon i1= new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2= i1.getImage().getScaledInstance(900,900,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0,0,900,900);
        add(image);

        back = new JButton("back");
        back.setBounds(355,520,150,30);
        back.addActionListener(this);
        image.add(back);

        conn c = new conn();
        int balance =0;
        try{
            ResultSet rs = c.s.executeQuery("select * from bank where pin_no ='"+pinno+"'");
            
            while(rs.next()){
                if(rs.getString("type").equals("deposite")){
                    balance +=Integer.parseInt(rs.getString("amount"));
                }else{
                    balance -=Integer.parseInt(rs.getString("amount")); 
            }
                    
            } 
        }catch(Exception e){
            System.out.println(e);
        }
        
        JLabel text = new JLabel("your current account balance is RS : "+balance);
        text.setForeground(Color.white);
        text.setBounds(170,300,400,30);
        image.add(text);

        setSize(900,900);
        setLocation(300,0);
        setUndecorated(true);
        setVisible(true);
    }
    public void actionPerformed(ActionEvent ae){
        setVisible(false);
        new transaction(pinno).setVisible(true);
    }
    public static void main(String []args){
        new balanceenquiry("");
    }
}
