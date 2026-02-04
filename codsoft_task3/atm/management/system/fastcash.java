package atm.management.system;

import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;
import java.util.Date;

import javax.swing.*;

public class fastcash extends JFrame implements ActionListener{
    JButton rs1,rs2,rs3,rs4,rs5,rs6,exit;
    String pinno;
    fastcash(String pinno){
        this.pinno=pinno;
        setLayout(null);

        ImageIcon i1= new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2= i1.getImage().getScaledInstance(900,900,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0,0,900,900);
        add(image);

        JLabel text = new JLabel("select withdrawal amount");
        text.setBounds(210,300,700,35);
        text.setForeground(Color.white);
        text.setFont(new Font("Raleway",Font.BOLD,16));
        image.add(text);

        rs1=new JButton("rs 100");
        rs1.setBounds(170,415,150,30);
        rs1.addActionListener(this);
        image.add(rs1);

        rs2=new JButton("rs 500");
        rs2.setBounds(355,415,150,30);
        rs2.addActionListener(this);
        image.add(rs2);

        rs3=new JButton("rs 1000");
        rs3.setBounds(170,450,150,30);
        rs3.addActionListener(this);
        image.add(rs3);

        rs4=new JButton("rs 2000");
        rs4.setBounds(355,450,150,30);
        rs4.addActionListener(this);
        image.add(rs4);

        rs5=new JButton("rs 5000");
        rs5.setBounds(170,485,150,30);
        rs5.addActionListener(this);
        image.add(rs5);

        rs6=new JButton("rs 10000");
        rs6.setBounds(355,485,150,30);
        rs6.addActionListener(this);
        image.add(rs6);

        exit=new JButton("back");
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
            setVisible(false);
            new transaction(pinno).setVisible(true);
        }else{
            String amount = ((JButton)ae.getSource()).getText().substring(3);
            conn c = new conn();
            try{
                ResultSet rs = c.s.executeQuery("select * from bank where pin_no ='"+pinno+"'");
                int balance =0;
                while(rs.next()){
                    if(rs.getString("type").equals("deposite")){
                        balance +=Integer.parseInt(rs.getString("amount"));
                    }else{
                        balance -=Integer.parseInt(rs.getString("amount")); 
                }
                    
                } 
                if(ae.getSource() != exit && balance <Integer.parseInt(amount)){
                    JOptionPane.showMessageDialog(null, "Insufficient balance");
                    return;
                }
                Date date = new Date();
                String query = "insert into bank values('"+pinno+"','"+date+"','withdrawal','"+amount+"')";
                c.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null,"RS "+amount+" debited successsfully");
                setVisible(false);
                new transaction(pinno).setVisible(true);
            }catch(Exception e){
                System.out.println(e);
            }
        }
    }
    public static void main(String []args){
        new fastcash("");
    }
}
