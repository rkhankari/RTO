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


public class TableViewVehicleRegistration5 
{   
	private static DefaultTableModel model;
	public static String stringOwnerName,stringAddress,stringContactNo,stringAadharNo,stringVehicleClass,stringVehicleType,stringVehicleCategory,stringChasisNo,stringPurchaseDate ;
	public static String stringUserName,stringPassword;
	public static String deleteStringSelectedColumn;
    public static String stringUpdateOwnerName,
    stringUpdateAddress,stringUpdateContactNo,stringUpdateAadharNo,
    UpdateVehicleClass,UpdateVehicleType,UpdateVehicleCategory,
    UpdateChasisNo,UpdatePurchaseDate,UpdateUsername,UpdatePassword;
	   
	   
	TableViewVehicleRegistration5()
	{
		JFrame frame = new JFrame();
        JTable table = new JTable(); 
     
     
        model = new DefaultTableModel(new Object[]{"stringOwnerName","stringAddress","stringContactNo","stringAadharNo","stringVehicleClass","stringVehicleType","stringVehicleCategory","stringChasisNo","stringPurchaseDate","stringUserName","stringPassword"},0);
        table.setModel(model);
      
     //   table.setModel(model);
       insertData();
        
        table.setBackground(Color.LIGHT_GRAY);
        table.setForeground(Color.black);
        Font font = new Font("",1,22);
        table.setFont(font);
        table.setRowHeight(30);
        
        
        JTextField textOwnerName = new JTextField();
        JTextField textAddress = new JTextField();
        JTextField textContactNo = new JTextField();
        JTextField textAadharNo = new JTextField();
        JTextField textVehicleClass= new JTextField();
        JTextField textVehicleType= new JTextField();
        JTextField textVehicleCategory= new JTextField();
        JTextField textChasisNo= new JTextField();
        JTextField textPurchaseDate= new JTextField();
        JTextField textUserName= new JTextField();
        JTextField textPassword= new JTextField();
      
        
        //JButton btnAdd = new JButton("Add");
        JButton btnDelete = new JButton("Delete");
        JButton btnUpdate = new JButton("Update");     
        JButton btnBack = new JButton("Back"); 

        textOwnerName.setBounds(20, 220, 100, 25);
        textAddress.setBounds(20, 250, 100, 25);
        textContactNo.setBounds(20, 280, 100, 25);
        textAadharNo.setBounds(20, 310, 100, 25);
        textVehicleClass.setBounds(20, 340, 100, 25);
        textVehicleType.setBounds(20, 370, 100, 25);
        textVehicleCategory.setBounds(20, 410, 100, 25);
        textChasisNo.setBounds(20, 440, 100, 25);
        textPurchaseDate.setBounds(20, 470, 100, 25);
        textUserName.setBounds(20, 500, 100, 25);
        textPassword.setBounds(20, 530, 100, 25);
        
      
        
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
        frame.add(textOwnerName);
        frame.add(textAddress);
        frame.add(textContactNo);
        frame.add(textAadharNo);
        frame.add(textVehicleClass);
        frame.add(textVehicleType);
        frame.add(textVehicleCategory);
        frame.add(textChasisNo);
        frame.add(textPurchaseDate);
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
	                    deleteStringSelectedColumn = textOwnerName.getText().toString();
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
				PreparedStatement ps=con.prepareStatement("delete from vehicleregistration where stringOwnerName=?");
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
                
    	    	
               
                
                textOwnerName.setText(model.getValueAt(i, 0).toString());
                textAddress.setText(model.getValueAt(i, 1).toString());
                textContactNo.setText(model.getValueAt(i, 2).toString());
                textAadharNo.setText(model.getValueAt(i, 3).toString());
                textVehicleClass.setText(model.getValueAt(i, 4).toString());
                textVehicleType.setText(model.getValueAt(i, 5).toString());
                textVehicleCategory.setText(model.getValueAt(i, 6).toString());
                textChasisNo.setText(model.getValueAt(i, 7).toString());
                textPurchaseDate.setText(model.getValueAt(i, 8).toString());
                textUserName.setText(model.getValueAt(i, 9).toString());
                textPassword.setText(model.getValueAt(i, 10).toString());
    	      
    	        
            }
            });
        
        
        btnUpdate.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				int i = table.getSelectedRow();
                
                if(i >= 0) 
                {
                   model.setValueAt(textOwnerName.getText(), i, 0);
                   model.setValueAt(textAddress.getText(), i, 1);
                   model.setValueAt(textContactNo.getText(), i, 2);
                   model.setValueAt(textAadharNo.getText(), i, 3);
                   model.setValueAt(textVehicleClass.getText(), i, 4);
                   model.setValueAt(textVehicleType.getText(), i, 5);
                   model.setValueAt(textVehicleCategory.getText(), i, 6);
                   model.setValueAt(textChasisNo.getText(), i, 7);
                   model.setValueAt(textPurchaseDate.getText(), i, 8);
                   model.setValueAt(textUserName.getText(), i, 9);
                   model.setValueAt(textPassword.getText(), i, 10);
                   
                   stringUpdateOwnerName = textOwnerName.getText().toString();
                   stringUpdateAddress = textAddress.getText().toString();
                   stringUpdateContactNo = textContactNo.getText().toString();
                   stringUpdateAadharNo = textAadharNo.getText().toString();
                   UpdateVehicleClass = textVehicleClass.getText().toString();
                   UpdateVehicleType = textVehicleType.getText().toString();
                   UpdateVehicleCategory = textVehicleCategory.getText().toString();
                   UpdateChasisNo = textChasisNo.getText().toString() ;
                   UpdatePurchaseDate = textPurchaseDate.getText().toString();
                 
                   UpdateUsername = textUserName.getText().toString();
                   UpdatePassword = textPassword.getText().toString();
                  
                  
                  
                  updateTableDataInMySqlDatabase();
                  
                   
                   
                }
                else{
                    System.out.println("Update Error");
                }
            }

			private void updateTableDataInMySqlDatabase() 
			{
				// TODO Auto-generated method stub
				try{
					Class.forName("com.mysql.jdbc.Driver");
	//        model = new DefaultTableModel(new Object[]{"stringOwnerName","stringAddress","stringContactNo","stringAadharNo","stringVehicleClass","stringVehicleType","stringVehicleCategory","stringChasisNo","stringPurchaseDate","stringUserName","stringPassword"},0);
				
					
					 String sqlUpdate = "UPDATE vehicleregistration "
							 + "SET stringOwnerName = ?,stringAddress=?,stringContactNo=?,stringAadharNo=?,stringVehicleClass=?,stringVehicleType=?,stringVehicleCategory=?,stringChasisNo=?,stringPurchaseDate=?,stringUserName=?, stringPassword=?"
				             +"WHERE stringOwnerName = ? and stringAddress=? and stringContactNo=? and stringAadharNo=? and stringVehicleClass=? and stringVehicleType=? and stringVehicleCategory=? and stringChasisNo=? and stringPurchaseDate=? and stringUserName=? and stringPassword=?";  
				
					Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/rtosystem","root","root");
				
					PreparedStatement ps=con.prepareStatement(sqlUpdate);
					
					ps.setString(1, stringUpdateOwnerName);
					ps.setString(2, stringUpdateAddress );
					ps.setString(3, stringUpdateContactNo );
					ps.setString(4, stringUpdateAadharNo );
					ps.setString(5, UpdateVehicleClass );
					ps.setString(6, UpdateVehicleType);
					ps.setString(7, UpdateVehicleCategory );
					ps.setString(8, UpdateChasisNo );
					ps.setString(9, UpdatePurchaseDate );
					ps.setString(10, UpdateUsername );
					ps.setString(11, UpdatePassword );

			//        model = new DefaultTableModel(new Object[]{"stringOwnerName","stringAddress","stringContactNo","stringAadharNo","stringVehicleClass","stringVehicleType","stringVehicleCategory","stringChasisNo","stringPurchaseDate","stringUserName","stringPassword"},0);

					ps.setString(12, stringOwnerName);
					ps.setString(13, stringAddress );
					ps.setString(14, stringContactNo );
					ps.setString(15, stringAadharNo );
					ps.setString(16, stringVehicleClass );
					ps.setString(17, stringVehicleType);
					ps.setString(18, stringVehicleCategory );
					ps.setString(19, stringChasisNo );
					ps.setString(20, stringPurchaseDate );
					ps.setString(21, stringUserName );
					ps.setString(22, stringPassword );
					

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
	
		ResultSet rs=stmt.executeQuery("select * from vehicleregistration");
		

		while(rs.next())
			{

	
			stringOwnerName  = rs.getString(1);
					//rs.getInt(1));
			stringAddress  = rs.getString(2);
			stringContactNo  =  rs.getString(3);
			
			stringAadharNo    =  rs.getString(4);
			stringVehicleClass   =  rs.getString(5);
			stringVehicleType    =  rs.getString(6);
			stringVehicleCategory    =  rs.getString(7);
			stringChasisNo    =  rs.getString(8);
			stringPurchaseDate= rs.getString(9);
			stringUserName = rs.getString(10);
			stringPassword = rs.getString(11);
			
			 int count = model.getRowCount()+1;
			 model.addRow(new Object[]{stringOwnerName,stringAddress,stringContactNo,stringAadharNo,stringVehicleClass,stringVehicleType,stringVehicleCategory,stringChasisNo,stringPurchaseDate,stringUserName,stringPassword });
			}
		
		con.close();

		}catch(Exception e){ 
			//System.out.println(e);
		}

	
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//col_student_name ,col_student_gender ,col_address ,col_student_persnal_contact ,col_student_parent_contact ,col_student_email ,col_student_password ,col_student_course_c ,col_student_course_cpp ,col_student_course_java ,col_student_course_java_framework ,col_student_course_python ,col_student_course_android ,col_student_course_ios ,col_student_course_php ,col_student_course_dotnet ,col_student_course_plsql ,col_student_course_mysql ,col_student_course_oracle)values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
		
       new TableViewVehicleRegistration5();
	}



}
