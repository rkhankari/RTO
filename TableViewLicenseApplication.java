package swingwithjdbcpkg;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableModel;

public class TableViewLicenseApplication extends JFrame implements ActionListener
{
	private JTable table;
	public JLabel background;
    private JButton btnBack,txtField3;
    private DefaultTableModel tableModel;
    public static String stringUserName,stringPassword;
    private JTextField txtField1,txtField2,txtField4,txtField5,txtField6,txtField7,txtField8,txtField9,txtField10;
    public static String stringFullName,gender,stringAddress,stringBloodGrp,stringContactNo,stringDOB,stringVehicleDiscription,PreviousDrivingLicense,LicenseDisqualified,PaidFees;
    
    TableViewLicenseApplication()
    {
    	
        super("TableViewLicenseApplication Entry");
        setSize(1350,800);
        setLayout(null);
    	createGUI();
        
    }
  
    private void createGUI() {
    	
        setLayout(new BorderLayout());
        JScrollPane pane = new JScrollPane();
        table = new JTable();
        pane.setViewportView(table);
        JPanel eastPanel = new JPanel();
        //btnAdd = new JButton("Add");
      //  eastPanel.add(btnAdd);
        JPanel northPanel = new JPanel();
        txtField1 = new JTextField();
        txtField2 = new JTextField();
        txtField3 = new JButton("BACK ");
        txtField3.addActionListener(this);
        txtField4 = new JTextField();
        txtField5 = new JTextField();
        txtField6 = new JTextField();
        txtField7 = new JTextField();
        txtField8 = new JTextField();
        txtField9 = new JTextField();
        txtField10 = new JTextField();

      //  tableModel = new DefaultTableModel(new Object[]{"Full_Name", "Gender", "Permanent_Address", "Blood_Grp", "Contact_No", "DOB", "Vehicle_Discription", "Previous_Driving_License", "License_Disqualified", "PaidFees"},0);

        JLabel lb1Field0 = new JLabel("License Application Details");
        JLabel lblField1 = new JLabel("Full_Name   ");
        JLabel lblField2 = new JLabel("Gender   ");
        JLabel lblField3 = new JLabel("Permanent_Address   ");
        JLabel lblField4 = new JLabel("Blood_Grp   ");
        JLabel lblField5 = new JLabel("Contact_No   ");
        JLabel lblField6 = new JLabel("DOB   ");
        JLabel lblField7 = new JLabel("Vehicle_Discription   ");
        JLabel lblField8 = new JLabel("Previous_Driving_License   ");
        JLabel lblField9 = new JLabel("License_Disqualified   ");
        JLabel lblField10 = new JLabel("PaidFees   ");

        northPanel.add(lb1Field0);
        eastPanel.add(txtField3);

       /* northPanel.add(lblField1);
       // northPanel.add(txtField1);
        northPanel.add(lblField2);
      //  northPanel.add(txtField2);
        northPanel.add(lblField3);
      //  northPanel.add(txtField3);
        northPanel.add(lblField4);
       // northPanel.add(txtField4);
        northPanel.add(lblField5);
        northPanel.add(lblField6);
        northPanel.add(lblField7);
        northPanel.add(lblField8);
        northPanel.add(lblField9);*/
        
            
     /*   txtField1.setPreferredSize(lblField1.getPreferredSize());
        txtField2.setPreferredSize(lblField2.getPreferredSize());
        txtField3.setPreferredSize(lblField3.getPreferredSize());
        txtField4.setPreferredSize(lblField4.getPreferredSize());
     */   
        
        
       
		
        setVisible(true);

        add(northPanel, BorderLayout.NORTH);
        add(eastPanel, BorderLayout.EAST);
        add(pane,BorderLayout.CENTER);
        tableModel = new DefaultTableModel(new Object[]{"Full_Name", "Gender", "Permanent_Address", "Blood_Grp", "Contact_No", "DOB", "Vehicle_Discription", "Previous_Driving_License", "License_Disqualified", "PaidFees"},0);
        table.setModel(tableModel);
        
        insertData();
        //btnAdd.addActionListener(this);
        /*new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
              
            }
        });*/
    }

	private void insertData() {
		// TODO Auto-generated method stub

		try{
			Class.forName("com.mysql.jdbc.Driver");
			//Class.forName("oracle.jdbc.driver.OracleDriver");
			
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/rtosystem","root","root");
			//Connection cn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1523:xe","system","root");
			//here sonoo is the database name, root is the username and root is the password
			Statement stmt=con.createStatement();
			//PreparedStatement ps= cn.prepareStatement("select * from tbl_ajna");
			ResultSet rs=stmt.executeQuery("select * from licenseapplication");
			
//insert into tbl_institute(col_id,col_course,col_fees,col_duration,col_staff)values(1,'java','5000','2months','kanchan');
			while(rs.next())
				{
				//System.out.println(rs.getInt(1)+"  "+rs.getString(2));
				stringFullName = rs.getString(1);
				gender =  rs.getString(2);
				stringAddress =  rs.getString(3);
				stringBloodGrp =  rs.getString(4);
				stringContactNo =  rs.getString(5);
				stringDOB =  rs.getString(6);
				stringVehicleDiscription =  rs.getString(7);
				PreviousDrivingLicense =  rs.getString(8);
				LicenseDisqualified =  rs.getString(9);
				PaidFees =  rs.getString(10);
		
				int count = tableModel.getRowCount()+1;
		        tableModel.addRow(new Object[]{stringFullName,gender,stringAddress,stringBloodGrp,stringContactNo,stringDOB,stringVehicleDiscription,PreviousDrivingLicense,LicenseDisqualified,PaidFees  });
				}
			con.close();

			}catch(Exception e){ 
				//System.out.println(e);
			}

	}

	public static void main(String[] args) 
	{
		SwingUtilities.invokeLater(new Runnable() {

            @Override
            public void run() {
            	TableViewVehicleRegistration frm = new TableViewVehicleRegistration();
               //frm.setLocationByPlatform(true);
               // frm.pack();
               // frm.setDefaultCloseOperation(EXIT_ON_CLOSE);
                frm.setVisible(true);

            }

        });
    }

	@Override
	public void actionPerformed(ActionEvent obj) {
		// TODO Auto-generated method stub
		
		String cmd = obj.getActionCommand();

		//if(cmd.equals("Back"))
		if(obj.getSource() == txtField3)
		{
			//this.dispose();
			new AdminChoice();
			this.dispose();
     	}
		
		/*if(arg0.getSource() == btnAdd)
		{*/
						/*int count = tableModel.getRowCount()+1;
	          tableModel.addRow(new Object[]{stringOwnerName,stringAddress,stringContactNo,stringAadharNo,stringVehicleClass,stringVehicleType,stringVehicleCategory,stringChasisNo,stringPurchaseDate});
		  int count = tableModel.getRowCount()+1;
          tableModel.addRow(new Object[]{stringCourse,stringFees,stringDuration,stringStaff});*/
		}
	}

	

	



