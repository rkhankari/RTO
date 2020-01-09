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

public class TableViewVehicleRegistration extends JFrame implements ActionListener
{
	private JTable table;
	public JLabel background;
    private JButton btnBack,txtField3;
    private DefaultTableModel tableModel;
    public static String stringUserName,stringPassword;
    private JTextField txtField1,txtField2,txtField4,txtField5,txtField6,txtField7,txtField8,txtField9;
    public static String stringOwnerName,stringAddress,stringContactNo,stringAadharNo,stringVehicleClass,stringVehicleType,stringVehicleCategory,stringChasisNo,stringPurchaseDate;

    TableViewVehicleRegistration()
    {
    	
        super("TableViewVehicleRegistration Entry");
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
        
        JLabel lb1Field0 = new JLabel("Vehicle Registration Details");
        JLabel lblField1 = new JLabel("Owner_Name   ");
        JLabel lblField2 = new JLabel("Permanent_Address   ");
        JLabel lblField3 = new JLabel("Contact_No   ");
        JLabel lblField4 = new JLabel("Aadhar_No   ");
        JLabel lblField5 = new JLabel("Vehicle_Class   ");
        JLabel lblField6 = new JLabel("Vehicle_Type   ");
        JLabel lblField7 = new JLabel("Vehicle_Category   ");
        JLabel lblField8 = new JLabel("Chasis_No   ");
        JLabel lblField9 = new JLabel("Purchase_Date   ");

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
        
        
     /*   btnBack = new JButton("Back");
		btnBack.setBounds(1000, 10, 20, 20);
		add(btnBack);
		btnBack.addActionListener(this);
		btnBack.setActionCommand("Back");	//Add action listener to btnCancel
	*/								
		
        setVisible(true);

        add(northPanel, BorderLayout.NORTH);
        add(eastPanel, BorderLayout.EAST);
        add(pane,BorderLayout.CENTER);
        tableModel = new DefaultTableModel(new Object[]{"Owner_Name", "Permanent_Address", "Contact_No", "Aadhar_No", "Vehicle_Class", "Vehicle_Type", "Vehicle_Category", "Chasis_No", "Purchase_Date"},0);
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
			System.out .println("hi1");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/rtosystem","root","root");
			System.out .println("hi2");
					//Connection cn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1523:xe","system","root");
			//here sonoo is the database name, root is the username and root is the password
			Statement stmt=con.createStatement();
			//PreparedStatement ps= cn.prepareStatement("select * from tbl_ajna");
			ResultSet rs=stmt.executeQuery("select * from vehicleregistration");
			
//insert into tbl_institute(col_id,col_course,col_fees,col_duration,col_staff)values(1,'java','5000','2months','kanchan');
			while(rs.next())
				{
				//System.out.println(rs.getInt(1)+"  "+rs.getString(2));
				stringOwnerName = rs.getString(1);
				stringAddress =  rs.getString(2);
				stringContactNo =  rs.getString(3);
				stringAadharNo =  rs.getString(4);
				stringVehicleClass =  rs.getString(5);
				stringVehicleType =  rs.getString(6);
				stringVehicleCategory =  rs.getString(7);
				stringChasisNo =  rs.getString(8);
				stringPurchaseDate =  rs.getString(9);
				
				
				
				int count = tableModel.getRowCount()+1;
		        tableModel.addRow(new Object[]{stringOwnerName,stringAddress,stringContactNo,stringAadharNo,stringVehicleClass,stringVehicleType,stringVehicleCategory,stringChasisNo,stringPurchaseDate});
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

	

	



