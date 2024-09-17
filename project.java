import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class project extends JFrame implements ActionListener {

    project() {
        setSize(1540, 850);
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/AMU.jpg"));
        Image i2 = i1.getImage().getScaledInstance(1550, 760, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        add(image);

        JMenuBar mb = new JMenuBar();
                        /// New Information

        JMenu newInformation = new JMenu("New_Information");
        newInformation.setForeground(Color.BLUE);
        Font menuFont = new Font("Arial", Font.BOLD, 27); // Change the size (20) as needed
        newInformation.setFont(menuFont);
        mb.add(newInformation);

        JMenuItem facultyInfo = new JMenuItem("New faculty Information");
        facultyInfo.setBackground(Color.white);
        facultyInfo.addActionListener(this);
        newInformation.add(facultyInfo);

        JMenuItem studentInfo = new JMenuItem("New Student Information");
        studentInfo.setBackground(Color.white);
        studentInfo.addActionListener(this);
        newInformation.add(studentInfo);

                    
                       /// Details

        JMenu details = new JMenu("View_Details");
        details.setForeground(Color.DARK_GRAY);
        Font menuDetails = new Font("Arial", Font.ITALIC, 27); // Change the size (20) as needed
        details.setFont(menuDetails);
        mb.add(details);

        JMenuItem facultyDetails = new JMenuItem("View faculty Details");
        facultyDetails.setBackground(Color.white);
        facultyDetails.addActionListener(this);
        details.add(facultyDetails);

        JMenuItem studentDetails = new JMenuItem("View Student Details");
        studentDetails.setBackground(Color.white);
        studentDetails.addActionListener(this);
        details.add(studentDetails);

              // leaves
        JMenu event = new JMenu("Apply_leave");
        event.setForeground(Color.GREEN);
        Font menuEvent = new Font("Arial", Font.BOLD, 27); // Change the size (20) as needed
        event.setFont(menuEvent);
        mb.add(event);

        JMenuItem lastEvent = new JMenuItem("Faculty leave");
        lastEvent.setBackground(Color.white);
        lastEvent.addActionListener(this);
        event.add(lastEvent);

        JMenuItem ongoingEvent = new JMenuItem("Student Leave");
        ongoingEvent.setBackground(Color.white);
        ongoingEvent.addActionListener(this);
        event.add(ongoingEvent);

              //leaves details
        JMenu eventDetails = new JMenu("Leave_Details");
        eventDetails.setForeground(Color.PINK);
        Font menuEventDetails = new Font("Arial", Font.ITALIC, 25); // Change the size (20) as needed
        eventDetails.setFont(menuEventDetails);
        mb.add(eventDetails);

        JMenuItem lastEvents = new JMenuItem("Faculty Leave Details");
        lastEvents.setBackground(Color.white);
        lastEvents.addActionListener(this);
        eventDetails.add(lastEvents);

        JMenuItem budget = new JMenuItem("Student Leave Details");
        budget.setBackground(Color.white);
        budget .addActionListener(this);
        eventDetails.add(budget);

        // Achievement
        JMenu achievement = new JMenu("Fee_Structure");
        achievement.setForeground(Color.MAGENTA);
        Font menuAchievement = new Font("Arial", Font.BOLD, 27); // Change the size (20) as needed
        achievement.setFont(menuAchievement);
        mb.add(achievement);

        JMenuItem ourAlumni = new JMenuItem("Student Fee");
        ourAlumni.setBackground(Color.white);
        ourAlumni .addActionListener(this);
        achievement.add(ourAlumni);

        JMenuItem ourAchievement = new JMenuItem("Our Achievement");
        ourAchievement.setBackground(Color.white);
        achievement.add(ourAchievement);

                       // Update information
        JMenu updateInfo = new JMenu("Update_Details");
        updateInfo.setForeground(Color.RED);
        Font menuUpdateInfo = new Font("Arial", Font.ITALIC, 27); // Change the size (20) as needed
        updateInfo.setFont(menuUpdateInfo);
        mb.add(updateInfo);

        JMenuItem updateFacultyInfo = new JMenuItem("Update Faculty Info");
        updateFacultyInfo.setBackground(Color.white);
        updateFacultyInfo.addActionListener(this);
        updateInfo.add(updateFacultyInfo);

        JMenuItem updateStudentInfo = new JMenuItem("Update Student Info");
        updateStudentInfo.setBackground(Color.white);
        updateStudentInfo.addActionListener(this);
        updateInfo.add(updateStudentInfo);

                    // Examination
        JMenu fundraising = new JMenu("Examination");
        fundraising.setForeground(Color.ORANGE);
        Font menuFundraising = new Font("Arial", Font.BOLD,27); // Change the size (20) as needed
        fundraising.setFont(menuFundraising);
        mb.add(fundraising);

        JMenuItem fundStructure = new JMenuItem("Examination Result");
        fundStructure.setBackground(Color.white);
        fundStructure.addActionListener(this);
        fundraising.add(fundStructure);

        JMenuItem fundForm = new JMenuItem("Enter marks");
        fundForm.setBackground(Color.white);
        fundForm.addActionListener(this);
        fundraising.add(fundForm);

                          // Utility
        JMenu utility = new JMenu("Utility");
        utility.setForeground(Color.GRAY);
        Font menuUtility = new Font("Arial", Font.ITALIC, 27); // Change the size (20) as needed
        utility.setFont(menuUtility);
        mb.add(utility);

        JMenuItem notepad = new JMenuItem("Notepad");
        notepad.setBackground(Color.white);
        notepad.addActionListener(this);
        utility.add(notepad);

        JMenuItem calc = new JMenuItem("Calculator");
        calc.setBackground(Color.white);
        calc.addActionListener(this);
        utility.add(calc);

         // Exit
         JMenu exit = new JMenu("Exit");
         exit.setForeground(Color.BLUE);
         Font newExit = new Font("Arial", Font.BOLD, 27); // Change the size (20) as needed
         exit.setFont(newExit);
         mb.add(exit);
 
         JMenuItem ex = new JMenuItem("Bahar");
         ex.setBackground(Color.white);
         ex.addActionListener(this);
         exit.add(ex);

        // ABout
        JMenu About = new JMenu("About");
        About.setForeground(Color.BLUE);
        Font newAbout = new Font("Arial", Font.ITALIC, 27); // Change the size (20) as needed
        About.setFont(newAbout);
        mb.add(About);

        JMenuItem ab = new JMenuItem("About");
        ab.setBackground(Color.white);
        ab.addActionListener(this);
        About.add(ab);

        setJMenuBar(mb);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    public void actionPerformed(ActionEvent ae) {
        String msg = ae.getActionCommand();
        if (msg.equals("Bahar")) {
            setVisible(false);
        } else if (msg.equals("Calculator")) {
            try {
                Runtime.getRuntime().exec("calc.exe");
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else if (msg.equals("Notepad")) {
            try {
                Runtime.getRuntime().exec("notepad.exe");
            } catch (Exception e) {
                
            }
            

            }
            else if (msg.equals("New faculty Information")){
                new AddTeacher();
            }
                else if(msg.equals("New Student Information")){
                    new AddStudent();
                
        
        }
        else if(msg.equals("View faculty Details")){
            new TeacherDetail();
        

}
else if(msg.equals("View faculty Details")){
    new StudentDetails();


}
        else if(msg.equals("View Student Details")){
            new Teacherleave();
        

    }
    else if(msg.equals("Student Leave")){
        new StudentLeave();
    }
    else if(msg.equals("Faculty leave")){
        new  Teacherleave();
    }
    else if(msg.equals("Faculty Leave Details")){
        new  TeacherLeaveDetail();
    }

    
    else if(msg.equals("Faculty Leave Details")){
        new  TeacherLeaveDetail();
    }
    else if(msg.equals("Student Leave Details")){
        new StudentLeaveDetail();
    }
    else if(msg.equals("Update Faculty Info")){
        new  Updateteacher();
    }
    else if(msg.equals("Update Student Info")){
        new  Updatestudent();
    }
    else if(msg.equals("Enter marks")){
        new  EnterMark();
    }
    else if(msg.equals("Examination Result")){
        new  ExaminationResuls();
    }
    else if(msg.equals("Student Fee")){
        new  FeeStructur();
    }
    else if(msg.equals("About")){
        new  About();
    }


    
}

    public static void main(String[] args) {
        new project();
    }
}


