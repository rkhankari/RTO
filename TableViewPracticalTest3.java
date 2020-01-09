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


public class TableViewPracticalTest3
{   
	private static DefaultTableModel model;
	public static String stringDate,stringTime,stringAddress;
    public static String stringUpdateDate,stringUpdateTime,stringUpdateAddress;
	public static String deleteStringSelectedColumn;
	
    TableViewPracticalTest3()
	{
		 JFrame frame = new JFrame();
	        JTable table = new JTable(); 
	     
	     
	        model = new DefaultTableModel(new Object[]{"stringDate","stringTime","stringAddress"},0);
	        table.setModel(model);
	      
	     //   table.setModel(model);
	       insertData();
	        
	        table.setBackground(Color.LIGHT_GRAY);
	        table.setForeground(Color.black);
	        Font font = new Font("",1,22);
	        table.setFont(font);
	        table.setRowHeight(30);
	        
	        
	        JTextField textDate = new JTextField();
	        JTextField textTime = new JTextField();
	        JTextField textAddress = new JTextField();
	      
	        
	        //JButton btnAdd = new JButton("Add");
	        JButton btnDelete = new JButton("Delete");
	        JButton btnUpdate = new JButton("Update");     
	        JButton btnBack = new JButton("Back"); 
	        
	        textDate.setBounds(20, 220, 100, 25);
	        textTime.setBounds(20, 250, 100, 25);
	        textAddress.setBounds(20, 280, 100, 25);
	      
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
	        frame.add(textDate);
	        frame.add(textTime);
	        frame.add(textAddress);
	       
	        
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
                          deleteStringSelectedColumn = textDate.getText().toString();
		                    
		                    deleteSingleColumn(deleteStringSelectedColumn);
		                    
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
						PreparedStatement ps=con.prepareStatement("delete from practicaltest where stringDate=?");
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
	                
	    	    	
	               
	                
	                textDate.setText(model.getValueAt(i, 0).toString());
	                textTime.setText(model.getValueAt(i, 1).toString());
	    	       textAddress.setText(model.getValueAt(i, 2).toString());
	    	      
	            }
	            });
	        
	        
	        btnUpdate.addActionListener(new ActionListener(){

				@Override
				public void actionPerformed(ActionEvent arg0) {
					// TODO Auto-generated method stub
					int i = table.getSelectedRow();
	                
	                if(i >= 0) 
	                {
	                   model.setValueAt(textDate.getText(), i, 0);
	                   model.setValueAt(textTime.getText(), i, 1);
	                  model.setValueAt(textAddress.getText(), i, 2);
	                  
	                  
	                  stringUpdateDate = textDate.getText().toString();
	                  stringUpdateTime = textTime.getText().toString();
	                  stringUpdateAddress = textAddress.getText().toString();
	                    
	                   updateTableDataInMySqlDatabase();
	                      
	            
	                   
	                }
	                else
	                {
	                    System.out.println("Update Error");
	                }
	            }
				
				private void updateTableDataInMySqlDatabase() 
				{
					// TODO Auto-generated method stub
					try{
						Class.forName("com.mysql.jdbc.Driver");
						
					//	 model.addRow(new Object[]{stringDate,stringTime,stringAddress});
	
						 String sqlUpdate = "UPDATE practicaltest "
								 + "SET stringDate = ?,stringTime=?,stringAddress=?"
					             +"WHERE stringDate = ? and stringTime=? and stringAddress=? ";  
					
						Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/rtosystem","root","root");
					
						PreparedStatement ps=con.prepareStatement(sqlUpdate);
						
						ps.setString(1, stringUpdateDate);
						ps.setString(2, stringUpdateTime );
						ps.setString(3, stringUpdateAddress  );
						

						ps.setString(4, stringDate);
						ps.setString(5, stringTime );
						ps.setString(6, stringAddress );
					
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
		
			ResultSet rs=stmt.executeQuery("select * from practicaltest");
			

			while(rs.next())
				{
	
		
				stringDate  = rs.getString(1);
						//rs.getInt(1));
				stringTime = rs.getString(2);
				stringAddress =  rs.getString(3);
			
				
				 int count = model.getRowCount()+1;
				 model.addRow(new Object[]{stringDate,stringTime,stringAddress});
				}
			
			con.close();

			}catch(Exception e){ 
				//System.out.println(e);
			}

	}
	public static void main(String[] args)
	{
		// TODO Auto-generated method stub
		
		//col_student_name ,col_student_gender ,col_address ,col_student_persnal_contact ,col_student_parent_contact ,col_student_email ,col_student_password ,col_student_course_c ,col_student_course_cpp ,col_student_course_java ,col_student_course_java_framework ,col_student_course_python ,col_student_course_android ,col_student_course_ios ,col_student_course_php ,col_student_course_dotnet ,col_student_course_plsql ,col_student_course_mysql ,col_student_course_oracle)values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
		new TableViewOnlineTest2();
		
		
	}



}
