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
import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import java.awt.Font;

@SuppressWarnings("serial")
public class Deposit extends JFrame {

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

	public Deposit(String username) {
		setResizable(false);
		setTitle("Deposit");
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 237, 286);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		t = new JTextField();
		t.setFont(new Font("Tahoma", Font.BOLD, 11));
		t.setHorizontalAlignment(SwingConstants.RIGHT);
		t.setBounds(10, 36, 192, 20);
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
		b2.setBounds(113, 67, 89, 23);
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
		b4.setBounds(113, 101, 89, 23);
		contentPane.add(b4);

		JButton b6 = new JButton("200,000");
		b6.setFont(new Font("Tahoma", Font.BOLD, 12));
		b6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				t.setText("200000");
			}
		});
		b6.setBounds(113, 136, 89, 23);
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
		b8.setBounds(113, 170, 89, 23);
		contentPane.add(b8);

		JButton b_ok = new JButton("OK");
		b_ok.setFont(new Font("Tahoma", Font.BOLD, 12));
		b_ok.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String text = t.getText();

				if (text.equals("")) {
					JOptionPane.showMessageDialog(null, "You should input first");
				} else if (text.length() >= 15) {
					JOptionPane.showMessageDialog(null, "Can't input more than 15 digits");
					t.setText("");
				} else if (!text.matches("^[0-9]*$")) {
					JOptionPane.showMessageDialog(null, "Balance must only be numbers");
					t.setText("");
				} else {
					try {
						int c = 0;
						int a = Integer.parseInt(text);
						Class.forName("com.mysql.jdbc.Driver");
						Connection con = DriverManager.getConnection("jdbc:mysql://localhost/student", "root", "");
						Statement s = con.createStatement();
						ResultSet r = s.executeQuery("select * from usertable");
						while (r.next()) {
							if (username.equals(r.getString(2))) {
								c = r.getInt(11);
							}
						}
						a = a + c;
						PreparedStatement p = con.prepareStatement("update usertable set balance=? where username=?");
						p.setInt(1, a);
						p.setString(2, username);
						p.executeUpdate();
						JOptionPane.showMessageDialog(null, text + " Deposited Successfully");
						t.setText("");
						p.close();
						con.close();
					} catch (Exception e1) {
						e1.toString();
					}
				}
			}
		});
		b_ok.setBounds(20, 203, 79, 23);
		contentPane.add(b_ok);

		JButton b_c = new JButton("Back");
		b_c.setFont(new Font("Tahoma", Font.BOLD, 12));
		b_c.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new Home(username);
				setVisible(false);
			}
		});
		b_c.setBounds(113, 203, 79, 23);
		contentPane.add(b_c);
	}
}
