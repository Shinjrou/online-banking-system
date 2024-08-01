package banking_system_project;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

import com.mysql.jdbc.ResultSet;

import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.SwingConstants;

@SuppressWarnings("serial")
public class ConfirmPass extends JFrame {

	private JPanel contentPane;
	JPasswordField t1, t2;
	JPanel panel;
	JLabel l1;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					// ConfirmPass frame = new ConfirmPass("", "");
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public ConfirmPass(String name, String mail) {
		setResizable(false);
		setTitle("Change your password");
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 366, 200);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lp1 = new JLabel("New Password ");
		lp1.setFont(new Font("Tahoma", Font.BOLD, 12));
		lp1.setBounds(10, 36, 125, 19);
		contentPane.add(lp1);

		JLabel lp2 = new JLabel("Re-enter Password ");
		lp2.setFont(new Font("Tahoma", Font.BOLD, 12));
		lp2.setBounds(12, 89, 154, 14);
		contentPane.add(lp2);

		t1 = new JPasswordField();
		t1.setFont(new Font("Tahoma", Font.BOLD, 11));
		t1.getDocument().addDocumentListener(new DocumentListener() {
			String pass;

			@Override
			public void insertUpdate(DocumentEvent e) {
				check(pass);
			}

			@Override
			public void removeUpdate(DocumentEvent e) {
				check(pass);
			}

			@Override
			public void changedUpdate(DocumentEvent e) {
				check(pass);
			}

			@SuppressWarnings("deprecation")
			public void check(String inputPassword) {
				l1.setVisible(true);
				pass = t1.getText();
				inputPassword = pass;
				if (inputPassword.equals("")) {
					l1.setText("");
				} else if (inputPassword.matches("^(?=.*[a-z])(?=.*[A-Z])(?=.*[0-9])(?=.*[!@#\\$%\\^&\\*]).{8,}")) {
					l1.setText("Strong");
					l1.setForeground(Color.BLACK);
				} else if (inputPassword.matches("^(?=.*[a-z])(?=.*[A-Z])(?=.*[0-9]).{8,}")) {
					l1.setText("Medium");
					l1.setForeground(Color.BLUE);
				} else if (inputPassword.matches("^(?=.*[a-z])(?=.*[0-9]).{8,}")) {
					l1.setText("Weak");
					l1.setForeground(Color.MAGENTA);
				} else {
					l1.setText("Invalid password");
					l1.setForeground(Color.RED);
				}

			}
		});
		t1.setBounds(155, 36, 180, 20);
		contentPane.add(t1);
		t1.setColumns(10);

		t2 = new JPasswordField();
		t2.setFont(new Font("Tahoma", Font.BOLD, 11));
		t2.setBounds(155, 87, 180, 20);
		contentPane.add(t2);
		t2.setColumns(10);

		JButton b1 = new JButton("Confirm");
		b1.setFont(new Font("Tahoma", Font.BOLD, 12));
		b1.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent e) {
				String pass = t1.getText();
				String pass1 = t2.getText();
				try {
					Class.forName("com.mysql.jdbc.Driver");
					Connection con = DriverManager.getConnection("jdbc:mysql://localhost/student", "root", "");
					Statement p = con.createStatement();
					ResultSet r = (ResultSet) p.executeQuery("select * from usertable");
					int count = 0;

					while (r.next()) {
						if ((pass.equals("")) || (pass1.equals(""))) {
							count = 1;
						} 
						else if ((name.equals(r.getString(2)) && (mail.equals(r.getString(7))))) {
							if (pass.equals(pass1)) {
								if (pass.equals(r.getString(8))) {
									JOptionPane.showMessageDialog(null, "Your new password can't be your old password");
									t1.setText("");
									t2.setText("");
								} else if (l1.getText().equals("Invalid password")) {
									JOptionPane.showMessageDialog(null, "Password is Invalid");
								} else {
									PreparedStatement p1 = con
											.prepareStatement("update usertable set password=? where username=?");
									p1.setString(1, pass);
									p1.setString(2, name);
									p1.executeUpdate();

									t1.setText("");
									t2.setText("");
									count = 2;
									new Login();
									setVisible(false);
									break;
								}
							} else {
								count = 3;
							}

						}

					}

					if (count == 1) {
						JOptionPane.showMessageDialog(null, "You should input first");
					} else if (count == 2)
						JOptionPane.showMessageDialog(null, "Password Changed Successfully");
					else if (count == 3) {
						JOptionPane.showMessageDialog(null, "Re-enter the same password");
						t1.setText("");
						t2.setText("");
					}

					p.close();
					con.close();

				} catch (ClassNotFoundException ex1) {

				} catch (SQLException ex) {

				}
			}
		});
		b1.setBounds(44, 127, 105, 23);
		contentPane.add(b1);

		JButton b2 = new JButton("Cancel");
		b2.setFont(new Font("Tahoma", Font.BOLD, 12));
		b2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new Login();
				setVisible(false);
			}
		});
		b2.setBounds(209, 127, 105, 23);
		contentPane.add(b2);

		l1 = new JLabel();
		l1.setBounds(155, 60, 116, 14);
		contentPane.add(l1);
		
		JLabel lblNewLabel = new JLabel("Reset Password");
		lblNewLabel.setForeground(Color.BLUE);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel.setBounds(100, 0, 170, 25);
		contentPane.add(lblNewLabel);
		l1.setVisible(false);
	}
}
