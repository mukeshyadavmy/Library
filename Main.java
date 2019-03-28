
//--------------------LIBRARY MANAGEMENT PROJECT ---Full Sourcecode-------------------//

//import statements

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.sql.*;
import javax.swing.table.DefaultTableModel;
import java.util.Date;
import java.text.SimpleDateFormat;

//Main Window
public class Main implements ActionListener
{ JFrame f;
  JButton b1,b2;
  JLabel l;
  
  Main(){
    f=new JFrame("Main Screen");
    f.setIconImage((new ImageIcon("arya-logo.png")).getImage());
    f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	l=new JLabel("Library Management- A.I.E.T");
	l.setFont(new Font("Serif",Font.BOLD,25));
    b1=new JButton("Admin");
	
	b2=new JButton("Librarian");
	b1.setFont(new Font("Arial",Font.PLAIN,20));
	b2.setFont(new Font("Arial",Font.PLAIN,20));
	b1.setBounds(140,150,120,50);
	b2.setBounds(140,250,120,50);
	f.add(b1);
	f.add(b2);
	f.add(l);
	l.setBounds(50,50,500,40);
	b1.addActionListener(this);
     b2.addActionListener(this);
	f.setSize(500,500);
	//f.pack();
	f.setLayout(null);
	f.setVisible(true);
   }
  public void actionPerformed(ActionEvent e)
  { 
  if(e.getSource()==b1)
	 { 
  f.dispose();
  new LoginAdmin();
	 }
	 else 
	    if(e.getSource()==b2)
	  {  
  f.dispose();
    new LoginLib();
  	   }
    }
  public static void main(String[] args)
  {  new Main();
  }
}


//Admin Login
 class LoginAdmin implements ActionListener
{ JFrame f1=new JFrame("Login Admin");
  JLabel l1,l2,l;
  JTextField tf1;
  JPasswordField pf;
  JButton b1;
 
  LoginAdmin()
  { l1=new JLabel("Username");
   l2=new JLabel("Password");
   tf1=new JTextField(20);
   pf=new JPasswordField(20);
   l=new JLabel("Admin Login");
   l.setFont(new Font("Serif",Font.BOLD,25));
   l1.setFont(new Font("Arial",Font.PLAIN,20));
   l2.setFont(new Font("Arial",Font.PLAIN,20));
   
    b1=new JButton("OK");
	b1.setFont(new Font("Arial",Font.BOLD,25));
    f1.setSize(500,500);
	f1.setLayout(null);
	f1.setVisible(true);
	f1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	f1.setIconImage((new ImageIcon("arya-logo.png")).getImage());
	f1.add(l1);
	f1.add(l2);
	f1.add(tf1);
	f1.add(pf);
	f1.getContentPane().add(b1);
	f1.add(l);
	l.setBounds(120,30,200,30);
	l1.setBounds(70,100,100,30);
	tf1.setBounds(180,100,100,30);
    l2.setBounds(70,170,100,30);
	pf.setBounds(180,170,100,30);
	b1.setBounds(130,250,90,40);
    b1.addActionListener(this);
   
  }
 /* public Connection getConnection()
  {  
    try{
		Class.forName("oracle.jdbc.driver.OracleDriver");  
        Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","tiger"); 
        return con;
	}
   catch(Exception e)
   {  e.printStackTrace();
      return null;
   }	   
  }*/
  public void actionPerformed(ActionEvent e)
  { String pass=pf.getText();
    ResultSet rs;
	
   try
   {
		Class.forName("oracle.jdbc.driver.OracleDriver");  
        Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","tiger"); 
	   String query="select username,password from login where username='"+tf1.getText()+"'";
     Statement stmt=con.createStatement();  
	 rs=stmt.executeQuery(query);
			rs.next();
	 if(pass.equals(rs.getString("password")))
	 {
  		 f1.dispose();
        new AdminSection();
	 }
	 else{
		 JOptionPane.showMessageDialog(null,"Login Failed.Please try again...!");
	   }
   }
	 catch(Exception ex){
		 ex.printStackTrace();
	 }

  }
}
  
  

//Librarian Login

class LoginLib implements ActionListener
{ JFrame f1=new JFrame("Login Lib");
  JLabel l1,l2,l;
  JTextField tf1;
  JPasswordField pf;
  JButton b1;
  
  LoginLib()
  { l1=new JLabel("Username");
   l2=new JLabel("Password");
   tf1=new JTextField(20);
   pf=new JPasswordField(20);
   l=new JLabel("Libarian Login");
   
    b1=new JButton("OK");
    f1.setSize(500,500);
	f1.setLayout(null);
	f1.setVisible(true);
	f1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	f1.setIconImage((new ImageIcon("arya-logo.png")).getImage());
	f1.add(l1);
	f1.add(l2);
	f1.add(tf1);f1.add(pf);
	f1.getContentPane().add(b1);
	f1.add(l);
	 l.setFont(new Font("Serif",Font.BOLD,25));
   l1.setFont(new Font("Arial",Font.PLAIN,20));
   l2.setFont(new Font("Arial",Font.PLAIN,20));
   b1.setFont(new Font("Arial",Font.BOLD,25));
	l.setBounds(120,30,200,30);
	l1.setBounds(70,100,100,30);
	tf1.setBounds(180,100,100,30);
    l2.setBounds(70,170,100,30);
	pf.setBounds(180,170,100,30);
	b1.setBounds(130,250,90,40);
     b1.addActionListener(this);
   
  }
  public void actionPerformed(ActionEvent e)
  {String pass=pf.getText();
    ResultSet rs;
	
   try
   {
		Class.forName("oracle.jdbc.driver.OracleDriver");  
        Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","tiger"); 
	   String query="select username,password from login where username='"+tf1.getText()+"'";
     Statement stmt=con.createStatement();  
	 rs=stmt.executeQuery(query);
			rs.next();
	 if(pass.equals(rs.getString("password")))
	 {
  		 f1.dispose();
        new LibrarianSection();
	 }
	 else{
		 JOptionPane.showMessageDialog(null,"Login Failed.Please try again...!");
	   }
   }
	 catch(Exception ex){
		 // Exhausted Resultset
		 ex.printStackTrace();
	 }

  }
	 
}
  
  
  //Admin section
   class AdminSection implements ActionListener
{ JFrame f;
  JButton b1,b2,b3,b4;
  JLabel l;
  AdminSection()
   {
	   f=new JFrame("Admin Section");
    f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	f.setIconImage((new ImageIcon("arya-logo.png")).getImage());
	l=new JLabel();
	l.setText("Admin Section");
    l.setFont(new Font("Serif",Font.BOLD,25));
    b1=new JButton("Add Librarian");
	b2=new JButton("View Librarian");
	b3=new JButton("Delete Librarian");
	b4=new JButton("Logout");
	b1.setFont(new Font("Arial",Font.PLAIN,20));
	b2.setFont(new Font("Arial",Font.PLAIN,20));
	b3.setFont(new Font("Arial",Font.PLAIN,20));
	b4.setFont(new Font("Arial",Font.PLAIN,20));
	b1.setBounds(90,120,200,35);
	b2.setBounds(90,190,200,35);
	b3.setBounds(90,260,200,35);
	b4.setBounds(90,330,200,35);
	f.add(b1);
	f.add(b2);
	f.add(b3);
	f.add(b4);
	f.add(l);
	l.setBounds(100,50,200,30);
	b1.addActionListener(this);
    b2.addActionListener(this);
		b3.addActionListener(this);
    b4.addActionListener(this);
	f.setSize(500,600);
	f.setLayout(null);
	f.setVisible(true);
   }
  
public void actionPerformed(ActionEvent e)
  { 
  if(e.getSource()==b1)
	 { 
  f.dispose();
    new AddLibrarian();
	 }
	 else if(e.getSource()==b2)
	  {  
  f.dispose();
   new ViewLibrarian();
	   }
	   	 else if(e.getSource()==b3)
	  {  
  f.dispose();
    new DeleteLibrarian();
	   }
 	 else if(e.getSource()==b4)
	  {  
         f.dispose();
   
	  } 
   }
 
}


//Add Librarian

class AddLibrarian implements ActionListener
{ JFrame f;
  JLabel l1,l2,l3,l4,l;
  JTextField tf1,tf2,tf3,tf4;
  JButton b,b1;
  AddLibrarian()
  { f=new JFrame("Add Librarian");
    l=new JLabel("Add Librarian");
    b=new JButton("ok"); 
	b1=new JButton("Back"); 
     l1=new JLabel("Name");
     l2=new JLabel("Password");  
	 l3=new JLabel("Email");  
	 l4=new JLabel("Librarian Id"); 
  tf1=new JTextField();	 
   tf2=new JTextField();
   tf3=new JTextField();	
  tf4=new JTextField();
    f.add(l1);
	f.add(l2);
	f.add(l3);
	f.add(l4);
	f.add(tf1);
	f.add(tf2);
	f.add(tf3);
	f.add(tf4);
	f.add(b);
	f.add(b1);
	f.add(l);
	l.setBounds(80,40,200,50);
	l1.setBounds(50,120,100,30);
	tf1.setBounds(170,120,100,30);
	l2.setBounds(50,170,100,30);
	tf2.setBounds(170,170,100,30); 
	l3.setBounds(50,220,150,30);
	tf3.setBounds(170,220,100,30); 
	l4.setBounds(50,270,100,30); 
	tf4.setBounds(170,270,100,30); 
	b.setBounds(200,330,80,40);
	b1.setBounds(50,330,80,40);
	l.setFont(new Font("Serif",Font.BOLD,25));
	b.setFont(new Font("Serif",Font.BOLD,25));
	b1.setFont(new Font("Serif",Font.BOLD,20));
	l1.setFont(new Font("Arial",Font.PLAIN,20));
    l2.setFont(new Font("Arial",Font.PLAIN,20));
	l3.setFont(new Font("Arial",Font.PLAIN,20));
    l4.setFont(new Font("Arial",Font.PLAIN,20));  
	
	  b.addActionListener(this);
	  b1.addActionListener(this);
	  f.setIconImage((new ImageIcon("arya-logo.png")).getImage());
	  f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	  f.setSize(500,500);
	  f.setLayout(null);
	  f.setVisible(true); 
	 }

		public void actionPerformed(ActionEvent e)
	{   if(e.getSource()==b1)
	   { 
       f.dispose();
 
       new AdminSection();
 	    }
	 else if(e.getSource()==b)
	  {  
	 /* String name=tf1.getText();
	  String pass=pf.getText();
	  String email=tf2.getText();*/
       ResultSet rs;
	
   try
   {
		Class.forName("oracle.jdbc.driver.OracleDriver");  
        Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","tiger"); 
	   String query="insert into librarian values ("+tf4.getText()+",'"+ tf1.getText()+"','"+tf2.getText()+"','"+tf3.getText()+"')";
     Statement stmt=con.createStatement();  
	 rs=stmt.executeQuery(query);
	 JOptionPane.showMessageDialog(null,"Successful...!!");
			
	/* if(rs=stmt.executeQuery(query)>0)
	 {
  		JOptionPane.showMessageDialog(null,"Successful...!!");
	 }
	 else{
		 JOptionPane.showMessageDialog(null,"Failed.Please try again...!");
	   }*/
   }
	 catch(Exception ex){
		 // Exhausted Resultset
		 ex.printStackTrace();
	 }
	
	
	 
	}
	}
	
	
}
//View Librarian

class  ViewLibrarian implements ActionListener
{ 
  	JFrame f;
	public ViewLibrarian()
	{
	 f=new JFrame("View Librarian");
    JTable t=new JTable();
	JButton b=new JButton("Back");
	
	Object[] columns={"Id","Name","Password","Email"};
	DefaultTableModel model=new DefaultTableModel();
	model.setColumnIdentifiers(columns);
	t.setModel(model);
	t.setForeground(Color.black);
	Font font=new Font("" ,1,22);
	t.setFont(font);
	t.setRowHeight(30);
	
    f.setIconImage((new ImageIcon("arya-logo.png")).getImage());
    JScrollPane pane=new JScrollPane(t);
	pane.setBounds(0,0,800,200);
	b.setBounds(100,300,100,30);
	f.setLayout(null);
	f.add(pane);
	f.add(b);
	
	b.addActionListener(this);
	f.setSize(900,400);
	f.setLocationRelativeTo(null);
	f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	f.setVisible(true);
	
	
	Object[] row=new Object[4];
	   try
   {
		Class.forName("oracle.jdbc.driver.OracleDriver");  
        Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","tiger"); 
	   String query="select * from librarian";
     Statement stmt=con.createStatement();  
	ResultSet rs=stmt.executeQuery(query);
  while(rs.next())
  {row[0]=rs.getInt(1);
	 row[1]=rs.getString(2);
		   row[2]=rs.getString(3);
		   row[3]=rs.getString(4);
	        model.addRow(row);
  }
   }
	catch(Exception ex){
		 // Exhausted Resultset
		 ex.printStackTrace();
	 }
	 
	}
	public void actionPerformed(ActionEvent e)
	{  f.dispose();
	  new AdminSection();
	   
	}
	
}


class DeleteLibrarian implements ActionListener
{    JFrame f;
     JButton b1,b2;
	 JTextField jt;

	public DeleteLibrarian()
	{ f=new JFrame("Delete Librarian");
	   jt=new JTextField();
	  JLabel l=new JLabel("Id");
	   b1=new JButton("Back");
	   b2=new JButton("Delete");
	  
	  f.add(b1);
	  f.add(b2);
	  f.add(l);
	  f.add(jt);
	  l.setBounds(20,50,100,30);
	  jt.setBounds(130,50,100,30);
	  b1.setBounds(20,100,80,30);
	  b2.setBounds(130,100,110,30);
	  b1.addActionListener(this);
      b2.addActionListener(this);
	  f.setSize(400,500);
	  f.setLayout(null);
	  f.setVisible(true);
	}
	  
	public void actionPerformed(ActionEvent e)
	{   if(e.getSource()==b1)
	 { 
       f.dispose();
       new AdminSection();
 	 }
	 else if(e.getSource()==b2)
	  {  
       try
        {  
		    
	    	Class.forName("oracle.jdbc.driver.OracleDriver");  
            Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","tiger"); 
    	   String query="delete from librarian where id="+jt.getText();
           Statement stmt=con.createStatement();  
      	   ResultSet  rs=stmt.executeQuery(query);
		  
	       JOptionPane.showMessageDialog(null,"Successful...!!");
		  
               }
			   catch(Exception ex){
		 // Exhausted Resultset
		 ex.printStackTrace();
	    }
	 
	  }  
	   }
	 
	
}




//Librarian Section

class LibrarianSection implements ActionListener
{ JButton b1,b2,b3,b4,b5,b6;
  JFrame f;
  JLabel l;
  LibrarianSection()
  {  f=new JFrame("Libraian Section");
     f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	 f.setIconImage((new ImageIcon("arya-logo.png")).getImage());
	 l=new JLabel("Librarian Section");
	 l.setFont(new Font("Serif",Font.BOLD,25));
 	  b1=new JButton("Add Books");
      b2=new JButton("View Books");
	  b3=new JButton("Issue Books"); 
	  b4=new JButton("View Issued Books"); 
	  b5=new JButton("Return Books");
	  b6=new JButton("Logout");
	  
	b1.setBounds(80,120,200,30);
	b2.setBounds(80,170,200,30);
	b3.setBounds(80,220,200,30);
	b4.setBounds(80,270,200,30);
	b5.setBounds(80,320,200,30);
	b6.setBounds(80,370,200,30);
	f.add(b1);
	f.add(b2);
	f.add(b3);
	f.add(b4);
	f.add(b5);
	f.add(b6);
	f.add(l);
	l.setBounds(90,50,200,40);
	b1.addActionListener(this);
    b2.addActionListener(this);
	b3.addActionListener(this);
    b4.addActionListener(this);
	b5.addActionListener(this);
    b6.addActionListener(this);
   b1.setFont(new Font("Arial",Font.PLAIN,20));
   b2.setFont(new Font("Arial",Font.PLAIN,20));
   b3.setFont(new Font("Arial",Font.PLAIN,20));
   b4.setFont(new Font("Arial",Font.PLAIN,20));
   b5.setFont(new Font("Arial",Font.PLAIN,20));
   b6.setFont(new Font("Arial",Font.PLAIN,20));
	f.setSize(500,600);
	f.setLayout(null);
	f.setVisible(true);
  }
	  
	public void actionPerformed(ActionEvent e)
  { 
  if(e.getSource()==b1)
	 { 
    f.dispose();
	new AddBook();
 
	 }
	 else if(e.getSource()==b2)
	  {  
       f.dispose();
        new ViewBook();
	   }
  else if(e.getSource()==b3)
	  {  
       f.dispose();
	  new IssueBook();
 
	   }
  else if(e.getSource()==b4)
	  {  
       f.dispose();
       new   ViewIssuedBooks();
	   }
  else if(e.getSource()==b5)
	  {  
       f.dispose();
      new  ReturnBooks();
	   }
  else if(e.getSource()==b6)
	  {  
       f.dispose();
 
	   }
 
  
   }  
	  
	
  }

  
  //Add Books
class AddBook implements ActionListener{
	JFrame f;
	JLabel l,l1,l2,l3;
	JTextField tf1,tf2,tf3;
	JButton b;
	public AddBook()
	{ f=new JFrame("Add Books");
	  b=new JButton("Add"); 
	  l1=new JLabel("Book Name");
     l2=new JLabel("Publisher");  
	 l3=new JLabel("Price");
	 l=new JLabel("Add Book");
tf1=new JTextField();	 
tf2=new JTextField();
tf3=new JTextField();	
f.add(l1);
	f.add(l2);
	f.add(l3);
	f.add(tf1);
	f.add(tf2);
	f.add(tf3);
	f.add(b);
	f.add(l);
	l.setFont(new Font("Serif",Font.BOLD,25));
	l1.setFont(new Font("Arial",Font.PLAIN,20));
	tf1.setFont(new Font("Arial",Font.PLAIN,20));
	l2.setFont(new Font("Arial",Font.PLAIN,20));
	l3.setFont(new Font("Arial",Font.PLAIN,20));
	l.setBounds(50,50,200,40);
	l1.setBounds(20,100,150,30);
	tf1.setBounds(150,100,100,30);
	l2.setBounds(20,150,150,30);
	tf2.setBounds(150,150,100,30); 
	l3.setBounds(20,200,150,30);
	tf3.setBounds(150,200,100,30);
	b.setBounds(80,250,80,30);
	  
	  f.setIconImage((new ImageIcon("arya-logo.png")).getImage());
	  f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	  f.setSize(500,600);
	  f.setLayout(null);
	  f.setVisible(true); 
	  b.addActionListener(this);
	  
	}
	public void actionPerformed(ActionEvent e)
	{
		 ResultSet rs;
		//String p=tf3.getText();
		//int price=Integer.parseInt(p);
		//System.out.println(price);
	
   try
   {
		Class.forName("oracle.jdbc.driver.OracleDriver");  
        Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","tiger"); 
	   String query="insert into books values('"+ tf1.getText()+"','"+tf2.getText()+"',"+tf3.getText()+")";
     Statement stmt=con.createStatement();  
	 rs=stmt.executeQuery(query);
	 JOptionPane.showMessageDialog(null,"Successful...!!");
			
	}
	
	catch(Exception ex){
		 // Exhausted Resultset
		 ex.printStackTrace();
	 }
	}
	
	
}

//View Books
class ViewBook implements ActionListener{
	JFrame f;
	public ViewBook()
	{
	 f=new JFrame("View Books");
    JTable t=new JTable();
	JButton b=new JButton("Back");
	
	Object[] columns={"Name","Publisher","Price"};
	DefaultTableModel model=new DefaultTableModel();
	model.setColumnIdentifiers(columns);
	t.setModel(model);
	t.setForeground(Color.black);
	Font font=new Font("" ,1,22);
	t.setFont(font);
	t.setRowHeight(30);
	
	  f.setIconImage((new ImageIcon("arya-logo.png")).getImage());
	  
	  JScrollPane pane=new JScrollPane(t);
	pane.setBounds(0,0,800,200);
	b.setBounds(100,300,100,30);
	f.setLayout(null);
	f.add(pane);
	f.add(b);
	
	b.addActionListener(this);
	f.setSize(900,400);
	f.setLocationRelativeTo(null);
	f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	f.setVisible(true);
	
	
	Object[] row=new Object[3];
	   try
   {
		Class.forName("oracle.jdbc.driver.OracleDriver");  
        Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","tiger"); 
	   String query="select * from books";
     Statement stmt=con.createStatement();  
	ResultSet rs=stmt.executeQuery(query);
  while(rs.next())
  {
	 row[0]=rs.getString(1);
		   row[1]=rs.getString(2);
		   row[2]=rs.getInt(3);
	        model.addRow(row);
  }
   }
	catch(Exception ex){
		 // Exhausted Resultset
		 ex.printStackTrace();
	 }
	 
	}
	public void actionPerformed(ActionEvent e)
	{  f.dispose();
	  new LibrarianSection();
	   
	}
	
	
	
}

//Issue Books
class IssueBook implements ActionListener{
	 JFrame f;
  JLabel l1,l2,l3,l4;
  JTextField tf1,tf2,tf3,tf4;
  JButton b;
  //Date dt=new Date();
  
  IssueBook()
  { f=new JFrame("issue Books");
    
    b=new JButton("ok"); 
     l1=new JLabel("Book Id");
     l2=new JLabel("Student Id");  
	 l3=new JLabel("Name");  
	 l4=new JLabel("Contact Number"); 
	 
   tf1=new JTextField();	 
   tf2=new JTextField();
   tf3=new JTextField();	
   tf4=new JTextField();
    f.add(l1);
	f.add(l2);
	f.add(l3);
	f.add(l4);
	f.add(tf1);
	f.add(tf2);
	f.add(tf3);
	f.add(tf4);
	f.add(b);
	
	l1.setBounds(20,50,100,30);
	tf1.setBounds(130,50,100,30);
	l2.setBounds(20,100,100,30);
	tf2.setBounds(130,100,100,30); 
	l3.setBounds(20,150,150,30);
	tf3.setBounds(130,150,100,30); 
	l4.setBounds(20,10,100,30); 
	tf4.setBounds(130,10,100,30); 
	b.setBounds(80,200,60,30);
	  b.addActionListener(this);
	  f.setIconImage((new ImageIcon("arya-logo.png")).getImage());
	 f.setSize(400,500);
	f.setLayout(null);
	f.setVisible(true); 
	f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  
	  
	}
	public void actionPerformed(ActionEvent e)
	{ 
   try
   {
		Class.forName("oracle.jdbc.driver.OracleDriver");  
        Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","tiger"); 
	  // String query="insert into issuedbooks values("+tf1.getText()+","+tf2.getText()+",'"+tf3.getText()+"',"+tf4.getText()+","+dt+")";
       Statement stmt=con.createStatement(); 
       /*String query1="select sysdate from dual";
 	   String dt=null;
			   ResultSet rs1=stmt.executeQuery(query1);
			   while(rs1.next())
			   { dt=rs1.getString(1);
			   }
			  // System.out.println(dt);
			  */
		String pattern="dd-MMM-YYYY";
  SimpleDateFormat sdft=new SimpleDateFormat(pattern);
  String date=sdft.format(new Date());
		System.out.println(date);	  
	   String query="insert into issuedbooks values("+tf1.getText()+","+tf2.getText()+",'"+tf3.getText()+"',"+tf4.getText()+",'"+date+"')";
	   ResultSet rs=stmt.executeQuery(query);
	   JOptionPane.showMessageDialog(null,"Successful...!!");
			
	/* if(rs=stmt.executeQuery(query)>0)
	 {
  		JOptionPane.showMessageDialog(null,"Successful...!!");
	 }
	 else{
		 JOptionPane.showMessageDialog(null,"Failed.Please try again...!");
	   }*/
   }
	 catch(Exception ex){
		 // Exhausted Resultset
		 ex.printStackTrace();
	 }
	
	
	 
	}
	
}
//Return Books

class ReturnBooks implements ActionListener{
	  JFrame f;
     JButton b1,b2;
	 JTextField jt;

	public ReturnBooks()
	{ f=new JFrame("Return Books");
	   jt=new JTextField();
	  JLabel l=new JLabel("Book Id");
	   b1=new JButton("Back");
	   b2=new JButton("Delete");
	  
	  f.add(b1);
	  f.add(b2);
	  f.add(l);
	  f.add(jt);
	  l.setBounds(20,50,100,30);
	  jt.setBounds(130,50,100,30);
	  b1.setBounds(20,100,80,30);
	  b2.setBounds(130,100,110,30);
	  b1.addActionListener(this);
      b2.addActionListener(this);
	  f.setSize(400,500);
	  f.setLayout(null);
	  f.setVisible(true);
	  f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	  f.setIconImage((new ImageIcon("arya-logo.png")).getImage());
	}
	  
	public void actionPerformed(ActionEvent e)
	{   if(e.getSource()==b1)
	 { 
       f.dispose();
       new LibrarianSection();
 	 }
	 else if(e.getSource()==b2)
	  {  
       try
        {  
		    
	    	Class.forName("oracle.jdbc.driver.OracleDriver");  
            Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","tiger"); 
    	   String query="delete from issuedbooks where BookId="+jt.getText();
           Statement stmt=con.createStatement();  
      	   ResultSet  rs=stmt.executeQuery(query);
		  
	       JOptionPane.showMessageDialog(null,"Successful...!!");
		  
               }
			   catch(Exception ex){
		 // Exhausted Resultset
		 ex.printStackTrace();
	    }
	 
	  } 
	}
}

//ViewIssued Books
class ViewIssuedBooks implements ActionListener{
	JFrame f;
	JLabel l;
	JButton b;
	ViewIssuedBooks()
	{ 
	 f=new JFrame("Issued Books");
    JTable t=new JTable();
	JButton b=new JButton("Back");
	
	Object[] columns={"BookId","StudentId","Name","Stu.Contact","IssueDate"};
	DefaultTableModel model=new DefaultTableModel();
	model.setColumnIdentifiers(columns);
	t.setModel(model);
	t.setForeground(Color.black);
	Font font=new Font("" ,1,22);
	t.setFont(font);
	t.setRowHeight(30);
	
	  f.setIconImage((new ImageIcon("arya-logo.png")).getImage());
	  JScrollPane pane=new JScrollPane(t);
	pane.setBounds(0,0,800,200);
	b.setBounds(100,300,100,30);
	f.setLayout(null);
	f.add(pane);
	f.add(b);
	
	b.addActionListener(this);
	f.setSize(900,400);
	f.setLocationRelativeTo(null);
	f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	f.setVisible(true);	
	Object[] row=new Object[5];
	   try
   {
		Class.forName("oracle.jdbc.driver.OracleDriver");  
        Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","tiger"); 
	   String query="select * from issuedbooks";
     Statement stmt=con.createStatement();  
	ResultSet rs=stmt.executeQuery(query);
  while(rs.next())
  {   row[0]=rs.getInt(1);
	 row[1]=rs.getInt(2);
		   row[2]=rs.getString(3);
		   row[3]=rs.getString(4);
		   row[4]=rs.getString(5);
	        model.addRow(row);
  }
   }
	catch(Exception ex){
		 // Exhausted Resultset
		 ex.printStackTrace();
	 }
	 
	}
	public void actionPerformed(ActionEvent e)
	{  f.dispose();
	  new LibrarianSection();
	   
	}
	
}






















