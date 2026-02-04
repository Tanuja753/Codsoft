package atm.management.system;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
//import com.toedter.calendar.JDateChooser;

public class signuptwo extends JFrame implements ActionListener{
    JTextField pannotextfield,adharnotextfield;
    JRadioButton syes,sno,ayes,ano;
    JComboBox<String> religon,cate,inco,edu,occup;
    String formno;
    JButton next;
    signuptwo(String formno){
        this.formno=formno;
        setLayout(null);
        setTitle("NEW APPLICATION FORM PAGE:2");

        JLabel additionaldetails= new JLabel("Page no.2 : Additional Details");
        additionaldetails.setFont(new Font("Raleway",Font.BOLD,20));
        additionaldetails.setBounds(290,80,400,30);
        add(additionaldetails);


        JLabel religion= new JLabel("Religion : ");
        religion.setFont(new Font("Raleway",Font.BOLD,20));
        religion.setBounds(100,140,100,30);
        add(religion);

        
        String valreligon[]={"Hindu","muslim","sikh","christian","others"};
        religon= new JComboBox<>(valreligon);
        religon.setBounds(300,140,400,30);
        religon.setBackground(Color.white);
        add(religon);

        

        JLabel category= new JLabel("Category : ");
        category.setFont(new Font("Raleway",Font.BOLD,20));
        category.setBounds(100,190,200,30);
        add(category);

        String valcategory[]={"General","obc","sc","st","other"};
        cate= new JComboBox<>(valcategory);
        cate.setBounds(300,190,400,30);
        cate.setBackground(Color.white);
        add(cate);


        JLabel income= new JLabel("Income : ");
        income.setFont(new Font("Raleway",Font.BOLD,20));
        income.setBounds(100,240,200,30);
        add(income);

        String valincome[]={"null","< 150000","< 250000","< 500000","upto 1000000"};
        inco= new JComboBox<>(valincome);
        inco.setBounds(300,240,200,30);
        inco.setBackground(Color.white);
        add(inco);

        JLabel educational= new JLabel("Educational : ");
        educational.setFont(new Font("Raleway",Font.BOLD,20));
        educational.setBounds(100,290,400,30);
        educational.setForeground(Color.BLACK);
        add(educational);

        

        JLabel qualification= new JLabel("Qualification : ");
        qualification.setFont(new Font("Raleway",Font.BOLD,20));
        qualification.setBounds(100,315,200,30);
        add(qualification);

        String educationalvalues[]={"non educational","graduate","post graduation","doctrate","other"};
        edu= new JComboBox<>(educationalvalues);
        edu.setBounds(300,315,400,30);
        edu.setBackground(Color.white);
        add(edu);


        JLabel occupation= new JLabel("Occupation : ");
        occupation.setFont(new Font("Raleway",Font.BOLD,20));
        occupation.setBounds(100,390,200,30);
        add(occupation);

        String occupationvalues[]={"salaried","self employed","buisness","student","retired","others"};
        occup= new JComboBox<>(occupationvalues);
        occup.setBounds(300,390,400,30);
        occup.setBackground(Color.white);
        add(occup);

        JLabel panno= new JLabel("pan no : ");
        panno.setFont(new Font("Raleway",Font.BOLD,20));
        panno.setBounds(100,440,200,30);
        add(panno);

        pannotextfield= new JTextField();
        pannotextfield.setFont(new Font("Raleway",Font.BOLD,14));
        pannotextfield.setBounds(300,440,400,30);
        add(pannotextfield);


        JLabel adharno= new JLabel("adhar no : ");
        adharno.setFont(new Font("Raleway",Font.BOLD,20));
        adharno.setBounds(100,490,200,30);
        add(adharno);

        adharnotextfield= new JTextField();
        adharnotextfield.setFont(new Font("Raleway",Font.BOLD,14));
        adharnotextfield.setBounds(300,490,400,30);
        add(adharnotextfield);


        JLabel senior= new JLabel("Senior citizen : ");
        senior.setFont(new Font("Raleway",Font.BOLD,20));
        senior.setBounds(100,540,200,30);
        add(senior);

        syes= new JRadioButton("yes");
        syes.setBounds(300,540,100,30);
        syes.setBackground(Color.white);
        add(syes);

        sno= new JRadioButton("no");
        sno.setBounds(450,540,100,30);
        sno.setBackground(Color.white);
        add(sno);

        ButtonGroup sgroup = new ButtonGroup();
        sgroup.add(syes);
        sgroup.add(sno);



        JLabel pincode= new JLabel("Existing Account : ");
        pincode.setFont(new Font("Raleway",Font.BOLD,20));
        pincode.setBounds(100,590,200,30);
        add(pincode);

       ayes= new JRadioButton("yes");
        ayes.setBounds(300,590,100,30);
        ayes.setBackground(Color.white);
        add(ayes);

        ano= new JRadioButton("no");
        ano.setBounds(450,590,100,30);
        ano.setBackground(Color.white);
        add(ano);

        ButtonGroup agroup = new ButtonGroup();
        agroup.add(ayes);
        agroup.add(ano);

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
    
        String religion =(String) religon.getSelectedItem();
        String category = (String)cate.getSelectedItem();
        String income = (String)inco.getSelectedItem();
        String education =(String)edu.getSelectedItem();
        String occupation =(String)occup.getSelectedItem();
        String seniorcitizen = null;
        if(syes.isSelected()){
            seniorcitizen= "yes";
        }else if(sno.isSelected()){
            seniorcitizen = "no";
        }

        String existingaccount = null;
        
        if(ayes.isSelected()){
            existingaccount = "yes";
        }else if(ano.isSelected()){
            existingaccount = "no";
        }
        String panno = pannotextfield.getText();
        String adharno = adharnotextfield.getText();
        

        try{
            conn c = new conn();
            String query= "insert into signuptwo values('"+formno+"','"+religion+"','"+category+"','"+income+"','"+education+"','"+occupation+"','"+seniorcitizen+"','"+existingaccount+"','"+panno+"','"+adharno+"')";
            c.s.executeUpdate(query);
            setVisible(false);
            new signupthree(formno).setVisible(true);
        }catch(Exception e){
            System.out.println(e);
        }
    }
    public static void main(String []args){
    }
}

