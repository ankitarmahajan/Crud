package CRUD;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class CRUD_Test {
	
	
  public static void main(String[] args) {
	CRUD_Test objTest = new CRUD_Test();
	   objTest.create("1", "Ankita", "1999-3-21", "2020-10-3");
	    objTest.create("2", "Vaishnavi", "1999-9-11", "2021-5-21");
		objTest.create("3", "Adhira", "1999-02-3", "2021-6-10");
		objTest.read("2");
	    objTest.update("2", "2", "Vaishna", "1999-9-11","2021-9-21");
		
		objTest.delete("3");
	}
	
	
	public void create(String stud_no, String stud_name, String stud_dob, String stud_doj) 
	{
		DB_Connection obj_DB_Connection=new DB_Connection();
		Connection connection=obj_DB_Connection.get_connection();
		
		PreparedStatement ps=null;
		try {
			
			String query="insert into Student(stud_no, stud_name, stud_dob, stud_doj) values (?,?,?,?)";
			ps=connection.prepareStatement(query);
			ps.setString(1, stud_no);
			ps.setString(2, stud_name);
			ps.setString(3, stud_dob);
			ps.setString(4, stud_doj);
			System.out.println(ps);
			ps.executeUpdate();
			
			}catch (Exception e) 
		{
			System.out.println(e);
		}
	}

	
	public void read(String stud_no){
		DB_Connection obj_DB_Connection=new DB_Connection();
		Connection connection=obj_DB_Connection.get_connection();
		
		PreparedStatement ps=null;
		
		ResultSet rs=null;
		try {
			String query="select * from Student where stud_no=?";
			ps=connection.prepareStatement(query);
			//ps.setString(1, stud_no);
			System.out.println(ps);
			rs=ps.executeQuery();
			while(rs.next()){
			System.out.println("stud no -"+rs.getString("stud_no"));
			System.out.println("stud name -"+rs.getString("stud_name"));
			System.out.println("stud dob -"+rs.getString("stud_dob"));
			System.out.println("stud doj -"+rs.getString("stud_doj"));
			System.out.println("---------------");
			}
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	
	public void update(String stud_no,String new_stud_no, String stud_name, String stud_dob, String stud_doj){
		DB_Connection obj_DB_Connection=new DB_Connection();
		Connection connection=obj_DB_Connection.get_connection();
		PreparedStatement ps=null;
		try {
			String query="update Student set stud_no=?,stud_name=?,stud_dob=?,stud_doj=? where stud_no=?";
			ps=connection.prepareStatement(query);
			ps.setString(1, stud_no);
			ps.setString(2, stud_name );
			ps.setString(3, stud_dob );
			ps.setString(4, stud_doj);
			ps.setString(5, stud_no);
			System.out.println(ps);
			ps.executeUpdate();
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	
	public void delete(String stud_no){
		DB_Connection obj_DB_Connection=new DB_Connection();
		Connection connection=obj_DB_Connection.get_connection();
		PreparedStatement ps=null;
		try {
			String query="delete from Student where stud_no=?";
			ps=connection.prepareStatement(query);
			ps.setString(1, stud_no);
			System.out.println(ps);
			ps.executeUpdate();
		} catch (Exception e) {
			System.out.println(e);
		}

	}

}