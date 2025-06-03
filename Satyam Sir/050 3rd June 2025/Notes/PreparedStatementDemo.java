import java.sql.*;

public class PreparedStatementDemo {
    public static void main(String[] args) {

        String url = "jdbc:mysql://localhost/test"; 
        String user = "root";
        String pass = "root";

        try (Connection conn = DriverManager.getConnection(url, user, pass)) {
            String sql = "SELECT empno, ename, sal FROM emp WHERE empno = ?";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, 7698); // set parameter value

            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                System.out.println("Emp No: " + rs.getInt("empno"));
                System.out.println("Name: " + rs.getString("ename"));
                System.out.println("Salary: " + rs.getDouble("sal"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
