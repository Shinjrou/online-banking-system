package banking_system_project;

import java.awt.Color;
import java.awt.EventQueue;
import java.sql.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.border.EmptyBorder;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.awt.event.ActionEvent;
import javax.swing.border.TitledBorder;
import javax.swing.border.EtchedBorder;
import java.awt.Font;
import javax.swing.SwingConstants;

@SuppressWarnings("serial")
public class Inserting extends JFrame {

	public JPanel contentPane;
	public JTextField t1;
	public JTextField t2;
	public JTextField t3;
	public JTextField t7;
	public JTextField t8;
	public JTextField t9;
	public JTextField t10;
	public JTextField t11;
	JLabel l1, l2, l3, l4, l5, l6, l7, l8, l9, l10, l11, ll;
	public JRadioButton rb1, rb2;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JTextField t4;
	private JTextField t5;
	private JButton b2;
	private static final String EMAIL_PATTERN = "^(?=.{1,64}@)[A-Za-z0-9_-]+(\\.[A-Za-z0-9_-]+)*@" + "[^-][A-Za-z0-9-]+(\\.[A-Za-z0-9-]+)*(\\.[A-Za-z]{2,})$";
	int count = 0;

	private static final Pattern pattern = Pattern.compile(EMAIL_PATTERN);

	public static boolean isValid(final String email) {
		Matcher matcher = pattern.matcher(email);
		return matcher.matches();
	}

	public static class GhostText implements FocusListener, DocumentListener, PropertyChangeListener {
		private final JTextField textfield;
		private boolean isEmpty;
		private Color ghostColor;
		private Color foregroundColor;
		private final String ghostText;

		protected GhostText(final JTextField textfield, String ghostText) {
			super();
			this.textfield = textfield;
			this.ghostText = ghostText;
			this.ghostColor = Color.LIGHT_GRAY;
			textfield.addFocusListener(this);
			registerListeners();
			updateState();
			if (!this.textfield.hasFocus()) {
				focusLost(null);
			}
		}

		public void delete() {
			unregisterListeners();
			textfield.removeFocusListener(this);
		}

		private void registerListeners() {
			textfield.getDocument().addDocumentListener(this);
			textfield.addPropertyChangeListener("foreground", this);
		}

		private void unregisterListeners() {
			textfield.getDocument().removeDocumentListener(this);
			textfield.removePropertyChangeListener("foreground", this);
		}

		public Color getGhostColor() {
			return ghostColor;
		}

		public void setGhostColor(Color ghostColor) {
			this.ghostColor = ghostColor;
		}

		private void updateState() {
			isEmpty = textfield.getText().length() == 0;
			foregroundColor = textfield.getForeground();
		}

		@Override
		public void focusGained(FocusEvent e) {
			if (isEmpty) {
				unregisterListeners();
				try {
					textfield.setText("");
					textfield.setForeground(foregroundColor);
				} finally {
					registerListeners();
				}
			}

		}

		@Override
		public void focusLost(FocusEvent e) {
			if (isEmpty) {
				unregisterListeners();
				try {
					textfield.setText(ghostText);
					textfield.setForeground(ghostColor);
				} finally {
					registerListeners();
				}
			}
		}

		@Override
		public void propertyChange(PropertyChangeEvent evt) {
			updateState();
		}

		@Override
		public void changedUpdate(DocumentEvent e) {
			updateState();
		}

		@Override
		public void insertUpdate(DocumentEvent e) {
			updateState();
		}

		@Override
		public void removeUpdate(DocumentEvent e) {
			updateState();
		}

	}

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					//Inserting frame = new Inserting();
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public Inserting() {
		setResizable(false);
		setTitle("Insert User");

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		setBounds(100, 100, 240, 455);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		t1 = new JTextField();
		t1.setFont(new Font("Tahoma", Font.BOLD, 11));
		t1.setBounds(107, 36, 96, 20);
		contentPane.add(t1);
		t1.setColumns(10);

		t2 = new JTextField();
		t2.setFont(new Font("Tahoma", Font.BOLD, 11));
		t2.setColumns(10);
		t2.setBounds(107, 67, 96, 20);
		contentPane.add(t2);

		t3 = new JTextField();
		t3.setFont(new Font("Tahoma", Font.BOLD, 11));
		@SuppressWarnings("unused")
		GhostText ghostText = new GhostText(t3, "YYYY-MM-DD");
		t3.setColumns(10);
		t3.setBounds(107, 99, 96, 20);
		contentPane.add(t3);

		t7 = new JTextField();
		t7.setFont(new Font("Tahoma", Font.BOLD, 11));
		t7.setColumns(10);
		t7.setBounds(107, 215, 96, 20);
		contentPane.add(t7);

		t8 = new JTextField();
		t8.setFont(new Font("Tahoma", Font.BOLD, 11));
		t8.setColumns(10);
		t8.setBounds(107, 247, 96, 20);
		contentPane.add(t8);

		t9 = new JTextField();
		t9.setFont(new Font("Tahoma", Font.BOLD, 11));
		t9.setColumns(10);
		t9.setBounds(107, 278, 96, 20);
		contentPane.add(t9);

		t10 = new JTextField();
		t10.setFont(new Font("Tahoma", Font.BOLD, 11));
		t10.setColumns(10);
		t10.setBounds(107, 309, 96, 20);
		contentPane.add(t10);

		t11 = new JTextField();
		t11.setFont(new Font("Tahoma", Font.BOLD, 11));
		t11.setColumns(10);
		t11.setBounds(107, 340, 96, 20);
		contentPane.add(t11);

		t4 = new JTextField();
		t4.setFont(new Font("Tahoma", Font.BOLD, 11));
		t4.setBounds(107, 130, 96, 20);
		contentPane.add(t4);
		t4.setColumns(10);

		t5 = new JTextField();
		t5.setFont(new Font("Tahoma", Font.BOLD, 11));
		t5.setBounds(107, 161, 96, 20);
		contentPane.add(t5);
		t5.setColumns(10);

		JButton b1 = new JButton("Insert");
		b1.setFont(new Font("Tahoma", Font.BOLD, 12));
		b1.setBounds(10, 383, 89, 23);
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

				try {
					Class.forName("com.mysql.jdbc.Driver");
					Connection con = DriverManager.getConnection("jdbc:mysql://localhost/student", "root", "");

					if (s1.equals("") || s2.equals("") || s3.equals("") || s4.equals("") || s5.equals("")|| s6.equals("") || s7.equals("") || s8.equals("") || s9.equals("") || s10.equals("")|| s11.equals("") || count==1)
						JOptionPane.showMessageDialog(null, "You should input first");
					else if (isValid(s7) == false) {
						JOptionPane.showMessageDialog(null, "Invalid Email");
					} 
					else {
						int ss11 = Integer.parseInt(s11);
						PreparedStatement p = con.prepareStatement("insert into usertable values(?,?,?,?,?,?,?,?,?,?,?,?)");
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
						p.setString(12, "");
						p.executeUpdate();
						JOptionPane.showMessageDialog(null, "Record Inserted");
						p.close();
						con.close();
						TestingTable t = new TestingTable();
						t.table_update();
						setVisible(false);
					}
				} catch (Exception e1) {
					e1.toString();
				}

			}
		});
		contentPane.add(b1);

		b2 = new JButton("Back");
		b2.setFont(new Font("Tahoma", Font.BOLD, 12));
		b2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new TestingTable();
				setVisible(false);
			}
		});
		b2.setBounds(117, 383, 89, 23);
		contentPane.add(b2);

		JPanel panel1 = new JPanel();
		panel1.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), " Insert values to add new user.", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel1.setBounds(4, 11, 216, 367);
		contentPane.add(panel1);
		panel1.setLayout(null);

		l3 = new JLabel("Birthday");
		l3.setBounds(12, 92, 78, 14);
		panel1.add(l3);
		l3.setHorizontalAlignment(SwingConstants.RIGHT);
		l3.setFont(new Font("Tahoma", Font.BOLD, 12));

		l1 = new JLabel("UserID");
		l1.setBounds(20, 28, 70, 14);
		panel1.add(l1);
		l1.setHorizontalAlignment(SwingConstants.RIGHT);
		l1.setFont(new Font("Tahoma", Font.BOLD, 12));

		l2 = new JLabel("Username");
		l2.setBounds(20, 56, 70, 14);
		panel1.add(l2);
		l2.setHorizontalAlignment(SwingConstants.RIGHT);
		l2.setFont(new Font("Tahoma", Font.BOLD, 12));

		JLabel l4_1 = new JLabel("First Name");
		l4_1.setBounds(12, 125, 78, 14);
		panel1.add(l4_1);
		l4_1.setHorizontalAlignment(SwingConstants.RIGHT);
		l4_1.setFont(new Font("Tahoma", Font.BOLD, 12));

		JLabel l5_1 = new JLabel("Last Name");
		l5_1.setBounds(12, 154, 78, 14);
		panel1.add(l5_1);
		l5_1.setHorizontalAlignment(SwingConstants.RIGHT);
		l5_1.setFont(new Font("Tahoma", Font.BOLD, 12));

		JLabel l6_1 = new JLabel("Gender");
		l6_1.setBounds(20, 179, 70, 14);
		panel1.add(l6_1);
		l6_1.setHorizontalAlignment(SwingConstants.RIGHT);
		l6_1.setFont(new Font("Tahoma", Font.BOLD, 12));

		l7 = new JLabel("Email");
		l7.setBounds(20, 207, 70, 14);
		panel1.add(l7);
		l7.setHorizontalAlignment(SwingConstants.RIGHT);
		l7.setFont(new Font("Tahoma", Font.BOLD, 12));

		l8 = new JLabel("Password");
		l8.setBounds(20, 239, 70, 14);
		panel1.add(l8);
		l8.setHorizontalAlignment(SwingConstants.RIGHT);
		l8.setFont(new Font("Tahoma", Font.BOLD, 12));

		l9 = new JLabel("Phone");
		l9.setBounds(26, 270, 64, 14);
		panel1.add(l9);
		l9.setHorizontalAlignment(SwingConstants.RIGHT);
		l9.setFont(new Font("Tahoma", Font.BOLD, 12));

		l10 = new JLabel("Address");
		l10.setBounds(26, 303, 64, 14);
		panel1.add(l10);
		l10.setHorizontalAlignment(SwingConstants.RIGHT);
		l10.setFont(new Font("Tahoma", Font.BOLD, 12));

		l11 = new JLabel("Balance");
		l11.setBounds(26, 333, 64, 14);
		panel1.add(l11);
		l11.setHorizontalAlignment(SwingConstants.RIGHT);
		l11.setFont(new Font("Tahoma", Font.BOLD, 12));

		rb2 = new JRadioButton("F");
		rb2.setBounds(161, 175, 38, 23);
		panel1.add(rb2);
		rb2.setFont(new Font("Tahoma", Font.BOLD, 12));
		buttonGroup.add(rb2);

		rb1 = new JRadioButton("M");
		rb1.setBounds(110, 175, 38, 23);
		panel1.add(rb1);
		rb1.setFont(new Font("Tahoma", Font.BOLD, 12));
		buttonGroup.add(rb1);

	}

	public String button(JRadioButton b1, JRadioButton b2) {
		if (b1.isSelected())
			return "Male";
		else if(b2.isSelected())
			return "Female";
		else {
			count = 1;
			return null;
		}			
	}
}
