package testing;


import java.sql.*;

public class JdbcDbCreation {
	
	
   // JDBC driver name and database URL
   static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
   static final String DB_URL = "jdbc:mysql://localhost:3306/";

   //  Database credentials
   static final String USER = "root";
   static final String PASS = "tiger";
   
   public static int createDb(String dbname){
   Connection conn = null;
   Statement stmt = null;
   int dbmode=0;
   try{
      //STEP 2: Register JDBC driver
      Class.forName("com.mysql.jdbc.Driver");

      //STEP 3: Open a connection
      System.out.println("Connecting to database...");
      conn = DriverManager.getConnection(DB_URL, USER, PASS);

      //STEP 4: Execute a query
      System.out.println("Creating database...");
      stmt = conn.createStatement();
      System.out.println("dbname-----------"+dbname);
     // String sql = "CREATE DATABASE '"+dbname+"'";
      String sql = "CREATE DATABASE `"+dbname+"` /*!40100 DEFAULT CHARACTER SET latin1 */";
      System.out.println(sql);
      stmt.executeUpdate(sql);
      System.out.println("Database created successfully...");
      dbmode=1;
   }catch(SQLException se){
      //Handle errors for JDBC
      se.printStackTrace();
   }catch(Exception e){
      //Handle errors for Class.forName
      e.printStackTrace();
   }finally{
      //finally block used to close resources
      try{
         if(stmt!=null)
            stmt.close();
      }catch(SQLException se2){
      }// nothing we can do
      try{
         if(conn!=null)
            conn.close();
      }catch(SQLException se){
         se.printStackTrace();
      }//end finally try
   }//end try
   System.out.println("Goodbye!");
   return dbmode;
}//end main
}//end JDBCExample