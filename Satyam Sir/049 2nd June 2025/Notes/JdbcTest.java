//compile java -cp "mysql-connector-j-8.0.32.jar;." JdbcTest

import java.sql.*;

class JdbcTest {
    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://localhost/test";
    static final String USER = "root";
    static final String PASS = "root";

    public static void main(String[] args) {
        Connection conn = null;
        Statement stmt = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("Connecting to database...");
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            System.out.println("Creating statement...");
            stmt = conn.createStatement();
            String sql = "SELECT * from emp";
            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()) {
                int empno = rs.getInt("EMPNO");
                System.out.print(" empno : " + empno);
            }
            rs.close();
            stmt.close();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}