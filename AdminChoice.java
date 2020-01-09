package swingwithjdbcpkg;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class AdminChoice  extends JFrame implements ActionListener

{
	public JLabel lb_Title, lb_note;
	public  JButton btnAdminRegistration,btnAdminLogin,btnTableViewNewUser1,btnTableViewLicenseApplication0,btnTableViewTestApplication4,btnTableViewOnlineTest2,btnTableViewPracticalTest3,btnTableViewVehicleRegistration5,btnupdate,btndelete,btnBack;
	public  ButtonGroup bg;
    public  String show;
		
    AdminChoice()
    {
        //frame
    	super("Admin Choice");
    	setLayout(null);
    	setSize(1050,800);

    	//Title Label
    	lb_Title = new JLabel("WELCOME TO ADMIN CHOICE");
    	lb_Title.setFont(new java.awt.Font("Times New Roman",3,18));
    	lb_Title.setOpaque(true);
    	lb_Title.setBackground(Color.RED);
    	lb_Title.setBounds(210, 30, 270, 20);
    	add(lb_Title);
    	
    	btnAdminRegistration = new JButton("Admin Registration");
    	btnAdminRegistration.setBounds(200, 80, 300, 40);
		add(btnAdminRegistration);
		btnAdminRegistration.addActionListener(this);
		btnAdminRegistration.setActionCommand("Admin Registration");	//Add action listener to btnCancel
		
		//btnAdmin
		btnAdminLogin = new JButton("Admin Login");
		btnAdminLogin.setBounds(200, 140, 300, 40);
		add(btnAdminLogin);
		btnAdminLogin.addActionListener(this);
		btnAdminLogin.setActionCommand("Admin Login");	//Add action listener to btnCancel

		
		btnTableViewNewUser1= new JButton("TableViewNewUser1");
		btnTableViewNewUser1.setBounds(200, 200, 300, 40);
	    add(btnTableViewNewUser1);
	    btnTableViewNewUser1.addActionListener(this);
	    btnTableViewNewUser1.setActionCommand("TableViewNewUser1");	//Add action listener to btnCancel

	    btnTableViewLicenseApplication0 = new JButton("TableViewLicenseApplication0");
	    btnTableViewLicenseApplication0.setBounds(200, 260, 300, 40);
	    add(btnTableViewLicenseApplication0);
	    btnTableViewLicenseApplication0.addActionListener(this);
	    btnTableViewLicenseApplication0.setActionCommand("TableViewLicenseApplication0");	//Add action listener to btnCancel
	   
	    btnTableViewTestApplication4 = new JButton("TableViewTestApplication4");
	    btnTableViewTestApplication4.setBounds(200, 320, 300, 40);
	    add(btnTableViewTestApplication4);
	    btnTableViewTestApplication4.addActionListener(this);
	    btnTableViewTestApplication4.setActionCommand("TableViewTestApplication4");	//Add action listener to btnCancel

	    btnTableViewOnlineTest2= new JButton("TableViewOnlineTest2");
	    btnTableViewOnlineTest2.setBounds(200, 380, 300, 40);
	    add(btnTableViewOnlineTest2);
	    btnTableViewOnlineTest2.addActionListener(this);
	    btnTableViewOnlineTest2.setActionCommand("TableViewOnlineTest2");	//Add action listener to btnCancel

	    btnTableViewPracticalTest3 = new JButton("TableViewPracticalTest3");
	    btnTableViewPracticalTest3.setBounds(200, 440, 300, 40);
	    add(btnTableViewPracticalTest3);
	    btnTableViewPracticalTest3.addActionListener(this);
	    btnTableViewPracticalTest3.setActionCommand("TableViewPracticalTest3");	//Add action listener to btnCancel

	    btnTableViewVehicleRegistration5 = new JButton("TableViewVehicleRegistration5");
	    btnTableViewVehicleRegistration5.setBounds(200, 500, 300, 40);
	    add(btnTableViewVehicleRegistration5);
	    btnTableViewVehicleRegistration5.addActionListener(this);
	    btnTableViewVehicleRegistration5.setActionCommand("TableViewVehicleRegistration5");	//Add action listener to btnCancel

	   
	    
	    
	    btnBack = new JButton("Back");
		btnBack.setBounds(200, 560, 300, 40);
		add(btnBack);
		btnBack.addActionListener(this);
		btnBack.setActionCommand("Back");	//Add action listener to btnCancel
		
		 setLayout(new BorderLayout());
		   	JLabel background=new JLabel(new ImageIcon("src/swingwithjdbcpkg/img/img2.jpg"));
		       add(background);
		       background.setLayout(new FlowLayout());


		setVisible(true);


}

	@Override
	public void actionPerformed(ActionEvent obj)
	{
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
					String cmd = obj.getActionCommand();
					if(cmd.equals("Admin Registration"))
					{
						new AdminRegistration();
						this.dispose();
			     	}
					else if(cmd.equals("Admin Login"))
					{
						new AdminLogin();
						this.dispose();
			     	}
					else if(cmd.equals("TableViewNewUser1"))
					{
						new TableViewNewUser1();
						this.dispose();
			     	}
			    	else if(cmd.equals("TableViewLicenseApplication0"))
					{
						new TableViewLicenseApplication0();
						this.dispose();
			     	}
					else if(cmd.equals("TableViewTestApplication4"))
					{
						new TableViewTestApplication4();
						this.dispose();
			     	}
					else if(cmd.equals("TableViewOnlineTest2"))
					{
						new TableViewOnlineTest2();
						this.dispose();
			     	}
					else if(cmd.equals("TableViewPracticalTest3"))
					{
						new TableViewPracticalTest3();
						this.dispose();
			     	}
					else if(cmd.equals("TableViewVehicleRegistration5"))
					{
						new TableViewVehicleRegistration5();
						this.dispose();
			     	}
					/*else if(cmd.equals("Update"))
					{
						new Update();
						this.dispose();
			     	}
					else if(cmd.equals("Delete"))
					{
						new Delete();
						this.dispose();
			     	}*/
					else if(cmd.equals("Back"))
					{
						new HomePage();
						this.dispose();
			     	}

	}
	
}	
