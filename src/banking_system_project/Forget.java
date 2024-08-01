package banking_system_project;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.sql.ResultSet;

import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.border.TitledBorder;

@SuppressWarnings("serial")
public class Forget extends JFrame {

	private JPanel contentPane;
	private JTextField t1;
	private JTextField t2;
	JPanel panel_1;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					// Forget frame = new Forget();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public Forget() {
		setResizable(false);
		setTitle("Forgot Password?");
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 292, 181);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(null, "Password Recovery", TitledBorder.CENTER, TitledBorder.TOP, null, null));
		panel_1.setBounds(10, 11, 256, 120);
		contentPane.add(panel_1);
		panel_1.setLayout(null);

		JLabel l1 = new JLabel("Username");
		l1.setFont(new Font("Tahoma", Font.BOLD, 12));
		l1.setHorizontalAlignment(SwingConstants.RIGHT);
		l1.setBounds(10, 25, 80, 14);
		panel_1.add(l1);

		JLabel l2 = new JLabel("Email");
		l2.setFont(new Font("Tahoma", Font.BOLD, 12));
		l2.setHorizontalAlignment(SwingConstants.RIGHT);
		l2.setBounds(10, 50, 80, 14);
		panel_1.add(l2);

		t1 = new JTextField();
		t1.setFont(new Font("Tahoma", Font.BOLD, 11));
		t1.setBounds(104, 21, 120, 20);
		panel_1.add(t1);
		t1.setColumns(10);

		t2 = new JTextField();
		t2.setFont(new Font("Tahoma", Font.BOLD, 11));
		t2.setBounds(104, 46, 120, 20);
		panel_1.add(t2);
		t2.setColumns(10);

		JButton bb1 = new JButton("OK");
		bb1.setFont(new Font("Tahoma", Font.BOLD, 12));
		bb1.setBounds(20, 77, 89, 23);
		panel_1.add(bb1);

		JButton bb2 = new JButton("Back");
		bb2.setFont(new Font("Tahoma", Font.BOLD, 12));
		bb2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new Login();
				setVisible(false);
			}
		});
		bb2.setBounds(124, 77, 89, 23);
		panel_1.add(bb2);
		bb1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String name = t1.getText();
				String mail = t2.getText();
				try {
					Class.forName("com.mysql.jdbc.Driver");
					Connection con = DriverManager.getConnection("jdbc:mysql://localhost/student", "root", "");
					Statement p = con.createStatement();
					ResultSet r = p.executeQuery("select * from usertable");
					int count = 0;

					while (r.next()) {
						if ((name.equals("")) || (mail.equals(""))) {
							count = 1;
						} else if ((name.equals(r.getString(2)) && (mail.equals(r.getString(7))))) {
							count = 3;
							new ConfirmPass(name, mail);
							setVisible(false);
							break;
						} else
							count = 2;
					}

					if (count == 1) {
						JOptionPane.showMessageDialog(null, "You should input first");
					} else if (count == 3)
						JOptionPane.showMessageDialog(null, "Please change new password");
					else if (count == 2)
						JOptionPane.showMessageDialog(null, "Invalid Username or Email");

					p.close();
					con.close();

					// table_update();

				} catch (ClassNotFoundException ex1) {

				} catch (SQLException ex) {

				}
			}
		});
	}
}
