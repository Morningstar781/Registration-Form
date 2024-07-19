package registration;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import javax.swing.JTree;
import javax.swing.JScrollPane;

public class registration extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtid;
	private JTextField txtname;
	private JTextField txtgender;
	private JTextField txtaddress;
	private JTextField txtcontact;
	protected JLabel Identification;
	private JTable table;
	private JTable table_1;

	/**
	 * Launch the application.
	 */

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					registration frame = new registration();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public registration() {
		setTitle("Registration Form");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 642, 369);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel identification = new JLabel("Identification");
		identification.setBounds(29, 38, 68, 14);
		contentPane.add(identification);
		
		JLabel name = new JLabel("Name");
		name.setBounds(29, 83, 46, 14);
		contentPane.add(name);
		
		JLabel gender = new JLabel("Gender");
		gender.setBounds(29, 139, 46, 14);
		contentPane.add(gender);
		
		JLabel address = new JLabel("Address");
		address.setBounds(29, 187, 46, 14);
		contentPane.add(address);
		
		JLabel contact = new JLabel("Contact");
		contact.setBounds(29, 236, 46, 14);
		contentPane.add(contact);
		
		txtid = new JTextField();
		txtid.setBounds(107, 35, 86, 20);
		contentPane.add(txtid);
		txtid.setColumns(10);
		
		txtname = new JTextField();
		txtname.setBounds(107, 80, 86, 20);
		contentPane.add(txtname);
		txtname.setColumns(10);
		
		txtgender = new JTextField();
		txtgender.setBounds(107, 136, 86, 20);
		contentPane.add(txtgender);
		txtgender.setColumns(10);
		
		txtaddress = new JTextField();
		txtaddress.setBounds(107, 181, 86, 20);
		contentPane.add(txtaddress);
		txtaddress.setColumns(10);
		
		txtcontact = new JTextField();
		txtcontact.setBounds(107, 233, 86, 20);
		contentPane.add(txtcontact);
		txtcontact.setColumns(10);
		
		JButton btnNewButton = new JButton("Save");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
		        try {
		            Class.forName("com.mysql.jdbc.Driver");
		            Connection con = DriverManager.getConnection("jdbc:mysql://localhost/registration", "root","");
					PreparedStatement ps = con.prepareStatement("insert into records(Identification,Name,Gender,Address,Contact)values(?,?,?,?,?)");
		            ps.setString(1, identification.getText());
		            ps.setString(2, name.getText());
		            ps.setString(3, gender.getText());
		            ps.setString(4, address.getText());
		            ps.setString(5, contact.getText());
		            int x = ps.executeUpdate();
		            if(x > 0) {
		            	System.out.println("Saved...");
		            }else {
		            	System.out.println("Failed...");
		            }
		        }catch(Exception e1) {
		        	System.out.println(e1);
		        }
				
			}
		});
		
		
		
		
		
		
		
		
		btnNewButton.setBounds(29, 279, 89, 23);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Exit");
		btnNewButton_1.setBounds(136, 279, 89, 23);
		contentPane.add(btnNewButton_1);
		
		table = new JTable();
		table.setBounds(418, 97, 1, 1);
		contentPane.add(table);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(242, 38, 374, 264);
		contentPane.add(scrollPane);
		
		table_1 = new JTable();
		scrollPane.setViewportView(table_1);
	}

	private void load() {
		// TODO Auto-generated method stub
		
	}
}
