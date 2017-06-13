import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Arrays;
import java.util.Properties;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import net.miginfocom.swing.MigLayout;

public class newLogin_Elninima_PnPAssistant001 extends JFrame
{
	
	private final JPanel contentPane;
	private final JTextField textField;
	private final JPasswordField passwordField;
	private final JPasswordField passwordField_1;
	
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
					final newLogin_Elninima_PnPAssistant001 frame = new newLogin_Elninima_PnPAssistant001();
					frame.setVisible(true);
				} catch (final Exception e)
				{
					e.printStackTrace();
				}
			}
		});
	}
	
	/**
	 * Create the frame.
	 */
	public newLogin_Elninima_PnPAssistant001()
	{
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setBounds(100, 100, 450, 300);
		this.contentPane = new JPanel();
		this.contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		this.setContentPane(this.contentPane);
		this.contentPane.setLayout(new MigLayout("", "[grow][]", "[][][][][][][]"));
		
		final JLabel lblNewLogin = new JLabel("New Login");
		this.contentPane.add(lblNewLogin, "cell 0 0");
		
		final JLabel lblEnterUsernameAnd = new JLabel("Enter Username and Password");
		this.contentPane.add(lblEnterUsernameAnd, "cell 0 2");
		
		this.textField = new JTextField();
		this.contentPane.add(this.textField, "cell 0 3,growx");
		this.textField.setColumns(10);
		
		final JLabel lblUsername = new JLabel("Username");
		this.contentPane.add(lblUsername, "cell 1 3");
		
		this.passwordField = new JPasswordField();
		this.contentPane.add(this.passwordField, "cell 0 4,growx");
		
		final JLabel lblPassword = new JLabel("Password");
		this.contentPane.add(lblPassword, "cell 1 4");
		
		this.passwordField_1 = new JPasswordField();
		this.contentPane.add(this.passwordField_1, "cell 0 5,growx");
		
		final JLabel lblRepeatPassword = new JLabel("repeat Password");
		this.contentPane.add(lblRepeatPassword, "cell 1 5");
		
		final JButton btnSubmit = new JButton("Submit");
		btnSubmit.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(final ActionEvent e)
			{
				//TODO write Submit check and create new Login Data
				final Properties prop = new Properties();
				OutputStream output = null;
				
				try
				{
					
					output = new FileOutputStream("config.properties");
					
					// set the properties value
					if (Arrays.equals(newLogin_Elninima_PnPAssistant001.this.passwordField.getPassword(), newLogin_Elninima_PnPAssistant001.this.passwordField_1.getPassword()))
					{
						prop.setProperty("Name", newLogin_Elninima_PnPAssistant001.this.textField.getText());
						prop.setProperty("Password", newLogin_Elninima_PnPAssistant001.this.passwordField.getText());
						JOptionPane.showMessageDialog(null, "New Login succesfully created");
					}
					else
						JOptionPane.showMessageDialog(null, "Passwords not equal");
					
					// save properties to project root folder
					prop.store(output, null);
					
				} catch (final IOException io)
				{
					io.printStackTrace();
				} finally
				{
					if (output != null)
						try
						{
							output.close();
						} catch (final IOException e2)
						{
							e2.printStackTrace();
						}
					
				}
			}
		});
		this.contentPane.add(btnSubmit, "cell 0 6");
	}
	
}
