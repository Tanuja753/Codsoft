package atm.management.system;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;
import javax.swing.*;
import com.toedter.calendar.JDateChooser;

public class signup extends JFrame implements ActionListener{
    Long random;
    JTextField nametextfield,fnametextfield,dobtextfield,emailtextfield,addresstextfield,citytextfield,statetextfield,pintextfield;
    JRadioButton male,female,married,unmarried;
    JDateChooser datechooser;
    JButton next;
    signup(){
        setLayout(null);
        Random ran = new Random();
        random = Math.abs((ran.nextLong() % 9000L)+1000L);
        
        JLabel formno= new JLabel("Application form no : "+random);
        formno.setFont(new Font("Raleway",Font.BOLD,20));
        formno.setBounds(290,20,600,40);
        add(formno);

        JLabel personaldetails= new JLabel("Page no.1 : Personal Details");
        personaldetails.setFont(new Font("Raleway",Font.BOLD,20));
        personaldetails.setBounds(290,80,400,30);
        add(personaldetails);

        JLabel name= new JLabel("Name : ");
        name.setFont(new Font("Raleway",Font.BOLD,20));
        name.setBounds(100,140,100,30);
        add(name);

        nametextfield= new JTextField();
        nametextfield.setFont(new Font("Raleway",Font.BOLD,14));
        nametextfield.setBounds(300,140,400,30);
        add(nametextfield);

        JLabel fname= new JLabel("Father's Name : ");
        fname.setFont(new Font("Raleway",Font.BOLD,20));
        fname.setBounds(100,190,200,30);
        add(fname);

        fnametextfield= new JTextField();
        fnametextfield.setFont(new Font("Raleway",Font.BOLD,14));
        fnametextfield.setBounds(300,190,400,30);
        add(fnametextfield);


        JLabel dob= new JLabel("Date OF Birth : ");
        dob.setFont(new Font("Raleway",Font.BOLD,20));
        dob.setBounds(100,240,200,30);
        add(dob);

        datechooser= new JDateChooser();
        datechooser.setBounds(300,240,200,30);
        add(datechooser);

        JLabel gender= new JLabel("Gender : ");
        gender.setFont(new Font("Raleway",Font.BOLD,20));
        gender.setBounds(100,290,400,30);
        datechooser.setForeground(Color.BLACK);
        add(gender);

        male= new JRadioButton("Male");
        male.setBounds(300,290,60,30);
        male.setBackground(Color.white);
        add(male);

        female= new JRadioButton("Female");
        female.setBounds(450,290,120,30);
        female.setBackground(Color.white);
        add(female);

        ButtonGroup gendergroup = new ButtonGroup();
        gendergroup.add(female);
        gendergroup.add(male);

        JLabel email= new JLabel("Email : ");
        email.setFont(new Font("Raleway",Font.BOLD,20));
        email.setBounds(100,340,200,30);
        add(email);

        emailtextfield= new JTextField();
        emailtextfield.setFont(new Font("Raleway",Font.BOLD,14));
        emailtextfield.setBounds(300,340,400,30);
        add(emailtextfield);



        JLabel maritalstatus= new JLabel("Marital Status : ");
        maritalstatus.setFont(new Font("Raleway",Font.BOLD,20));
        maritalstatus.setBounds(100,390,200,30);
        add(maritalstatus);

        married= new JRadioButton("Married");
        married.setBounds(300,390,100,30);
        married.setBackground(Color.white);
        add(married);

        unmarried= new JRadioButton("Unmarried");
        unmarried.setBounds(450,390,100,30);
        unmarried.setBackground(Color.white);
        add(unmarried);

        ButtonGroup gendergroup2 = new ButtonGroup();
        gendergroup2.add(married);
        gendergroup2.add(unmarried);


        JLabel address= new JLabel("Address : ");
        address.setFont(new Font("Raleway",Font.BOLD,20));
        address.setBounds(100,440,200,30);
        add(address);

        addresstextfield= new JTextField();
        addresstextfield.setFont(new Font("Raleway",Font.BOLD,14));
        addresstextfield.setBounds(300,440,400,30);
        add(addresstextfield);


        JLabel city= new JLabel("City : ");
        city.setFont(new Font("Raleway",Font.BOLD,20));
        city.setBounds(100,490,200,30);
        add(city);

        citytextfield= new JTextField();
        citytextfield.setFont(new Font("Raleway",Font.BOLD,14));
        citytextfield.setBounds(300,490,400,30);
        add(citytextfield);


        JLabel state= new JLabel("State : ");
        state.setFont(new Font("Raleway",Font.BOLD,20));
        state.setBounds(100,540,200,30);
        add(state);

        statetextfield= new JTextField();
        statetextfield.setFont(new Font("Raleway",Font.BOLD,14));
        statetextfield.setBounds(300,540,400,30);
        add(statetextfield);


        JLabel pincode= new JLabel("pincode : ");
        pincode.setFont(new Font("Raleway",Font.BOLD,20));
        pincode.setBounds(100,590,200,30);
        add(pincode);

        pintextfield= new JTextField();
        pintextfield.setFont(new Font("Raleway",Font.BOLD,14));
        pintextfield.setBounds(300,590,400,30);
        add(pintextfield);

        next = new JButton("Next");
        next.setBackground(Color.black);
        next.setForeground(Color.white);
        next.setFont(new Font("Raleway",Font.BOLD,14));
        next.setBounds(620,640,80,30);
        next.addActionListener(this);
        add(next);



        getContentPane().setBackground(Color.white);

        setSize(850,800);
        setLocation(350,10);
        setVisible(true);

    }
    public void actionPerformed(ActionEvent ae){
        String formno= ""+random;
        String name = nametextfield.getText();
        String fname = fnametextfield.getText();
        String dob= ((JTextField)datechooser.getDateEditor().getUiComponent()).getText();
        String gender = null;
        if(male.isSelected()){
            gender= "Male";
        }else if(female.isSelected()){
            gender = "Female";
        }

        String email = emailtextfield.getText();
        String marital = null;
        if(married.isSelected()){
            marital = "Married";
        }else if(unmarried.isSelected()){
            marital = "Unmarried";
        }
        String address = addresstextfield.getText();
        String city = citytextfield.getText();
        String pin = pintextfield.getText();
        String state = statetextfield.getText();

        try{
            if(name.equals("")){
                JOptionPane.showMessageDialog(null,"Name is Required");
            }else{
                conn c = new conn();
                String query= "insert into signup values('"+formno+"','"+name+"','"+fname+"','"+dob+"','"+gender+"','"+email+"','"+marital+"','"+address+"','"+city+"','"+pin+"','"+state+"')";
                c.s.executeUpdate(query);
                setVisible(false);
                new signuptwo(formno).setVisible(true);
            }
        }catch(Exception e){
            System.out.println(e);
        }
    }
    public static void main(String []args){
        new signup();
    }
}
