package banking_system_project;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import java.awt.Font;

@SuppressWarnings("serial")
public class ConfirmTransfer extends JFrame {

	private JPanel contentPane;
	private JTextField t;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					// Deposit frame = new Deposit();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public ConfirmTransfer(String username, String balance, String name, String bal) {
		setResizable(false);
		setTitle("Balance Transfer");
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 251, 286);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		t = new JTextField();
		t.setFont(new Font("Tahoma", Font.BOLD, 11));
		t.setHorizontalAlignment(SwingConstants.RIGHT);
		t.setBounds(10, 36, 202, 20);
		contentPane.add(t);
		t.setColumns(10);

		JButton b1 = new JButton("5,000");
		b1.setFont(new Font("Tahoma", Font.BOLD, 12));
		b1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				t.setText("5000");
			}
		});
		b1.setBounds(10, 67, 89, 23);
		contentPane.add(b1);

		JButton b2 = new JButton("10,000");
		b2.setFont(new Font("Tahoma", Font.BOLD, 12));
		b2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				t.setText("10000");
			}
		});
		b2.setBounds(123, 67, 89, 23);
		contentPane.add(b2);

		JButton b3 = new JButton("20,000");
		b3.setFont(new Font("Tahoma", Font.BOLD, 12));
		b3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				t.setText("20000");
			}
		});
		b3.setBounds(10, 101, 89, 23);
		contentPane.add(b3);

		JLabel lblNewLabel = new JLabel("Enter desirable amount");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel.setBounds(10, 11, 211, 14);
		contentPane.add(lblNewLabel);

		JButton b4 = new JButton("50,000");
		b4.setFont(new Font("Tahoma", Font.BOLD, 12));
		b4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				t.setText("50000");
			}
		});
		b4.setBounds(123, 101, 89, 23);
		contentPane.add(b4);

		JButton b6 = new JButton("200,000");
		b6.setFont(new Font("Tahoma", Font.BOLD, 12));
		b6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				t.setText("200000");
			}
		});
		b6.setBounds(123, 135, 89, 23);
		contentPane.add(b6);

		JButton b5 = new JButton("100,000");
		b5.setFont(new Font("Tahoma", Font.BOLD, 12));
		b5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				t.setText("100000");
			}
		});
		b5.setBounds(10, 135, 89, 23);
		contentPane.add(b5);

		JButton b7 = new JButton("500,000");
		b7.setFont(new Font("Tahoma", Font.BOLD, 12));
		b7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				t.setText("500000");
			}
		});
		b7.setBounds(10, 169, 89, 23);
		contentPane.add(b7);

		JButton b8 = new JButton("1,000,000");
		b8.setFont(new Font("Tahoma", Font.BOLD, 11));
		b8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				t.setText("1000000");
			}
		});
		b8.setBounds(123, 169, 89, 23);
		contentPane.add(b8);

		JButton b_ok = new JButton("OK");
		b_ok.setFont(new Font("Tahoma", Font.BOLD, 12));
		b_ok.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String text = t.getText();

				if (text.equals("")) {
					JOptionPane.showMessageDialog(null, "Please input");
				} else if (text.length() >= 15) {
					JOptionPane.showMessageDialog(null, "Can't input more than 15 digits");
				} else if (!text.matches("^[0-9]*$")) {
					JOptionPane.showMessageDialog(null, "Balance can only be numbers");
				} else {
					try {
						int a = 0;
						try {
							a = Integer.parseInt(text);
						} catch (NumberFormatException e1) {
							JOptionPane.showMessageDialog(null, "Not a number");
						}
						Class.forName("com.mysql.jdbc.Driver");
						Connection con = DriverManager.getConnection("jdbc:mysql://localhost/student", "root", "");

						int b = Integer.parseInt(balance);
						int c = Integer.parseInt(bal);

						if (b < a) {
							JOptionPane.showMessageDialog(null, "Insufficient");
						} else {
							b = b - a;
							c = c + a;

							PreparedStatement p = con
									.prepareStatement("update usertable set balance=? where username=?");
							p.setInt(1, b);
							p.setString(2, username);
							p.executeUpdate();

							PreparedStatement p1 = con
									.prepareStatement("update usertable set balance=? where username=?");
							p1.setInt(1, c);
							p1.setString(2, name);
							p1.executeUpdate();
							JOptionPane.showMessageDialog(null, text + " Transfered Successfully to " + name);
							t.setText("");
							p.close();
							con.close();
							new Home(username);
							setVisible(false);
						}
					} catch (Exception e1) {
						e1.toString();
					}
				}
			}
		});
		b_ok.setBounds(19, 203, 80, 23);
		contentPane.add(b_ok);

		JButton b_c = new JButton("Back");
		b_c.setFont(new Font("Tahoma", Font.BOLD, 12));
		b_c.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new BalanceTransfer(username, balance);
				setVisible(false);
			}
		});
		b_c.setBounds(123, 203, 80, 23);
		contentPane.add(b_c);
	}
}
