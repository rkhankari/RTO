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


public class TableViewTestApplication4
{   
	private static DefaultTableModel model;
	public static String deleteStringSelectedColumn;
	
	public static String stringUsername,stringPassword,stringTestType;

   // public static String stringFullName,gender,stringAddress,stringBloodGrp,stringContactNo,stringDOB,stringVehicleDiscription,PreviousDrivingLicense,LicenseDisqualified,PaidFees;
    public static String stringUpdateUsername,stringUpdatePassword,stringUpdateTestType;
    
   
    TableViewTestApplication4()
	{
		 JFrame frame = new JFrame();
	       JTable table = new JTable(); 
	     
	     
	        model = new DefaultTableModel(new Object[]{"stringUsername","stringPassword","stringTestType"},0);
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
	        JTextField textUsername = new JTextField();
	        JTextField textPassword = new JTextField();
	        JTextField textTestType = new JTextField();
	       
	     //   JTextField textUserName= new JTextField();
	     //   JTextField textPassword= new JTextField();
	        
	        //JButton btnAdd = new JButton("Add");
	        JButton btnDelete = new JButton("Delete");
	        JButton btnUpdate = new JButton("Update");     
	        JButton btnBack = new JButton("Back"); 
	       
	        textUsername.setBounds(20, 220, 100, 25);
	        textPassword.setBounds(20, 250, 100, 25);
	        textTestType.setBounds(20, 280, 100, 25);
	       
	     //   textUserName.setBounds(20, 530, 100, 25);
	       // textPassword.setBounds(20, 560, 100, 25);
	        
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
	        frame.add(textUsername);
	        frame.add(textPassword);
	        frame.add(textTestType);
	       
	     //   frame.add(textUserName);
	       // frame.add(textPassword);
	        
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
		                if(i >= 0)
		                {
		                    // remove a row from jtable
		                    model.removeRow(i);
		                    deleteStringSelectedColumn = textUsername.getText().toString();
		                    
		                    deleteSingleColumn(deleteStringSelectedColumn);
		               // deleteStringSelectedColumn =  model.removeRow(i);
		                }
		                else
		                {
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
						PreparedStatement ps=con.prepareStatement("delete from testapplication where stringUsername=?");
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
	                
	    	    	
	               
	                
	                textUsername.setText(model.getValueAt(i, 0).toString());
	                textPassword.setText(model.getValueAt(i, 1).toString());
	    	        textTestType.setText(model.getValueAt(i, 2).toString());
	    	     
	    	      //  textUserName.setText(model.getValueAt(i, 10).toString());
	    	      //  textPassword.setText(model.getValueAt(i, 11).toString());
	    	        
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
	                   model.setValueAt(textUsername.getText(), i, 0);
	                   model.setValueAt(textPassword.getText(), i, 1);
	                  model.setValueAt(textTestType.getText(), i, 2);
	                 
	                 //  model.setValueAt(textUserName.getText(), i, 10);
	                 //  model.setValueAt(textPassword.getText(), i, 11);
	                   
	                   stringUpdateUsername = textUsername.getText().toString();
	                   stringUpdatePassword = textPassword.getText().toString();
	                   stringUpdateTestType = textTestType.getText().toString();
	                    
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
						
						 String sqlUpdate = "UPDATE testapplication "
								 + "SET stringUsername = ?,stringPassword=?,stringTestType=?"
					             +"WHERE stringUsername = ? and stringPassword=? and stringTestType=? ";  
					
						Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/rtosystem","root","root");
					
						PreparedStatement ps=con.prepareStatement(sqlUpdate);
						
						ps.setString(1, stringUpdateUsername);
						ps.setString(2, stringUpdatePassword );
						ps.setString(3, stringUpdateTestType  );
						

						ps.setString(4, stringUsername);
						ps.setString(5, stringPassword );
						ps.setString(6, stringTestType );
					
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
		
			ResultSet rs=stmt.executeQuery("select * from testapplication");
			

			while(rs.next())
				{
	
		
				stringUsername  = rs.getString(1);
						//rs.getInt(1));
				stringPassword  =  rs.getString(2);
				stringTestType   =  rs.getString(3);
				
				
				 int count = model.getRowCount()+1;
				 model.addRow(new Object[]{stringUsername,stringPassword,stringTestType});
				}
			
			con.close();

			}catch(Exception e){ 
				//System.out.println(e);
			}

		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//col_student_name ,col_student_gender ,col_address ,col_student_persnal_contact ,col_student_parent_contact ,col_student_email ,col_student_password ,col_student_course_c ,col_student_course_cpp ,col_student_course_java ,col_student_course_java_framework ,col_student_course_python ,col_student_course_android ,col_student_course_ios ,col_student_course_php ,col_student_course_dotnet ,col_student_course_plsql ,col_student_course_mysql ,col_student_course_oracle)values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
		new TableViewTestApplication4();
		
	}
}
