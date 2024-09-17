import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;

public class Updateteacher extends JFrame implements ActionListener {
    
    JTextField tfcourse, tfaddress, tfphone, tfemail, tfaadhar, tfbranch;
    JLabel labelrollno, labelname, labelfname, labeldob, labelx, lblxii, labelEmpId ;
    JButton Submit, Cancel;
    Choice cEmpId;
    private JLabel labalxii;

    Updateteacher() {
        setSize(900, 650);
        setLocation(350, 50);
        setLayout(null);

        JLabel heading = new JLabel("Update Teacher Details");
        heading.setBounds(50, 10, 500, 50);
        heading.setFont(new Font("serif", Font.BOLD, 35));
        add(heading);

        JLabel lblrollnumber = new JLabel("Select Employee Number");
        lblrollnumber.setBounds(50, 100, 200, 20);
        lblrollnumber.setFont(new Font("serif", Font.BOLD, 20));
        add(lblrollnumber);

        cEmpId = new Choice();
        cEmpId .setBounds(250, 100, 200, 20);
        add( cEmpId );

        try {
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select * from teacher");
            while (rs.next()) {
              cEmpId.add(rs.getString("EmpId"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        cEmpId.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent ie) {
                try {
                    Conn c = new Conn();
                    String query = "select * from teacher where empId='" + cEmpId.getSelectedItem() + "'";
                    ResultSet rs = c.s.executeQuery(query);
                    if (rs.next()) {
                        labelname.setText(rs.getString("name"));
                        labelfname.setText(rs.getString("fname"));
                        labelEmpId.setText(rs.getString("empId"));
                        labeldob.setText(rs.getString("dob"));
                        tfaddress.setText(rs.getString("address"));
                        tfphone.setText(rs.getString("phone"));
                        tfemail.setText(rs.getString("email"));
                        labelx.setText(rs.getString("class_x"));
                        labalxii.setText(rs.getString("class_xii"));
                        tfaadhar.setText(rs.getString("aadhar"));
                        tfcourse.setText(rs.getString("Higher_Education"));
                        tfbranch.setText(rs.getString("Deparment"));
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

        JLabel lblrollno = new JLabel("EmpId");
        lblrollno.setBounds(50, 200, 200, 30);
        lblrollno.setFont(new Font("serif", Font.BOLD, 20));
        add(lblrollno);

        labelEmpId = new JLabel();
        labelEmpId .setBounds(200, 200, 200, 30);
        labelEmpId .setFont(new Font("serif", Font.BOLD, 20));
        add( labelEmpId );

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

        JLabel lblaadhar = new JLabel("Education");
        lblaadhar.setBounds(400, 350, 200, 30);
        lblaadhar.setFont(new Font("serif", Font.BOLD, 20));
        add(lblaadhar);

        tfaadhar = new JTextField();
        tfaadhar.setBounds(600, 350, 150, 30);
        add(tfaadhar);

        JLabel lblcourse = new JLabel("Departmnet");
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
            String rollno = cEmpId.getSelectedItem();
            String address = tfaddress.getText();
            String phone = tfphone.getText();
            String email = tfemail.getText();
            String aadhar = tfaadhar.getText();
            String course = tfcourse.getText();
            String branch = tfbranch.getText();

            try {
                String tfcourse;
                String query = "update student set address='" + address + "', phone='" + phone + "', email='" + email + "', aadhar='" + aadhar + "', education='" + Higher_Education+ "', branch='" +Deparment + "' where rollno='" + rollno + "'";
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
        new Updateteacher();
    }
}
