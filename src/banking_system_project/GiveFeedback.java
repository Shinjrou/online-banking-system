package banking_system_project;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import javax.swing.JTextArea;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.awt.event.ActionEvent;

@SuppressWarnings("serial")
public class GiveFeedback extends JFrame {

	private JPanel contentPane;
	JTextArea t;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					// GiveFeedback frame = new GiveFeedback();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public GiveFeedback(String username) {
		setVisible(true);
		setTitle("Submit Feedback");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 497, 301);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		t = new JTextArea();
		t.setBounds(10, 11, 461, 199);
		contentPane.add(t);
		t.setLineWrap(true);

		JButton btnNewButton_1 = new JButton("Back");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new Home(username);
				setVisible(false);
			}
		});
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnNewButton_1.setBounds(268, 228, 89, 23);
		contentPane.add(btnNewButton_1);

		JButton btnNewButton = new JButton("Submit");
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String ts = t.getText();
					String name = username;

					System.out.println(t.getText());
					Class.forName("com.mysql.jdbc.Driver");
					Connection con = DriverManager.getConnection("jdbc:mysql://localhost/student", "root", "");

					PreparedStatement p = con.prepareStatement("update usertable set feedback=? where username=?");
					p.setString(1, ts);
					p.setString(2, name);
					p.executeUpdate();
					JOptionPane.showMessageDialog(null, "Feedback Sent");
					new Home(username);
					setVisible(false);
					con.close();
					p.close();
				} catch (Exception e1) {
					e1.toString();
				}
			}
		});
		btnNewButton.setBounds(92, 229, 89, 23);
		contentPane.add(btnNewButton);
	}

}
