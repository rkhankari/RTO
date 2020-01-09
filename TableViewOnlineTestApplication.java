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
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableModel;

public class TableViewOnlineTestApplication extends JFrame implements ActionListener
{
	private JTable table;
	public JLabel background;
    private JButton btnBack,txtField3,txtField4,txtField5;
    private DefaultTableModel tableModel;
    private JTextField txtField1,txtField2,txtField6,txtField7,txtField8,txtField9,txtField10;
    public static String stringDate,stringTime,stringAddress;
    private JTextField tf_date,tf_time;
    private JTextArea ta_place;
    public  JButton btnDelete;
    
    TableViewOnlineTestApplication()
    {
    	
        super("TableViewOnlineTestApplication Entry");
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
        txtField4 = new JButton("UPDATE");
        txtField4.addActionListener(this);
        txtField5 = new JButton("DELETE");
        txtField5.addActionListener(this);
        txtField6 = new JTextField();
        txtField7 = new JTextField();
        txtField8 = new JTextField();
        txtField9 = new JTextField();
        txtField10 = new JTextField();


        JLabel lb1Field0 = new JLabel("Online Test Application Details");
        JLabel lblField1 = new JLabel("Test_Date");
        JLabel lblField2 = new JLabel("Test_Time");
        JLabel lblField3 = new JLabel("Permanent_Address");
       

        northPanel.add(lb1Field0);
        eastPanel.add(txtField3);
        eastPanel.add(txtField4);
        eastPanel.add(txtField5);
        
        
        setVisible(true);

        add(northPanel, BorderLayout.NORTH);
        add(eastPanel, BorderLayout.EAST);
        add(pane,BorderLayout.CENTER);
        tableModel = new DefaultTableModel(new Object[]{"Test_Date","Test_Time","Permanent_Address"},0);
        table.setModel(tableModel);
        
        insertData();
        deleteData();
        //btnAdd.addActionListener(this);
        /*new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
              
            }
        });*/
    }

	private void deleteData() 
	{

		try{
			Class.forName("com.mysql.jdbc.Driver");
			//Class.forName("oracle.jdbc.driver.OracleDriver");
			
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/rtosystem","root","root");
			//Connection cn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1523:xe","system","root");
			//here sonoo is the database name, root is the username and root is the password
			Statement stmt=con.createStatement();
			//PreparedStatement ps= cn.prepareStatement("select * from tbl_ajna");
		//	ResultSet rs=stmt.executeQuery("select * from onlinetest");
			ResultSet ps=stmt.executeQuery("select * from onlinetest");

//insert into tbl_institute(col_id,col_course,col_fees,col_duration,col_staff)values(1,'java','5000','2months','kanchan');
			while(ps.next())
				{
				//System.out.println(rs.getInt(1)+"  "+rs.getString(2));
				stringDate = ps.getString(1);
				stringTime=  ps.getString(2);
				stringAddress =  ps.getString(3);
				
				int count = tableModel.getRowCount()+1;
		        tableModel.addRow(new Object[]{stringDate,stringTime,stringAddress });
				}
			con.close();

			}catch(Exception e){ 
				//System.out.println(e);
			}

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
			ResultSet rs=stmt.executeQuery("select * from onlinetest");
			
//insert into tbl_institute(col_id,col_course,col_fees,col_duration,col_staff)values(1,'java','5000','2months','kanchan');
			while(rs.next())
				{
				//System.out.println(rs.getInt(1)+"  "+rs.getString(2));
				stringDate = rs.getString(1);
				stringTime=  rs.getString(2);
				stringAddress =  rs.getString(3);
				
				int count = tableModel.getRowCount()+1;
		        tableModel.addRow(new Object[]{stringDate,stringTime,stringAddress });
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
            	TableViewOnlineTestApplication frm = new TableViewOnlineTestApplication();
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
		else if(obj.getSource() == txtField4)
		{
			//this.dispose();
		//	new AdminChoice();
			//new UpdateTest();
			this.dispose();
     	}
		else if(obj.getSource() == txtField5)
		{
			//this.dispose();
     		 
		  // new DeleteTestDetails();
			this.dispose();
			//deleteData();
			//JOptionPane.showMessageDialog(btnDelete, "Deleted Successfully");
     	}
		
		/*if(arg0.getSource() == btnAdd)
		{*/
						/*int count = tableModel.getRowCount()+1;
	          tableModel.addRow(new Object[]{stringOwnerName,stringAddress,stringContactNo,stringAadharNo,stringVehicleClass,stringVehicleType,stringVehicleCategory,stringChasisNo,stringPurchaseDate});
		  int count = tableModel.getRowCount()+1;
          tableModel.addRow(new Object[]{stringCourse,stringFees,stringDuration,stringStaff});*/
		}
	}

	

	



