import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.Color;
import java.awt.event.*;
import java.util.*;
import java.awt.GridLayout;
@SuppressWarnings("serial")

public class   RegistrationForm extends JFrame implements ActionListener{     
JLabel title, FirstnameLabel,  LastnameLabel, genderLabel, emailLabel, DepartmentLabel;               
JTextField FirstnameField, LastnameField, genderField, emailField, DepartmentField;             
JButton registerButton, exitButton;               
JRadioButton male, female;           
ButtonGroup bg;              
JPanel panel;               
List<User> list = new ArrayList<User>();               
JTable table;                
String gender = "";                
// Returns a column class of Object               
DefaultTableModel model;               
JScrollPane scrollpane;               
Object[][] data;               
// Defining Constructor               
RegistrationForm() {                               
setSize(700, 360);                               
setLayout(null);                              
  //Defining Labels                               
title = new JLabel("Student Registration Form");                                
title.setBounds(60, 7, 200,50);
FirstnameLabel = new JLabel("FirstName");
FirstnameLabel.setBounds(30, 50, 60, 30);                                
LastnameLabel = new JLabel("LastName");                                
LastnameLabel.setBounds(30, 85, 60, 30);
  genderLabel =new JLabel("Gender");                               
genderLabel.setBounds(30, 120, 60, 30);                                
emailLabel = new JLabel("Email");                                
emailLabel.setBounds(30, 155, 60, 30);                                
DepartmentLabel = new JLabel("Dept");                               
DepartmentLabel.setBounds(30, 190, 60, 30);                               
// Defining Name field                                
FirstnameField = new JTextField();                                
FirstnameField.setBounds(95, 50, 100, 30);                               
             
// Defining Name field                                
LastnameField = new JTextField();                                
LastnameField.setBounds(95, 85, 100, 30);

  // Defining Gender Buttons
 male = new JRadioButton("Male");                          
male.setBounds(95, 120, 60, 30);                             
male.addActionListener(new ActionListener() {

  public void actionPerformed(ActionEvent e) {
     gender= "Male";
  }

   });

    female = new  JRadioButton("Female");
 female.setBounds(155,120, 70, 30);                       

female.addActionListener(new ActionListener() {
   public void actionPerformed(ActionEvent e) {
      gender ="Female";
            }

         });
 bg = new ButtonGroup();
       bg.add(male);
      bg.add(female);
     emailField = new JTextField();
    emailField.setBounds(95, 155, 100, 30);
 DepartmentField = new JTextField();  
DepartmentField.setBounds(95, 190, 100, 30);         

    //Defining Exit Button
     exitButton = new JButton("Exit");                          
exitButton.setBounds(25, 230, 80, 30);                         
exitButton.addActionListener(this);
    //Defining Register Button
   registerButton = new JButton("Register");      
registerButton.setBounds(110, 230, 100, 30);                      
registerButton.addActionListener(this);
    // fixing all Label,TextField,Button 
       add(title);
       add(FirstnameLabel);
      add(LastnameLabel);
     add(genderLabel);
     add(emailLabel);
      add(DepartmentLabel);
       add(FirstnameField);
       add(LastnameField);
        add(male);
        add(female);
       add(emailField);
      add(DepartmentField);
     add(exitButton);
    add(registerButton);
      //Defining Panel
     panel =new JPanel();
     panel.setLayout(new GridLayout());
     panel.setBounds(250,10, 400, 300);                         
panel.setBorder(BorderFactory.createDashedBorder(Color.blue));
    add(panel);
     // Defining Model for table 
      model = new DefaultTableModel();
        table = new JTable(model);                          
       table.setEnabled(false);
   // Defining Column Names on model 
         model.addColumn("FirstName");                         
        model.addColumn("LastName");                         
        model.addColumn("Gender");                        
        model.addColumn("Email");
         model.addColumn("Department"); 
    // Enable Scrolling on table
      scrollpane = new JScrollPane(table,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,                                                       

JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);panel.add(scrollpane);                       
panel.setEnabled(false);                         
setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
       setResizable(false); 
       setVisible(true);

            }

    public void actionPerformed(ActionEvent ae) {

    if(ae.getSource() == exitButton) {
   System.exit(0); 

            }

    if(ae.getSource() ==registerButton) {                        

if(FirstnameField.getText().equals("") || LastnameField.getText().equals("") ||                           
emailField.getText().equals("")|| DepartmentField.getText().equals("")||                              
gender.equals(""))JOptionPane.showMessageDialog(FirstnameField,  "Fields will not be blank"); 

         else{
     //Storing records in List 
      list.add(new User(FirstnameField.getText(), LastnameField.getText(), gender,                                                   
emailField.getText(), DepartmentField.getText())); 
       addRows();
       // using for DialogBox
        JOptionPane.showMessageDialog(this,"Successfully Registered");                                    
       FirstnameField.setText("");                                     
     LastnameField.setText("");
       gender ="";                            
bg.clearSelection();                                 
emailField.setText("");                                    
DepartmentField.setText("");

      } 

           } 
        }
    //Adding records in List

      public void addRows() { 
         Object[] row =null;
     User str = list.get(list.size()- 1); 
      String string =str.uFirstname + "," + str.uLastname + "," + str.gender +"," + str.uEmail + "," +                                                  
str.uDepartment;

             row =string.split(",");
       //Adding records in table model                           
model.addRow(row);                             
panel.revalidate(); 

       }

        public static void main(String[] args) { 
           new RegistrationForm(); 

      }
}