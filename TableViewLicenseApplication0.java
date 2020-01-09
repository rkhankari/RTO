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
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.AbstractButton;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;


public class TableViewLicenseApplication0 
{   
	private static DefaultTableModel model;
	public static String deleteStringSelectedColumn;
    public static String stringFullName,gender,stringAddress,stringBloodGrp,stringContactNo,stringDOB,
    stringVehicleDiscription,PreviousDrivingLicense,LicenseDisqualified,PaidFees,Username,Password;
    public static String stringUpdateFullName,genderUpdate,
    stringUpdateAddress,stringUpdateBloodGrp,stringUpdateContactNo,stringUpdateDOB,
    stringUpdateVehicleDiscription,UpdatePreviousDrivingLicense,UpdateLicenseDisqualified,
    UpdatePaidFees,UpdateUsername,UpdatePassword;
   
    TableViewLicenseApplication0()
	{
		 JFrame frame = new JFrame();
	       JTable table = new JTable(); 
	     
	     
	        model = new DefaultTableModel(new Object[]{"stringFullName","gender","stringAddress","stringBloodGrp","stringContactNo","stringDOB","stringVehicleDiscription","PreviousDrivingLicense","LicenseDisqualified","PaidFees","Username","Password"},0);
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
	        JTextField textgender = new JTextField();
	        JTextField textAddress = new JTextField();
	        JTextField textBloodGrp = new JTextField();
	        JTextField textContactNo= new JTextField();
	        JTextField textDOB= new JTextField();
	        JTextField textVehicleDiscription= new JTextField();
	        JTextField textPreviousDrivingLicense= new JTextField();
	        JTextField textLicenseDisqualified= new JTextField();
	        JTextField textPaidFees= new JTextField();
	       JTextField textUserName= new JTextField();
	       JTextField textPassword= new JTextField();
	        
	        //JButton btnAdd = new JButton("Add");
	        JButton btnDelete = new JButton("Delete");
	        JButton btnUpdate = new JButton("Update");     
	        JButton btnBack = new JButton("Back"); 
	       
	        textFullname.setBounds(20, 220, 100, 25);
	        textgender.setBounds(20, 250, 100, 25);
	        textAddress.setBounds(20, 280, 100, 25);
	        textBloodGrp.setBounds(20, 310, 100, 25);
	        textContactNo.setBounds(20, 340, 100, 25);
	        textDOB.setBounds(20, 370, 100, 25);
	        textVehicleDiscription.setBounds(20, 410, 100, 25);
	        textPreviousDrivingLicense.setBounds(20, 440, 100, 25);
	        textLicenseDisqualified.setBounds(20, 470, 100, 25);
	        textPaidFees.setBounds(20, 500, 100, 25);
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
	        frame.add(textgender);
	        frame.add(textAddress);
	        frame.add(textBloodGrp);
	        frame.add(textContactNo);
	        frame.add(textDOB);
	        frame.add(textVehicleDiscription);
	        frame.add(textPreviousDrivingLicense);
	        frame.add(textLicenseDisqualified);
	        frame.add(textPaidFees);
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
		                    deleteStringSelectedColumn = textFullname.getText().toString();
		                    deleteSingleColumn(deleteStringSelectedColumn);
		                  //  deleteStringSelectedColumn =  model.removeRow(i);
		                }
		                else{
		                    System.out.println("Delete Error");
		                    
		                    
		                }
		            }

				public void deleteSingleColumn(String deleteStringSelectedColumn)
				{
					deleteStringSelectedColumn = deleteStringSelectedColumn;
					// TODO Auto-generated method stub
					try {
						Class.forName("com.mysql.jdbc.Driver");
						Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/rtosystem","root","root");
						PreparedStatement ps=con.prepareStatement("delete from licenseapplication where stringFullName=?");
/*						 String sqlUpdate = "UPDATE test "
					                + "SET name=? , lname = ? "
					                + "WHERE name = ? and lname = ?";
*/						// PreparedStatement ps=con.prepareStatement(sqlUpdate);
						ps.setString(1, deleteStringSelectedColumn);
						 int i=ps.executeUpdate();
						//con.commit();
						System.out.println(i);
						
					} catch (ClassNotFoundException | SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
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
	    	       textgender.setText(model.getValueAt(i, 1).toString());
	    	       textAddress.setText(model.getValueAt(i, 2).toString());
	    	       textBloodGrp.setText(model.getValueAt(i, 3).toString());
	    	       textContactNo.setText(model.getValueAt(i, 4).toString());
	    	       textDOB.setText(model.getValueAt(i, 5).toString());
	    	       textVehicleDiscription.setText(model.getValueAt(i, 6).toString());
	    	       textPreviousDrivingLicense.setText(model.getValueAt(i, 7).toString());
	    	       textLicenseDisqualified.setText(model.getValueAt(i, 8).toString());
	    	       textPaidFees .setText(model.getValueAt(i, 9).toString());
	    	       textUserName.setText(model.getValueAt(i, 10).toString());
	    	       textPassword.setText(model.getValueAt(i, 11).toString());
	    	        
	            }
	            });
	        
	        //table madhe data update zala
	        btnUpdate.addActionListener(new ActionListener(){

				@Override
				public void actionPerformed(ActionEvent arg0) {
					// TODO Auto-generated method stub
					int i = table.getSelectedRow();
	                
	                if(i >= 0) 
	                {
	                   model.setValueAt(textFullname.getText(), i, 0);
	                   model.setValueAt(textgender.getText(), i, 1);
	                  model.setValueAt(textAddress.getText(), i, 2);
	                   model.setValueAt(textBloodGrp.getText(), i, 3);
	                   model.setValueAt(textContactNo.getText(), i, 4);
	                   model.setValueAt(textDOB.getText(), i, 5);
	                   model.setValueAt(textVehicleDiscription.getText(), i, 6);
	                   model.setValueAt(textPreviousDrivingLicense.getText(), i, 7);
	                   model.setValueAt(textLicenseDisqualified.getText(), i, 8);
	                   model.setValueAt(textPaidFees.getText(), i, 9);
	                   model.setValueAt(textUserName.getText(), i, 10);
	                   model.setValueAt(textPassword.getText(), i, 11);
	                   
	                    stringUpdateFullName = textFullname.getText().toString();
	                    genderUpdate = textgender.getText().toString();
	                    stringUpdateAddress = textAddress.getText().toString();
	                    stringUpdateBloodGrp = textBloodGrp.getText().toString();
	                    stringUpdateContactNo = textContactNo.getText().toString();
	                    stringUpdateDOB = textDOB.getText().toString();
	                    stringUpdateVehicleDiscription = textVehicleDiscription.getText().toString();
	                    UpdatePreviousDrivingLicense = textPreviousDrivingLicense.getText().toString() ;
	                    UpdateLicenseDisqualified = textLicenseDisqualified.getText().toString();
	                    UpdatePaidFees = textPaidFees.getText().toString();
	                   UpdateUsername = textUserName.getText().toString();
	                   UpdatePassword = textPassword.getText().toString();
	                   
	                   
	                   
	                   updateTableDataInMySqlDatabase();
	                   
	                   
	                   
	                   
	                }
	                else{
	                    System.out.println("Update Error");
	                }
	            }
//table cha updated data la database madhe takto....
				private void updateTableDataInMySqlDatabase() 
				{
					// TODO Auto-generated method stub
					try{
						Class.forName("com.mysql.jdbc.Driver");
						
						//String stringUpdate = "insert into licenseapplication(stringFullName,gender,stringAddress,stringBloodGrp,stringContactNo,stringDOB,stringVehicleDiscription,PreviousDrivingLicense,LicenseDisqualified,PaidFees)values(?,?,?,?,?,?,?,?,?,?)";
						
						 String sqlUpdate = "UPDATE licenseapplication "
								 + "SET stringFullName = ?,gender=?,stringAddress=?,stringBloodGrp=?,stringContactNo=?,stringDOB=?,stringVehicleDiscription=?,PreviousDrivingLicense=?,LicenseDisqualified=?,PaidFees=?, Username=?, Password=?"
					             +"WHERE stringFullName = ? and gender=? and stringAddress=? and stringBloodGrp=? and stringContactNo=? and stringDOB=? and stringVehicleDiscription=? and PreviousDrivingLicense=? and LicenseDisqualified=? and PaidFees=? and Username=? and Password=?";  
					
						Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/rtosystem","root","root");
					
						PreparedStatement ps=con.prepareStatement(sqlUpdate);
						
						ps.setString(1, stringUpdateFullName);
						ps.setString(2, genderUpdate );
						ps.setString(3, stringUpdateAddress );
						ps.setString(4, stringUpdateBloodGrp );
						ps.setString(5, stringUpdateContactNo );
						ps.setString(6,stringUpdateDOB);
						ps.setString(7, stringUpdateVehicleDiscription );
						ps.setString(8, UpdatePreviousDrivingLicense );
						ps.setString(9, UpdateLicenseDisqualified );
						ps.setString(10, UpdatePaidFees );
						ps.setString(11, UpdateUsername );
						ps.setString(12, UpdatePassword );
						
						ps.setString(13, stringFullName);
						ps.setString(14, gender );
						ps.setString(15, stringAddress );
						ps.setString(16, stringBloodGrp );
						ps.setString(17, stringContactNo );
						ps.setString(18,stringDOB);
						ps.setString(19, stringVehicleDiscription );
						ps.setString(20, PreviousDrivingLicense );
						ps.setString(21, LicenseDisqualified );
						ps.setString(22,PaidFees );
						ps.setString(23, Username );
						ps.setString(24, Password );
						

						System.out.println(ps.executeUpdate());


						}catch(Exception e){ 
							//System.out.println(e);
						}

				}
	        });
	        frame.setSize(1200,1000);
	        frame.setLocationRelativeTo(null);
	        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	        frame.setVisible(true);
	        
	     
	      
	}

	private static void insertData() {
		// TODO Auto-generated method stub
		try{
			Class.forName("com.mysql.jdbc.Driver");
			
			
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/rtosystem","root","root");
			Statement stmt=con.createStatement();
		
			ResultSet rs=stmt.executeQuery("select * from licenseapplication");
			

			while(rs.next())
				{
	
		
				stringFullName  = rs.getString(1);
						//rs.getInt(1));
				gender  =  rs.getString(2);
				stringAddress   =  rs.getString(3);
				stringBloodGrp  =  rs.getString(4);
				stringContactNo    =  rs.getString(5);
				stringDOB   =  rs.getString(6);
				stringVehicleDiscription    =  rs.getString(7);
				PreviousDrivingLicense    =  rs.getString(8);
				LicenseDisqualified    =  rs.getString(9);
				PaidFees   =  rs.getString(10);
			
			Username  =  rs.getString(11);
			Password    =  rs.getString(12);
				
				
				
				 int count = model.getRowCount()+1;
				 model.addRow(new Object[]{stringFullName,gender,stringAddress,stringBloodGrp,stringContactNo,stringDOB,stringVehicleDiscription,PreviousDrivingLicense,LicenseDisqualified,PaidFees,Username,Password});
				}
			
			con.close();

			}catch(Exception e){ 
				//System.out.println(e);
			}

		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//col_student_name ,col_student_gender ,col_address ,col_student_persnal_contact ,col_student_parent_contact ,col_student_email ,col_student_password ,col_student_course_c ,col_student_course_cpp ,col_student_course_java ,col_student_course_java_framework ,col_student_course_python ,col_student_course_android ,col_student_course_ios ,col_student_course_php ,col_student_course_dotnet ,col_student_course_plsql ,col_student_course_mysql ,col_student_course_oracle)values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
		new TableViewLicenseApplication0();
		
	}
}
