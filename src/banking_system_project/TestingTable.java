package banking_system_project;

import java.awt.EventQueue;
import java.sql.DriverManager;
import java.sql.*;

import javax.swing.*;
import javax.swing.border.*;
import javax.swing.table.*;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;

@SuppressWarnings("serial")
public class TestingTable extends JFrame {

	private JPanel contentPane;
	private JTable table1;
	String id1, name1, dob1, email1, fname1, lname1, gender1, pass1, ph1, addr1, balance1, feedback1;
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					// TestingTable frame = new TestingTable();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public TestingTable() {
		setResizable(false);
		setTitle("Administration Settings");
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1041, 360);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 11, 1000, 250);

		contentPane.add(scrollPane);

		table1 = new JTable();
		scrollPane.setViewportView(table1);

		JButton b1 = new JButton("Insert");
		b1.setFont(new Font("Tahoma", Font.BOLD, 12));
		b1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new Inserting();
				setVisible(false);
			}
		});
		b1.setBounds(87, 278, 100, 30);
		contentPane.add(b1);

		JButton b2 = new JButton("Edit");
		b2.setFont(new Font("Tahoma", Font.BOLD, 12));
		b2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DefaultTableModel model = (DefaultTableModel) table1.getModel();
				int selectedIndex = table1.getSelectedRow();

				String id = model.getValueAt(selectedIndex, 0).toString();
				String name = model.getValueAt(selectedIndex, 1).toString();
				String date = model.getValueAt(selectedIndex, 2).toString();
				String fname = model.getValueAt(selectedIndex, 3).toString();
				String lname = model.getValueAt(selectedIndex, 4).toString();
				String gender = model.getValueAt(selectedIndex, 5).toString();
				String email = model.getValueAt(selectedIndex, 6).toString();
				String pass = model.getValueAt(selectedIndex, 7).toString();
				String ph = model.getValueAt(selectedIndex, 8).toString();
				String addr = model.getValueAt(selectedIndex, 9).toString();
				String bal = model.getValueAt(selectedIndex, 10).toString();

				new Editing(id, name, date, fname, lname, gender, email, pass, ph, addr, bal);
				setVisible(false);
				table_update();

			}
		});
		b2.setBounds(278, 278, 100, 30);
		contentPane.add(b2);

		JButton b4 = new JButton("Exit");
		b4.setFont(new Font("Tahoma", Font.BOLD, 12));
		b4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});

		b4.setBounds(841, 278, 100, 30);
		contentPane.add(b4);

		JButton btnDelete = new JButton("Delete");
		btnDelete.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DefaultTableModel model = (DefaultTableModel) table1.getModel();
				int selectedIndex = table1.getSelectedRow();
				try {

					String id = model.getValueAt(selectedIndex, 0).toString();
					int dialogResult = JOptionPane.showConfirmDialog(null, "Do you want to Delete the record",
							"Warning", JOptionPane.YES_NO_OPTION);
					if (dialogResult == JOptionPane.YES_OPTION) {

						Class.forName("com.mysql.jdbc.Driver");
						Connection con = DriverManager.getConnection("jdbc:mysql://localhost/student", "root", "");
						PreparedStatement p = con.prepareStatement("delete from usertable where userID = ?");

						p.setString(1, id);
						p.executeUpdate();
						p.close();
						con.close();
						JOptionPane.showMessageDialog(null, "Record Deleted");
						table_update();

					}

				} catch (ClassNotFoundException ex) {

				} catch (SQLException ex) {

				}
			}
		});
		btnDelete.setBounds(476, 278, 100, 30);
		contentPane.add(btnDelete);
		
		JButton btnNewButton = new JButton("Feedback");
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new Feedback();
				setVisible(false);
			}
		});
		btnNewButton.setBounds(665, 279, 100, 30);
		contentPane.add(btnNewButton);
		table_update();

	}

	public void table_update() {
		int cols;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost/student", "root", "");

			Statement s = con.createStatement();
			ResultSet r = s.executeQuery("select * from usertable");
			ResultSetMetaData rsmd = r.getMetaData();
			DefaultTableModel dtm = (DefaultTableModel) table1.getModel();

			dtm.setRowCount(0);
			cols = rsmd.getColumnCount();
			String[] colName = new String[cols];
			for (int i = 0; i < cols; i++) {
				colName[i] = rsmd.getColumnName(i + 1);
			}
			dtm.setColumnIdentifiers(colName);

			while (r.next()) {
				id1 = r.getString(1);
				name1 = r.getString(2);
				dob1 = r.getString(3);
				fname1 = r.getString(4);
				lname1 = r.getString(5);
				gender1 = r.getString(6);
				email1 = r.getString(7);
				pass1 = r.getString(8);
				ph1 = r.getString(9);
				addr1 = r.getString(10);
				balance1 = r.getString(11);
				feedback1 = r.getString(12);
				String[] row = { id1, name1, dob1, fname1, lname1, gender1, email1, pass1, ph1, addr1, balance1, feedback1 };
				dtm.addRow(row);
			}
			s.close();
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e1) {
			e1.printStackTrace();
		}
	}
}
