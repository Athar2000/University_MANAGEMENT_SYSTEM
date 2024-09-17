import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;
import net.proteanit.sql.DbUtils;
public class ExaminationResuls extends JFrame implements ActionListener {
    JTextField search;
    JButton Submit ,Cancel;
    JTable table;
    ExaminationResuls(){

        setSize(1000,475);
        setLocation(300,100);
        setVisible(true);

        setLayout(null);
        getContentPane().setBackground(Color.white);

        JLabel heading = new JLabel(" Check Result");
        heading.setBounds(80, 15, 400, 50);
        heading.setFont(new Font("serif", Font.BOLD, 24));
        add(heading);

        search=new JTextField();
        search.setBounds(80,90,200,30);
        search.setFont(new Font("Tehoma",Font.PLAIN,18));
        add(search);

        Submit = new JButton("Result");
        Submit.setBounds(300, 90, 120, 30);
        Submit.addActionListener(this);
        Submit.setBackground(Color.BLACK);
        Submit.setForeground(Color.white);
        Submit.setFont(new Font("serif", Font.BOLD, 16));
        add(Submit);

        Cancel = new JButton("Back");
        Cancel.setBounds(250, 500, 120, 25);
        Cancel.addActionListener(this);
        Cancel.setBackground(Color.BLACK);
        Cancel.setForeground(Color.white);
        Cancel.setFont(new Font("serif", Font.BOLD, 16));
        add(Cancel);


        table =new JTable();
        table.setFont(new Font("Tahoma",Font.PLAIN,16));
        
        
        JScrollPane jsp=new JScrollPane(table);
        jsp.setBounds(0,130,1000,310);
        add(jsp);

        try{
            Conn c=new Conn();
            
            ResultSet rs=c.s.executeQuery("select * from student");
            table.setModel(DbUtils.resultSetToTableModel(rs));

        }catch(Exception e){
            e.printStackTrace();
        }


        table.addMouseListener(new MouseAdapter()  {
        public void mouseClicked(MouseEvent me) {
        int row =table.getSelectedRow();
        search.setText(table.getModel().getValueAt(row,2).toString());
        }

        });
        setVisible(true);
 }
 public void actionPerformed(ActionEvent ae) {
    if(ae.getSource()==Submit){
         setVisible(false);
         
        new Marks(search.getText());
        

    }else{
        setVisible(false);
    }
}
public static void main(String[] args) {
        new ExaminationResuls();
        
    }
    
}