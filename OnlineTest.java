package swingwithjdbcpkg;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class OnlineTest extends JFrame implements ActionListener
{

	public static String stringDate,stringTime,stringAddress;
	
    public JLabel lb_title,lb_date,lb_time,lb_place,lb_result,lb_ol;
	
	public  JLabel lb_hint0, lb_hint1, lb_hint2, lb_hint3, lb_hint4, lb_hintFinal,show1;	//Label for showing text field
	public  JTextField tf_date,tf_time,tf_result;
	public  JTextArea ta_place;
	public  JButton btnSubmit,btnCancel,btnBack;
	public  String show;
		
	OnlineTest()
	{
		//frame layout
				//f =  new JFrame();
				super("Onlinetest Form");
				//setLayout(null);
				setSize(1050, 800);
						
				//adding components
		//1)Labels
				
				//title
				lb_title = new JLabel("*****ONLINE TEST FORM*****");
				lb_title.setFont(new java.awt.Font("Times New Roman",3,18));

				lb_title.setBounds(190, 20, 450, 20);
				//add(lb_title,BorderLayout.CENTER);
				add(lb_title);
				//date
				lb_date = new JLabel("*  DATE OF TEST:");		
				lb_date.setBounds(50, 80, 100, 20);
				add(lb_date);
				
				//1)TextFields
				//date
				tf_date = new JTextField();
				tf_date.setBounds(190, 80, 300, 20);
				add(tf_date);
			
		//side error firing
				lb_hint1 = new JLabel();
				lb_hint1.setBounds(500, 80, 300, 20);
				add(lb_hint1);
		//time
				lb_time = new JLabel("* TEST TIMING:");		
				lb_time.setBounds(50, 110, 150, 30);
				add(lb_time);
				
				//1)TextFields
				//time
				tf_time = new JTextField();
				tf_time.setBounds(190, 110, 300, 20);
				add(tf_time);
			
		//side error firing
				lb_hint1 = new JLabel();
				lb_hint1.setBounds(500, 110, 300, 20);
				add(lb_hint1);	
				
				//Address
				lb_place = new JLabel("* Address:");		
				lb_place.setBounds(50, 160, 200, 20);
				add(lb_place);
				
		//address
				ta_place = new JTextArea();
				ta_place.setBounds(190, 160, 300, 40);
				add(ta_place);
								
						//Last Notification message
								lb_hintFinal = new JLabel();
								//lb_hintFinal.setBackground(Color.RED);
								lb_hintFinal.setBounds(200, 200, 300, 20); 
								
								//Buttons
						//btn_Submit	
								btnSubmit = new JButton("Submit");
								btnSubmit.setBounds(200, 250, 80, 40);
								add(btnSubmit);
								
								btnSubmit.addActionListener(this);		//Add action listener to btnSubmit
								btnSubmit.setActionCommand("Submit");
								
					/*	//btn_Cancel
								btnCancel = new JButton("Cancel");
								btnCancel.setBounds(300, 250, 80, 40);
								add(btnCancel);
								btnCancel.addActionListener(this);
								btnCancel.setActionCommand("Close");	//Add action listener to btnCancel
								*/
					//Adding error fire
								
								btnBack = new JButton("Back");
								btnBack.setBounds(400, 250, 80, 40);
								add(btnBack);
								btnBack.addActionListener(this);
								btnBack.setActionCommand("Back");	//Add action listener to btnCancel
										
								
								
							//	add(lb_hint2);
								
								add(lb_hint1);
								
						//		add(lb_hint4);
								 
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
		new OnlineTest();
	}
*/
	@Override
	public void actionPerformed(ActionEvent obj)
	{
		// TODO Auto-generated method stub
        String cmd = obj.getActionCommand();
		
		if(cmd.equals("Submit"))
		{
		
			if(tf_date.getText().isEmpty() || tf_time.getText().isEmpty())
	       	{
	       		  JOptionPane.showMessageDialog(btnSubmit, "Please Enter Date & Time");
	        }	            
	        else
	        {
	        	
	        	InsertDatabaseOnlineTest();
              JOptionPane.showMessageDialog(btnSubmit, "Data Saved Successfully");
              
	               // this.dispose();
					//new FirstForm();
	        }	
		}	
		else if(cmd.equals("Back"))
		{
			//this.dispose();
			new TestApplication();
			this.dispose();
     	}
			
		
		
		if(obj.getSource()==btnSubmit)
		{
			
			if(tf_date.getText().isEmpty())
			{
				lb_hint1.setText("***blank field");
				lb_hintFinal.setText(null);
			}
			else if(tf_time.getText().isEmpty())
			{
				lb_hint2.setText("***blank field");
				lb_hintFinal.setText(null);
			}
			else if(ta_place.getText().isEmpty())
			{
				lb_hint3.setText("***blank field");
				lb_hintFinal.setText(null);
			}
			
		
		}
		
	}

	private void InsertDatabaseOnlineTest()
	{
				// TODO Auto-generated method stub
		stringDate = tf_date.getText();
		stringTime = tf_time.getText();
		stringAddress = ta_place.getText();
		
		String sql="insert into onlinetest(stringDate,stringTime,stringAddress)values(?,?,?) ";
		
		//String sql1="select * from newuserregistration ";
		
				try{
			//Class.forName("oracle.jdbc.driver.OracleDriver");
			Class.forName("com.mysql.jdbc.Driver");
			//Connection cn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1523:xe","system","root");
			Connection cn=DriverManager.getConnection("jdbc:mysql://localhost:3306/rtosystem","root","root");
			PreparedStatement ps=cn.prepareStatement(sql);
		
				ps.setString(1, stringDate);
				ps.setString(2, stringTime);
				ps.setString(3, stringAddress);
				
				System.out.println(ps.executeUpdate());
		
		//System.out.println("User is Registred Successfully.......");
			}catch(Exception e1)
		    {
			
			System.out.println(e1);
			

		}

	}

}
