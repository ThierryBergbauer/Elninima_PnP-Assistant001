import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import net.miginfocom.swing.MigLayout;

//Bare Bone of Elninima_PnPAssistant, Version 001
public class main_Elninima_PnPAssistant001
{
	
	private JFrame frame;
	private JTextField textField;
	private JPasswordField passwordField;
	
	/**
	 * Launch the application.
	 */
	public static void main(final String[] args)
	{
		EventQueue.invokeLater(new Runnable()
		{
			@Override
			public void run()
			{
				try
				{
					final main_Elninima_PnPAssistant001 window = new main_Elninima_PnPAssistant001();
					window.frame.setVisible(true);
				} catch (final Exception e)
				{
					e.printStackTrace();
				}
			}
		});
	}
	
	/**
	 * Create the application.
	 */
	public main_Elninima_PnPAssistant001()
	{
		this.initialize();
	}
	
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize()
	{
		final String usernameAndPasswordText = "Enter Username and Password";
		this.frame = new JFrame();
		this.frame.setBounds(100, 100, 641, 474);
		this.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.frame.getContentPane().setLayout(new MigLayout("", "[][grow][grow]", "[][][][][][][][][][][]"));
		
		final JLabel lblElninimaPpassistant = new JLabel("Elninima P&P-Assistant");
		this.frame.getContentPane().add(lblElninimaPpassistant, "cell 0 1");
		
		final JLabel lblWelcomToElinima = new JLabel("Welcom to Elinima to create an new Login press the button below");
		this.frame.getContentPane().add(lblWelcomToElinima, "cell 0 2");
		
		final JButton btnNewLogin = new JButton("New Login");
		btnNewLogin.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(final ActionEvent e)
			{
				final newLogin_Elninima_PnPAssistant001 newLoginFrame = new newLogin_Elninima_PnPAssistant001();
				newLoginFrame.setVisible(true);
			}
		});
		this.frame.getContentPane().add(btnNewLogin, "cell 0 3");
		
		final JLabel lblEnterUsernameAnd = new JLabel("usernameAndPasswordText");
		this.frame.getContentPane().add(lblEnterUsernameAnd, "cell 0 5");
		
		this.textField = new JTextField();
		this.frame.getContentPane().add(this.textField, "cell 0 6,growx");
		this.textField.setColumns(10);
		
		final JButton btnLoadData = new JButton("Login");
		btnLoadData.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(final ActionEvent e)
			{
				//TODO AfterLoginWelcom frame -> new Game/load Game -> In Game frame
			}
		});
		
		final JLabel lblUsername = new JLabel("Username");
		this.frame.getContentPane().add(lblUsername, "cell 1 6");
		
		this.passwordField = new JPasswordField();
		this.frame.getContentPane().add(this.passwordField, "cell 0 7,growx");
		
		final JLabel lblPassword = new JLabel("Password");
		this.frame.getContentPane().add(lblPassword, "cell 1 7");
		this.frame.getContentPane().add(btnLoadData, "cell 0 8");
	}
	
}
