import java.sql.*;
import java.lang.Thread;
import java.awt.event.*; 
import javax.swing.*;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.*;
import java.io.Console;
import javax.swing.table.*;  
import javax.swing.table.DefaultTableModel;
public class Teacher extends JFrame {  
    private Connection conn;
public DefaultTableModel model;
    public JTable table;
    public ResultSet rs;
    public Statement stmt;
    JFrame f; //declaration
    JLabel id,l1;
    JButton b;

    public Teacher() throws SQLException {
        String url = "jdbc:mysql://localhost:3306/externalmanagement";
        String username = "root";
        String password = "Sanket_@#$123";
        conn = DriverManager.getConnection(url, username, password);
        TeacherData();
    }
    public void Front(){
        JFrame frame=new JFrame();
        JPanel panel=new JPanel();
        JPanel panel2=new JPanel();
        
        JLabel title=new JLabel("External Management System");
        panel2.add(title);
        Font font=new Font("Arial",Font.BOLD,20);
        title.setFont(font);
        //panel2.setBackground();
        panel2.setBounds(600,65,300,60);
        panel2.setVisible(true);
        frame.add(panel2);
        JButton Clickhere = new JButton("Click here to Continue..");
        Clickhere.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
                Login();
            }
        });
         panel.add(Clickhere);
         panel.setBackground(Color.BLACK);
         panel.setBounds(650,600,200,50);
         panel.setVisible(true);
    
         frame.add(panel);
         

        JLabel imageLabel = new JLabel(new ImageIcon("D:/second year 4th sem/OOP/course project/front.jpg"));
        
        // Add the imageLabel to the JFrame
        //frame.add(imageLabel1);
       frame.add(imageLabel);
        
        // Set the size of the JFrame
        frame.setSize(1500, 1500);
        
        // Set the JFrame to be visible
        frame.setVisible(true);
        

frame.setVisible(true);


        
    }
    public void Login()
    {
        JDialog dialog = new JDialog(this, "Login Here..", true);
        // JPanel image=new JPanel();
        // JLabel imageLabel1 = new JLabel(new ImageIcon("D:/second year 4th sem/OOP/course project/image4.jpg"));
        // image.add(imageLabel1);
        // image.setSize(500,550);
        // dialog.add(image);
            JPanel detail=new JPanel();
            JLabel title1=new JLabel("Enter Login Detail....");
            title1.setBounds(80,20,200,30);
            Font font=new Font("Arial",Font.BOLD,20);
        title1.setFont(font);
            dialog.add(title1);
            detail.setBounds(100,80,280,300);
            detail.setBackground(Color.LIGHT_GRAY);
            detail.setBorder(new EmptyBorder(5, 5, 5, 5));
            dialog.add(detail);
            dialog.setSize(500, 550);
            dialog.setLayout(null);
            detail.setLayout(new GridLayout(9, 2));
            detail.add(new JLabel("         "));
        detail.add(new JLabel("         "));
        detail.add(new JLabel("         "));
        detail.add(new JLabel("         "));
        detail.add(new JLabel("                  User:"));
        JTextField UserField = new JTextField();
        detail.add(UserField);
        detail.add(new JLabel("         "));
        detail.add(new JLabel("         "));
        detail.add(new JLabel("           Password:"));
        JTextField PasswordField = new JTextField();
        detail.add(PasswordField);
        
        detail.add(new JLabel("         "));
        detail.add(new JLabel("         "));
        detail.add(new JLabel("         "));
        detail.add(new JLabel("         "));
            JButton addButton = new JButton("Add");
            addButton.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    try {
                        PreparedStatement stmt = conn.prepareStatement("INSERT INTO Login (user,password) VALUES (?, ?)");
                        stmt.setString(1, UserField.getText());
                        stmt.setString(2, PasswordField.getText());
                       
                        stmt.executeUpdate();
                        JOptionPane.showMessageDialog(dialog,"User added successfully...");
                        dialog.dispose();
                        initUI();
                        
                    } catch (SQLException ex) {
                        ex.printStackTrace();
                        JOptionPane.showMessageDialog(dialog, "Error adding data.");
                    } catch (NumberFormatException ex) {
                        JOptionPane.showMessageDialog(dialog, "Invalid age.");
                    }
                }
            });
            detail.add(addButton);
            JButton cancelButton = new JButton("Cancel");
            cancelButton.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    dialog.dispose();
                }
            });
            detail.add(cancelButton);
            detail.add(new JLabel("         "));
        detail.add(new JLabel("         "));
            dialog.setVisible(true);
        } 
    
         

    
     public void initUI()  
        {  
        JFrame frame= new JFrame("External Management System");    
        JPanel panel=new JPanel(); 
        JPanel panel2=new JPanel(); 
        Container big=frame.getContentPane();
        big.setBackground(Color.GRAY);
        panel2.setBounds(200,40,300,50);
        panel2.setBackground(Color.CYAN);
       
        JLabel title=new JLabel("External Management System");
        panel2.add(title);
        Font font=new Font("Arial",Font.BOLD,20);
        title.setFont(font);
        panel.setBounds(200,130,300,300);    
        panel.setBackground(Color.BLACK);  
        panel.setBorder(new EmptyBorder(90, 2, 2, 2));
      JPanel layout = new JPanel(new GridBagLayout());
      layout.setBorder(new EmptyBorder(5, 5, 5, 5));
      JPanel btnPanel = new JPanel(new GridLayout(2, 1, 10, 25));
      btnPanel.setBounds(200,250,250,200);
      JButton addButton = new JButton("External Data");
        addButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                ExternalData();
            }
        });
         btnPanel.add(addButton);
         JButton addButton2 = new JButton("Teacher Data");
        addButton2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                TeacherData();
            }
        });
         btnPanel.add(addButton2);
      //btnPanel.add(new JButton("Teacher Data"));
      layout.add(btnPanel);
      panel.add(layout, BorderLayout.CENTER);
      frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
      frame.setLocationByPlatform(true);
      
        frame.add(panel); 
        frame.add(panel2); 
                frame.setSize(700,600);
                frame.setLayout(null);    
                frame.setVisible(true);    
        } 
        private void ExternalData() {
            // Create a dialog to get the data from the user
            JDialog dialog = new JDialog(this, "External Data", true);
            JPanel detail=new JPanel();
            JLabel title1=new JLabel("Enter Your Detail....");
            title1.setBounds(80,20,200,30);
            Font font=new Font("Arial",Font.BOLD,20);
        title1.setFont(font);
            dialog.add(title1);
            detail.setBounds(100,60,280,400);
            detail.setBackground(Color.LIGHT_GRAY);
            detail.setBorder(new EmptyBorder(5, 5, 5, 5));
            dialog.add(detail);
            dialog.setSize(500, 550);
            dialog.setLayout(null);
            detail.setLayout(new GridLayout(17, 2));
        detail.add(new JLabel("            ID:"));
        JTextField IDField = new JTextField();
        detail.add(IDField);
        detail.add(new JLabel("         "));
        detail.add(new JLabel("         "));
        detail.add(new JLabel("           Name:"));
        JTextField nameField = new JTextField();
        detail.add(nameField);
        detail.add(new JLabel("         "));
        detail.add(new JLabel("         "));
        detail.add(new JLabel("           Age:"));
        JTextField ageField = new JTextField();
        detail.add(ageField);
        detail.add(new JLabel("         "));
        detail.add(new JLabel("         "));
        detail.add(new JLabel("          Date: "));
        JTextField date = new JTextField();
        detail.add(date);
        detail.add(new JLabel("         "));
        detail.add(new JLabel("         "));
        detail.add(new JLabel("          Time: "));
        JTextField Time = new JTextField();
        detail.add(Time);
        detail.add(new JLabel("         "));
        detail.add(new JLabel("         "));
        detail.add(new JLabel("         Account Number: "));
        JTextField Account = new JTextField();
        detail.add(Account);
        detail.add(new JLabel("         "));
        detail.add(new JLabel("         "));
        detail.add(new JLabel("          charges: "));
        JTextField Charge = new JTextField();
        detail.add(Charge);
        detail.add(new JLabel("         "));
        detail.add(new JLabel("         "));
        detail.add(new JLabel("          Current job: "));
        JTextField job = new JTextField();
        detail.add(job);
        detail.add(new JLabel("         "));
        detail.add(new JLabel("         "));
            JButton addButton = new JButton("Add");
            addButton.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    try {
                        PreparedStatement stmt = conn.prepareStatement("INSERT INTO external (ID,name, age,date,Time,Account,Charge,job) VALUES (?, ?, ?,?,?,?,?,?)");
                        stmt.setInt(1, Integer.parseInt(IDField.getText()));
                        stmt.setString(2, nameField.getText());
                       stmt.setInt(3, Integer.parseInt(ageField.getText()));
                       stmt.setString(4,date.getText());
                       stmt.setString(5,Time.getText());
                       stmt.setInt(6,Integer.parseInt(Account.getText()));
                        stmt.setInt(7,Integer.parseInt(Charge.getText()));
                        stmt.setString(8,job.getText());
                        stmt.executeUpdate();
                        JOptionPane.showMessageDialog(dialog,"Data added successfully...");
                        dialog.dispose();
                        
                    } catch (SQLException ex) {
                        ex.printStackTrace();
                        JOptionPane.showMessageDialog(dialog, "Error adding data.");
                    } catch (NumberFormatException ex) {
                        JOptionPane.showMessageDialog(dialog, "Invalid age.");
                    }
                }
            });
            detail.add(addButton);
            JButton cancelButton = new JButton("Cancel");
            cancelButton.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    dialog.dispose();
                }
            });
            detail.add(cancelButton);
            dialog.setVisible(true);
        } 
        private void TeacherData() {
        
                //JFrame frame1 = new JFrame("Database Result");
                JDialog dialog = new JDialog(this, "External Data", true);
                JPanel panel=new JPanel();
                JPanel panel2=new JPanel();
                JPanel panel3=new JPanel();

                JTable table;
                PreparedStatement pst;
                String[] columnNames = {"ID","name","age","date","Time","Account","Charge","job"};
   
   
                   panel.setLayout(new BorderLayout());
                   DefaultTableModel model = new DefaultTableModel();
   
                   model.setColumnIdentifiers(columnNames);
   
                   table = new JTable();
   
                   table.setModel(model);
   
                   table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
   
                   table.setFillsViewportHeight(true);
   
                   JScrollPane scroll = new JScrollPane(table);
   
                   scroll.setHorizontalScrollBarPolicy(
   
                           JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
   
                   scroll.setVerticalScrollBarPolicy(
   
                           JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
   
                   try {
                       
                       String sql = "select * from external";
                       Statement ps =  conn.createStatement();
                       ResultSet rs = ps.executeQuery(sql);
   
                       int i = 0;
                       while(rs.next()) 
                      {
                           int ID = rs.getInt(1);
                           String name =rs.getString(2);
                           String age =rs.getString(3);
                           String date=rs.getString(4);
                           String Time=rs.getString(5);
                           int Account=rs.getInt(6);
                           int Charge=rs.getInt(7);
                           String job=rs.getString(8);
                           
                           model.addRow(new Object[]{ID,name, age,date,Time,Account,Charge,job});
                          i++;	
                       }
                       if(i <1)
                      {
                           JOptionPane.showMessageDialog(null, "No Record Found","Error",
                           JOptionPane.ERROR_MESSAGE);
                           }
                           if(i ==1)
                           {
                           System.out.println(i+" Record Found");
                           }
                           else
                           {
                           System.out.println(i+" Records Found");
                           }
                           
                   } catch (Exception ex) {
                       JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                   }
                   panel.add(scroll);
                  panel.setVisible(true);
                   panel.setBounds(80,50,900,600);
                   dialog.add(panel);
                   dialog.setSize(1050, 1000);
            dialog.setLayout(null);
            
                JButton Select = new JButton("Select External");
        Select.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                select();
            }
        });
         panel2.add(Select);
         panel2.setBounds(350,700,150,50);
         panel2.setVisible(true);
         JButton View = new JButton("View Data");
        View.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                View();
            }
        });
        panel3.add(View);
        panel3.setBounds(500,700,150,50);
        panel3.setVisible(true);
         dialog.add(panel2);
         dialog.add(panel3);
         dialog.setVisible(true);
         }
         public void select()
         {
            JDialog dialog = new JDialog(this, "Select External", true);
            JPanel detail=new JPanel();
            JLabel title1=new JLabel("Select External....");
            title1.setBounds(80,20,200,30);
            Font font=new Font("Arial",Font.BOLD,20);
        title1.setFont(font);
            dialog.add(title1);
            detail.setBounds(150,80,450,600);
            detail.setBackground(Color.LIGHT_GRAY);
            detail.setBorder(new EmptyBorder(5, 5, 5, 5));
            dialog.add(detail);
            dialog.setSize(800, 780);
            dialog.setLayout(null);
            detail.setLayout(new GridLayout(25, 2));
        detail.add(new JLabel("         "));
        detail.add(new JLabel("         "));
        detail.add(new JLabel("     ID:"));
        JTextField IDField = new JTextField();
        detail.add(IDField);
        detail.add(new JLabel("         "));
        detail.add(new JLabel("         "));
        detail.add(new JLabel("     Teacher Name:"));
        JTextField nameField = new JTextField();
        detail.add(nameField);
        detail.add(new JLabel("         "));
        detail.add(new JLabel("         "));
        detail.add(new JLabel("     External Name:  "));
        JTextField externalField = new JTextField();
        detail.add(externalField);
        detail.add(new JLabel("         "));
        detail.add(new JLabel("         "));
        detail.add(new JLabel("     Subject: "));
        JTextField subjectField = new JTextField();
        detail.add(subjectField);
        detail.add(new JLabel("         "));
        detail.add(new JLabel("         "));
        detail.add(new JLabel("     Date: "));
        JTextField dateField = new JTextField();
        detail.add(dateField);  
        detail.add(new JLabel("         "));
        detail.add(new JLabel("         "));
        detail.add(new JLabel("     Time: "));
        JTextField timeField = new JTextField();
        detail.add(timeField);
        detail.add(new JLabel("         "));
        detail.add(new JLabel("         ")); 
        detail.add(new JLabel("     Total Student:  ")); 
        JTextField studField = new JTextField();
        detail.add(studField);
        detail.add(new JLabel("         "));
        detail.add(new JLabel("         ")); 
        detail.add(new JLabel("     Charge: "));
        JTextField chargeField = new JTextField();
        detail.add(chargeField);
        detail.add(new JLabel("         "));
        detail.add(new JLabel("         ")); 
        detail.add(new JLabel("     Bonus: "));
        JTextField bonusField = new JTextField();
        detail.add(bonusField);
        detail.add(new JLabel("         "));
        detail.add(new JLabel("         ")); 
        detail.add(new JLabel("     Total: "));
        JTextField totalField = new JTextField();
        totalField.setEditable(false);
        detail.add(totalField);
        detail.add(new JLabel("         "));
        detail.add(new JLabel("         ")); 
        JButton calculateButton = new JButton("Calculate");
        calculateButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e)
            {
                try {
                    int quantity = Integer.parseInt(studField.getText());
                    int price = Integer.parseInt(chargeField.getText());
                    int x=Integer.parseInt(bonusField.getText());
                    int total = (quantity * price) + x ;
                    totalField.setText(String.format("%d", total));
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(dialog, "Invalid input", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        detail.add(calculateButton);
        JButton clearButton = new JButton("Clear");
        clearButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e)
            {
            IDField.setText("");
            nameField.setText("");
            externalField.setText("");
            subjectField.setText("");
            dateField.setText("");
            timeField.setText("");
            studField.setText("");
            chargeField.setText("");
            bonusField.setText("");
            totalField.setText("");
            }
        });
        detail.add(clearButton);
        detail.add(new JLabel("         "));
        detail.add(new JLabel("         ")); 
            JButton addButton = new JButton("Add");
            addButton.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    try {
                        PreparedStatement stmt = conn.prepareStatement("INSERT INTO teacherdata (Id,TeacherName,ExternalName,Subject,Date,Time,TotalStudent,Charge,Bonus,Total) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");
                        //stmt.setString(1, UserField.getText());
                        stmt.setInt(1, Integer.parseInt(IDField.getText()));
                        stmt.setString(2, nameField.getText());
                        stmt.setString(3, externalField.getText());
                        stmt.setString(4, subjectField.getText());
                        stmt.setString(5, dateField.getText());
                        stmt.setString(6, timeField.getText());
                        stmt.setInt(7, Integer.parseInt(studField.getText()));
                        stmt.setInt(8, Integer.parseInt(chargeField.getText()));
                        stmt.setInt(9, Integer.parseInt(bonusField.getText()));
                        stmt.setInt(10, Integer.parseInt(totalField.getText()));
                        stmt.executeUpdate();
                        JOptionPane.showMessageDialog(dialog,"External added successfully...");
                        dialog.dispose();
                        
                        
                    } catch (SQLException ex) {
                        ex.printStackTrace();
                        JOptionPane.showMessageDialog(dialog, "Error adding data.");
                    } catch (NumberFormatException ex) {
                        JOptionPane.showMessageDialog(dialog, "Invalid data.");
                    }
                }
            });
            detail.add(addButton);
            JButton cancelButton = new JButton("Cancel");
            cancelButton.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    dialog.dispose();
                }
            });
            
            detail.add(cancelButton);
            dialog.setVisible(true);
        } 
    
    public void View()
    {
        JDialog dialog = new JDialog(this, "External Data", true);
                JPanel panel=new JPanel();
                JTable table;
                PreparedStatement pst;
                String[] columnNames = {"ID","TeacherName","ExternalName","Subject","Date","Time","TotalStudent","Charge","Bonus","Total"};
   
   
                   panel.setLayout(new BorderLayout());
                   DefaultTableModel model = new DefaultTableModel();
   
                   model.setColumnIdentifiers(columnNames);
   
                   table = new JTable();
   
                   table.setModel(model);
   
                   table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
   
                   table.setFillsViewportHeight(true);
   
                   JScrollPane scroll = new JScrollPane(table);
   
                   scroll.setHorizontalScrollBarPolicy(
   
                           JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
   
                   scroll.setVerticalScrollBarPolicy(
   
                           JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
   
                   try {
                       
                       String sql = "select * from teacherdata";
                       Statement ps =  conn.createStatement();
                       ResultSet rs = ps.executeQuery(sql);
   
                       int i = 0;
                       while(rs.next()) 
                      {
                           int ID = rs.getInt(1);
                           String TeahcherName =rs.getString(2);
                           String ExternalName =rs.getString(3);
                           String Subject =rs.getString(4);
                           String Date = rs.getString(5);
                           String Time=rs.getString(6);
                           int TotalStudent=rs.getInt(7);
                           int Charge=rs.getInt(8);
                           int Bonus=rs.getInt(9);
                           int Total=rs.getInt(10);
                           
                           model.addRow(new Object[]{ID,TeahcherName,ExternalName,Subject,Date,Time,TotalStudent,Charge,Bonus,Total});
                          i++;	
                       }
                       if(i <1)
                      {
                           JOptionPane.showMessageDialog(null, "No Record Found","Error",
                           JOptionPane.ERROR_MESSAGE);
                           }
                           if(i ==1)
                           {
                           System.out.println(i+" Record Found");
                           }
                           else
                           {
                           System.out.println(i+" Records Found");
                           }
                           
                   } catch (Exception ex) {
                       JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                   }
                   panel.add(scroll);
                  panel.setVisible(true);
                   panel.setBounds(30,25,1000,800);
                   dialog.add(panel);
                   dialog.setSize(1200, 1000);
            dialog.setLayout(null);
            dialog.setVisible(true);
    }
         
       
   
        
        

       

    }  
