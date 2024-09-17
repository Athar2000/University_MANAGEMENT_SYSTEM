import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;

public class Updatestudent extends JFrame implements ActionListener {
    JTextField tfcourse, tfaddress, tfphone, tfemail, tfaadhar, tfbranch;
    JLabel labelrollno, labelname, labelfname, labeldob, labelx, lblxii;
    JButton Submit, Cancel;
    Choice crollno;
    private JLabel labalxii;

    Updatestudent() {
        setSize(900, 650);
        setLocation(350, 50);
        setLayout(null);

        JLabel heading = new JLabel("Update Student Details");
        heading.setBounds(50, 10, 500, 50);
        heading.setFont(new Font("serif", Font.BOLD, 35));
        add(heading);

        JLabel lblrollnumber = new JLabel("Select Roll Number");
        lblrollnumber.setBounds(50, 100, 200, 20);
        lblrollnumber.setFont(new Font("serif", Font.BOLD, 20));
        add(lblrollnumber);

        crollno = new Choice();
        crollno.setBounds(250, 100, 200, 20);
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

        crollno.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent ie) {
                try {
                    Conn c = new Conn();
                    String query = "select * from student where rollno='" + crollno.getSelectedItem() + "'";
                    ResultSet rs = c.s.executeQuery(query);
                    if (rs.next()) {
                        labelname.setText(rs.getString("name"));
                        labelfname.setText(rs.getString("fname"));
                        labelrollno.setText(rs.getString("rollno"));
                        labeldob.setText(rs.getString("dob"));
                        tfaddress.setText(rs.getString("address"));
                        tfphone.setText(rs.getString("phone"));
                        tfemail.setText(rs.getString("email"));
                        labelx.setText(rs.getString("class_x"));
                        labalxii.setText(rs.getString("class_xii"));
                        tfaadhar.setText(rs.getString("aadhar"));
                        tfcourse.setText(rs.getString("course"));
                        tfbranch.setText(rs.getString("branch"));
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });

        JLabel lblname = new JLabel("Name");
        lblname.setBounds(50, 150, 100, 30);
        lblname.setFont(new Font("serif", Font.BOLD, 20));
        add(lblname);

        labelname = new JLabel();
        labelname.setBounds(200, 150, 150,30);
        labelname.setFont(new Font("serif", Font.BOLD, 20));
        add(labelname);

        JLabel lblfname = new JLabel("Father Name");
        lblfname.setBounds(400, 150, 200, 30);
        lblfname.setFont(new Font("serif", Font.BOLD, 20));
        add(lblfname);

        labelfname = new JLabel();
        labelfname.setBounds(600, 150, 150, 30);
        labelfname.setFont(new Font("serif", Font.BOLD, 20));
        add(labelfname);

        JLabel lblrollno = new JLabel("Roll No");
        lblrollno.setBounds(50, 200, 200, 30);
        lblrollno.setFont(new Font("serif", Font.BOLD, 20));
        add(lblrollno);

        labelrollno = new JLabel();
        labelrollno.setBounds(200, 200, 200, 30);
        labelrollno.setFont(new Font("serif", Font.BOLD, 20));
        add(labelrollno);

        JLabel lbldob = new JLabel("Date Of Birth");
        lbldob.setBounds(400, 200, 200, 30);
        lbldob.setFont(new Font("serif", Font.BOLD, 20));
        add(lbldob);

        labeldob = new JLabel();
        labeldob.setBounds(600, 200, 150, 30);
        add(labeldob);

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

        labelx = new JLabel();
        labelx.setBounds(600, 300, 150, 30);
        add(labelx);

        JLabel lblxii = new JLabel("Class XII (%)");
        lblxii.setBounds(50, 350, 200, 30);
        lblxii.setFont(new Font("serif", Font.BOLD, 20));
        add(lblxii);

        labalxii = new JLabel();
        labalxii.setBounds(200, 350, 150, 30);
        add( labalxii);

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

        tfcourse = new JTextField();
        tfcourse.setBounds(200, 400, 150, 30);
        add(tfcourse);

        JLabel lblbranch = new JLabel("Branch");
        lblbranch.setBounds(400, 400, 200, 30);
        lblbranch.setFont(new Font("serif", Font.BOLD, 20));
        add(lblbranch);

        tfbranch = new JTextField();
        tfbranch.setBounds(600, 400, 150, 30);
        add(tfbranch);

        Submit = new JButton("Update");
        Submit.setBounds(250, 500, 120, 30);
        Submit.addActionListener(this);
        Submit.setBackground(Color.BLACK);
        Submit.setForeground(Color.white);
        Submit.setFont(new Font("serif", Font.BOLD, 16));
        add(Submit);

        Cancel = new JButton("Cancel");
        Cancel.setBounds(450, 500, 120, 30);
        Cancel.addActionListener(this);
        Cancel.setBackground(Color.BLACK);
        Cancel.setForeground(Color.white);
        Cancel.setFont(new Font("serif", Font.BOLD, 16));
        add(Cancel);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == Submit) {
            String rollno = crollno.getSelectedItem();
            String address = tfaddress.getText();
            String phone = tfphone.getText();
            String email = tfemail.getText();
            String aadhar = tfaadhar.getText();
            String course = tfcourse.getText();
            String branch = tfbranch.getText();

            try {
                String query = "update student set address='" + address + "', phone='" + phone + "', email='" + email + "', aadhar='" + aadhar + "', course='" + course + "', branch='" + branch + "' where rollno='" + rollno + "'";
                Conn c = new Conn();
                c.s.executeUpdate(query);

                JOptionPane.showMessageDialog(null, "Student Details Updated Successfully");
                setVisible(false);
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            setVisible(false);
        }
    }

    public static void main(String[] args) {
        new Updatestudent();
    }
}
