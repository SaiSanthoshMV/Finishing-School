// javac jdbc6.java
// java -cp "mysql-connector-j-8.0.32.jar;." jdbc6

import java.sql.*;
import java.util.*;

class jdbc6 {
  static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
  static final String DB_URL = "jdbc:mysql://localhost:3306/test";
  static final String USER = "root";
  static final String PASS = "root";

  public static void main(String[] args) throws SQLException {
    Connection conn = null;
    Statement stmt = null;
    ResultSet rs = null;
    Scanner sc = new Scanner(System.in);
    try {
      Class.forName(JDBC_DRIVER); // Load the driver
      conn = DriverManager.getConnection(DB_URL, USER, PASS);
      stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
          ResultSet.CONCUR_READ_ONLY);

      String sql = "SELECT empno FROM emp ORDER BY empno";
      rs = stmt.executeQuery(sql);

      if (rs.next()) {
        System.out.println(rs.getInt("empno"));
      }
      if (rs.absolute(2)) {
        System.out.println(rs.getInt("empno"));
      }
      if (rs.relative(2)) {
        System.out.println(rs.getInt("empno"));
      }
      if (rs.absolute(-1)) {
        System.out.println(rs.getInt("empno"));
      }
      if (rs.relative(-1)) {
        System.out.println(rs.getInt("empno"));
      }
    } catch (SQLException | ClassNotFoundException e) {
      e.printStackTrace();
    } finally {
      if (rs != null)
        rs.close();
      if (stmt != null)
        stmt.close();
      if (conn != null)
        conn.close();
    }
  }
}