package banking_system_project;

import java.awt.EventQueue;
import java.sql.*;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.DriverManager;
import java.awt.event.ActionEvent;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import java.awt.Font;
import javax.swing.SwingConstants;

@SuppressWarnings("serial")
public class Editing extends JFrame {

	public JPanel contentPane;
	public JTextField t1;
	public JTextField t2;
	public JTextField t3;
	public JTextField t7;
	public JTextField t8;
	public JTextField t9;
	public JTextField t10;
	public JTextField t11;
	JLabel l1, l2, l3, l7, l8, l9, l10, l11, l, ll;
	JButton b1, b2;
	private JTextField t4;
	private JTextField t5;
	public JRadioButton rb1, rb2;
	private final ButtonGroup buttonGroup = new ButtonGroup();

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					// Editing frame = new Editing("1", "", "", "", "", "", "", "", "", "", "100");
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public Editing(String id, String name, String dob, String fname, String lname, String gender, String email,
			String password, String phone, String address, String balance) {
		setResizable(false);
		setTitle("Edit User");
		String id1 = id;
		String name1 = name;
		String dob1 = dob;
		String fname1 = fname;
		String lname1 = lname;
		String gender1 = gender;
		String email1 = email;
		String password1 = password;
		String phone1 = phone;
		String address1 = address;
		String balance1 = balance;

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		setBounds(100, 100, 250, 478);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		l1 = new JLabel("UserID");
		l1.setHorizontalAlignment(SwingConstants.RIGHT);
		l1.setFont(new Font("Tahoma", Font.BOLD, 12));
		l1.setBounds(10, 66, 75, 14);
		contentPane.add(l1);

		l2 = new JLabel("Username");
		l2.setHorizontalAlignment(SwingConstants.RIGHT);
		l2.setFont(new Font("Tahoma", Font.BOLD, 12));
		l2.setBounds(10, 97, 75, 14);
		contentPane.add(l2);

		l3 = new JLabel("Birthday");
		l3.setHorizontalAlignment(SwingConstants.RIGHT);
		l3.setFont(new Font("Tahoma", Font.BOLD, 12));
		l3.setBounds(10, 128, 75, 14);
		contentPane.add(l3);

		l7 = new JLabel("Email");
		l7.setHorizontalAlignment(SwingConstants.RIGHT);
		l7.setFont(new Font("Tahoma", Font.BOLD, 12));
		l7.setBounds(10, 250, 75, 14);
		contentPane.add(l7);

		l8 = new JLabel("Password");
		l8.setHorizontalAlignment(SwingConstants.RIGHT);
		l8.setFont(new Font("Tahoma", Font.BOLD, 12));
		l8.setBounds(10, 279, 75, 14);
		contentPane.add(l8);

		l9 = new JLabel("Phone");
		l9.setHorizontalAlignment(SwingConstants.RIGHT);
		l9.setFont(new Font("Tahoma", Font.BOLD, 12));
		l9.setBounds(10, 310, 75, 14);
		contentPane.add(l9);

		l10 = new JLabel("Address");
		l10.setHorizontalAlignment(SwingConstants.RIGHT);
		l10.setFont(new Font("Tahoma", Font.BOLD, 12));
		l10.setBounds(10, 341, 75, 14);
		contentPane.add(l10);

		l11 = new JLabel("Balance");
		l11.setHorizontalAlignment(SwingConstants.RIGHT);
		l11.setFont(new Font("Tahoma", Font.BOLD, 12));
		l11.setBounds(10, 372, 75, 14);
		contentPane.add(l11);

		t1 = new JTextField();
		t1.setFont(new Font("Tahoma", Font.BOLD, 12));
		t1.setText(id1);
		t1.setBounds(95, 63, 119, 20);
		contentPane.add(t1);
		t1.setColumns(10);

		t2 = new JTextField();
		t2.setFont(new Font("Tahoma", Font.BOLD, 12));
		t2.setText(name1);
		t2.setColumns(10);
		t2.setBounds(95, 94, 119, 20);
		contentPane.add(t2);

		t3 = new JTextField();
		t3.setFont(new Font("Tahoma", Font.BOLD, 12));
		t3.setText(dob1);
		t3.setColumns(10);
		t3.setBounds(95, 125, 119, 20);
		contentPane.add(t3);

		t7 = new JTextField();
		t7.setFont(new Font("Tahoma", Font.BOLD, 12));
		t7.setText(email1);
		t7.setColumns(10);
		t7.setBounds(95, 247, 119, 20);
		contentPane.add(t7);

		t8 = new JTextField();
		t8.setFont(new Font("Tahoma", Font.BOLD, 12));
		t8.setText(password1);
		t8.setColumns(10);
		t8.setBounds(95, 276, 119, 20);
		contentPane.add(t8);

		t9 = new JTextField();
		t9.setFont(new Font("Tahoma", Font.BOLD, 12));
		t9.setText(phone1);
		t9.setColumns(10);
		t9.setBounds(95, 307, 119, 20);
		contentPane.add(t9);

		t10 = new JTextField();
		t10.setFont(new Font("Tahoma", Font.BOLD, 12));
		t10.setText(address1);
		t10.setColumns(10);
		t10.setBounds(95, 338, 119, 20);
		contentPane.add(t10);

		t11 = new JTextField();
		t11.setFont(new Font("Tahoma", Font.BOLD, 12));
		t11.setText(balance1);
		t11.setColumns(10);
		t11.setBounds(95, 369, 119, 20);
		contentPane.add(t11);

		b2 = new JButton("Back");
		b2.setFont(new Font("Tahoma", Font.BOLD, 12));
		b2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new TestingTable();
				setVisible(false);
			}
		});
		b2.setBounds(114, 399, 89, 23);
		contentPane.add(b2);

		l = new JLabel("The Values are following. ");
		l.setFont(new Font("Tahoma", Font.BOLD, 12));
		l.setBounds(10, 11, 174, 14);
		contentPane.add(l);

		ll = new JLabel("Simply change the value to edit.");
		ll.setFont(new Font("Tahoma", Font.BOLD, 12));
		ll.setBounds(10, 30, 204, 14);
		contentPane.add(ll);

		t4 = new JTextField();
		t4.setFont(new Font("Tahoma", Font.BOLD, 12));
		t4.setText(fname1);
		t4.setBounds(95, 154, 119, 20);
		contentPane.add(t4);
		t4.setColumns(10);

		t5 = new JTextField();
		t5.setFont(new Font("Tahoma", Font.BOLD, 12));
		t5.setText(lname1);
		t5.setBounds(95, 185, 119, 20);
		contentPane.add(t5);
		t5.setColumns(10);

		JLabel l4 = new JLabel("First Name");
		l4.setHorizontalAlignment(SwingConstants.RIGHT);
		l4.setFont(new Font("Tahoma", Font.BOLD, 12));
		l4.setBounds(10, 157, 75, 14);
		contentPane.add(l4);

		JLabel l5 = new JLabel("Last Name");
		l5.setHorizontalAlignment(SwingConstants.RIGHT);
		l5.setFont(new Font("Tahoma", Font.BOLD, 12));
		l5.setBounds(10, 188, 75, 14);
		contentPane.add(l5);

		JLabel l6 = new JLabel("Gender");
		l6.setHorizontalAlignment(SwingConstants.RIGHT);
		l6.setFont(new Font("Tahoma", Font.BOLD, 12));
		l6.setBounds(10, 219, 75, 14);
		contentPane.add(l6);

		rb1 = new JRadioButton("M");
		rb1.setHorizontalAlignment(SwingConstants.CENTER);
		rb1.setFont(new Font("Tahoma", Font.BOLD, 12));
		buttonGroup.add(rb1);
		rb1.setBounds(105, 212, 40, 23);
		contentPane.add(rb1);

		rb2 = new JRadioButton("F");
		rb2.setHorizontalAlignment(SwingConstants.CENTER);
		rb2.setFont(new Font("Tahoma", Font.BOLD, 12));
		buttonGroup.add(rb2);
		rb2.setBounds(161, 212, 40, 23);
		contentPane.add(rb2);

		b1 = new JButton("Update");
		b1.setFont(new Font("Tahoma", Font.BOLD, 12));
		b1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String s1 = t1.getText();
				String s2 = t2.getText();
				String s3 = t3.getText();
				String s4 = t4.getText();
				String s5 = t5.getText();
				String s6 = button(rb1, rb2);
				String s7 = t7.getText();
				String s8 = t8.getText();
				String s9 = t9.getText();
				String s10 = t10.getText();
				String s11 = t11.getText();
				int ss11 = Integer.parseInt(s11);
				try {
					Class.forName("com.mysql.jdbc.Driver");
					Connection con = DriverManager.getConnection("jdbc:mysql://localhost/student", "root", "");
					String sql = "update usertable set userID=?, username=?, dob=?, firstname=?, lastname=?, gender=?, email=?, password=?, phone=?, address=?, balance=? where userID=?";
					PreparedStatement p = con.prepareStatement(sql);
					p.setString(1, s1);
					p.setString(2, s2);
					p.setString(3, s3);
					p.setString(4, s4);
					p.setString(5, s5);
					p.setString(6, s6);
					p.setString(7, s7);
					p.setString(8, s8);
					p.setString(9, s9);
					p.setString(10, s10);
					p.setInt(11, ss11);
					p.setString(12, id1);
					p.executeUpdate();
					TestingTable t = new TestingTable();
					t.table_update();
					setVisible(false);
					p.close();
					con.close();
					JOptionPane.showMessageDialog(null, "Record Updated");
				} catch (Exception e1) {
					e1.toString();
				}
			}
		});
		b1.setBounds(10, 399, 89, 23);
		contentPane.add(b1);

		if (gender1.equals("Male")) {
			rb1.setSelected(true);
			rb2.setSelected(false);
		} else if (gender1.equals("Female")) {
			rb1.setSelected(true);
			rb2.setSelected(false);
		}

	}

	public String button(JRadioButton b1, JRadioButton b2) {
		if (b1.isSelected())
			return "Male";
		else
			return "Female";
	}
}
