package swingwithjdbcpkg;

import java.awt.BorderLayout;
import java.awt.Color;
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
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class VehicleRegistration extends JFrame implements ActionListener
{
	public static String stringOwnerName,stringAddress,stringContactNo,stringAadharNo,stringVehicleClass,stringVehicleType,stringVehicleCategory,stringChasisNo,stringPurchaseDate;
	public static String stringUserName,stringPassword;
    public JLabel lb_Title, lb_note, lb_ownername,  lb_vehicletype, lb_vehicleclass, lb_add, lb_mob, lb_vehiclecategory, lb_aadhar,lb_purchasedate,lb_chasisno;
    public JLabel lb_hint0,lb_hint1,lb_hint2,lb_hint3, lb_hint4, lb_hintFinal,show1,lb_UserName,lb_pass;	
    public JTextField tf_ownername,tf_aadhar,tf_chasisno,tf_purchasedate,tf_mob,tf_UserName,tf_pass;
    public JTextArea ta_add;
	JComboBox cb1;
	public  JCheckBox cb2,cb3,cb4,cb5,cb6,cb7,cb8,cb9;		//for choosing courses java, android
    public  JButton btnSubmit,btnCancel,btnBack;
	public  ButtonGroup bg;
	public  String show;
	private JPasswordField jPasswordField;
	
    VehicleRegistration()
    {
        //frame
    	super("Vehicle Registration Form");
    	setSize(1050,800);
    	
    	//Title Label
    	lb_Title = new JLabel("******VEHICLE REGISTRATION FORM******");
    	lb_Title.setFont(new java.awt.Font("Times New Roman",3,18));

    	lb_Title.setBounds(200, 30, 450, 20);
    	add(lb_Title);
    	
    	//name
    	lb_ownername = new JLabel("* Owner Name:");		
    	lb_ownername.setBounds(50, 80, 100, 20);
		add(lb_ownername);
		
		//1)TextFields
		//name
		tf_ownername = new JTextField();
		tf_ownername.setBounds(190, 80, 300, 20);
		add(tf_ownername);
		
		//side error firing
		lb_hint1 = new JLabel();
		lb_hint1.setBounds(500, 80, 300, 20);
		add(lb_hint1);

    	//Address
		lb_add = new JLabel(" Permanent Address:");		
		lb_add.setBounds(50, 120, 300, 40);
		add(lb_add);
		
		//1)TextFields
		//name
		ta_add = new JTextArea();
		ta_add.setBounds(190, 120, 500, 40);
		add(ta_add);

		lb_mob = new JLabel("* Contact No:");		
		lb_mob.setBounds(50, 180, 100, 20);
		add(lb_mob);
		
		tf_mob = new JTextField();
		tf_mob.setBounds(190, 180, 300, 20);
		add(tf_mob);
		
		lb_aadhar = new JLabel("* Aadhar No:");		
		lb_aadhar.setBounds(50, 220, 100, 20);
		add(lb_aadhar);
		
		tf_aadhar = new JTextField();
		tf_aadhar.setBounds(190, 220, 300, 20);
		add(tf_aadhar);
		
		lb_hint4 = new JLabel();
		//lb_hint4.setBackground(Color.RED);
		lb_hint4.setBounds(500, 220, 300, 20);

		//NOTE
		lb_note = new JLabel("***ENTER THE VEHICLE DETAILS***");		
		lb_note.setBounds(200, 260, 250, 20);
		//lb_note.setBackground(Color.PINK);
		add(lb_note);

		lb_vehicleclass = new JLabel(" Vehicle Class  (Select from below):");		
		lb_vehicleclass.setBounds(50, 280, 300, 40);
		add(lb_vehicleclass);
		
		/*//Check Boxes		
		cb1 = new JCheckBox("Central Government");
		cb1.setBounds(100, 320, 200, 20);
		add(cb1);
		cb2 = new JCheckBox("Driving Training School");
		cb2.setBounds(300, 320, 200, 20);
		add(cb2);
		cb3 = new JCheckBox("Cooperation");
		cb3.setBounds(100, 340, 200, 20);
		add(cb3);
		cb4 = new JCheckBox("Individual");
		cb4.setBounds(300, 340, 200, 20);
		add(cb4);
		cb5 = new JCheckBox("Other");
		cb5.setBounds(100, 360, 200, 20);
		add(cb5);
		*/
		
		String Offer1[]={"Central Government","Driving Training School","Cooperation","Individual","Individual","Other"};
		cb1=new JComboBox(Offer1);
		cb1.setBounds(70, 320, 200, 20);
		add(cb1);
		
		
    	lb_vehicletype = new JLabel(" Vehicle Type (Select from below):");		
		lb_vehicletype.setBounds(50, 360, 300, 20);
		add(lb_vehicletype);
		
		//Check Boxes		
		cb6 = new JCheckBox("Transport");
		cb6.setBounds(100, 380, 200, 20);
		add(cb6);
		cb7 = new JCheckBox("Non Transport");
		cb7.setBounds(300, 380, 200, 20);
		add(cb7);
	
		lb_vehiclecategory = new JLabel(" Vehicle Category:");		
		lb_vehiclecategory.setBounds(50, 420, 300, 20);
		add(lb_vehiclecategory);
		
		cb8 = new JCheckBox("SCR");
		cb8.setBounds(100, 440, 200, 20);
		add(cb8);
		/*cb9 = new JCheckBox("Individual");
		cb9.setBounds(300, 520, 200, 20);
		add(cb9);*/
		

    	//name
		lb_chasisno = new JLabel("* Chasis Number:");		
		lb_chasisno.setBounds(50, 480, 300, 20);
		add(lb_chasisno);
		
		//1)TextFields
		//name
		tf_chasisno = new JTextField();
		tf_chasisno.setBounds(190, 480, 300, 20);
		add(tf_chasisno);
		
		lb_hint3 = new JLabel();
		//lb_hint3.setBackground(Color.RED);
		lb_hint3.setBounds(500, 560, 300, 20);
		
		lb_purchasedate = new JLabel("* Purchase Date:");		
		lb_purchasedate.setBounds(50, 520, 100, 20);
		add(lb_purchasedate);
		
		tf_purchasedate = new JTextField();
		tf_purchasedate.setBounds(190, 520, 100, 20);
		add(tf_purchasedate);
		
		lb_hint2 = new JLabel();
		//lb_hint2.setBackground(Color.RED);
		lb_hint2.setBounds(500, 600, 300, 20);
		
		
//User Ulogin_id
		lb_UserName = new JLabel("* UserName:");		
		lb_UserName.setBounds(50, 560, 100, 20);
		add(lb_UserName);
		
//Text Field Ulogin_id
		tf_UserName = new JTextField();		
		tf_UserName.setBounds(190, 560, 300, 20);
				add(tf_UserName);
				
//side error of Ulogin_id
				lb_hint3 = new JLabel();
				//lb_hint3.setBackground(Color.RED);
				lb_hint3.setBounds(500, 480, 300, 20);
				
				
		
//Password
		lb_pass = new JLabel("* Password:");		
		lb_pass.setBounds(50, 600, 80, 20);
		add(lb_pass);
		
		//Text field password
		tf_pass = new JTextField();		
		tf_pass.setBounds(190, 600, 300, 20);
		add(tf_pass);
		
//side error of password
		lb_hint4 = new JLabel();
		//lb_hint4.setBackground(Color.RED);
		lb_hint4.setBounds(500, 520, 300, 20);  
		

		//Last Notification message
		lb_hintFinal = new JLabel();
		//lb_hintFinal.setBackground(Color.RED);
		lb_hintFinal.setBounds(200, 680, 300, 20); 
		
		
		

		
		//Buttons
//btn_Submit	
		btnSubmit = new JButton("Submit");
		btnSubmit.setBounds(200, 640, 80, 40);
		add(btnSubmit);
		
		btnSubmit.addActionListener(this);		//Add action listener to btnSubmit
		btnSubmit.setActionCommand("Submit");
		
/*////btn_Cancel
//		btnCancel = new JButton("Cancel");
//		btnCancel.setBounds(300, 640, 80, 40);
//		add(btnCancel);
//		btnCancel.addActionListener(this);
//		btnCancel.setActionCommand("Close");	//Add action listener to btnCancel
//		
*/		
		
		btnBack = new JButton("Back");
		btnBack.setBounds(400, 640, 80, 40);
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
       new VehicleRegistration();
	}
*/
	@Override
	public void actionPerformed(ActionEvent obj)
	{
		// TODO Auto-generated method stub
		String cmd = obj.getActionCommand();
		if(cmd.equals("Submit"))
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
			 
			 if(obj.getSource()==btnSubmit)
				{
						if(tf_ownername.getText().isEmpty())
						{
							lb_hint1.setText("***blank field");
							lb_hintFinal.setText(null);
						}
						else if(tf_mob.getText().isEmpty())
						{
							lb_hint2.setText("***blank field");
							lb_hintFinal.setText(null);
						}
						else if(tf_aadhar.getText().isEmpty())
						{
							lb_hint3.setText("***blank field");
							lb_hintFinal.setText(null);
						}
						else if(tf_purchasedate.getText().isEmpty())
						{
							lb_hint4.setText("***blank field");
							lb_hintFinal.setText(null);
						}
					
				}
			 
		}
		private void validatestringFullName()
		{
			// TODO Auto-generated method stub
			final String FullName_Pattern=
					"[a-zA-Z][a-zA-Z ]*";	
			this.stringOwnerName = tf_ownername.getText().toString();

			if(this.stringOwnerName.matches(FullName_Pattern))
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
				VerifyUsernamePass();
		         JOptionPane.showMessageDialog(btnSubmit, "Data Saved Successfully");

			}	
						//		String str = "insert into Registration_Form(Full_Name, Gender, Permanent_Address, Mob_Num, Email_Id, Courses, Username, Password) values(?,?,?,?,?,?,?,?)";   }	

		}

			
	
		
	

	
	
	
//	public static String stringOwnerName,stringAddress,stringContactNo,stringAadharNo,stringVehicleClass,stringVehicleType,stringVehicleCategory,stringChasisNo,stringPurchaseDate;

	private void VerifyUsernamePass() 
	{
		// TODO Auto-generated method stub
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
			InsertDatabaseVehicleRegistration();
			//this.dispose();
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

	private void InsertDatabaseVehicleRegistration()
	{
		// TODO Auto-generated method stub
		stringOwnerName= tf_ownername.getText();
		stringAddress=ta_add.getText();
		stringContactNo=tf_mob.getText();
		stringAadharNo=tf_aadhar.getText();
		stringVehicleClass= (String) cb1.getSelectedItem();
	//	stringVehicleClass=tf_qualification.getText();
		/*if(cb1.isSelected())
		{
			stringVehicleClass= cb1.getText();
		}
		else if(cb2.isSelected())
		{
			stringVehicleClass= cb2.getText();
		}
		else if(cb3.isSelected())
		{
			stringVehicleClass= cb3.getText();
		}
		else if(cb4.isSelected())
		{
			stringVehicleClass= cb4.getText();
		}
		else if(cb5.isSelected())
		{
			stringVehicleClass= cb5.getText();
		}*/
	//	stringVehicleType=tf_bloodgroup.getText();
		if(cb6.isSelected())
		{
			stringVehicleType= cb6.getText();
		}
		else if(cb7.isSelected())
		{
			stringVehicleType= cb7.getText();
		}
		stringVehicleCategory=cb8.getText();
		stringChasisNo=tf_chasisno.getText();
		stringPurchaseDate = tf_purchasedate.getText();
		stringUserName = tf_UserName.getText();
		stringPassword = tf_pass.getText();
		//.toString();
		// model.addRow(new Object[]{stringOwnerName,stringAddress,stringContactNo,stringAadharNo,stringVehicleClass,stringVehicleType,stringVehicleCategory,stringChasisNo,stringPurchaseDate,stringUserName,stringPassword });

		String sql="insert into vehicleregistration(stringOwnerName, stringAddress, stringContactNo, stringAadharNo, stringVehicleClass, stringVehicleType, stringVehicleCategory, stringChasisNo, stringPurchaseDate,stringUserName,stringPassword) values(?,?,?,?,?,?,?,?,?,?,?)";
				try{
			//Class.forName("oracle.jdbc.driver.OracleDriver");
			Class.forName("com.mysql.jdbc.Driver");
			//Connection cn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1523:xe","system","root");
			Connection cn=DriverManager.getConnection("jdbc:mysql://localhost:3306/rtosystem","root","root");
			PreparedStatement ps=cn.prepareStatement(sql);
			
			//ps.setInt(1, 1);
			ps.setString(1, stringOwnerName);
			ps.setString(2, stringAddress);
			ps.setString(3, stringContactNo);
			ps.setString(4, stringAadharNo);
			ps.setString(5, stringVehicleClass);
			ps.setString(6, stringVehicleType );
			ps.setString(7, stringVehicleCategory );
			ps.setString(8, stringChasisNo );
			ps.setString(9, stringPurchaseDate );
			ps.setString(10, stringUserName );
			ps.setString(11, stringPassword );
			System.out.println(ps.executeUpdate());
		
		
	
			}catch(Exception e1)
		{
			
			System.out.println(e1);
			

		}

	}

}
