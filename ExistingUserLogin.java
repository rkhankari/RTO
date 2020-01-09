package swingwithjdbcpkg;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class ExistingUserLogin extends JFrame implements ActionListener
{
	public static String stringUserName,stringPassword,stringuserid;
    public JLabel  lb_Ulogin_id, lb_pass;
	public  JLabel lb_Title,lb_UserName,lb_note,lb_hint0, lb_hint1, lb_hint2, lb_hint3, lb_hint4, lb_hintFinal,show1;	//Label for showing text field
	public  JTextField  tf_UserName,tf_User_id,  tf_pass;
	public  JTextArea ta_add;
	public  JCheckBox cb1,cb2,cb3,cb4;		//for choosing courses java, android
	public  JRadioButton rb1,rb2;		//for choosing gender
	public  JButton btnSubmit,btnCancel,btnBack;
	public  ButtonGroup bg;
	public  String show;
	public  JTextField jPasswordField;
	
	
	ExistingUserLogin()
	{
		//frame layout
		//f =  new JFrame();
		super("User Login Form");
		//setLayout(null);
		setSize(1050,800);
			
		
		//adding components
//1)Labels
		
		//title
		lb_Title = new JLabel("*****USER LOGIN FORM*****");
		lb_Title.setFont(new java.awt.Font("Times New Roman",3,18));
		lb_Title.setBounds(370, 20, 450, 30);
		//add(lb_Title,BorderLayout.CENTER);
		add(lb_Title);		
						
					//NOTE
						lb_note = new JLabel("***Enter USERID and PASSWORD for LOGIN");		
						lb_note.setFont(new java.awt.Font("Times New Roman",3,20));
                        lb_note.setBounds(300, 70, 450, 30);
						add(lb_note);
						
				//User Ulogin_id
						lb_Ulogin_id = new JLabel("* User Id:");		
						lb_Ulogin_id.setBounds(300, 130, 100, 20);
						add(lb_Ulogin_id);
						
				//Text Field Ulogin_id
						tf_User_id = new JTextField();		
						tf_User_id.setBounds(400, 130, 300, 20);
								add(tf_User_id);
								
				//side error of Ulogin_id
								lb_hint3 = new JLabel();
								//lb_hint3.setBackground(Color.RED);
								lb_hint3.setBounds(500, 480, 300, 20);
								
								
						
				//Password
						lb_pass = new JLabel("* Password:");		
						lb_pass.setBounds(300, 200, 80, 20);
						add(lb_pass);
						
						//Text field password
						/*tf_pass = new JTextField();		
						tf_pass.setBounds(400, 200, 300, 20);
						add(tf_pass);*/
						
						jPasswordField = new JPasswordField();
						jPasswordField.setBounds(400, 200, 300, 20);
						add(jPasswordField);
						
				//side error of password
						lb_hint4 = new JLabel();
						//lb_hint4.setBackground(Color.RED);
						lb_hint4.setBounds(500, 520, 300, 20);  
						
				//Last Notification message
						lb_hintFinal = new JLabel();
						//lb_hintFinal.setBackground(Color.RED);
						lb_hintFinal.setBounds(200, 620, 300, 20); 
						
						//Buttons
				//btn_Submit	
						btnSubmit = new JButton("Submit");
						btnSubmit.setBounds(300, 300, 80, 40);
						add(btnSubmit);
						
						btnSubmit.addActionListener(this);		//Add action listener to btnSubmit
						btnSubmit.setActionCommand("Submit");
						
			/*	//btn_Cancel
						btnCancel = new JButton("Cancel");
						btnCancel.setBounds(500, 300, 80, 40);
						add(btnCancel);
						btnCancel.addActionListener(this);
						btnCancel.setActionCommand("Close");	//Add action listener to btnCancel
*/						
						btnBack = new JButton("Back");
						btnBack.setBounds(700, 300, 80, 40);
						add(btnBack);
						btnBack.addActionListener(this);
						btnBack.setActionCommand("Back");	
						
				
						add(lb_hintFinal);
						
						setLayout(new BorderLayout());
					   	JLabel background=new JLabel(new ImageIcon("src/swingwithjdbcpkg/img/rutu.jpg"));
					       add(background);
					       background.setLayout(new FlowLayout());
						
						
						setVisible(true);
			}
		



/*
public static void main(String[] args)
{
// TODO Auto-generated method stub
new AdminLogin();
}
*/
@Override
public void actionPerformed(ActionEvent obj)
{
// TODO Auto-generated method stub
{
	String cmd = obj.getActionCommand();
	
	if(cmd.equals("Submit"))
	{
          if(tf_User_id.getText().isEmpty() || jPasswordField.getText().isEmpty())
       	  {
       		  JOptionPane.showMessageDialog(btnSubmit, "Please enter user id and password");
       	  }	            
          else
          {
        	  InsertDatabaseExistingAdminLogin();
               //JOptionPane.showMessageDialog(btnSubmit, "Data Saved Successfully");
            
          }
	 }
	else if(cmd.equals("Back"))
	{
		new UsersChoice();
		this.dispose();
 	}

	 if(obj.getSource()==btnSubmit)
	 {
		
	 }
	 if(tf_User_id.getText().isEmpty())
	 {
			lb_hint1.setText("***blank field");
			lb_hintFinal.setText(null);
	 }
     else if(tf_pass.getText().isEmpty())
	 {
			lb_hint2.setText("***blank field");
			lb_hintFinal.setText(null);
	 }
	 
	}

}





private void InsertDatabaseExistingAdminLogin()
{
// TODO Auto-generated method stub
	stringuserid =tf_User_id.getText();
//.toString();
stringPassword = jPasswordField.getText();
//.toString();

String sql="select * from newuserregistration ";
		try{
	//Class.forName("oracle.jdbc.driver.OracleDriver");
	Class.forName("com.mysql.jdbc.Driver");
	//Connection cn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1523:xe","system","root");
	Connection cn=DriverManager.getConnection("jdbc:mysql://localhost:3306/rtosystem","root","root");
	PreparedStatement ps=cn.prepareStatement(sql);
	
	ResultSet rs = ps.executeQuery();
	while(rs.next())
	{
		
	if(rs.getString(2).equals(tf_User_id.getText().toString()))
	{
		if(rs.getString(12).equals(jPasswordField.getText().toString()))
		{
			JOptionPane.showMessageDialog(btnSubmit, "Login Successfull!!!");
			new RtoServices();
			this.dispose();
			System.out.println("Successful................");
		}else
		{
			JOptionPane.showMessageDialog(btnSubmit, "Wrong Password Entered!!!");
			System.out.println("jPasswordField failed................");
		}
	}else
	{
		//JOptionPane.showMessageDialog(btnSubmit, "Wrong Entry!!!");
		System.out.println("tf_User_id failed................");
	}
		
	}
	

//System.out.println("User is Registred Successfully.......");
	}catch(Exception e1)
    {
	
	System.out.println(e1);
	

}

}
}