import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.*;
import java.sql.ResultSet;
import java.sql.*;

public class StudentFeeForm extends JFrame {
    Choice crollno;

    StudentFeeForm(){
        setSize(900,500);
        setLocation(300,100);
        setLayout(null);

        getContentPane().setBackground(Color.BLUE);

ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/Fourt.jpg"));
Image i2 = i1.getImage().getScaledInstance(500, 300, Image.SCALE_DEFAULT);
ImageIcon i3 = new ImageIcon(i2);
JLabel image = new JLabel(i3);
image.setBounds(400,50,500,300);
add(image);


 JLabel lblrollnumber = new JLabel("Select Roll No");
        lblrollnumber.setBounds(40, 60, 150, 16);
        lblrollnumber.setFont(new Font("tahoma", Font.BOLD, 20));
        add(lblrollnumber);

        crollno = new Choice();
        crollno.setBounds(200, 60, 150, 20);
        add(crollno);

        try {
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select * from student");
            while (rs.next()) {
                crollno.add(rs.getString("rollno"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        JLabel lblname = new JLabel("Name");
        lblname.setBounds(40, 100, 150, 20);
        lblname.setFont(new Font("Tahoma", Font.BOLD, 16));
        add(lblname);

        JLabel labelname = new JLabel();
        labelname.setBounds(2000, 100, 150,20);
        labelname.setFont(new Font("tahoma", Font.PLAIN, 16));
        add(labelname);

        JLabel lblfname = new JLabel("Father Name");
        lblfname.setBounds(40, 140, 150, 20);
        lblfname.setFont(new Font("Tahoma", Font.BOLD, 16));
        add(lblfname);

        JLabel lablfname= new JLabel();
        lablfname.setBounds(200, 140, 150,20);
        lablfname.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(lablfname);

        try {
            Conn c = new Conn();
            String query = "select * from student where rollno='" + crollno.getSelectedItem() + "'";
            ResultSet rs = c.s.executeQuery(query);
            if (rs.next()) {
                labelname.setText(rs.getString("name"));
                lablfname.setText(rs.getString("fname"));
               ;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        
    






setVisible(true);

    }
    public static void main(String[] args) {
        new StudentFeeForm();
        
    }
    
}
