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
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class TestApplication extends JFrame implements ActionListener
{
	public static String stringUsername,stringPassword,stringTestType;
	
	public JLabel lb_title,lb_username,lb_password,lb_ol;
	public  JLabel lb_hint0, lb_hint1, lb_hint2, lb_hint3, lb_hint4, lb_hintFinal,show1;	//Label for showing text field
	public  JTextField tf_UserName,tf_pass,tf_result;
	public  ButtonGroup bg;
	public  JTextArea ta_place;
	public  JButton btnSubmit,btnCancel,btnBack;
	public  JRadioButton rb1,rb2;
	public  String show;
		
	TestApplication()
	{
		//frame layout
				//f =  new JFrame();
				super("Test Form");
				setLayout(null);
				setSize(1050, 800);
					
				
				//adding components
		//1)Labels
				
				//title
				lb_title = new JLabel("******TEST FORM******");
				lb_title.setFont(new java.awt.Font("Times New Roman",3,18));

				lb_title.setBounds(200, 20, 250, 20);
				//add(lb_title,BorderLayout.CENTER);
				add(lb_title);
				//date
				lb_username = new JLabel("*  Username:");		
				lb_username.setBounds(50, 80, 100, 20);
				add(lb_username);
				
				//1)TextFields
				//date
				tf_UserName = new JTextField();
				tf_UserName.setBounds(190, 80, 300, 20);
				add(tf_UserName);
			
		//side error firing
				lb_hint3 = new JLabel();
				lb_hint3.setBounds(500, 80, 300, 20);
				add(lb_hint3);
		
			
		//side error firing
				lb_hint1 = new JLabel();
				lb_hint1.setBounds(500, 160, 300, 20);
				add(lb_hint1);	
				
				//Password
				lb_password = new JLabel("*Password:");		
				lb_password.setBounds(50, 160, 200, 20);
				add(lb_password);
				
		//Password
				tf_pass = new JTextField();
				tf_pass.setBounds(190, 160, 300, 20);
				add(tf_pass);
					
				
				//2)RadioButton
						
						//gender
						lb_ol = new JLabel("*TEST TYPE:");		
						lb_ol.setBounds(50, 210, 80, 20);
						add(lb_ol);
						
						//radioButton1
						rb1 = new JRadioButton("Online Test");
						rb1.setBounds(190, 210, 90, 20);
						
						//radioButton2
						rb2 = new JRadioButton("Practical Test");
						rb2.setBounds(340, 210, 110, 20);
						
						lb_hint0 = new JLabel();
						lb_hint0.setBounds(250, 210, 80, 20);
						add(lb_hint0);
						
						//Button Group
						
						bg = new ButtonGroup();
						bg.add(rb1);
						bg.add(rb2);
						
						add(rb1);
						add(rb2);
								
						//Last Notification message
								lb_hintFinal = new JLabel();
								//lb_hintFinal.setBackground(Color.RED);
								lb_hintFinal.setBounds(200, 200, 300, 20); 
								
								//Buttons
						//btn_Submit	
								btnSubmit = new JButton("Submit");
								btnSubmit.setBounds(200, 300, 80, 40);
								add(btnSubmit);
								
								btnSubmit.addActionListener(this);		//Add action listener to btnSubmit
								btnSubmit.setActionCommand("Submit");
								
						/*//btn_Cancel
								btnCancel = new JButton("Cancel");
								btnCancel.setBounds(300, 300, 80, 40);
								add(btnCancel);
								btnCancel.addActionListener(this);
								btnCancel.setActionCommand("Close");	//Add action listener to btnCancel
								*/
								//btnAdmin
								btnBack = new JButton("Back");
								btnBack.setBounds(400, 300, 80, 40);
								add(btnBack);
								btnBack.addActionListener(this);
								btnBack.setActionCommand("Back");	//Add action listener to btnCancel
										
								
								
								add(lb_hint1);
								add(lb_hintFinal);
								
								setLayout(new BorderLayout());
							   	JLabel background=new JLabel(new ImageIcon("src/swingwithjdbcpkg/img/rutu.jpg"));
							    add(background);
							    background.setLayout(new FlowLayout());
								
								
				     			setVisible(true);					
	}
				
	
	

	/*public static void main(String[] args)
	{
		// TODO Auto-generated method stub
		new TestApplication();io
	}

*/


	@Override
	public void actionPerformed(ActionEvent obj)
	{
		// TODO Auto-generated method stub
       String cmd = obj.getActionCommand();
		
		if(cmd.equals("Submit"))
		{
		
			if(tf_UserName.getText().isEmpty() || tf_pass.getText().isEmpty())
	       	  {
	       		  JOptionPane.showMessageDialog(btnSubmit, "please enter username & password");
	       	  }	            
	            else
	            {
	            	VerifyUserPassword();
	            	//InsertDatabaseTestApplication();
	               // JOptionPane.showMessageDialog(btnSubmit, "Data Saved Successfully");
	            }
			
		}
		 if(cmd.equals("Submit"))
		{
           if(rb1.isSelected())
           {
        	   new OnlineTest();
   			this.dispose();
           }else if(rb2.isSelected())
           {
		
        	   new PracticalTest();
			//JOptionPane.showMessageDialog(rb2, "Give online test first");
			this.dispose();
     	   }
		}
		else if(cmd.equals("Back"))
		{
			//this.dispose();
			new RtoServices();
			this.dispose();
     	}
			
	
		
		if(obj.getSource()==btnSubmit)
		{
			
			if(tf_UserName.getText().isEmpty())
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




	private void VerifyUserPassword() 
	{
		// TODO Auto-generated method stub
		stringUsername=tf_UserName.getText();
		stringPassword = tf_pass.getText();
		
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
		//rs.getString(11);
	//	rs.getString(12);
		//System.out.println("ghgffghfhghg:::"+rs.getString(11));
	if(rs.getString(11).equals(tf_UserName.getText().toString()))
	{
		if(rs.getString(12).equals(tf_pass.getText().toString()))
		{
			//JOptionPane.showMessageDialog(btnSubmit, "Login Successfull!!!");
			InsertDatabaseTestApplication(); 
			this.dispose();
			System.out.println("successful................");
		}else
		{
			//JOptionPane.showMessageDialog(btnSubmit, "Wrong Password Entered!!!");
			System.out.println("tf_pass failed................");
		}
	}else
	{
		//JOptionPane.showMessageDialog(btnSubmit, "Wrong Entry!!!");
		System.out.println("tf_UserName failed................");
		new TestApplicationChoice();
		this.dispose();
	}
		
	}
	

//System.out.println("User is Registred Successfully.......");
	}catch(Exception e1)
    {
	
	System.out.println(e1);
	

    }

}


	private void InsertDatabaseTestApplication()
	{
		// TODO Auto-generated method stub
		stringUsername = tf_UserName.getText();
		//.toString();
		stringPassword = tf_pass.getText();
		//.toString();
		if(rb1.isSelected())
		{
			stringTestType= rb1.getText();
		}
		else if(rb2.isSelected())
		{
			stringTestType= rb2.getText();
		}
		
		String sql="insert into testapplication(stringUsername,stringPassword,stringTestType)values(?,?,?) ";
		
		//String sql1="select * from newuserregistration ";
		
				try{
			//Class.forName("oracle.jdbc.driver.OracleDriver");
			Class.forName("com.mysql.jdbc.Driver");
			//Connection cn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1523:xe","system","root");
			Connection cn=DriverManager.getConnection("jdbc:mysql://localhost:3306/rtosystem","root","root");
			PreparedStatement ps=cn.prepareStatement(sql);
		
				ps.setString(1, stringUsername);
				ps.setString(2, stringPassword);
				ps.setString(3, stringTestType);
				
				System.out.println(ps.executeUpdate());
		
		//System.out.println("User is Registred Successfully.......");
			}catch(Exception e1)
		    {
			
			System.out.println(e1);
			

		}

	}

}
