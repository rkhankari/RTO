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

public class RtoServices extends JFrame implements ActionListener

{

public JLabel lb_Title, lb_note;
public  JButton btnVehilceRegistration,btnUpdatedLicenseApplication,btnVehicleApproval,btnLicenseApplication,btnTest,btnBack;
public  ButtonGroup bg;
public  String show;
	
RtoServices()
{
    //frame
	super("RTO SERVICES");
	setLayout(null);
	setSize(1050,800);
	
	//Title Label
	lb_Title = new JLabel("WELCOME TO RTO SERVICES");
	lb_Title.setFont(new java.awt.Font("Times New Roman",3,18));
	lb_Title.setOpaque(true);
	lb_Title.setBackground(Color.RED);
	lb_Title.setBounds(180, 30, 270, 20);
	add(lb_Title);
	
	btnVehilceRegistration = new JButton("Vehicle Registration Choice");
	btnVehilceRegistration.setBounds(200, 80, 200, 40);
	add(btnVehilceRegistration);
	btnVehilceRegistration.addActionListener(this);
	btnVehilceRegistration.setActionCommand("Vehicle Registration Choice");	//Add action listener to btnCancel
	
	//btnAdmin
	btnLicenseApplication = new JButton("License Application ");
	btnLicenseApplication.setBounds(200, 130, 200, 40);
	add(btnLicenseApplication);
	btnLicenseApplication.addActionListener(this);
	btnLicenseApplication.setActionCommand("License Application ");	//Add action listener to btnCancel
	
/*	btnUpdatedLicenseApplication = new JButton("Update License Application ");
	btnUpdatedLicenseApplication.setBounds(500, 130, 200, 40);
	add(btnUpdatedLicenseApplication);
	btnUpdatedLicenseApplication.addActionListener(this);
	btnUpdatedLicenseApplication.setActionCommand("Update License Application ");	//Add action listener to btnCancel
	
	*/
	btnTest = new JButton("Test Application");
	btnTest.setBounds(200, 180, 200, 40);
	add(btnTest);
	btnTest.addActionListener(this);
	btnTest.setActionCommand("Test Application");	//Add action listener to btnCancel


	//btnAdmin
	btnBack = new JButton("Back");
	btnBack.setBounds(200, 230, 200, 40);
	add(btnBack);
	btnBack.addActionListener(this);
	btnBack.setActionCommand("Back");	//Add action listener to btnCancel
	
	setLayout(new BorderLayout());
   	JLabel background=new JLabel(new ImageIcon("src/swingwithjdbcpkg/img/carnature.jpg"));
       add(background);
       background.setLayout(new FlowLayout());
	
	
	setVisible(true);


}

@Override
public void actionPerformed(ActionEvent obj)
{
	// TODO Auto-generated method stub

				String cmd = obj.getActionCommand();
				if(cmd.equals("Vehicle Registration Choice"))
				{
					new VehicleRegistrationChoice();
					this.dispose();
		     	}
				else if(cmd.equals("License Application "))
				{
					new LicenseApplicationChoice();
					this.dispose();
		     	}
				
				else if(cmd.equals("Test Application"))
				{
					new TestApplicationChoice();
					this.dispose();
		     	}
			
				else if(cmd.equals("Back"))
				{
					new HomePage();
					this.dispose();
		     	}
}
}


