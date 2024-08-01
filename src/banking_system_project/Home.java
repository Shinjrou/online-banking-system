package banking_system_project;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import java.awt.Color;

@SuppressWarnings("serial")
public class Home extends JFrame {

	private JPanel contentPane;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					// HomeFrame frame = new HomeFrame();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public Home(String username) {
		setResizable(false);
		setTitle("Banking Services");
		setAlwaysOnTop(true);
		setLocationRelativeTo(null);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 377, 321);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JButton accountdetailsButton = new JButton("Account Details");
		accountdetailsButton.setFont(new Font("Tahoma", Font.BOLD, 15));
		accountdetailsButton.setBounds(82, 42, 200, 23);
		contentPane.add(accountdetailsButton);
		accountdetailsButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					Class.forName("com.mysql.jdbc.Driver");
					Connection con = DriverManager.getConnection("jdbc:mysql://localhost/student", "root", "");

					Statement p = con.createStatement();
					ResultSet r = p.executeQuery("select * from usertable");

					while (r.next()) {
						if (username.equals(r.getString(2))) {
							String id = r.getString(1);
							String user = r.getString(2);
							String dob = r.getString(3);
							String fname = r.getString(4);
							String lname = r.getString(5);
							String gender = r.getString(6);
							String email = r.getString(7);
							String pass = r.getString(8);
							String ph = r.getString(9);
							String addr = r.getString(10);
							String bal = r.getString(11);
							new AccInfo(id, user, pass, fname, lname, gender, dob, email, ph, addr, bal);
							setVisible(false);
						}
					}
					p.close();
					con.close();
				} catch (Exception e1) {
					e1.toString();
				}

			}

		});

		JLabel titleLabel = new JLabel("Banking Services");
		titleLabel.setForeground(Color.BLUE);
		titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
		titleLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
		titleLabel.setBounds(105, 11, 159, 20);
		contentPane.add(titleLabel);

		JButton depositButton = new JButton("Deposit");
		depositButton.setFont(new Font("Tahoma", Font.BOLD, 15));
		depositButton.setBounds(82, 76, 200, 23);
		contentPane.add(depositButton);
		depositButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				new Deposit(username);
				setVisible(false);
			}

		});

		JButton withdrawButton = new JButton("Withdraw");
		withdrawButton.setFont(new Font("Tahoma", Font.BOLD, 15));
		withdrawButton.setBounds(82, 110, 200, 23);
		contentPane.add(withdrawButton);
		withdrawButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				new Withdraw(username);
				setVisible(false);
			}

		});

		JButton transferButton = new JButton("Balance Transfer");
		transferButton.setFont(new Font("Tahoma", Font.BOLD, 15));
		transferButton.setBounds(82, 144, 200, 23);
		contentPane.add(transferButton);
		transferButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				String balance = "";
				try {
					Class.forName("com.mysql.jdbc.Driver");
					Connection con = DriverManager.getConnection("jdbc:mysql://localhost/student", "root", "");

					Statement p = con.createStatement();
					ResultSet r = p.executeQuery("select * from usertable");
					while (r.next()) {
						if (username.equals(r.getString(2))) {
							balance = r.getString(11);
						}
					}
					new BalanceTransfer(username, balance);
					setVisible(false);
					p.close();
					con.close();
				} catch (Exception e1) {
					e1.toString();
				}
			}
		});

		JButton checkButton = new JButton("Check Balance");
		checkButton.setFont(new Font("Tahoma", Font.BOLD, 15));
		checkButton.setBounds(82, 178, 200, 23);
		contentPane.add(checkButton);
		checkButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// boolean status = false;
				try {
					Class.forName("com.mysql.jdbc.Driver");
					Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/student", "root", "");
					Statement statement = connection.createStatement();
					ResultSet resultSet = statement.executeQuery("select * from usertable");
					while (resultSet.next()) {
						if (username.equals(resultSet.getString(2))) {
							JOptionPane.showMessageDialog(contentPane, "Your current balance: " + resultSet.getInt(11) + " Ks");
							break;
						}
					}
					connection.close();
					statement.close();
				} catch (ClassNotFoundException | SQLException e1) {
					e1.printStackTrace();
				}

			}

		});

		JButton currencyButton = new JButton("Currency Exchange");
		currencyButton.setFont(new Font("Tahoma", Font.BOLD, 15));
		currencyButton.setBounds(82, 212, 200, 23);
		contentPane.add(currencyButton);

		JButton b1 = new JButton("Log Out");
		b1.setFont(new Font("Tahoma", Font.BOLD, 12));
		b1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new Login();
				setVisible(false);
			}
		});
		b1.setBounds(262, 246, 89, 23);
		contentPane.add(b1);
		
		JButton btnNewButton = new JButton("Feedback");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new GiveFeedback(username);
				setVisible(false);
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnNewButton.setBounds(10, 246, 89, 23);
		contentPane.add(btnNewButton);
		currencyButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				new Exchange(username);
				setVisible(false);
			}

		});
	}
}
