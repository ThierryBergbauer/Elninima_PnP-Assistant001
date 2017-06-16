import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import net.miginfocom.swing.MigLayout;

//Bare Bone of Elninima_PnPAssistant, Version 001
public class main_Elninima_PnPAssistant001
{
	
	private JFrame frame;
	private JTextField UsernameTextField;
	final Properties prop = new Properties();
	InputStream input = null;
	private JPasswordField PasswordField;
	
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
		this.frame.getContentPane().setLayout(new MigLayout("", "[grow][grow][grow]", "[][][][][][][][][][][]"));
		
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
		
		this.UsernameTextField = new JTextField();
		this.frame.getContentPane().add(this.UsernameTextField, "cell 0 6,growx");
		this.UsernameTextField.setColumns(10);
		
		final JButton btnLogin = new JButton("Login");
		btnLogin.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(final ActionEvent e)
			{
				try
				{
					main_Elninima_PnPAssistant001.this.input = new FileInputStream(main_Elninima_PnPAssistant001.this.UsernameTextField.getText() + "_config.properties");
					main_Elninima_PnPAssistant001.this.prop.load(main_Elninima_PnPAssistant001.this.input);
					if (main_Elninima_PnPAssistant001.this.prop.getProperty("Password") == String.valueOf(main_Elninima_PnPAssistant001.this.PasswordField.getPassword()))
					{
						//TODO AfterLoginWelcom frame -> new Game/load Game -> In Game frame use MigLayout for Login
						JOptionPane.showMessageDialog(null, "Login succesfull");
						JOptionPane.showMessageDialog(null, "Placeholder for ingame window");
					}
					else
						JOptionPane.showMessageDialog(null, "Wrong Password");
				} catch (final IOException error3)
				{
					error3.printStackTrace();
				} finally
				{
					if (main_Elninima_PnPAssistant001.this.input != null)
						try
						{
							main_Elninima_PnPAssistant001.this.input.close();
						} catch (final IOException error4)
						{
							error4.printStackTrace();
						}
				}
			}
		});
		
		final JLabel lblUsername = new JLabel("Username");
		this.frame.getContentPane().add(lblUsername, "cell 1 6");
		
		this.PasswordField = new JPasswordField();
		this.frame.getContentPane().add(this.PasswordField, "cell 0 7,growx");
		
		final JLabel lblPassword = new JLabel("Password");
		this.frame.getContentPane().add(lblPassword, "cell 1 7");
		this.frame.getContentPane().add(btnLogin, "cell 0 8");
	}
	
}
