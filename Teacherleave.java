

import javax.swing.*;

import com.toedter.calendar.JDateChooser;

import java.awt.*;
import java.sql.ResultSet;
import java.sql.*;
import com.toedter.calendar.JDateChooser;
import java.awt.event.*;


public class Teacherleave extends JFrame implements ActionListener {
    Choice cempId,ctime;
    JDateChooser dcdate;
    JButton Submit,Cancel;

    Teacherleave(){
    setSize(500,550);
    setLocation(550,100);
    setLayout(null);
     
    getContentPane().setBackground(Color.white);
    JLabel heading=new JLabel("Apply Leave(Teacher)");
    heading.setBounds(40,50,300,30);
    heading.setFont(new Font("Tahoma",Font.BOLD,20));
    
    add(heading);

        JLabel lblrollno=new JLabel("Search by empId Number");
        lblrollno.setBounds(60,100,200,20);
        lblrollno.setFont(new Font("Tahoma",Font.BOLD,15));
        add(lblrollno);

        cempId=new Choice();
        cempId.setBounds(60,130,200,20);
        add(cempId);

        try{
            Conn c=new Conn();
            ResultSet rs=c.s.executeQuery("select*from teacher");
            while(rs.next()){
                cempId.add(rs.getString("empId"));
           

        
        }
    }catch(Exception e){
            e.printStackTrace();
        }
        JLabel lbldate=new JLabel("Date");
        lbldate.setBounds(60,180,200,20);
        lbldate.setFont(new Font("Tahoma",Font.BOLD,15));
        add(lbldate);

        
        dcdate = new JDateChooser();
        dcdate.setBounds(60, 210, 200, 20);
        add( dcdate);

        JLabel lbltime=new JLabel("Time Duration");
        lbltime.setBounds(60,260,200,25);
        lbltime.setFont(new Font("Tahoma",Font.BOLD,15));
        add(lbltime);

        ctime=new Choice();
        ctime.setBounds(60,290,200,20);
        ctime.add("Full Day");
        ctime.add("Half Day");
        add(ctime);

        
        Submit = new JButton("Submit");
        Submit.setBounds(60, 350, 100, 25);
        Submit.addActionListener(this);
        Submit.setBackground(Color.GREEN);
        Submit.setForeground(Color.white);
        Submit.setFont(new Font("serif", Font.BOLD, 16));
        add(Submit);

        Cancel = new JButton("Cancel");
        Cancel.setBounds(200, 350, 100, 25);
        Cancel.addActionListener(this);
        Cancel.setBackground(Color.GREEN);
        Cancel.setForeground(Color.white);
        Cancel.setFont(new Font("serif", Font.BOLD, 16));
        add(Cancel);
        
            setVisible(true);
    }

    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==Submit){
            String rollno=cempId.getSelectedItem();
            String date =((JTextField)dcdate.getDateEditor().getUiComponent()).getText();
            String duration=ctime.getSelectedItem();
            String query="insert into teacherleave  values('"+rollno+"','"+date+"','"+duration+"') ";
            try{
                Conn c=new Conn();
                c.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null,"Leave Applied");
                setVisible(false);


            }catch(Exception e){

                e.printStackTrace();

            }

        }else {
            setVisible(false);
        }

    }
    public static void main(String[] args) {
        new Teacherleave();
        
    }
    
}
