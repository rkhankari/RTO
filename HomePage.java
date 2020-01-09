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
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class HomePage extends JFrame implements ActionListener
{
	public JLabel lb_Title, lb_note,lb_slogan;
	public JTextArea ta_add;
	public JLabel background;
    public  JButton btnHome,btnUser,btnAdmin,btnRtoServices;
    public  ButtonGroup bg;
	public  String show;
	
	HomePage()
	{
	    //frame
    	super("HomePage RTO System");
    	setSize(1050,800);
    	
    	setLayout(null);
  
        //Title Label
    	lb_Title = new JLabel("WELCOME   TO   RTO   MANAGEMENT   SYSTEM");
    	lb_Title.setFont(new java.awt.Font("Times New Roman",3,20));
        lb_Title.setBounds(280, 20, 450, 80);
    	add(lb_Title);
    	
    	lb_slogan = new JLabel("LEAVE SOONER, DRIVE SLOWER, LIVE LONGER!!!");
    	lb_slogan.setFont(new java.awt.Font("Arial Black",3,22));
    	lb_slogan.setBounds(180,500, 650, 80);
    	add(lb_slogan);
    
//btnUser
		btnUser = new JButton("User");
		btnUser.setBounds(250, 100, 80, 40);
		add(btnUser);
		btnUser.addActionListener(this);
		btnUser.setActionCommand("User");	//Add action listener to btnCancel
		
		//btnAdmin
		btnAdmin = new JButton("Admin");
		btnAdmin.setBounds(450, 100, 100, 40);
		add(btnAdmin);
		btnAdmin.addActionListener(this);
		btnAdmin.setActionCommand("Admin");	//Add action listener to btnCancel

		btnRtoServices = new JButton("RTO Services");
		btnRtoServices.setBounds(650, 100, 120, 40);
		add(btnRtoServices);
		btnRtoServices.addActionListener(this);
		btnRtoServices.setActionCommand("RTO Services");	//Add action listener to btnCancel
		
		
        ImageIcon background_image = new ImageIcon("src/swingwithjdbcpkg/img/car.jpg");
        JLabel background = new JLabel(" ",background_image,JLabel.LEFT);
        java.awt.Image img = background_image.getImage();
        background.setBounds(60, 160,850, 320);
        add(background);
        
   	  
        ImageIcon back_image = new ImageIcon("src/swingwithjdbcpkg/img/bike.jpg");
        JLabel back = new JLabel(" ",back_image,JLabel.CENTER);
        java.awt.Image im = back_image.getImage();
        back.setBounds(100, 160,850, 320);
        add(back);
        
        ImageIcon ba_image = new ImageIcon("src/swingwithjdbcpkg/img/activa.jpg");
        JLabel ba = new JLabel(" ",ba_image,JLabel.LEFT);
        java.awt.Image i = ba_image.getImage();
        ba.setBounds(650, 212,800, 215);
        add(ba);
		
		setLayout(new BorderLayout());
	   	JLabel background1=new JLabel(new ImageIcon("src/swingwithjdbcpkg/img/rutu.jpg"));
	       add(background1);
	       background1.setLayout(new FlowLayout());
		
		

               setVisible(true);
	}
	
	
	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		new HomePage();
	}

	@Override
	public void actionPerformed(ActionEvent obj)
	{
		// TODO Auto-generated method stub
		String cmd = obj.getActionCommand();
		if(cmd.equals("User"))
		{
			new UsersChoice();
			this.dispose();
			
     	}
		else if(cmd.equals("Admin"))
		{
			new AdminChoice();
			this.dispose();
     	}
		
		else if(cmd.equals("RTO Services"))
		{
			new RtoServices();
			this.dispose();
     	}
			}
               }
