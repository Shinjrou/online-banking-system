package banking_system_project;

import java.awt.EventQueue;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

@SuppressWarnings("serial")
public class Feedback extends JFrame {

	private JPanel contentPane;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					// Feedback frame = new Feedback();

				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public Feedback() {
		setTitle("Feeback from Users");

		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 315);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 11, 414, 227);
		contentPane.add(scrollPane);

		JTextArea textArea = new JTextArea();
		scrollPane.setViewportView(textArea);
		textArea.setText("UserID" + "\t" + "Username" + "\t" + "Feedback" + "\n");
		
		JButton btnNewButton = new JButton("Back");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new TestingTable();
				setVisible(false);
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnNewButton.setBounds(169, 249, 89, 23);
		contentPane.add(btnNewButton);
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost/student", "root", "");

			Statement s = con.createStatement();
			ResultSet r = s.executeQuery("select * from usertable");

			while (r.next()) {
				if (!r.getString(12).equals("")) {
					textArea.append(r.getString(1) + "\t" + r.getString(2) + "\t" + r.getString(12) + "\n");

				}

			}
			s.close();
			con.close();
		} catch (Exception e1) {
			e1.toString();
		}
	}
}
