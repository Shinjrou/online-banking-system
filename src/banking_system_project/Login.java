package banking_system_project;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.Color;

@SuppressWarnings("serial")
public class Login extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JPasswordField passwordField;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					@SuppressWarnings("unused")
					Login frame = new Login();
					// frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public Login() {
		setAlwaysOnTop(true);
		setTitle("Banking Login");
		setLocationRelativeTo(null);
		setVisible(true);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 341, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel welcomeLabel = new JLabel("Banking System");
		welcomeLabel.setForeground(Color.MAGENTA);
		welcomeLabel.setVerticalAlignment(SwingConstants.TOP);
		welcomeLabel.setHorizontalAlignment(SwingConstants.CENTER);
		welcomeLabel.setFont(new Font("Arial Black", Font.BOLD | Font.ITALIC, 20));
		welcomeLabel.setBounds(33, 11, 250, 29);
		contentPane.add(welcomeLabel);

		JLabel usernameLabel = new JLabel("Username");
		usernameLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		usernameLabel.setFont(new Font("Tahoma", Font.BOLD, 12));
		usernameLabel.setBounds(10, 90, 82, 19);
		contentPane.add(usernameLabel);

		textField = new JTextField();
		textField.setFont(new Font("Tahoma", Font.BOLD, 11));
		textField.setBounds(117, 90, 180, 20);
		contentPane.add(textField);
		textField.setColumns(10);

		JLabel passwordLabel = new JLabel("Password");
		passwordLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		passwordLabel.setFont(new Font("Tahoma", Font.BOLD, 12));
		passwordLabel.setBounds(10, 130, 82, 19);
		contentPane.add(passwordLabel);

		passwordField = new JPasswordField();
		passwordField.setFont(new Font("Tahoma", Font.BOLD, 11));
		passwordField.setBounds(117, 130, 180, 20);
		contentPane.add(passwordField);

		JButton loginButton = new JButton("Log In");
		loginButton.setFont(new Font("Tahoma", Font.BOLD, 12));
		loginButton.setBounds(47, 171, 92, 23);
		contentPane.add(loginButton);

		JButton signupButton = new JButton("Sign Up");
		signupButton.setFont(new Font("Tahoma", Font.BOLD, 12));
		signupButton.setBounds(177, 171, 92, 23);
		contentPane.add(signupButton);
		signupButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				new SignUp();
				setVisible(false);
			}

		});

		JButton forgotButton = new JButton("Forgot password?");
		forgotButton.setFont(new Font("Tahoma", Font.BOLD, 10));
		forgotButton.setBounds(182, 227, 133, 23);
		contentPane.add(forgotButton);
		forgotButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				new Forget();
				setVisible(false);
			}

		});

		JLabel loginLabel = new JLabel("Login Page");
		loginLabel.setForeground(Color.BLUE);
		loginLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
		loginLabel.setHorizontalAlignment(SwingConstants.CENTER);
		loginLabel.setBounds(95, 51, 108, 19);
		contentPane.add(loginLabel);

		loginButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String username = textField.getText();
				@SuppressWarnings("deprecation")
				String password = passwordField.getText();
				int count = 0;

				try {
					Class.forName("com.mysql.jdbc.Driver");
					Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/student", "root", "");
					Statement statement = connection.createStatement();
					ResultSet resultSet = statement.executeQuery("select * from usertable");
					while (resultSet.next()) {

						if (username.equals("admin") && password.equals("password")) {
							count = 3;
						} else if (username.equals("") || password.equals("")) {
							count = 2;
							break;
						} else if (username.equals(resultSet.getString(2)) && password.equals(resultSet.getString(8))) {
							JOptionPane.showMessageDialog(contentPane, "Welcome to Banking System, "+ resultSet.getString(4) + " " + resultSet.getString(5) + "!");
							count = 1;
						}
					}

					if (count == 2)
						JOptionPane.showMessageDialog(contentPane, "Please Input First");
					else if (count == 1) {
						new Home(username);
						setVisible(false);
					} else if (count == 3) {
						new TestingTable();
						setVisible(false);
						JOptionPane.showMessageDialog(contentPane, "Welcome Admin");
					} else {
						JOptionPane.showMessageDialog(contentPane, "Invalid username or password");
						textField.setText("");
						passwordField.setText("");
					}
					connection.close();
					statement.close();
				} catch (ClassNotFoundException | SQLException e1) {
					e1.printStackTrace();
				}

			}

		});
	}
}
