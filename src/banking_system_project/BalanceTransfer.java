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
import java.sql.ResultSet;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import javax.swing.border.TitledBorder;
import javax.swing.border.EtchedBorder;
import java.awt.Color;
import java.awt.Font;

@SuppressWarnings("serial")
public class BalanceTransfer extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					// new BalanceTransfer("htoo", "33888");
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public BalanceTransfer(String username, String balance) {
		setTitle("Balance Transfer");
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 267, 189);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(
				new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)),
				"Recipient's Information", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel.setBounds(10, 11, 237, 121);
		contentPane.add(panel);
		panel.setLayout(null);

		JLabel lblNewLabel_1 = new JLabel("UserID");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_1.setBounds(16, 25, 79, 20);
		panel.add(lblNewLabel_1);
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.RIGHT);

		textField = new JTextField();
		textField.setFont(new Font("Tahoma", Font.BOLD, 11));
		textField.setBounds(105, 25, 112, 20);
		panel.add(textField);
		textField.setColumns(10);

		textField_1 = new JTextField();
		textField_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		textField_1.setBounds(105, 56, 112, 20);
		panel.add(textField_1);
		textField_1.setColumns(10);

		JButton b_ok1 = new JButton("OK");
		b_ok1.setFont(new Font("Tahoma", Font.BOLD, 12));
		b_ok1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String id = textField.getText();
				String name = textField_1.getText();
				String bal = "";
				int count = 0;
				try {
					Class.forName("com.mysql.jdbc.Driver");
					Connection con = DriverManager.getConnection("jdbc:mysql://localhost/student", "root", "");

					Statement p = con.createStatement();
					ResultSet r = p.executeQuery("select * from usertable");

					while (r.next()) {
						if (id.equals("") || name.equals("")) {
							count = 1;
						} else if (username.equals(name)) {
							count = 4;
						} else if ((id.equals(r.getString(1))) && (name.equals(r.getString(2)))) {
							count = 2;
							bal = r.getString(11);
							break;
						} else {
							count = 3;
						}

					}
					if (count == 1) {
						JOptionPane.showMessageDialog(null, "You should input first");
						textField.setText("");
						textField_1.setText("");
					} else if (count == 4) {
						JOptionPane.showMessageDialog(null, "You can't transfer to yourself");
					} else if (count == 2) {
						new ConfirmTransfer(username, balance, name, bal);
						setVisible(false);
					} else {
						JOptionPane.showMessageDialog(null, "Invalid Input");
						textField.setText("");
						textField_1.setText("");
					}
					p.close();
					con.close();
				} catch (Exception e1) {
					e1.toString();
				}
			}
		});
		b_ok1.setBounds(31, 87, 79, 23);
		panel.add(b_ok1);

		JButton b_c1 = new JButton("Back");
		b_c1.setFont(new Font("Tahoma", Font.BOLD, 12));
		b_c1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new Home(username);
				setVisible(false);
			}
		});
		b_c1.setBounds(120, 87, 79, 23);
		panel.add(b_c1);

		JLabel lblNewLabel = new JLabel("Username");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel.setBounds(16, 56, 79, 20);
		panel.add(lblNewLabel);
		lblNewLabel.setHorizontalAlignment(SwingConstants.RIGHT);
	}
}
