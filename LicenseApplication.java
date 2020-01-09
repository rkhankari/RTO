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
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class LicenseApplication extends JFrame implements ActionListener
{

	public static String stringFullName,gender,stringAddress,stringBloodGrp,stringContactNo,stringDOB,stringVehicleDiscription,PreviousDrivingLicense,LicenseDisqualified,PaidFees,stringUserName,stringPassword;

	public JLabel lb_Title, lb_note, lb_gender,  lb_name, lb_DOB, lb_add, lb_mob, lb_courses, lb_UserName ,lb_pass,lb_bloodgroup,lb_q1,lb_q2,lb_q3,lb_q4;
	public  JLabel lb_hint0, lb_hint1, lb_hint2, lb_hint3, lb_hint4, lb_hintFinal,show1;	//Label for showing text field
	public  JTextField tf_name, tf_DOB, tf_mob, tf_UserName, tf_pass,tf_bloodgroup,tf_q3;
	public  JTextArea ta_add;
	JComboBox cb1;

	public  JCheckBox cb2,cb3,cb4,cb5,cb6;		//for choosing courses java, android
	public  JRadioButton rb1,rb2,rb3,rb4,rb5,rb6;		//for choosing gender
	public  JButton btnSubmit,btnCancel,btnBack;
	public  ButtonGroup bg;
	public  String show;
	private JPasswordField jPasswordField;
		
	
	LicenseApplication()
	{
		//frame layout
				//f =  new JFrame();
				super("License Application Form");
				setLayout(null);
				setSize(1050, 800);
					
				
				//adding components
		//1)Labels
				
				//title
				lb_Title = new JLabel("*****LICENSE APPLICATION FORM*****");
				lb_Title.setFont(new java.awt.Font("Times New Roman",3,18));

				lb_Title.setBounds(150, 20, 450, 20);
				//add(lb_Title,BorderLayout.CENTER);
				add(lb_Title);
				//name
				lb_name = new JLabel("* Full Name:");		
				lb_name.setBounds(50, 80, 100, 20);
				add(lb_name);
				
				//1)TextFields
				//name
				tf_name = new JTextField();
				tf_name.setBounds(210, 80, 300, 20);
				add(tf_name);
			
		//side error firing
				lb_hint1 = new JLabel();
				lb_hint1.setBounds(500, 80, 300, 20);
				add(lb_hint1);
				
		//2)RadioButton
				
				//gender
				lb_gender = new JLabel("* Gender:");		
				lb_gender.setBounds(50, 120, 80, 20);
				add(lb_gender);
				
				//radioButton1
				rb1 = new JRadioButton("Male");
				rb1.setBounds(190, 120, 60, 20);
				
				//radioButton2
				rb2 = new JRadioButton("Female");
				rb2.setBounds(290, 120, 80, 20);
				
				lb_hint0 = new JLabel();
				lb_hint0.setBounds(250, 120, 80, 20);
				add(lb_hint0);
				
				//Button Group
				
				bg = new ButtonGroup();
				bg.add(rb1);
				bg.add(rb2);
				
				add(rb1);
				add(rb2);
				
				//Address
				lb_add = new JLabel("*Permenent Address:");		
				lb_add.setBounds(50, 160, 200, 20);
				add(lb_add);
				
		//address
				ta_add = new JTextArea();
				ta_add.setBounds(210, 160, 300, 40);
				add(ta_add);
				
		//Mobile number
				lb_mob = new JLabel("* Contact Number:");		
				lb_mob.setBounds(50, 250, 200, 20);
				add(lb_mob);
				
		//text area for mob no.
				tf_mob = new JTextField();
				tf_mob.setBounds(210, 250, 300, 20);
				add(tf_mob);
				
		//blood group
				lb_bloodgroup = new JLabel("*Blood Group:");		
				lb_bloodgroup.setBounds(50, 220, 200, 20);
				add(lb_bloodgroup);
				
		//text area for blood group.
				tf_bloodgroup = new JTextField();
				tf_bloodgroup.setBounds(210, 220, 300, 20);
				add(tf_bloodgroup);
				
		//side error of mob
				lb_hint2 = new JLabel();
				//lb_hint2.setBackground(Color.RED);
				lb_hint2.setBounds(500, 240, 300, 20);
				
		//DOB label
				lb_DOB = new JLabel("*Date Of Birth:");		
				lb_DOB.setBounds(50, 280, 200, 20);
				add(lb_DOB);
				
				//Text Area DOB
						tf_DOB = new JTextField();		
						tf_DOB.setBounds(210, 280, 300, 20);
						add(tf_DOB);
						

						//courses available		
								lb_courses = new JLabel("*I hereby apply for license to enable me drive vehicle of the following description*");
								lb_courses.setBounds(50, 320, 500, 20);
								add(lb_courses);
						/*//Check Boxes		
								cb1 = new JCheckBox("motor vehicle");
								cb1.setBounds(50, 360, 250, 20);
								add(cb1);
								cb2 = new JCheckBox("bike with gear vehicle");
								cb2.setBounds(300, 360, 250, 20);
								add(cb2);
								cb3 = new JCheckBox("bike without gear vehicle");
								cb3.setBounds(50, 380, 200, 20);
								add(cb3);
								cb4 = new JCheckBox("transport vehicle");
								cb4.setBounds(300, 380, 200, 20);
								add(cb4);
								cb5 = new JCheckBox("auto rikshaw");
								cb5.setBounds(50, 400, 200, 20);
								add(cb5);
								cb6 = new JCheckBox("light motor vehicles");
								cb6.setBounds(300, 400, 200, 20);
								add(cb6);*/
								
								String Offer1[]={"motor vehicle","bike with gear vehicle","bike without gear vehicle","transport vehicle","auto rikshaw","light motor vehicles"};
								cb1=new JComboBox(Offer1);
								cb1.setBounds(70, 360, 200, 20);
								add(cb1);
								
								
								
								
								lb_q1 = new JLabel("*Have you previously held driving license?:");		
								lb_q1.setBounds(50, 400, 250, 20);
								add(lb_q1);
								
								//radioButton1
								rb3 = new JRadioButton("yes");
								rb3.setBounds(350, 400, 80, 20);
								
								//radioButton2
								rb4 = new JRadioButton("no");
								rb4.setBounds(450, 400, 100, 20);
								
								lb_hint0 = new JLabel();
								lb_hint0.setBounds(250, 120, 80, 20);
								add(lb_hint0);
								
								//Button Group
								
								bg = new ButtonGroup();
								bg.add(rb3);
								bg.add(rb4);
								
								add(rb3);
								add(rb4);	

								lb_q2 = new JLabel("*Have you ever disqualified for obtaining a license?");		
								lb_q2.setBounds(50, 440, 350, 20);
								add(lb_q2);
								
								//radioButton1
								rb5 = new JRadioButton("yes");
								rb5.setBounds(350, 440, 80, 20);
								
								//radioButton2
								rb6 = new JRadioButton("no");
								rb6.setBounds(450, 440, 100, 20);
								
								lb_hint0 = new JLabel();
								lb_hint0.setBounds(250, 120, 80, 20);
								add(lb_hint0);
								
								//Button Group
								
								bg = new ButtonGroup();
								bg.add(rb5);
								bg.add(rb6);
								
								add(rb5);
								add(rb6);		
								
								lb_q3 = new JLabel("*I have paid fess of RS.-?");		
								lb_q3.setBounds(50, 480, 250, 20);
								add(lb_q3);
							
								tf_q3 = new JTextField();
								tf_q3.setBounds(210, 480, 100, 20);
								add(tf_q3);
								
								
					   //NOTE
								lb_note = new JLabel("ENTER USERNAME AND PASSWORD");		
								lb_note.setBounds(50, 510, 350, 20);
								add(lb_note);
								
						//User name
								lb_UserName = new JLabel("* Username:");		
								lb_UserName.setBounds(50, 540, 200, 20);
								add(lb_UserName);
								
						//Text Field User name
								tf_UserName = new JTextField();		
								tf_UserName.setBounds(210, 540, 300, 20);
										add(tf_UserName);
										
						//side error of user name
										lb_hint3 = new JLabel();
										//lb_hint3.setBackground(Color.RED);
										lb_hint3.setBounds(500, 540, 300, 20);
										
										
								
						//Password
								lb_pass = new JLabel("* Password:");		
								lb_pass.setBounds(50, 580, 200, 20);
								add(lb_pass);
								
								//Text field password
								tf_pass = new JTextField();		
								tf_pass.setBounds(210, 580, 300, 20);
								add(tf_pass);
								
						//side error of password
								lb_hint4 = new JLabel();
								//lb_hint4.setBackground(Color.RED);
								lb_hint4.setBounds(500, 580, 300, 20);  
								
						//Last Notification message
								lb_hintFinal = new JLabel();
								//lb_hintFinal.setBackground(Color.RED);
								lb_hintFinal.setBounds(200, 600, 300, 20); 
								
								//Buttons
						//btn_Submit	
								btnSubmit = new JButton("Submit");
								btnSubmit.setBounds(200, 620, 80, 40);
								add(btnSubmit);
								
								btnSubmit.addActionListener(this);		//Add action listener to btnSubmit
								btnSubmit.setActionCommand("Submit");
								
					/*	//btn_Cancel
								btnCancel = new JButton("Cancel");
								btnCancel.setBounds(300, 620, 80, 40);
								add(btnCancel);
								btnCancel.addActionListener(this);
								btnCancel.setActionCommand("Close");	//Add action listener to btnCancel
*/								
								//btnBack
								btnBack = new JButton("Back");
								btnBack.setBounds(400, 620, 80, 40);
								add(btnBack);
								btnBack.addActionListener(this);
								btnBack.setActionCommand("Back");	//Add action listener to btnCancel
							
							//Adding error fire						
								add(lb_hint2);
								
								add(lb_hint3);
								
								add(lb_hint4);
								 
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
		new LicenseApplication();
	}*/
	@Override
	public void actionPerformed(ActionEvent obj)
	{
		// TODO Auto-generated method stub
		String cmd = obj.getActionCommand();
			
		if(cmd.equals("Submit"))
		{
			//validatestringFullName();
			//stringAddress(ta_add.getText());
		}else
		{
			System.out.println("Error...");
		}
		 if(cmd.equals("Submit"))
		{
			 validatestringFullName();
		}
		 if(cmd.equals("Back"))
			{
				new UsersChoice();
				this.dispose();
	     	}
	}
	private void validatestringFullName()
	{
		// TODO Auto-generated method stub
		final String FullName_Pattern=
				"[a-zA-Z][a-zA-Z ]*";	
		this.stringFullName = tf_name.getText().toString();

		if(this.stringFullName.matches(FullName_Pattern))
		{
			validateContactNo(tf_mob.getText());
		}else 
			//if(this.stringEmail.isEmpty())
		{
			JOptionPane.showMessageDialog(btnSubmit, "Enter Full Name Correctly!!!");
		}

	}
	
	
	private void validateContactNo(String string)
	{
		// TODO Auto-generated method stub
		final String ContactNo_PATTERN = 
		        "(0/91)?[7-9][0-9]{9}";
				this.stringContactNo = tf_mob.getText().toString();
				if(this.stringContactNo.matches(ContactNo_PATTERN ))
				{
					//validateDOB(tf_DOB.getText());
					validatePassword(tf_pass.getText());
				}else 
					//if(this.stringEmail.isEmpty())
				{
					JOptionPane.showMessageDialog(btnSubmit, "Enter Correct Contact No...");
				}
				

	}

	private void validateDOB(String string)
	{
		// TODO Auto-generated method stub
		//(mm/dd/yyyy)
		final String DOB_PATTERN = "(//^(//d{1,2})//(//d{1,2})//(//d{4})$)";
		       // " (0?[1-9]|[12][0-9]|3[01])/(0?[1-9]|1[012])/((19|20)\\d\\d)";
				this.stringDOB = tf_DOB.getText().toString();
				if(this.stringDOB.matches(DOB_PATTERN ))
				{
					//validateAadharNo(tf_Aadhar.getText());
					//validateAadharNo()
					validatePassword(tf_pass.getText());
				}else 
					//if(this.stringEmail.isEmpty())
				{
					JOptionPane.showMessageDialog(btnSubmit, "Enter Date Using Format (mm/dd/yyyy)");
				}
	}
	
	private void validatePassword(String password) 
	{
		this.stringPassword = password;
		// TODO Auto-generated method stub
		jPasswordField = new JPasswordField();
		jPasswordField.setBounds(190, 500, 300, 20);
		add(jPasswordField);
		if(this.stringPassword.isEmpty())
		{
			JOptionPane.showMessageDialog(btnSubmit, "Password is Empty");
		}else 
		{
			 VerifyUserNamePassword();
	         JOptionPane.showMessageDialog(btnSubmit, "Data Saved Successfully");

		}	
					//		String str = "insert into Registration_Form(Full_Name, Gender, Permanent_Address, Mob_Num, Email_Id, Courses, Username, Password) values(?,?,?,?,?,?,?,?)";   }	

	}

	private void VerifyUserNamePassword() 
	{
		// TODO Auto-generated method stub
		stringUserName=tf_UserName.getText();
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
			 InsertDatabaseLicenseApplication();
		//	this.dispose();
			System.out.println("chimniiiiiiii................");
		}else
		{
			//JOptionPane.showMessageDialog(btnSubmit, "Wrong Password Entered!!!");
			System.out.println("tf_pass popat................");
		}
	}else
	{
		//JOptionPane.showMessageDialog(btnSubmit, "Wrong UserName Entered!!!");
		System.out.println("tf_UserName popat................");
	}
		
	}
	

//System.out.println("User is Registred Successfully.......");
	}catch(Exception e1)
    {
	
	System.out.println(e1);
	

}

	}
	private void InsertDatabaseLicenseApplication() 
	{
		// TODO Auto-generated method stub
		stringFullName= tf_name.getText();
		if(rb1.isSelected())
		{
			gender= rb1.getText();
		}
		else if(rb2.isSelected())
		{
			gender= rb2.getText();
		}
		stringAddress=ta_add.getText();
		stringBloodGrp=tf_bloodgroup.getText();
		stringContactNo=tf_mob.getText();
		stringDOB=tf_DOB.getText();
		
		stringVehicleDiscription= (String) cb1.getSelectedItem();
	
	//	stringVehicleDiscription=tf_qualification.getText();
	/*	if(cb1.isSelected())
		{
			stringVehicleDiscription= cb1.getText();
		}
		else if(cb2.isSelected())
		{
			stringVehicleDiscription= cb2.getText();
		}
		else if(cb3.isSelected())
		{
			stringVehicleDiscription= cb3.getText();
		}
		else if(cb4.isSelected())
		{
			stringVehicleDiscription= cb4.getText();
		}
		else if(cb5.isSelected())
		{
			stringVehicleDiscription= cb5.getText();
		}
		else if(cb6.isSelected())
		{
			stringVehicleDiscription= cb6.getText();
		}*/
//		PreviousDrivingLicense=tf_bloodgroup.getText();
		if(rb3.isSelected())
		{
			PreviousDrivingLicense= rb3.getText();
		}
		else if(rb4.isSelected())
		{
			PreviousDrivingLicense= rb4.getText();
		}
		
	//	DisqualifyLicense=cb8.getText();
		
		if(rb5.isSelected())
		{
			LicenseDisqualified= rb5.getText();
		}
		else if(rb6.isSelected())
		{
			LicenseDisqualified= rb6.getText();
		}
		
		PaidFees=tf_q3.getText();
		stringUserName=tf_UserName.getText();
		stringPassword = tf_pass.getText();
		
		// "SET stringFullName = ?,gender=?,stringAddress=?,stringBloodGrp=?,stringContactNo=?,stringDOB=?,stringVehicleDiscription=?,PreviousDrivingLicense=?,LicenseDisqualified=?,PaidFees=?
		String sql="insert into licenseapplication(stringFullName, gender, stringAddress, stringBloodGrp, stringContactNo, stringDOB, stringVehicleDiscription, PreviousDrivingLicense, LicenseDisqualified, PaidFees, Username, Password) values(?,?,?,?,?,?,?,?,?,?,?,?)";
		
	//	String sql1 = "select * from newuserregistration";
		
		try{
			//Class.forName("oracle.jdbc.driver.OracleDriver");
			Class.forName("com.mysql.jdbc.Driver");
			//Connection cn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1523:xe","system","root");
			Connection cn=DriverManager.getConnection("jdbc:mysql://localhost:3306/rtosystem","root","root");
			
			PreparedStatement ps=cn.prepareStatement(sql);
			
		//	PreparedStatement ps1=cn.prepareStatement(sql1);

//			public static String stringFullName,gender,stringAddress,stringBloodGrp,stringContactNo,stringDOB,stringVehicleDiscription,PreviousDrivingLicense,DisqualifyLicense,PaidFees,stringUserName,stringPassword;

			//ps.setInt(1, 1);
			ps.setString(1, stringFullName);
			ps.setString(2, gender);
			ps.setString(3, stringAddress);
			ps.setString(4, stringBloodGrp);
			ps.setString(5, stringContactNo );
			ps.setString(6, stringDOB );
			ps.setString(7, stringVehicleDiscription );
			ps.setString(8, PreviousDrivingLicense );
			ps.setString(9,LicenseDisqualified );
			ps.setString(10, PaidFees );
			ps.setString(11, stringUserName );
			ps.setString(12, stringPassword );
			
			System.out.println(ps.executeUpdate());
				
			//System.out.println(ps1.executeUpdate());

			}catch(Exception e1)
		{
			
			System.out.println(e1);
			

		}
	}

}
