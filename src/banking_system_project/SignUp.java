package banking_system_project;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

import javax.swing.JTextField;
import javax.swing.ButtonGroup;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JButton;
import javax.swing.JComboBox;

import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collections;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.awt.event.ActionEvent;

@SuppressWarnings("serial")
public class SignUp extends JFrame {
	private JTextField idnumberTextField;
	private JTextField usernameTextField;
	private JPasswordField passwordField;
	private JTextField fnameTextField;
	private JTextField lnameTextField;
	private JTextField emailTextField;
	private JTextField phnoTextField;
	private JTextField addressTextField;
	JLabel l1;
	int count = 0;
	JRadioButton maleRadioButton;
	JRadioButton femaleRadioButton;
	String year1, month1, day1;
	JComboBox<Object> c1, c2, c3;
	Object[] array1, array2, array3;
	private JTextField balanceTextField;

	private static final String EMAIL_PATTERN = "^(?=.{1,64}@)[A-Za-z0-9_-]+(\\.[A-Za-z0-9_-]+)*@"
			+ "[^-][A-Za-z0-9-]+(\\.[A-Za-z0-9-]+)*(\\.[A-Za-z]{2,})$";
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
					//new SignUp();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public SignUp() {

		setTitle("Banking Signup");
		setLocationRelativeTo(null);
		setVisible(true);
		setResizable(false);
		setAlwaysOnTop(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 521);
		getContentPane().setLayout(null);

		JLabel signupLabel = new JLabel("Create your account");
		signupLabel.setForeground(Color.BLUE);
		signupLabel.setHorizontalAlignment(SwingConstants.CENTER);
		signupLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
		signupLabel.setBounds(121, 11, 200, 18);
		getContentPane().add(signupLabel);

		JLabel idnumberLabel = new JLabel("ID Number");
		idnumberLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
		idnumberLabel.setBounds(47, 44, 82, 19);
		getContentPane().add(idnumberLabel);

		idnumberTextField = new JTextField();
		idnumberTextField.setFont(new Font("Tahoma", Font.BOLD, 12));
		idnumberTextField.setBounds(173, 45, 209, 20);
		getContentPane().add(idnumberTextField);
		idnumberTextField.setColumns(10);

		JLabel usernameLabel = new JLabel("Username");
		usernameLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
		usernameLabel.setBounds(47, 79, 82, 19);
		getContentPane().add(usernameLabel);

		usernameTextField = new JTextField();
		usernameTextField.setFont(new Font("Tahoma", Font.BOLD, 12));
		usernameTextField.setBounds(173, 80, 209, 20);
		getContentPane().add(usernameTextField);
		usernameTextField.setColumns(10);

		JLabel passwordLabel = new JLabel("Password");
		passwordLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
		passwordLabel.setBounds(47, 114, 82, 19);
		getContentPane().add(passwordLabel);

		passwordField = new JPasswordField();
		passwordField.setFont(new Font("Tahoma", Font.BOLD, 12));
		passwordField.getDocument().addDocumentListener(new DocumentListener() {
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
				pass = passwordField.getText();
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
				l1.setVisible(true);
			}
		});
		passwordField.setBounds(173, 115, 209, 20);
		getContentPane().add(passwordField);

		JLabel fnameLabel = new JLabel("First Name");
		fnameLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
		fnameLabel.setBounds(47, 149, 82, 19);
		getContentPane().add(fnameLabel);

		fnameTextField = new JTextField();
		fnameTextField.setFont(new Font("Tahoma", Font.BOLD, 12));
		fnameTextField.setBounds(173, 150, 209, 20);
		getContentPane().add(fnameTextField);
		fnameTextField.setColumns(10);

		JLabel lnameLabel = new JLabel("Last Name");
		lnameLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
		lnameLabel.setBounds(47, 184, 82, 19);
		getContentPane().add(lnameLabel);

		lnameTextField = new JTextField();
		lnameTextField.setFont(new Font("Tahoma", Font.BOLD, 12));
		lnameTextField.setBounds(173, 185, 209, 20);
		getContentPane().add(lnameTextField);
		lnameTextField.setColumns(10);

		JLabel genderLabel = new JLabel("Gender");
		genderLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
		genderLabel.setBounds(47, 219, 82, 19);
		getContentPane().add(genderLabel);

		maleRadioButton = new JRadioButton("Male");
		maleRadioButton.setSelected(true);
		maleRadioButton.setFont(new Font("Tahoma", Font.BOLD, 15));
		maleRadioButton.setBounds(173, 220, 100, 20);
		getContentPane().add(maleRadioButton);

		femaleRadioButton = new JRadioButton("Female");
		femaleRadioButton.setFont(new Font("Tahoma", Font.BOLD, 15));
		femaleRadioButton.setBounds(273, 220, 100, 20);
		getContentPane().add(femaleRadioButton);

		ButtonGroup bg = new ButtonGroup();
		bg.add(maleRadioButton);
		bg.add(femaleRadioButton);

		JLabel dobLabel = new JLabel("Date of Birth");
		dobLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
		dobLabel.setBounds(47, 254, 100, 19);
		getContentPane().add(dobLabel);

		JLabel emailLabel = new JLabel("Email");
		emailLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
		emailLabel.setBounds(47, 289, 82, 19);
		getContentPane().add(emailLabel);

		emailTextField = new JTextField();
		emailTextField.setFont(new Font("Tahoma", Font.BOLD, 12));
		emailTextField.setBounds(173, 290, 209, 20);
		getContentPane().add(emailTextField);
		emailTextField.setColumns(10);

		JLabel phnoLabel = new JLabel("Phone No.");
		phnoLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
		phnoLabel.setBounds(47, 319, 82, 19);
		getContentPane().add(phnoLabel);

		phnoTextField = new JTextField();
		phnoTextField.setFont(new Font("Tahoma", Font.BOLD, 12));
		phnoTextField.setBounds(173, 325, 209, 20);
		getContentPane().add(phnoTextField);
		phnoTextField.setColumns(10);

		JLabel addressLabel = new JLabel("Address");
		addressLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
		addressLabel.setBounds(47, 354, 82, 19);
		getContentPane().add(addressLabel);

		addressTextField = new JTextField();
		addressTextField.setFont(new Font("Tahoma", Font.BOLD, 12));
		addressTextField.setBounds(173, 360, 209, 20);
		getContentPane().add(addressTextField);
		addressTextField.setColumns(10);

		JLabel balanceLabel = new JLabel("Balance");
		balanceLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
		balanceLabel.setBounds(47, 389, 82, 19);
		getContentPane().add(balanceLabel);

		JButton b1 = new JButton("Create");
		b1.setFont(new Font("Tahoma", Font.BOLD, 12));
		b1.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent e) {
				int y = c1.getSelectedIndex();
				Object year = array1[y];
				year1 = year.toString();

				int m = c2.getSelectedIndex();
				Object month = array2[m];
				month1 = month.toString();

				int d = c3.getSelectedIndex();
				Object day = array3[d];
				day1 = day.toString();

				String s1 = idnumberTextField.getText();
				String s2 = usernameTextField.getText();
				String s3 = year1 + "-" + month1 + "-" + day1;
				String s4 = fnameTextField.getText();
				String s5 = lnameTextField.getText();
				String s6 = button(maleRadioButton, femaleRadioButton);
				String s7 = emailTextField.getText();
				String s8 = passwordField.getText();
				String s9 = phnoTextField.getText();
				String s10 = addressTextField.getText();
				String s11 = balanceTextField.getText();

				int counts = 0;
				try {
					Class.forName("com.mysql.jdbc.Driver");
					Connection con = DriverManager.getConnection("jdbc:mysql://localhost/student", "root", "");

					Statement s = con.createStatement();
					ResultSet r = s.executeQuery("select * from usertable");
					while (r.next()) {
						if (s2.equals(r.getString(2))) {
							counts = 1;
						}

						if (s1.equals(r.getString(1)) || s1.length() != 6) {
							counts = 2;
						}
					}

					if (s1.equals("") || s2.equals("") || s3.equals("") || s4.equals("") || s5.equals("")
							|| s6.equals("") || s7.equals("") || s8.equals("") || s9.equals("") || s10.equals("")
							|| s11.equals("") || count == 1) {
						JOptionPane.showMessageDialog(null, "You should input first");
					} 
					else if (isValid(s7) == false) {
						JOptionPane.showMessageDialog(null, "Invalid email");
					} 
					else if (counts == 1) {
						JOptionPane.showMessageDialog(null, "Username already exists");
					} 
					else if (counts == 2) {
						JOptionPane.showMessageDialog(null, "ID number must be unique and must have 6 digits");
					} 
					else if (!s4.matches("^[a-zA-Z_ ]*$") || !s5.matches("^[a-zA-Z_ ]*$")) {
						JOptionPane.showMessageDialog(null, "Your name must only be characters");
					} 
					else if (!s9.matches("^[0-9]*$") || (s9.length() < 7) || (s9.length() > 15)) {
						JOptionPane.showMessageDialog(null, "Phone number must only be numbers & range between 7 to 15 digits");
					} 
					else if (!s11.matches("^[0-9]*$")) {
						JOptionPane.showMessageDialog(null, "Balance must only be numbers");
					} 
					else if (l1.getText().equals("Invalid password")) {
						JOptionPane.showMessageDialog(null, "Invalid Password");
					} 
					else {
						try {
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
							JOptionPane.showMessageDialog(null, "Account created");
							new Login();
							setVisible(false);
							idnumberTextField.setText("");
							usernameTextField.setText("");
							passwordField.setText("");
							fnameTextField.setText("");
							lnameTextField.setText("");
							c1.setSelectedIndex(0);
							c2.setSelectedIndex(0);
							c3.setSelectedIndex(0);
							emailTextField.setText("");
							phnoTextField.setText("");
							addressTextField.setText("");
							balanceTextField.setText("");
							p.close();

						} catch (Exception e1) {
							e1.toString();
						}
					}
					con.close();
					s.close();
				} catch (Exception e1) {
					e1.toString();
				}
			}
		});
		b1.setBounds(37, 433, 92, 23);
		getContentPane().add(b1);

		JButton b2 = new JButton("Reset All");
		b2.setFont(new Font("Tahoma", Font.BOLD, 12));
		b2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				idnumberTextField.setText("");
				usernameTextField.setText("");
				passwordField.setText("");
				fnameTextField.setText("");
				lnameTextField.setText("");
				c1.setSelectedIndex(0);
				c2.setSelectedIndex(0);
				c3.setSelectedIndex(0);
				emailTextField.setText("");
				phnoTextField.setText("");
				addressTextField.setText("");
				balanceTextField.setText("");
				maleRadioButton.setSelected(true);

			}
		});
		b2.setBounds(160, 433, 92, 23);
		getContentPane().add(b2);

		JButton b3 = new JButton("Back");
		b3.setFont(new Font("Tahoma", Font.BOLD, 12));
		b3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new Login();
				setVisible(false);
			}
		});
		b3.setBounds(280, 433, 92, 23);
		getContentPane().add(b3);

		l1 = new JLabel("");
		l1.setBounds(173, 133, 231, 14);
		getContentPane().add(l1);

		ArrayList<Integer> ls1 = new ArrayList<Integer>();
		for (int i = 1900; i <= 2022; i++) {
			ls1.add(i);
		}
		Collections.reverse(ls1);
		array1 = ls1.toArray();
		c1 = new JComboBox<Object>(array1);
		c1.setFont(new Font("Tahoma", Font.BOLD, 11));
		c1.setBounds(173, 254, 65, 22);
		getContentPane().add(c1);

		ArrayList<Integer> ls2 = new ArrayList<Integer>();
		for (int j = 1; j <= 12; j++) {
			ls2.add(j);
		}
		array2 = ls2.toArray();
		c2 = new JComboBox<Object>(array2);
		c2.setFont(new Font("Tahoma", Font.BOLD, 11));
		c2.setBounds(255, 254, 40, 22);
		getContentPane().add(c2);

		ArrayList<Integer> ls3 = new ArrayList<Integer>();
		for (int x = 1; x <= 31; x++) {
			ls3.add(x);
		}
		array3 = ls3.toArray();
		c3 = new JComboBox<Object>(array3);
		c3.setFont(new Font("Tahoma", Font.BOLD, 11));
		c3.setBounds(310, 254, 72, 22);

		getContentPane().add(c3);

		JLabel lblNewLabel = new JLabel("-");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(224, 258, 46, 14);
		getContentPane().add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("-");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(280, 258, 46, 14);
		getContentPane().add(lblNewLabel_1);

		balanceTextField = new JTextField();
		balanceTextField.setFont(new Font("Tahoma", Font.BOLD, 12));
		balanceTextField.setBounds(173, 391, 209, 20);
		getContentPane().add(balanceTextField);
		balanceTextField.setColumns(10);

	}

	public String button(JRadioButton b1, JRadioButton b2) {
		if (b1.isSelected())
			return "Male";
		else if (b2.isSelected())
			return "Female";
		else {
			count = 1;
			return null;
		}
	}
}
