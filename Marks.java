
import javax.swing.*;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class Marks extends JFrame implements ActionListener{
    String rollno;
    JButton Cancel;
    Marks(String rollno){
        this.rollno=rollno;
        setSize(500,600);
        setLocation(500,100);
        setLayout(null);
        getContentPane().setBackground(Color.WHITE);


        JLabel heading = new JLabel("Aligarh Muslim Unversity");
        heading.setBounds(100, 10, 500, 25);
        heading.setFont(new Font("serif", Font.BOLD, 20));
        add(heading);

        JLabel subheading = new JLabel("Result Of Examination 2022");
        subheading.setBounds(100, 50, 500, 20);
        subheading.setFont(new Font("serif", Font.BOLD, 18));
        add(subheading);

        JLabel lblrollno= new JLabel("Roll Number"+rollno);
        lblrollno.setBounds(60, 100, 500, 20);
        lblrollno.setFont(new Font("serif", Font.PLAIN, 18));
        add(lblrollno);

        JLabel lblsemester = new JLabel();
        lblsemester.setBounds(60,130, 500, 20);
        lblsemester.setFont(new Font("serif", Font.PLAIN, 18));
        add( lblsemester);

        JLabel sub1 = new JLabel();
        sub1.setBounds(100,200, 500, 20);
        sub1.setFont(new Font("serif", Font.PLAIN, 18));
        add( sub1);

        JLabel sub2 = new JLabel();
        sub2.setBounds(100,230, 500, 20);
        sub2.setFont(new Font("serif", Font.PLAIN, 18));
        add( sub2);
        
        JLabel sub3 = new JLabel();
        sub3.setBounds(100,260, 500, 20);
        sub3.setFont(new Font("serif", Font.PLAIN, 18));
        add( sub3);
        
        JLabel sub4 = new JLabel();
        sub4.setBounds(100,290, 500, 20);
        sub4.setFont(new Font("serif", Font.PLAIN, 18));
        add( sub4);

        JLabel sub5 = new JLabel();
        sub5.setBounds(100,320, 500, 20);
        sub5.setFont(new Font("serif", Font.PLAIN, 18));
        add( sub5);


        try{
            Conn c=new Conn();
            ResultSet rs1=c.s.executeQuery ("select*from subject where rollno='"+rollno+"'");
            while(rs1.next()){
                sub1.setText(rs1.getString("subject1"));
                sub2.setText(rs1.getString("subject2"));
                sub3.setText(rs1.getString("subject3"));
                sub4.setText(rs1.getString("subject4"));
                sub5.setText(rs1.getString("subject5"));
                
            

            }
            ResultSet rs2=c.s.executeQuery ("select*from marks where rollno='"+rollno+"'");
            while(rs2.next()){
                sub1.setText(sub1.getText()+"---------"+rs2.getString("marks1"));
                sub2.setText(sub1.getText()+"---------"+rs2.getString("marks2"));
                sub3.setText(sub1.getText()+"---------"+rs2.getString("marks3"));
                sub4.setText(sub1.getText()+"---------"+rs2.getString("marks4"));
                sub5.setText(sub1.getText()+"---------"+rs2.getString("marks5"));

                lblsemester.setText("semester"+rs2.getString("semester"));





        }
    }catch(Exception e){
            e.printStackTrace();
        }
        Cancel = new JButton("Baack");
        Cancel.setBounds(250, 500, 120, 25);
        Cancel.addActionListener(this);
        Cancel.setBackground(Color.BLACK);
        Cancel.setForeground(Color.white);
        Cancel.setFont(new Font("serif", Font.BOLD, 16));
        add(Cancel);
        
        
        
        setVisible(true);
    }
     
    public void actionPerformed(ActionEvent e) {
        setVisible(false);
   
        
    }
   
    public static void main(String[] args) {
        new Marks(""); 
        
    }
    
}
