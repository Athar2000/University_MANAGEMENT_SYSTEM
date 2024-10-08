
import javax.swing.*;
import com.toedter.calendar.JDateChooser;
import java.awt.*;
import java.awt.event.*;
import java.util.Random;

public class AddStudent extends JFrame implements ActionListener {
    JTextField tfname, tffname, tfaddress, tfphone, tfemail, tfx, tfxii, tfaadhar;
    JLabel labelRollNo;
    JDateChooser dcdob;
    JComboBox<String> cbcourse, cbbranch;
    JButton Submit, Cancel;
    Random ran = new Random();
    Long first4 = Math.abs((ran.nextLong() % 9000L) + 1000L);

    AddStudent() {
        setSize(900, 700);
        setLocation(350, 50);
        setLayout(null);
        
        JLabel heading = new JLabel("New Student Details");
        heading.setBounds(320, 30, 500, 50);
        heading.setFont(new Font("serif", Font.BOLD, 30));
        add(heading);

        JLabel lblname = new JLabel("Name");
        lblname.setBounds(50, 150, 100, 30);
        lblname.setFont(new Font("serif", Font.BOLD, 20));
        add(lblname);

        tfname = new JTextField();
        tfname.setBounds(200, 150, 150, 30);
        add(tfname);

        JLabel lblfname = new JLabel("Father Name");
        lblfname.setBounds(400, 150, 200, 30);
        lblfname.setFont(new Font("serif", Font.BOLD, 20));
        add(lblfname);

        tffname = new JTextField();
        tffname.setBounds(600, 150, 150, 30);
        add(tffname);

        JLabel lblrollno = new JLabel("Roll No");
        lblrollno.setBounds(50, 200, 200, 30);
        lblrollno.setFont(new Font("serif", Font.BOLD, 20));
        add(lblrollno);

        labelRollNo = new JLabel("2345" + first4);
        labelRollNo.setBounds(200, 200, 200, 30);
        labelRollNo.setFont(new Font("serif", Font.BOLD, 20));
        add(labelRollNo);

        JLabel lbldob = new JLabel("Date Of Birth");
        lbldob.setBounds(400, 200, 200, 30);
        lbldob.setFont(new Font("serif", Font.BOLD, 20));
        add(lbldob);

        dcdob = new JDateChooser();
        dcdob.setBounds(600, 200, 150, 30);
        add(dcdob);

        JLabel lbladdress = new JLabel("Address");
        lbladdress.setBounds(50, 250, 200, 30);
        lbladdress.setFont(new Font("serif", Font.BOLD, 20));
        add(lbladdress);

        tfaddress = new JTextField();
        tfaddress.setBounds(200, 250, 150, 30);
        add(tfaddress);

        JLabel lblphone = new JLabel("Phone");
        lblphone.setBounds(400, 250, 200, 30);
        lblphone.setFont(new Font("serif", Font.BOLD, 20));
        add(lblphone);

        tfphone = new JTextField();
        tfphone.setBounds(600, 250, 150, 30);
        add(tfphone);

        JLabel lblemail = new JLabel("Email Id");
        lblemail.setBounds(50, 300, 300, 30);
        lblemail.setFont(new Font("serif", Font.BOLD, 20));
        add(lblemail);

        tfemail = new JTextField();
        tfemail.setBounds(200, 300, 150, 30);
        add(tfemail);

        JLabel lblx = new JLabel("Class X (%)");
        lblx.setBounds(400, 300, 200, 30);
        lblx.setFont(new Font("serif", Font.BOLD, 20));
        add(lblx);

        tfx = new JTextField();
        tfx.setBounds(600, 300, 150, 30);
        add(tfx);

        JLabel lblxii = new JLabel("Class XII (%)");
        lblxii.setBounds(50, 350, 200, 30);
        lblxii.setFont(new Font("serif", Font.BOLD, 20));
        add(lblxii);

        tfxii = new JTextField();
        tfxii.setBounds(200, 350, 150, 30);
        add(tfxii);

        JLabel lblaadhar = new JLabel("Aadhar Number");
        lblaadhar.setBounds(400, 350, 200, 30);
        lblaadhar.setFont(new Font("serif", Font.BOLD, 20));
        add(lblaadhar);

        tfaadhar = new JTextField();
        tfaadhar.setBounds(600, 350, 150, 30);
        add(tfaadhar);

        JLabel lblcourse = new JLabel("Course");
        lblcourse.setBounds(50, 400, 200, 30);
        lblcourse.setFont(new Font("serif", Font.BOLD, 20));
        add(lblcourse);

        String[] courses = {"B.Tech", "BBA", "BCA", "BA(hons)", "B.Sc(hons)", "LLB", "MBA", "MCA", "Berojgar"};
        cbcourse = new JComboBox<>(courses);
        cbcourse.setBounds(200, 400, 150, 30);
        add(cbcourse);

        JLabel lblbranch = new JLabel("Branch");
        lblbranch.setBounds(400, 400, 200, 30);
        lblbranch.setFont(new Font("serif", Font.BOLD, 20));
        add(lblbranch);

        String[] branches = {"CS", "Electronics", "Mechanical", "Civil", "Electrical", "Physics", "Chemistry", "Commerce", "Math", "Urdu", "Berojgar"};
        cbbranch = new JComboBox<>(branches);
        cbbranch.setBounds(600, 400, 150, 30);
        add(cbbranch);

        Submit = new JButton("Submit");
        Submit.setBounds(250, 550, 120, 30);
        Submit.addActionListener(this);
        Submit.setBackground(Color.BLACK);
        Submit.setForeground(Color.BLACK);
        Submit.setFont(new Font("serif", Font.BOLD, 16));
        add(Submit);

        Cancel = new JButton("Cancel");
        Cancel.setBounds(450, 550, 120, 30);
        Cancel.addActionListener(this);
        Cancel.setBackground(Color.BLACK);
        Cancel.setForeground(Color.BLACK);
        Cancel.setFont(new Font("serif", Font.BOLD, 16));
        add(Cancel);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == Submit) {
            String name = tfname.getText();
            String fname = tffname.getText();
            String rollno = labelRollNo.getText();
            String dob = ((JTextField) dcdob.getDateEditor().getUiComponent()).getText();
            String address = tfaddress.getText();
            String phone = tfphone.getText();
            String email = tfemail.getText();
            String x = tfx.getText();
            String xii = tfxii.getText();
            String aadhar = tfaadhar.getText();
            String course = (String) cbcourse.getSelectedItem();
            String branch = (String) cbbranch.getSelectedItem();

            try {
                String query = "insert into student values('" + name + "','" + fname + "','" + rollno + "','" + dob + "','" + address + "','" + phone + "','" + email + "','" + x + "','" + xii + "','" + aadhar + "','" + course + "','" + branch + "')";

                Conn c = new Conn();
                c.s.executeUpdate(query);

                JOptionPane.showMessageDialog(null, "Student Details Inserted Successfully");
                setVisible(false);
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            setVisible(false);
        }
    }

    public static void main(String[] args) {
        new AddStudent();
    }
}
