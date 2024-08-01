package banking_system_project;

import java.awt.EventQueue;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.DecimalFormat;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.ActionEvent;
import java.awt.Font;

@SuppressWarnings("serial")
public class Exchange extends JFrame {

	private JPanel contentPane;
	private JTextField t1;
	private JTextField t2;
	private JTextField t3;
	private JTextField t4;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					// Exchange frame = new Exchange("thant");
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public Exchange(String username) {
		setTitle("Currency Exchange");
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 350, 202);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		JPanel panel = new JPanel();
		panel.setBounds(10, 11, 300, 106);
		contentPane.add(panel);
		panel.setLayout(null);
		JLabel l1 = new JLabel("Dollar($)");
		l1.setFont(new Font("Tahoma", Font.BOLD, 12));
		l1.setHorizontalAlignment(SwingConstants.RIGHT);
		l1.setBounds(43, 35, 86, 14);
		panel.add(l1);
		JLabel l2 = new JLabel("Kyat(MMK) :");
		l2.setFont(new Font("Tahoma", Font.BOLD, 12));
		l2.setHorizontalAlignment(SwingConstants.RIGHT);
		l2.setBounds(43, 60, 86, 14);
		panel.add(l2);

		t1 = new JTextField();
		t1.setFont(new Font("Tahoma", Font.BOLD, 12));
		t1.addFocusListener(new FocusListener() {

			@Override
			public void focusGained(FocusEvent e) {
				// TODO Auto-generated method stub
				t1.getDocument().addDocumentListener(new DocumentListener() {
					@Override
					public void insertUpdate(DocumentEvent e) {
						// TODO Auto-generated method stub
						change();
					}

					@Override
					public void removeUpdate(DocumentEvent e) {
						// TODO Auto-generated method stub
						if (t1.getText().equals("")) {
							t4.setText("");
						} else {
							change();
						}
					}

					@Override
					public void changedUpdate(DocumentEvent e) {
						// TODO Auto-generated method stub
						change();
					}

					public void change() {
						t2.setVisible(false);
						t4.setVisible(true);
						String a = t1.getText();
						if (!a.matches("^[0-9]*$")) {
							JOptionPane.showMessageDialog(null, "Balance can only be numbers");
						} else {
							Double ab = Double.parseDouble(a);
							Double b = ab * 3000;
							DecimalFormat df = new DecimalFormat();
							df.setMaximumFractionDigits(3);
							t4.setText(df.format(b));
							t4.setFont(new Font("Tahoma", Font.BOLD, 12));
						}
					}
				});
			}

			@Override
			public void focusLost(FocusEvent e) {
				// TODO Auto-generated method stub
				t1.setText("");
			}
		});
		t1.setBounds(139, 32, 110, 20);
		panel.add(t1);
		t1.setColumns(10);
		t2 = new JTextField();
		t2.setFont(new Font("Tahoma", Font.BOLD, 12));
		t2.addFocusListener(new FocusListener() {

			@Override
			public void focusGained(FocusEvent e) {
				// TODO Auto-generated method stub
				t2.getDocument().addDocumentListener(new DocumentListener() {
					@Override
					public void insertUpdate(DocumentEvent e) {
						// TODO Auto-generated method stub
						changee();
					}

					@Override
					public void removeUpdate(DocumentEvent e) {
						// TODO Auto-generated method stub
						if (t2.getText().equals("")) {
							t3.setText("");
						} else {
							changee();
						}
					}

					@Override
					public void changedUpdate(DocumentEvent e) {
						// TODO Auto-generated method stub
						changee();
					}

					public void changee() {
						t1.setVisible(false);
						t3.setVisible(true);
						String a = t2.getText();
						if (!a.matches("^[0-9]*$")) {
							JOptionPane.showMessageDialog(null, "Balance can only be numbers");
						} else {
							Double ab = Double.parseDouble(a);
							Double b = ab / 3000;
							DecimalFormat df = new DecimalFormat();
							df.setMaximumFractionDigits(3);
							t3.setText(df.format(b));
							t3.setFont(new Font("Tahoma", Font.BOLD, 12));
						}
					}
				});
			}

			@Override
			public void focusLost(FocusEvent e) {
				// TODO Auto-generated method stub
				t2.setText("");
			}
		});
		t2.setBounds(139, 57, 110, 20);
		panel.add(t2);
		t2.setColumns(10);
		JLabel l = new JLabel("Your balance is Dollar is :");
		l.setFont(new Font("Tahoma", Font.BOLD, 12));
		l.setHorizontalAlignment(SwingConstants.CENTER);
		l.setBounds(10, 10, 181, 14);
		panel.add(l);
		JLabel ll = new JLabel("New label");
		ll.setFont(new Font("Tahoma", Font.BOLD, 12));
		ll.setBounds(190, 10, 86, 14);
		panel.add(ll);
		t3 = new JTextField();
		t3.addFocusListener(new FocusListener() {

			@Override
			public void focusGained(FocusEvent e) {
				// TODO Auto-generated method stub
				t1.setVisible(true);
				t3.setVisible(false);
			}

			@Override
			public void focusLost(FocusEvent e) {
				// TODO Auto-generated method stub
			}
		});
		t3.setVisible(false);
		t3.setBounds(139, 32, 110, 20);
		panel.add(t3);
		t3.setColumns(10);
		t4 = new JTextField();
		t4.addFocusListener(new FocusListener() {

			@Override
			public void focusGained(FocusEvent e) {
				// TODO Auto-generated method stub
				t4.setVisible(false);
				t2.setVisible(true);
			}

			@Override
			public void focusLost(FocusEvent e) {
				// TODO Auto-generated method stub
			}
		});
		t4.setBounds(139, 57, 110, 20);
		panel.add(t4);
		t4.setColumns(10);
		JButton btnNewButton = new JButton("Back");
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new Home(username);
				setVisible(false);
			}
		});
		btnNewButton.setBounds(235, 129, 89, 23);
		contentPane.add(btnNewButton);
		try {
			double c = 0;
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost/student", "root", "");
			Statement s = con.createStatement();
			ResultSet r = s.executeQuery("select * from usertable");
			while (r.next()) {
				if (username.equals(r.getString(2))) {
					c = r.getInt(11);
					c = c / 3000;
					DecimalFormat df = new DecimalFormat();
					df.setMaximumFractionDigits(3);
					ll.setText(df.format(c) + "$");
				}
			}
			s.close();
			con.close();
		} catch (Exception e2) {
			e2.toString();
		}
	}
}