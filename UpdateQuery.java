package swingwithjdbcpkg;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.AbstractButton;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;


public class UpdateQuery 
{   
	private static DefaultTableModel model;
	public static String stringFullName,stringUserId,gender,stringAddress,stringContactNo,stringEmail,stringDOB,stringBloodGrp,stringQualification,stringAadharNo,stringUserName,stringPassword;
	public  JTextField tf_name, tf_DOB, tf_mob,tf_id,tf_email, tf_UserName, tf_pass,tf_bloodgroup,tf_qualification,tf_Aadhar;	
	public  JTextArea ta_add;
	public  JCheckBox cb1,cb2,cb3,cb4,cb5,cb6;		//for choosing courses java, android
	public  JRadioButton rb1,rb2;
	
	UpdateQuery()
	{
		 JFrame frame = new JFrame();
	       JTable table = new JTable(); 
	     
	     
	        model = new DefaultTableModel(new Object[]{"stringFullName","stringUserId","gender","stringAddress","stringEmail","stringContactNo","stringDOB","stringQualification","stringBloodGrp","stringAadharNo","stringUserName","stringPassword"},0);
	        table.setModel(model);
	      
	     //   table.setModel(model);
	       insertData();
	     
	       
	       
	        table.setBackground(Color.LIGHT_GRAY);
	        table.setForeground(Color.black);
	        Font font = new Font("",1,22);
	        table.setFont(font);
	        table.setRowHeight(30);
	        
	        
//	        txtField3 = new JButton("BACK ");
//	        txtField3.addActionListener(this);
//	        
	        JTextField textFullname = new JTextField();
	        JTextField textUserId = new JTextField();
	        JTextField textgender = new JTextField();
	        JTextField textAddress = new JTextField();
	        JTextField textContactNo= new JTextField();
	        JTextField textEmail= new JTextField();
	        JTextField textDOB= new JTextField();
	        JTextField textBloodGrp= new JTextField();
	        JTextField textQualification= new JTextField();
	        JTextField textAadharNo= new JTextField();
	        JTextField textUserName= new JTextField();
	        JTextField textPassword= new JTextField();
	        
	        //JButton btnAdd = new JButton("Add");
	        JButton btnDelete = new JButton("Delete");
	        JButton btnUpdate = new JButton("Update");     
	        JButton btnBack = new JButton("Back"); 
	       
	        textFullname.setBounds(20, 220, 100, 25);
	        textUserId.setBounds(20, 250, 100, 25);
	        textgender.setBounds(20, 280, 100, 25);
	        textAddress.setBounds(20, 310, 100, 25);
	        textContactNo.setBounds(20, 340, 100, 25);
	        textEmail.setBounds(20, 370, 100, 25);
	        textDOB.setBounds(20, 410, 100, 25);
	        textBloodGrp.setBounds(20, 440, 100, 25);
	        textQualification.setBounds(20, 470, 100, 25);
	        textAadharNo.setBounds(20, 500, 100, 25);
	        textUserName.setBounds(20, 530, 100, 25);
	        textPassword.setBounds(20, 560, 100, 25);
	        
	       // btnAdd.setBounds(150, 220, 100, 25);
	        btnUpdate.setBounds(150, 265, 100, 25);
	        btnDelete.setBounds(150, 310, 100, 25);
	        btnBack.setBounds(150, 360, 100, 25);

	        // create JScrollPane
	        JScrollPane pane = new JScrollPane(table);
	        pane.setBounds(0, 0, 1190, 200);
	        
	        frame.setLayout(null);
	        
	        frame.add(pane);
	        
	        // add JTextFields to the jframe
	        frame.add(textFullname);
	        frame.add(textUserId);
	        frame.add(textgender);
	        frame.add(textAddress);
	        frame.add(textContactNo);
	        frame.add(textEmail);
	        frame.add(textDOB);
	        frame.add(textBloodGrp);
	        frame.add(textQualification);
	        frame.add(textAadharNo);
	        frame.add(textUserName);
	        frame.add(textPassword);
	        
	        // add JButtons to the jframe
	       // frame.add(btnAdd);
	        frame.add(btnDelete);
	        frame.add(btnUpdate);
	        frame.add(btnBack);

	      
	        Object[] row = new Object[8];
	        /*btnAdd.addActionListener(new ActionListener(){

				@Override
				public void actionPerformed(ActionEvent arg0) {
					// TODO Auto-generated method stub
					  row[0] = textId.getText();
		                row[1] = textFname.getText();
		                row[2] = textLname.getText();
		                row[3] = textAge.getText();
		                
		                // add row to the model
		                model.addRow(row);
		            }
		        });*/
	        
	        btnDelete.addActionListener(new ActionListener(){

				@Override
				public void actionPerformed(ActionEvent arg0) {
					// TODO Auto-generated method stub
					  int i = table.getSelectedRow();
		                if(i >= 0){
		                    // remove a row from jtable
		                    model.removeRow(i);
		                }
		                else{
		                    System.out.println("Delete Error");
		                    
		                    
		                }
		            }
		        });
	        
	       
	        btnBack.addActionListener(new ActionListener(){

				@Override
				public void actionPerformed(ActionEvent obj) {
					// TODO Auto-generated method stub
					if(obj.getSource()== btnBack)
					{
						new AdminChoice();
					
					}
		            }
		        });
	        
	        
	        table.addMouseListener(new MouseAdapter(){
	            
	          
				@Override
	            public void mouseClicked(MouseEvent e){
	                
	                // i = the index of the selected row
	                int i = table.getSelectedRow();
	              
	                
	    	        textFullname.setText(model.getValueAt(i, 0).toString());
	    	        textUserId.setText(model.getValueAt(i, 1).toString());
	    	       textgender.setText(model.getValueAt(i, 2).toString());
	    	        textAddress.setText(model.getValueAt(i, 3).toString());
	    	       textContactNo.setText(model.getValueAt(i, 4).toString());
	    	        textEmail.setText(model.getValueAt(i, 5).toString());
	    	        textDOB.setText(model.getValueAt(i, 6).toString());
	    	        textBloodGrp.setText(model.getValueAt(i, 7).toString());
	    	        textQualification.setText(model.getValueAt(i, 8).toString());
	    	        textAadharNo .setText(model.getValueAt(i, 9).toString());
	    	        textUserName.setText(model.getValueAt(i, 10).toString());
	    	        textPassword.setText(model.getValueAt(i, 11).toString());
	    	        
	            }
	            });
	        
	        
	        btnUpdate.addActionListener(new ActionListener(){

				@Override
				public void actionPerformed(ActionEvent arg0) {
					// TODO Auto-generated method stub
					int i = table.getSelectedRow();
	                
	                if(i >= 0) 
	                {
	                   model.setValueAt(textFullname.getText(), i, 0);
	                   model.setValueAt(textUserId.getText(), i, 1);
	                  model.setValueAt(textgender.getText(), i, 2);
	                   model.setValueAt(textAddress.getText(), i, 3);
	                   model.setValueAt(textContactNo.getText(), i, 4);
	                   model.setValueAt(textEmail.getText(), i, 5);
	                   model.setValueAt(textDOB.getText(), i, 6);
	                   model.setValueAt(textBloodGrp.getText(), i, 7);
	                   model.setValueAt(textQualification.getText(), i, 8);
	                   model.setValueAt(textAadharNo.getText(), i, 9);
	                   model.setValueAt(textUserName.getText(), i, 10);
	                   model.setValueAt(textPassword.getText(), i, 11);
	                   
	                   
	                 
		              updateData();
		               
	                   
	                   
	                   
	                }
	                else{
	                    System.out.println("Update Error");
	                }
	            }
	        });
	        frame.setSize(1200,1000);
	        frame.setLocationRelativeTo(null);
	        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	        frame.setVisible(true);
	        
	     
	      
	}
	

	
	private void updateData()
	{
	
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
	
	String sql="update newuserregistration set Full_Name=?, User_Id=?, Gender=?, Permanent_Address=?, Email_Id=?, Contact_No=?, DOB=?, Qualification=?, Blood_Grp=?, Aadhar_No=?, Password=? where Username=?";
			try{
		//Class.forName("oracle.jdbc.driver.OracleDriver");
		Class.forName("com.mysql.jdbc.Driver");
		//Connection cn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1523:xe","system","root");
		Connection cn=DriverManager.getConnection("jdbc:mysql://localhost:3306/rtosystem","root","root");
		PreparedStatement ps=cn.prepareStatement(sql);
		
			//ps.setInt(1, 1);
		//  model.getValueAt(textFullname.getText(), i, 0);
          
		ps.setString(1, "Nikita");
		ps.setString(2, "Nik123");
		ps.setString(3, "Female");
		ps.setString(4, "Nashik");
		ps.setString(5, "nik@gmail.com" );
		ps.setString(6, "9806890987" );
		ps.setString(7, "09/09/2018" );
		ps.setString(8, "BE" );
		ps.setString(9, "A+" );
		ps.setString(10, "21345789098" );
		ps.setString(11, "nik12" );
		ps.setString(12, "nik" );
		
		int rowsUpdated = ps.executeUpdate();
		//System.out.println(ps.executeUpdate());
	
	
	System.out.println("User is Registred Successfully.......");
		}catch(Exception e1)
	{
		
		System.out.println(e1);
		

	}

	}

	private static void insertData() {
		// TODO Auto-generated method stub
		try{
			Class.forName("com.mysql.jdbc.Driver");
			
			
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/rtosystem","root","root");
			Statement stmt=con.createStatement();
		
			ResultSet rs=stmt.executeQuery("select * from newuserregistration");
			

			while(rs.next())
				{
	
		
				stringFullName  = rs.getString(1);
						//rs.getInt(1));
				stringUserId  = rs.getString(2);
				gender  =  rs.getString(3);
				stringAddress   =  rs.getString(4);
				stringContactNo  =  rs.getString(5);
				stringEmail    =  rs.getString(6);
				stringDOB   =  rs.getString(7);
				stringBloodGrp    =  rs.getString(8);
				stringQualification    =  rs.getString(9);
				stringAadharNo    =  rs.getString(10);
				stringUserName  =  rs.getString(11);
				stringPassword    =  rs.getString(12);
				
				
				
				 int count = model.getRowCount()+1;
				 model.addRow(new Object[]{stringFullName,stringUserId,gender,stringAddress,stringContactNo,stringEmail,stringDOB,stringBloodGrp,stringQualification,stringAadharNo,stringUserName,stringPassword});
				}
			
			con.close();

			}catch(Exception e){ 
				//System.out.println(e);
			}

		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//col_student_name ,col_student_gender ,col_address ,col_student_persnal_contact ,col_student_parent_contact ,col_student_email ,col_student_password ,col_student_course_c ,col_student_course_cpp ,col_student_course_java ,col_student_course_java_framework ,col_student_course_python ,col_student_course_android ,col_student_course_ios ,col_student_course_php ,col_student_course_dotnet ,col_student_course_plsql ,col_student_course_mysql ,col_student_course_oracle)values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
		new UpdateQuery();
		
	}



}
