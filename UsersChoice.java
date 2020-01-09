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

public class UsersChoice extends JFrame implements ActionListener
{
	public JLabel lb_Title, lb_note;
	public  JButton btnNewUserRegistration,btnExistingUserLogin,btnRtoServices,btnBack;
	public  ButtonGroup bg;
    public  String show;
		
    UsersChoice()
    {
        //frame
    	super("Users Choice");
    	setLayout(null);
    	setSize(1050,800);
    	//jframe.setBackground(Color.RED);
    	//Title Label
    	lb_Title = new JLabel("WELCOME TO USERS CHOICE");
    	lb_Title.setFont(new java.awt.Font("Times New Roman",3,18));
    	lb_Title.setOpaque(true);
    	lb_Title.setBackground(Color.RED);
    	lb_Title.setBounds(180, 30, 270, 20);
    	add(lb_Title);
    	
    	btnNewUserRegistration = new JButton("New User Registration");
    	btnNewUserRegistration.setBounds(200, 80, 200, 40);
		add(btnNewUserRegistration);
		btnNewUserRegistration.addActionListener(this);
		btnNewUserRegistration.setActionCommand("New User Registration");	//Add action listener to btnCancel
		
		//btnAdmin
		btnExistingUserLogin = new JButton("Existing User Login");
		btnExistingUserLogin.setBounds(200, 150, 200, 40);
		add(btnExistingUserLogin);
		btnExistingUserLogin.addActionListener(this);
		btnExistingUserLogin.setActionCommand("Existing User Login");	//Add action listener to btnCancel

		//btnAdmin
		btnRtoServices = new JButton("Rto Services");
		btnRtoServices.setBounds(200, 220, 200, 40);
		add(btnRtoServices);
		btnRtoServices.addActionListener(this);
		btnRtoServices.setActionCommand("Rto Services");	//Add action listener to btnCancel

		

		//btnAdmin
		btnBack = new JButton("Back");
		btnBack.setBounds(200, 430, 200, 40);
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
			if(cmd.equals("New User Registration"))
			{
				new NewUserRegistration();
				this.dispose();
	     	}
			else if(cmd.equals("Existing User Login"))
			{
				new ExistingUserLogin();
				this.dispose();
	     	}
			else if(cmd.equals("Rto Services"))
			{
				new RtoServices();
				this.dispose();
	     	}
			
			else if(cmd.equals("Back"))
			{
				new HomePage();
				this.dispose();
	     	}
		}
}
