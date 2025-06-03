/*
DELIMITER //
CREATE PROCEDURE getEmployeeById(IN emp_id INT)
BEGIN
    SELECT empno, ename, sal FROM emp WHERE empno = emp_id;
END //
DELIMITER ;

*/



import java.sql.*;

public class CallableStatementDemo {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost/test";
        String user = "root";
        String pass = "root";

        try (Connection conn = DriverManager.getConnection(url, user, pass)) {
            CallableStatement cstmt = conn.prepareCall("{call getEmployeeById(?)}");
            cstmt.setInt(1, 7698); // pass parameter

            ResultSet rs = cstmt.executeQuery();
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
