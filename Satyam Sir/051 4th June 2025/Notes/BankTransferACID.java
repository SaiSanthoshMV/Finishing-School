import java.sql.*;

public class BankTransferACID {
public static void main(String[] args) {

String url = "jdbc:mysql://localhost/bank";
String user = "root";
String pass = "root";

Connection conn = null;

try {
conn = DriverManager.getConnection(url, user, pass);
conn.setAutoCommit(false);  // Start transaction

PreparedStatement deduct = conn.prepareStatement("UPDATE accounts SET balance = balance - ? WHERE id = ?");
PreparedStatement add = conn.prepareStatement("UPDATE accounts SET balance = balance + ? WHERE id = ?" );

deduct.setInt(1, 500);
deduct.setInt(2, 1);  // Account A

add.setInt(1, 500);
add.setInt(2, 2);  // Account B

deduct.executeUpdate();  // Step 1: Deduct ₹500 from A
add.executeUpdate();     // Step 2: Add ₹500 to B

conn.commit();  //  Transaction successful (Atomic + Durable)
System.out.println("Transfer completed successfully.");

} catch (Exception e) {
try {
if (conn != null) 
		conn.rollback();  //  Error = Rollback (Atomic)
System.out.println("Transaction failed. Rolled back.");
} catch (SQLException se) {
se.printStackTrace();
}
e.printStackTrace();
} finally {
try {
if (conn != null) conn.close();
} catch (SQLException se) {
se.printStackTrace();
}
}
}
}

/*
Atomicity			----	conn.setAutoCommit(false) + conn.commit() + conn.rollback()
Consistency		----	Business rule: balance remains valid after transfer
Isolation				----	Ensured by default in JDBC using transaction isolation levels
Durability			----	After conn.commit(), data is persisted even after a system crash

CREATE DATABASE bank;
USE bank;

CREATE TABLE accounts (
    id INT PRIMARY KEY,
    name VARCHAR(50),
    balance INT
);

INSERT INTO accounts (id, name, balance) VALUES
(1, 'Alice', 1000),
(2, 'Bob', 500);


*/


