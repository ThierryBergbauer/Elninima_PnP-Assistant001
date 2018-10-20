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
	
	public void CloseFrame()
	{
		super.dispose();
	}
	
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
		
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
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
				final Properties prop = new Properties();
				OutputStream output = null;
				
				// set the properties value
				//TODO check online for username collision (when sql database is working)
				if (Arrays.equals(newLogin_Elninima_PnPAssistant001.this.passwordField.getPassword(), newLogin_Elninima_PnPAssistant001.this.passwordField_1.getPassword()))
					/*the config file is declared in here and not outside so  we can use the Username for the file Name. 
					 * This should help minimize confusions or miss uses of different config files.
					 * Further data concerning a Player (Settings, Games, Friends...) should be written in this file.
					 * This should make it possible to share config files without renaming them.
					 * At some point we need to separate config and save files. But now we will only use one file*/
					try
					{
						output = new FileOutputStream(newLogin_Elninima_PnPAssistant001.this.textField.getText() + "_config.properties");
						prop.setProperty("Name", newLogin_Elninima_PnPAssistant001.this.textField.getText());
						prop.setProperty("Password", newLogin_Elninima_PnPAssistant001.this.passwordField.getText()); //TODO save password save (for online use)
						JOptionPane.showMessageDialog(null, "New Login succesfully created");
						prop.store(output, null);
						newLogin_Elninima_PnPAssistant001.this.CloseFrame();
						
					} catch (final IOException io2)
					{
						io2.printStackTrace();
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
				else
					JOptionPane.showMessageDialog(null, "Passwords not equal");
				
				// save properties to project root folder
				
			}
		});
		this.contentPane.add(btnSubmit, "flowx,cell 0 6");
		
		JButton btnCancel = new JButton("Cancel");
		contentPane.add(btnCancel, "cell 0 6");
		btnCancel.addActionListener(e -> this.dispose());
	}
	
}
