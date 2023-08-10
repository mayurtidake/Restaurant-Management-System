package cp;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.*;
import javax.xml.transform.Result;

//import GUI.RestaurantOrderGUI;

import java.awt.*;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;

class Miframe extends JFrame implements ActionListener
{
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	//	Container c;
    JTextField t1,t2,t3,t5;
    JPasswordField t4;
    JLabel l12,l0,l1,l2,l3,l4,l5,l6;
    JButton b1,b2,b3;

    public Miframe(){
    	setContentPane(new JLabel(new ImageIcon("C:\\Users\\lenovo\\Downloads\\image-900x600 (1).jpg")));
        JLabel background = new JLabel("C:\\userpage.png",JLabel.CENTER);
        background.setBounds(0,0,900,800);
        // Add the JLabel to the JPanel and set it to the back of the z-order
        add(background);
       
        t1 = new JTextField();
        t2 = new JTextField();
        t3 = new JTextField();
        t4 = new JPasswordField();
        t5 = new JTextField();
           
        l12 = new JLabel("Welcome to Our Restaurant !!");
        l0 = new JLabel("Register");
        l1 = new JLabel("Name");
        l2 = new JLabel("Email");
        l3 = new JLabel("Mobile no.");
        l4 = new JLabel("Set password");
        l5 = new JLabel("Address");
        l6 = new JLabel("Already have an account?");
        b1 = new JButton("sign up");
        b2 = new JButton("sign in");

        int a=310,b=150,c=100,d=30;
        //label border kel
        l12.setBounds(200,30,450,60);
        l12.setFont(new Font("MV Boli",Font.PLAIN,30));
        l12.setForeground(Color.white);
        l0.setBounds(360,80,170,60);
        l0.setFont(new Font("Times New Roman",Font.PLAIN,25)); 
		l0.setForeground(Color.white);
        l1.setBounds(a,b,c,d);
        l1.setFont(new Font("Times New Roman",Font.PLAIN,15));
        l1.setForeground(Color.white);
        l2.setBounds(a,b+30,c,d);
        l2.setFont(new Font("Times New Roman",Font.PLAIN,15));
        l2.setForeground(Color.white);
        l3.setBounds(a,b+60,c,d);
        l3.setFont(new Font("Times New Roman",Font.PLAIN,15));
        l3.setForeground(Color.white);
        l4.setBounds(a,b+90,c,d);
        l4.setFont(new Font("Times New Roman",Font.PLAIN,15));
        l4.setForeground(Color.white);
        l5.setBounds(a,b+120,c,d);
        l5.setFont(new Font("Times New Roman",Font.PLAIN,15));
        l5.setForeground(Color.white);
        l6.setBounds(a,b+200,c+90,d);
        l6.setFont(new Font("Times New Roman",Font.PLAIN,15));
        l6.setForeground(Color.white);
        //text box border kel
        int a1 = 410;
        t1.setBounds(a1,b,c,d);
        t2.setBounds(a1,b+30,c,d);
        t3.setBounds(a1,b+60,c,d);
        t4.setBounds(a1,b+90,c,d);
        t5.setBounds(a1,b+120,c,d);
        //button add kele
        b1.setBounds(a1-30,b+170,c,d);
        b2.setBounds(a+170,b+205,c-25,d-12);
           
        add(l12);
        add(l0);
        add(l1);
        add(l2);
        add(l3);
        add(l4);
        add(l5);
        add(l6);
        add(t1);
        add(t2);
        add(t3);
        add(t4);
        add(t5);
        add(b1);
        add(b2);
        setLayout(null);
        setVisible(true);

        Image img = Toolkit.getDefaultToolkit().getImage("C:\\Users\\thora\\eclipse-workspace\\Dbms cp\\src\\Dbmscp\\userpage.png");

        b1.addActionListener(this);

        //to open sign in page
        b2.addActionListener(this);

    }

    private void paintComponent(Graphics g) {
        // TODO Auto-generated method stub
        super.paintComponents(g);
        //	g.drawImage(img,0,0,null);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub
        //login button
        if(e.getSource()==b1) {
            try {

                Class.forName("com.mysql.cj.jdbc.Driver");
                Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/cp2","root","mysql");
                Statement st = c.createStatement();

                String s1 = t1.getText();
                String s2 = t2.getText();
                int s3 =  Integer.parseInt(t3.getText());
                String s4 = new String(t4.getPassword());
                String s5 = t5.getText();
                //int s5 =  Integer.parseInt(t5.getText());
                String s = "insert into user (Name,Email,Mobile_no,Set_password,Address) values ('"+s1+"','"+s2+"',"+s3+",'"+s4+"','"+s5+"')";
                st.executeUpdate(s);


                // ResultSet r = st.executeQuery("select Name from users where Name = "+s1);
                thirdframe();
                c.close();

            }catch(Exception a) {
                System.out.println(a);
            }
        }
        if(e.getSource()==b2) {

            try {
                JFrame f2 = new JFrame("Sign in Frame");
                f2.setContentPane(new JLabel(new ImageIcon("C:\\Users\\lenovo\\Downloads\\image-900x600 (6).jpg")));
                //f2.getContentPane().setBackground(Color.YELLOW);
                //f2.setContentPane(new JLabel(new ImageIcon("C:\\Users\\lenovo\\Document\\IoT cp LR\\OOP CP\\images.jpg")));

                JLabel la0,la1,la2;//label = new JLabel("This is a new frame");
                JTextField te1;
                JPasswordField te2;
                
                la2 = new JLabel("Log In");
                la2.setBounds(330,110,450,60);
                la2.setFont(new Font("MV Boli",Font.PLAIN,40)); 
        		la2.setForeground(Color.WHITE);
                la0 = new JLabel("Email");
                la1 = new JLabel("password");

                JButton b3 = new JButton("Sign in");
                te1 = new JTextField();
                te2 = new JPasswordField();
                int a=300,b=200,c=100,d=30,a1 = 400;
                la0.setBounds(a,b,c,d);
                la0.setFont(new Font("Times New Roman",Font.PLAIN,20));
                la0.setForeground(Color.WHITE);
                la1.setBounds(a,b+35,c,d);
                la1.setFont(new Font("Times New Roman",Font.PLAIN,20));
                la1.setForeground(Color.WHITE);
                b3.setBounds(a+30,b+95,c,d);
                te1.setBounds(a1,b,c,d);
                te2.setBounds(a1,b+35,c,d);
                JButton closeButton = new JButton("Close");
                closeButton.setBounds(a1-30,b+170,c-20,d-5);
                getContentPane().setLayout(null);

                // Create a JLabel to hold the background image
                JLabel background = new JLabel(new ImageIcon("/Dbms cp/src/Dbmscp/userpage2.png"));
                background.setBounds(0, 0, getWidth(), getHeight());
                f2.add(background);
                f2.add(b3);
                f2.add(la2);
                f2.add(la0);
                f2.add(la1);
                f2.add(te1);
                f2.add(te2);
                f2.add(closeButton);
                setLayout(null);
                setVisible(true);
                f2.setSize(900,600);
                f2.setLocationRelativeTo(null);
                f2.setLayout(null);
                f2.setVisible(true);
                b3.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        String username = te1.getText();
                        String password = new String(te2.getPassword());

                        try {
                            if(username.equals("admin") && password.equals("password")) {
                                JFrame f4 = new JFrame("Manage Items");
                                //f4.setContentPane(new JLabel(new ImageIcon("C:\\Users\\lenovo\\Downloads\\image-900x600 (2).jpg")));
                                f4.getContentPane().setBackground(Color.ORANGE);
                                JTextField t11,t12,t13,t14,t15,t16,t17,t18,t19,t20,t21;
                                JLabel l10,l11,l12,l13,l14,l15,l16,l17,l18,l19,l20;
                                JButton b11,b12,b13,b14;

                                t11 = new JTextField();
                                t12 = new JTextField();
                                t13 = new JTextField();
                                t14 = new JTextField();
                                t15 = new JTextField();
                                t16 = new JTextField();
                                t17 = new JTextField();
                                t18 = new JTextField();
                                t19 = new JTextField();
                                t20 = new JTextField();
                                t21 = new JTextField();

//
                                l10 = new JLabel("Menu ID");
                                l11 = new JLabel("Item");
                                l12 = new JLabel("Description");
                                l13 = new JLabel("Price");
//                                l14 = new JLabel("");
//                                l15 = new JLabel("");
//                                l16 = new JLabel("");
//                                l17 = new JLabel("");
//                                l18 = new JLabel("");
//                                l19 = new JLabel("");
//                                l20 = new JLabel("");

                                b11 = new JButton("ADD");
                                b12 = new JButton("UPDATE");
                                b13 = new JButton("DELETE");
                                b14 = new JButton("display");
                                int a=10,b=140,c=100,d=30;
                                //label border kel
                                l10.setBounds(a,b-30,c,d);
                                l11.setBounds(a,b,c,d);
                                l12.setBounds(a,b+30,c,d);
                                l13.setBounds(a,b+60,c,d);
//                                l14.setBounds(a,b+90,c,d);
//                                l15.setBounds(a,b+120,c,d);
//                                l16.setBounds(a,b+150,c,d);
//                                l17.setBounds(a,b+180,c,d);
//                                l18.setBounds(a,b+210,c,d);
//                                l19.setBounds(a,b+240,c,d);
//                                l20.setBounds(a,b+270,c,d);

                                b11.setBounds(0,b+300,c,d);
                                b12.setBounds(100,b+300,c,d);
                                b13.setBounds(0,b+300+d,c,d);
                                b14.setBounds(100,b+300+d,c,d);
                                //text box border kel
                                int a1 = 90;
                                
                                t11.setBounds(a1,b-30,c,d);
                                t12.setBounds(a1,b,c,d);
                                t13.setBounds(a1,b+30,c,d);
                                t14.setBounds(a1,b+60,c,d);
                                t15.setBounds(a1,b+90,c,d);
                                t16.setBounds(a1,b+120,c,d);
                                t17.setBounds(a1,b+150,c,d);
                                t18.setBounds(a1,b+180,c,d);
                                t19.setBounds(a1,b+210,c,d);
                                t20.setBounds(a1,b+240,c,d);
                                t21.setBounds(a1,b+270,c,d);

                                f4.add(l10);
                                f4.add(l11);
                                f4.add(l12);
                                f4.add(l13);
//                                f4.add(l14);
//                                f4.add(l15);
//                                f4.add(l16);
//                                f4.add(l17);
//                                f4.add(l18);
//                                f4.add(l19);
//                                f4.add(l20);

                                f4.add(t11);
                                f4.add(t12);
                                f4.add(t13);
                                f4.add(t14);
//                                f4.add(t15);
//                                f4.add(t16);
//                                f4.add(t17);
//                                f4.add(t18);
//                                f4.add(t19);
//                                f4.add(t20);
//                                f4.add(t21);

                                f4.add(b11);
                                f4.add(b12);
                                f4.add(b13);
                                f4.add(b14);


                                setLayout(null);
                                setVisible(true);
                                f4.setSize(900,600);
                                f4.setLocationRelativeTo(null);
                                f4.setLayout(null);
                                f4.setVisible(true);
                                JScrollPane scrollpane1 = new JScrollPane();
                                scrollpane1.setBounds(210,100,620,350);
                                f4.add(scrollpane1);

                                JTable table1 = new JTable();
                                scrollpane1.setViewportView(table1);
                                table1.setBounds(210,100,620,350);
                                f4.add(table1);
                                
                                
                                
                              //Problems Here Checkpoint
                                b11.addActionListener(new ActionListener() {

                                    @Override
                                    public void actionPerformed(ActionEvent e) {
                                        // TODO Auto-generated method stub
                                    	
                                    	System.out.print("Add Clicked");
                                        try {
                                        	
                                        	Class.forName("com.mysql.cj.jdbc.Driver");
                                            Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/cp2","root","mysql");
                                            Statement st = c.createStatement();

                                            int s11 = Integer.parseInt(t11.getText().toString());
                                            String s12 = t12.getText().toString();
                                            String s13 = t13.getText().toString();
//                                            String s14 = t14.getText();
//                                            String s15 = t15.getText();
//                                            String s16 = t16.getText();
//                                            String s17 = t17.getText();
//                                            String s18 = t18.getText();
//                                            String s19 = t19.getText();
//                                            String s20 = t20.getText();
                                            int s14 =  Integer.parseInt(t14.getText().toString());
                                            String s = "insert into menu_list (menu_id,item,description,price) values ('"+s11+"' ,'"+s12+"','" +s13+ "',"+s14+")";
                                            st.executeUpdate(s);
                                            
                                            
                                            ResultSet r = st.executeQuery(s);
                                            if (r.next()) {
                                                // JOptionPane.showInputDialog(this, "Welcome, " + username + "!");
                                                JOptionPane.showMessageDialog(null, "Welcome, ");
                                                // thirdframe();
                                            } else {
                                                JOptionPane.showMessageDialog(null, "Invalid username or password.");
                                            }
                                            
                                            c.close();
                                        }catch(Exception ab) {
                                        	


                                        }
                                    }

                                });
                                b12.addActionListener(new ActionListener() {

                                    @Override
                                    public void actionPerformed(ActionEvent e) {
                                        // TODO Auto-generated method stub
                                        try {
                                            Class.forName("com.mysql.cj.jdbc.Driver");
                                            Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/cp2","root","mysql");
                                            Statement st = c.createStatement();

                                            int s11 = Integer.parseInt(t11.getText().toString());
                                            String s12 = t12.getText().toString();
                                            String s13 = t13.getText().toString();
                                            int s14 = Integer.parseInt(t14.getText().toString());
//                                            String s15 = t15.getText();
//                                            String s16 = t16.getText();
//                                            String s17 = t17.getText();
//                                            String s18 = t18.getText();
//                                            String s19 = t19.getText();
//                                            String s20 = t20.getText();
//                                            String s21 = t21.getText();
                                            String s ="update menu_list set item = '"+s12+"',description= '"+s13+"',price = "+s14+" where menu_id = "+s11+"";
                                            st.executeUpdate(s);
                                            ResultSet r = st.executeQuery(s);

                                            c.close();
                                        }catch(Exception ab) {
                                        	

                                        }
                                    }

                                });

                                b13.addActionListener(new ActionListener() {

                                    @Override
                                    public void actionPerformed(ActionEvent e) {
                                        // TODO Auto-generated method stub
                                        try {
                                            Class.forName("com.mysql.cj.jdbc.Driver");
                                            Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/cp2","root","mysql");
                                            Statement st = c.createStatement();
                                            String s11 = t11.getText().toString();
                                            String s = "delete from menu_list where menu_id = "+s11+"";
                                            st.executeUpdate(s);
                                            ResultSet r = st.executeQuery(s);

                                            c.close();
                                        }catch(Exception ba) {}

                                    }
                                });
                                
                                //Display Here Checkpoint
                                b14.addActionListener(new ActionListener() {

                                    @Override
                                    public void actionPerformed(ActionEvent e) {
                                        // TODO Auto-generated method stub
                                        try {
                                            Class.forName("com.mysql.cj.jdbc.Driver");
                                            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/cp2", "root", "mysql");
                                            // Create query to retrieve table metadata
                                            String query = "SELECT * FROM menu_list";
                                            PreparedStatement st = con.prepareStatement(query);
                                            ResultSet rs = st.executeQuery();

                                            // Create DefaultTableModel and add column headers
                                            ResultSetMetaData metaData = rs.getMetaData();
                                            int columnCount = metaData.getColumnCount();
                                            DefaultTableModel model = new DefaultTableModel();

                                            for (int i = 1; i <= columnCount; i++) {
                                                model.addColumn(metaData.getColumnLabel(i));
                                            }
                                            // table.setModel(model);
                                            while (rs.next()) {
                                                Object[] row = new Object[columnCount];

                                                for (int i = 1; i <= columnCount; i++) {
                                                    row[i - 1] = rs.getObject(i);
                                                }
                                                model.addRow(row);
                                            }

                                            // Set the TableModel to the JTable
                                            table1.setModel(model);

                                            // Close the resources
                                            rs.close();
                                            st.close();
                                            con.close();


                                        }catch(Exception abc) {

                                        }
                                    }
                                });
                            }else {
                                Class.forName("com.mysql.cj.jdbc.Driver");
                                Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/cp2", "root", "mysql");

                                // check if user data is present in SQL
                                String query = "SELECT * FROM user WHERE Name=? AND Set_password=?";
                                PreparedStatement pstmt = con.prepareStatement(query);
                                pstmt.setString(1, username);
                                pstmt.setString(2, password);
                                ResultSet rs = pstmt.executeQuery();
                                if (rs.next()) {
                                    // JOptionPane.showInputDialog(this, "Welcome, " + username + "!");
                                    JOptionPane.showMessageDialog(null, "Welcome, "+ username);
                                    thirdframe();
                                } else {
                                    JOptionPane.showMessageDialog(null, "Invalid username or password.");
                                }
                                // close database connection
                                con.close();
                            }
                        } catch (Exception ex) {
                            ex.printStackTrace();
                            JOptionPane.showInputDialog(this, "Error connecting to database.");
                        }
                    }
                });

                // second frame close karnya sati button
                closeButton.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        f2.dispose();
                    }
                });
            }catch(Exception b) {

            }
        }
    }
    public void thirdframe() {
        JFrame f3 = new JFrame("3 frame :- type");
        f3.setContentPane(new JLabel(new ImageIcon("C:\\Users\\lenovo\\Downloads\\image-900x600 (3).jpg")));
        //f3.getContentPane().setBackground(Color.black);
        JLabel lb1;
        JButton ba1,ba2,ba3;
        lb1 = new JLabel("Home");
        ba1 = new JButton("<html>Menu</html>");
        ba2 = new JButton("<html>Order</html>");
        ba3 = new JButton("<html>Reservation</html>");

        lb1.setBounds(400,0,300,100);
        ba1.setBounds(150,100,130,50);
        ba2.setBounds(385,100,130,50);
        ba3.setBounds(610,100,130,50);

        lb1.setFont(new Font("MV Boli", Font.BOLD, 35));
        lb1.setForeground(Color.WHITE);
        f3.add(lb1);
        f3.add(ba1);
        f3.add(ba2);
        f3.add(ba3);

        f3.setSize(900,600);
        f3.setLocationRelativeTo(null);
        f3.setLayout(null);
        f3.setVisible(true);

        JScrollPane scrollpane = new JScrollPane();
        scrollpane.setBounds(145,150,600,350);
        f3.add(scrollpane);

        JTable table = new JTable();

        scrollpane.setViewportView(table);
        table.setBounds(150,150,600,350);
        f3.add(table);

        //show menu ki frame
        ba1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    Class.forName("com.mysql.cj.jdbc.Driver");
                    Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/cp2", "root", "mysql");
                    // Create query to retrieve table metadata
                    String query = "SELECT * FROM menu_list";
                    PreparedStatement st = con.prepareStatement(query);
                    ResultSet rs = st.executeQuery();

                    // Create DefaultTableModel and add column headers
                    ResultSetMetaData metaData = rs.getMetaData();
                    int columnCount = metaData.getColumnCount();
                    DefaultTableModel model = new DefaultTableModel();

                    for (int i = 1; i <= columnCount; i++) {
                        model.addColumn(metaData.getColumnLabel(i));
                    }
                    table.setModel(model);
                    while (rs.next()) {
                        Object[] row = new Object[columnCount];

                        for (int i = 1; i <= columnCount; i++) {
                            row[i - 1] = rs.getObject(i);
                        }
                        model.addRow(row);
                    }

                    // Set the TableModel to the JTable
                    table.setModel(model);

                    // Close the resources
                    rs.close();
                    st.close();
                    con.close();
                    

                } catch (Exception c) {
                    System.out.println(c);
                }
            }
        });
        // for professional laptop button
        ba2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	
                table.setModel(new DefaultTableModel());
                new RestaurantOrderGUI();
                try {
                    Class.forName("com.mysql.cj.jdbc.Driver");
                    Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/cp2", "root", "mysql");
                    Statement st = con.createStatement();
                    ResultSet rs = st.executeQuery("SELECT cust_name,cust_order,price FROM order");
                    DefaultTableModel model = new DefaultTableModel();
                    ResultSetMetaData metaData = rs.getMetaData();
                    int columnCount = metaData.getColumnCount();
                    for (int i = 1; i <= columnCount; i++) {
                        model.addColumn(metaData.getColumnLabel(i));
                    }
                    while (rs.next()) {
                        Object[] row = new Object[columnCount];
                        for (int i = 1; i <= columnCount; i++) {
                            row[i - 1] = rs.getObject(i);
                        }
                        model.addRow(row);
                    }

                    // Set the TableModel to the JTable
                    table.setModel(model);

                    // Close the resources
                    rs.close();
                    st.close();
                    con.close();


                } catch (Exception c) {
                    System.out.println(c);
                }
            }
        });
        ba3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	//table.setModel(new DefaultTableModel());
            	new TableReservationGUI();
//                try {
//                    Class.forName("com.mysql.cj.jdbc.Driver");
//                    Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/cp2", "root", "909680");
//                    // Create query to retrieve table metadata
//                    String query = "SELECT cust_add,cust_mobile,cust_email FROM cust_details where Home = 'Customer'";
//                    PreparedStatement st = con.prepareStatement(query);
//                    ResultSet rs = st.executeQuery();
//
//                    // Create DefaultTableModel and add column headers
//                    ResultSetMetaData metaData = rs.getMetaData();
//                    int columnCount = metaData.getColumnCount();
//                    DefaultTableModel model = new DefaultTableModel();
//                    
//                    for (int i = 1; i <= columnCount; i++) {
//                        model.addColumn(metaData.getColumnLabel(i));
//                    }
//                    table.setModel(model);
//                    while (rs.next()) {
//                        Object[] row = new Object[columnCount];
//
//                        for (int i = 1; i <= columnCount; i++) {
//                            row[i - 1] = rs.getObject(i);
//                        }
//                        model.addRow(row);
//                    }
//
//                    // Set the TableModel to the JTable
//                    table.setModel(model);
//
//                    // Close the resources
//                    rs.close();
//                    st.close();
//                    con.close();
//
//
//                } catch (Exception c) {
//                    System.out.println(c);
//                }
            }
        });

    }

}

class OOP {
    public static void main(String[] args) {
        Miframe f = new Miframe();
      
        //f.getContentPane().setBackground(Color.orange);
        f.setTitle("Restaurant Management System");

        // Create a new label with the background image
        ImageIcon imageIcon = new ImageIcon("C:\\Users\\lenovo\\Downloads\\image-900x600 (4).jpg");
        JLabel backgroundLabel = new JLabel(imageIcon);

// Set the size and position of the label
        backgroundLabel.setBounds(0, 0, imageIcon.getIconWidth(), imageIcon.getIconHeight());

// Get the content pane of the frame
        Container contentPane = f.getContentPane();
// Set the layout of the content pane to null
        contentPane.setLayout(null);

// Add the background label to the content pane
        contentPane.add(backgroundLabel);
// Set the size of the frame to the size of the image
        f.setSize(imageIcon.getIconWidth(), imageIcon.getIconHeight());
// Make the frame visible
        
        
        
        f.setVisible(true);

        f.setSize(900,600);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setLocationRelativeTo(null);
        f.setVisible(true);
    }
}