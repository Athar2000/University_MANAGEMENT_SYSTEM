
import javax.swing.*;
import java.awt.*;


public class About extends JFrame {

About(){
setSize(700,500);
setLocation(400,50);
getContentPane().setBackground(Color.BLUE);

ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/First.jpg"));
Image i2 = i1.getImage().getScaledInstance(300, 200, Image.SCALE_DEFAULT);
ImageIcon i3 = new ImageIcon(i2);
JLabel image = new JLabel(i3);
image.setBounds(350,0,300,200);
add(image);


JLabel heading = new JLabel("<html>Aligarh<br/>Muslim University</html>");
heading.setBounds(70, 20, 250, 130);
heading.setFont(new Font("serif", Font.BOLD, 30));
add(heading);

JLabel name = new JLabel("Devoloped BY Nimrah Shakeel");
name.setBounds(70, 220, 400, 40);
name.setFont(new Font("serif", Font.BOLD, 30));
add(name);


JLabel RollNo = new JLabel("22CAMSA106");
RollNo .setBounds(70, 280, 550, 40);
RollNo .setFont(new Font("serif", Font.BOLD, 30));
add(RollNo );

JLabel email = new JLabel("Contact:mohdathar786lucknow@gmail.com");
email .setBounds(70, 320, 550, 40);
email .setFont(new Font("serif", Font.BOLD, 20));
add(email );



setLayout(null);
setVisible(true);


    }
    public static void main(String[] args) {
        new About();
        
    }
    
}
