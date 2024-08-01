package banking_system_project;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.border.TitledBorder;
import java.awt.SystemColor;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;

@SuppressWarnings("serial")
public class AccInfo extends JFrame {

	private JPanel contentPane;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					// AccInfo frame = new AccInfo("");

				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public AccInfo(String id, String username, String pass, String fname, String lname, String gender, String dob,
			String email, String ph, String addr, String bal) {
		setResizable(false);
		setTitle("Account Details");
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 311, 343);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "Account Details", TitledBorder.CENTER, TitledBorder.TOP, null,
				SystemColor.desktop));
		panel.setBounds(10, 11, 275, 255);
		contentPane.add(panel);
		panel.setLayout(null);

		JLabel l1 = new JLabel("UserID :");
		l1.setFont(new Font("Tahoma", Font.BOLD, 11));
		l1.setBounds(0, 25, 78, 14);
		panel.add(l1);
		l1.setHorizontalAlignment(SwingConstants.RIGHT);

		JLabel l2 = new JLabel("Username :");
		l2.setFont(new Font("Tahoma", Font.BOLD, 11));
		l2.setBounds(0, 50, 78, 14);
		panel.add(l2);
		l2.setHorizontalAlignment(SwingConstants.RIGHT);

		JLabel l4 = new JLabel("First Name :");
		l4.setFont(new Font("Tahoma", Font.BOLD, 11));
		l4.setBounds(0, 75, 78, 14);
		panel.add(l4);
		l4.setHorizontalAlignment(SwingConstants.RIGHT);

		JLabel l5 = new JLabel("Last Name :");
		l5.setFont(new Font("Tahoma", Font.BOLD, 11));
		l5.setBounds(0, 100, 78, 14);
		panel.add(l5);
		l5.setHorizontalAlignment(SwingConstants.RIGHT);

		JLabel l6 = new JLabel("Gender :");
		l6.setFont(new Font("Tahoma", Font.BOLD, 11));
		l6.setBounds(0, 125, 78, 14);
		panel.add(l6);
		l6.setHorizontalAlignment(SwingConstants.RIGHT);

		JLabel l7 = new JLabel("Date of Birth :");
		l7.setFont(new Font("Tahoma", Font.BOLD, 11));
		l7.setBounds(0, 150, 78, 14);
		panel.add(l7);
		l7.setHorizontalAlignment(SwingConstants.RIGHT);

		JLabel l8 = new JLabel("Email :");
		l8.setFont(new Font("Tahoma", Font.BOLD, 11));
		l8.setBounds(0, 175, 78, 14);
		panel.add(l8);
		l8.setHorizontalAlignment(SwingConstants.RIGHT);

		JLabel l9 = new JLabel("Phone :");
		l9.setFont(new Font("Tahoma", Font.BOLD, 11));
		l9.setBounds(0, 200, 78, 14);
		panel.add(l9);
		l9.setHorizontalAlignment(SwingConstants.RIGHT);

		JLabel l10 = new JLabel("Address :");
		l10.setFont(new Font("Tahoma", Font.BOLD, 11));
		l10.setBounds(0, 225, 78, 14);
		panel.add(l10);
		l10.setHorizontalAlignment(SwingConstants.RIGHT);

		JLabel r1 = new JLabel();
		r1.setFont(new Font("Tahoma", Font.BOLD, 11));
		r1.setText(id);
		r1.setBounds(88, 25, 155, 14);
		panel.add(r1);

		JLabel r2 = new JLabel();
		r2.setFont(new Font("Tahoma", Font.BOLD, 11));
		r2.setText(username);
		r2.setBounds(88, 50, 155, 14);
		panel.add(r2);

		JLabel r4 = new JLabel();
		r4.setFont(new Font("Tahoma", Font.BOLD, 11));
		r4.setText(fname);
		r4.setBounds(88, 75, 155, 14);
		panel.add(r4);

		JLabel r5 = new JLabel();
		r5.setFont(new Font("Tahoma", Font.BOLD, 11));
		r5.setText(lname);
		r5.setBounds(88, 100, 155, 14);
		panel.add(r5);

		JLabel r6 = new JLabel();
		r6.setFont(new Font("Tahoma", Font.BOLD, 11));
		r6.setText(gender);
		r6.setBounds(88, 125, 155, 14);
		panel.add(r6);

		JLabel r7 = new JLabel();
		r7.setFont(new Font("Tahoma", Font.BOLD, 11));
		r7.setText(dob);
		r7.setBounds(88, 150, 155, 14);
		panel.add(r7);

		JLabel r8 = new JLabel();
		r8.setFont(new Font("Tahoma", Font.BOLD, 11));
		r8.setText(email);
		r8.setBounds(88, 175, 187, 14);
		panel.add(r8);

		JLabel r9 = new JLabel();
		r9.setFont(new Font("Tahoma", Font.BOLD, 11));
		r9.setText(ph);
		r9.setBounds(88, 200, 155, 14);
		panel.add(r9);

		JLabel r10 = new JLabel();
		r10.setFont(new Font("Tahoma", Font.BOLD, 11));
		r10.setText(addr);
		r10.setBounds(88, 225, 155, 14);
		panel.add(r10);

		JButton b = new JButton("Back");
		b.setFont(new Font("Tahoma", Font.BOLD, 15));
		b.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new Home(username);
				setVisible(false);
			}
		});
		b.setBounds(103, 277, 89, 23);
		contentPane.add(b);
	}
}
