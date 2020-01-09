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

public class TestApplicationChoice extends JFrame implements ActionListener

{

public JLabel lb_Title, lb_note;
public  JButton btnVehilceRegistration,btnLicenseApproval,btnVehicleApproval,btnLicenseApplication,btnTest,btnBack,btnExistingUserLogin,btnNewUserRegistration;
public  ButtonGroup bg;
public  String show;
	
TestApplicationChoice()
{
    //frame
	super(" Test Application");
	setLayout(null);
	setSize(1050,800);
	
	//Title Label
	lb_Title = new JLabel("WELCOME TO RTO TEST APPLICATION");
	lb_Title.setFont(new java.awt.Font("Times New Roman",3,18));
	lb_Title.setOpaque(true);
	lb_Title.setBackground(Color.RED);
	lb_Title.setBounds(140, 80, 360, 20);
	add(lb_Title);
	
	btnNewUserRegistration = new JButton("New User(Register First)");
	btnNewUserRegistration.setBounds(180, 150, 200, 40);
	add(btnNewUserRegistration);
	btnNewUserRegistration.addActionListener(this);
	btnNewUserRegistration.setActionCommand("New User(Register First)");	//Add action listener to btnCancel


	btnExistingUserLogin = new JButton("Test Application");
	btnExistingUserLogin.setBounds(180, 250, 200, 40);
	add(btnExistingUserLogin);
	btnExistingUserLogin.addActionListener(this);
	btnExistingUserLogin.setActionCommand("Test Application");	//Add action listener to btnCancel

	
	//btnAdmin
	btnBack = new JButton("Back");
	btnBack.setBounds(180, 350, 200, 40);
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

				String cmd = obj.getActionCommand();
				
				 if(cmd.equals("New User(Register First)"))
				{
					new NewUserRegistration();
					this.dispose();
		     	}
				else if(cmd.equals("Test Application"))
				{
					new TestApplication();
					this.dispose();
		     	}
				else if(cmd.equals("Back"))
				{
					new RtoServices();
					this.dispose();
		     	}
}
}


