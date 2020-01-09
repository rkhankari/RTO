package swingwithjdbcpkg;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

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

public class NewUserRegistration extends JFrame implements ActionListener
{
	public static String gender;

    public JLabel lb_Title, lb_note, lb_gender,lb_id,lb_email,  lb_name, lb_DOB, lb_add, lb_mob, lb_courses,lb_Aadhar, lb_UserName ,lb_pass,lb_bloodgroup,lb_q3,lb_qualification;
	//public  JLabel lb_hint0, lb_hint1, lb_hint2, lb_hint3, lb_hint4, lb_hintFinal,show1;	//Label for showing text field
	public  JTextField tf_name, tf_DOB, tf_mob,tf_id,tf_email, tf_UserName, tf_pass,tf_bloodgroup,tf_qualification,tf_Aadhar;	
	public  JTextArea ta_add;
	public  JCheckBox cb1,cb2,cb3,cb4,cb5,cb6;		//for choosing courses java, android
	public  JRadioButton rb1,rb2;		//for choosing gender
	public  JButton btnSubmit,btnCancel,btnBack;
	public  ButtonGroup bg;
	public  String show;

	private JPasswordField jPasswordField;
		
	public static String stringFullName,stringUserId,stringAddress,stringContactNo,stringEmail,stringDOB,stringBloodGrp,stringQualification,stringAadharNo,stringUserName,stringPassword;
	
	NewUserRegistration()
	{
		//frame layout
				//f =  new JFrame();
				super("User Registration Form");
				//setLayout(null);
				setSize(1050, 800);
					
				
				//adding components
		//1)Labels
				
				//title
				lb_Title = new JLabel("******USER REGISTRATION FORM******");
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
				tf_name.setBounds(190, 80, 300, 20);
				add(tf_name);
			
		/*//side error firing
				lb_hint1 = new JLabel();
				lb_hint1.setBounds(500, 80, 300, 20);
				add(lb_hint1);*/
		//admin id
				lb_id = new JLabel("* User ID:");		
				lb_id.setBounds(50, 110, 100, 20);
				add(lb_id);
				
				//1)TextFields
				//name
				tf_id = new JTextField();
				tf_id.setBounds(190, 110, 300, 20);
				add(tf_id);
		/*	
		//side error firing
				lb_hint1 = new JLabel();
				lb_hint1.setBounds(500, 110, 300, 20);
				add(lb_hint1);	*/
				
		//2)RadioButton
				
				//gender
				lb_gender = new JLabel("* Gender:");		
				lb_gender.setBounds(50, 140, 80, 20);
				add(lb_gender);
				
				//radioButton1
				rb1 = new JRadioButton("Male");
				rb1.setBounds(190, 140, 60, 20);
				
				//radioButton2
				rb2 = new JRadioButton("Female");
				rb2.setBounds(270, 140, 80, 20);
				
				/*lb_hint0 = new JLabel();
				lb_hint0.setBounds(250, 140, 80, 20);
				add(lb_hint0);
				*/
				//Button Group
				
				bg = new ButtonGroup();
				bg.add(rb1);
				bg.add(rb2);
				
				add(rb1);
				add(rb2);
				
				//Address
				lb_add = new JLabel("*Permenent Address:");		
				lb_add.setBounds(50, 170, 200, 20);
				add(lb_add);
				
		//address
				ta_add = new JTextArea();
				ta_add.setBounds(190, 170, 300, 40);
				add(ta_add);
				
				//Email id
				lb_email = new JLabel("   Email Id:");		
				lb_email.setBounds(50, 220, 200, 20);
				add(lb_email);
				
				//Text AreaEmail id
						tf_email = new JTextField();		
						tf_email.setBounds(190, 220, 300, 20);
						add(tf_email);		
				
		//Mobile number
				lb_mob = new JLabel("* Contact Number:");		
				lb_mob.setBounds(50, 250, 200, 20);
				add(lb_mob);
				
		//text area for mob no.
				tf_mob = new JTextField();
				tf_mob.setBounds(190, 250, 300, 20);
				add(tf_mob);
				
	    //Aadhar number
				lb_Aadhar = new JLabel("* Aadhar Number:");		
				lb_Aadhar.setBounds(50, 400, 200, 20);
				add(lb_Aadhar);
				
		//text area for aadhar no.
				tf_Aadhar = new JTextField();
				tf_Aadhar.setBounds(190, 400, 300, 20);
				add(tf_Aadhar);	
				
		//blood group
				lb_bloodgroup = new JLabel("*Blood group:");		
				lb_bloodgroup.setBounds(50, 370, 200, 20);
				add(lb_bloodgroup);
				
		//text area for blood group.
				tf_bloodgroup = new JTextField();
				tf_bloodgroup.setBounds(190, 370, 300, 20);
				add(tf_bloodgroup);
				
		/*//side error of mob
				lb_hint2 = new JLabel();
				//lb_hint2.setBackground(Color.RED);
				lb_hint2.setBounds(500, 240, 300, 20);
				*/
		//DOB
				lb_DOB = new JLabel("*Date Of Birth:");		
				lb_DOB.setBounds(50, 300, 200, 20);
				add(lb_DOB);
				
				//Text AreaEmail id
						tf_DOB = new JTextField();		
						tf_DOB.setBounds(190, 300, 300, 20);
	                    add(tf_DOB);
	     //qualification
	    				lb_qualification = new JLabel("*qualification:");		
	    				lb_qualification.setBounds(50, 340, 200, 20);
	    				add(lb_qualification);
	    				
	    				//Text AreaEmail id
	    				tf_qualification = new JTextField();		
	    				tf_qualification.setBounds(190, 340, 300, 20);
	    	                    add(tf_qualification);			

					
								
								//User name
	    	                    lb_UserName = new JLabel("* Username:");		
	    	                    lb_UserName.setBounds(50, 460, 200, 20);
								add(lb_UserName);
								
						//Text Field User name
								tf_UserName = new JTextField();		
								tf_UserName.setBounds(190, 460, 300, 20);
										add(tf_UserName);
										
					/*	//side error of user name
										lb_hint3 = new JLabel();
										//lb_hint3.setBackground(Color.RED);
										lb_hint3.setBounds(500, 460, 300, 20);
										*/
										
								
						//Password
								lb_pass = new JLabel("* Password:");		
								lb_pass.setBounds(50, 500, 200, 20);
								add(lb_pass);
								
								//Text field password
								tf_pass = new JTextField();		
								tf_pass.setBounds(190, 500, 300, 20);
								add(tf_pass);
								
						/*//side error of password
								lb_hint4 = new JLabel();
								//lb_hint4.setBackground(Color.RED);
								lb_hint4.setBounds(500, 500, 300, 20);  
								*/
						/*//Last Notification message
								lb_hintFinal = new JLabel();
								//lb_hintFinal.setBackground(Color.RED);
								lb_hintFinal.setBounds(200, 500, 300, 20); 
								*/
								//Buttons
						//btn_Submit	
								btnSubmit = new JButton("Submit");
								btnSubmit.setBounds(200, 560, 80, 40);
								add(btnSubmit);
								
								btnSubmit.addActionListener(this);		//Add action listener to btnSubmit
								btnSubmit.setActionCommand("Submit");
								
						//btn_Cancel
								btnCancel = new JButton("Cancel");
								btnCancel.setBounds(300, 560, 80, 40);
								add(btnCancel);
								btnCancel.addActionListener(this);
								btnCancel.setActionCommand("Close");	//Add action listener to btnCancel
								
								btnBack = new JButton("Back");
								btnBack.setBounds(400, 560, 80, 40);
								add(btnBack);
								btnBack.addActionListener(this);
								btnBack.setActionCommand("Back");	//Add action listener to btnCancel
															
								
						//Adding error fire
								
								
								//add(lb_hint2);
								
								//add(lb_hint3);
								
								//add(lb_hint4);
								 
								//add(lb_hintFinal);
								
								setLayout(new BorderLayout());
							   	JLabel background=new JLabel(new ImageIcon("src/swingwithjdbcpkg/img/rutu.jpg"));
							       add(background);
							       background.setLayout(new FlowLayout());
								
								
								setVisible(true);
	}							
	@Override
	public void actionPerformed(ActionEvent obj)
	{
        String cmd = obj.getActionCommand();
		
        if(cmd.equals("Submit"))
    	{
    		//validatestringFullName();
    		//stringAddress(ta_add.getText());
    	}else
    	{
    		System.out.println("done...");
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
    		validateEmail(tf_email.getText());
    	}else 
    		//if(this.stringEmail.isEmpty())
    	{
    		JOptionPane.showMessageDialog(btnSubmit, "Enter Full Name Correctly!!!");
    	}

    }
    /*private void stringAddress(String text) 
    {
    	// TODO Auto-generated method stub
    	final String Address_Pattern=
    			"[a-zA-Z]+";	
    		this.stringAddress = ta_add.getText().toString();

    		if(this.stringAddress.matches(Address_Pattern))
    		{
    			validateEmail(tf_email.getText());
    		}else 
    			//if(this.stringEmail.isEmpty())
    		{
    			JOptionPane.showMessageDialog(btnSubmit, "Enter Correct Address!!!");
    		}


    }*/
    private void validateEmail(String string) 
    {
    	
    	final String EMAIL_PATTERN = 
        "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
        + "[a-z-]+(\\.[a-z]+)*(\\.[a-z]{2,6})$";
    	this.stringEmail = tf_email.getText().toString();
    	if(this.stringEmail.matches(EMAIL_PATTERN))
    	{
    		//validatePassword(tf_pass.getText());
    		validateContactNo(tf_mob.getText());
    	}else 
    		//if(this.stringEmail.isEmpty())
    	{
    		JOptionPane.showMessageDialog(btnSubmit, "Enter Correct Email...");
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
    /*private void validateBloodGrp(String text)
    {
    	// TODO Auto-generated method stub
    	final String BloodGrp_PATTERN = 
    	        "/^(A|B|AB|O)[+-]$/";
    			this.stringBloodGrp = tf_bloodgroup.getText().toString();
    			if(this.stringBloodGrp.matches(BloodGrp_PATTERN ))
    			{
    				validateAadharNo(tf_Aadhar.getText());
    			}else 
    				//if(this.stringEmail.isEmpty())
    			{
    				JOptionPane.showMessageDialog(btnSubmit, "Enter Blood Group Properly...");
    			}

    }*/
    private void validateAadharNo(String text)
    {
    	// TODO Auto-generated method stub
    	final String AadharNo_PATTERN = 
    	        "^[2-9]{1}[0-9]{11}$";
    			this.stringAadharNo = tf_Aadhar.getText().toString();
    			if(this.stringAadharNo.matches( AadharNo_PATTERN ))
    			{
    				validatePassword(tf_pass.getText());
    			}else 
    				//if(this.stringEmail.isEmpty())
    			{
    				JOptionPane.showMessageDialog(btnSubmit, "Enter Aadhar No Properly...");
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
    		InsertDatabaseNewUserRegistration();
              JOptionPane.showMessageDialog(btnSubmit, "Data Saved Successfully");

    	}	
    				//		String str = "insert into Registration_Form(Full_Name, Gender, Permanent_Address, Mob_Num, Email_Id, Courses, Username, Password) values(?,?,?,?,?,?,?,?)";   }	



    			
	
   }

//public static String stringFullName,stringUserId,stringAddress,stringContactNo,stringEmail,stringDOB,stringBloodGrp,stringQualification,stringAadharNo,stringUserName,stringPassword;


private void InsertDatabaseNewUserRegistration()
{
	// TODO Auto-generated method stub

	// TODO Auto-generated method stub
	stringFullName= tf_name.getText();
	stringUserId= tf_id.getText();
//	gender=	rb2.getText();
	if(rb1.isSelected())
	{
		gender= rb1.getText();
	}
	else if(rb2.isSelected())
	{
		gender= rb2.getText();
	}
	
	stringAddress= ta_add.getText();
	stringEmail=tf_email.getText();
	stringContactNo=tf_mob.getText();
	stringDOB=tf_DOB.getText();
	stringQualification=tf_qualification.getText();
	stringBloodGrp=tf_bloodgroup.getText();
	stringAadharNo=tf_Aadhar.getText();
	stringUserName=tf_UserName.getText();
	stringPassword = tf_pass.getText();
	//.toString();
	
	//stringFullName,stringUserId,gender,stringAddress,stringContactNo,stringEmail,stringDOB,stringBloodGrp,stringQualification,stringAadharNo,stringUserName,stringPassword
	
	String sql="insert into newuserregistration(stringFullName, stringUserId, gender, stringAddress, stringContactNo, stringEmail, stringDOB, stringBloodGrp, stringQualification, stringAadharNo, stringUserName, stringPassword) values(?,?,?,?,?,?,?,?,?,?,?,?)";
			try{
		//Class.forName("oracle.jdbc.driver.OracleDriver");
		Class.forName("com.mysql.jdbc.Driver");
		//Connection cn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1523:xe","system","root");
		Connection cn=DriverManager.getConnection("jdbc:mysql://localhost:3306/rtosystem","root","root");
		PreparedStatement ps=cn.prepareStatement(sql);
		
			//ps.setInt(1, 1);
		ps.setString(1, stringFullName);
		ps.setString(2, stringUserId);
		ps.setString(3, gender);
		ps.setString(4, stringAddress);
		ps.setString(5, stringEmail );
		ps.setString(6, stringContactNo );
		ps.setString(7, stringDOB );
		ps.setString(8, stringQualification );
		ps.setString(9, stringBloodGrp );
		ps.setString(10, stringAadharNo );
		ps.setString(11, stringUserName );
		ps.setString(12, stringPassword );
		

		System.out.println(ps.executeUpdate());
	
	
	System.out.println("User is Registred Successfully.......");
		}catch(Exception e1)
	{
		
		System.out.println(e1);
		

	}

}	
}	