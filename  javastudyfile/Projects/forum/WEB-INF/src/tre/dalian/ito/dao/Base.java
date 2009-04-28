package tre.dalian.ito.dao;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
public class Base {
		 public   Connection databaseConnection;
		 private String driverName="org.postgresql.Driver";
		 private String dbURL="jdbc:postgresql://172.18.1.42:5432/BBS";
		 private String userName="postgres";
		 private String passWord="";
		 public void creatConnect()throws Exception{
			 if(databaseConnection==null){
				 try{
					 Class.forName(driverName).newInstance();
					 databaseConnection=DriverManager.getConnection(dbURL, userName, passWord);//getConnection(dbURL,userName,passWord);
					 
				 }catch(Exception e){
					 System.out.print(e);
					 e.printStackTrace();
				 }
			 }
		 }
		 public void closeConnect()throws SQLException{
			 if(databaseConnection!=null){
				 databaseConnection.close();
				 databaseConnection=null;
			 }
		 }
		 public static void main(String[] args) throws Exception{
			 	Base b=new Base();
			 	b.creatConnect();
			 	String sql="select * from article";
			 	PreparedStatement pst=b.databaseConnection.prepareStatement(sql);
			 	ResultSet tr=pst.executeQuery();
			 	while(tr.next()){
			 		System.out.print(tr.getString("subject"));
			 	}
			 	b.closeConnect();
			 	
		 }
}

	

