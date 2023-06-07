package connect;

import java.sql.Connection;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class KetNoiSQL {

    public static void closeConnection(Connection connection) {
        throw new UnsupportedOperationException("Not supported yet."); 
    }

    public static Connection ConnectSQL() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    private Connection con = null;

    public KetNoiSQL() {
        try {
    String url = "jdbc:sqlserver://localhost:1433;databaseName=Management"; // thay thế "localhost" bằng tên hoặc địa chỉ IP của máy chủ SQL Server
    String user = "sa"; // thay thế "sa" bằng tên người dùng của bạn
    String password = "your_password_here"; // thay thế "your_password_here" bằng mật khẩu của bạn
    con = DriverManager.getConnection(url, user, password);
} catch (SQLException ex) {
    Logger.getLogger(KetNoiSQL.class.getName()).log(Level.SEVERE, null, ex);
}
    }
    
    public static Connection getConnection(){
        Connection conn = null;
        String url = "net.sourceforge.jtds.jdbc.Driver";
        try {
            Class.forName(url);
            String dbUrl = "jdbc:jtds:sqlserver://localhost/Management;user=sa;password=sa123";
            try {
                conn = DriverManager.getConnection(dbUrl);
            } catch (SQLException ex) {
                Logger.getLogger(KetNoiSQL.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(KetNoiSQL.class.getName()).log(Level.SEVERE, null, ex);
        }
        return conn;
    }

    public ResultSet GetResultSet(String tableName) throws SQLException {

        ResultSet rs = null;

        Statement stmt = con.createStatement();

        String sql = "select * from " + tableName;

        rs = stmt.executeQuery(sql);

        return rs;

    }

    public void Close() throws Exception {

        con.close();
    }

    public static void main(String[] args) {
        KetNoiSQL kn = new KetNoiSQL();
        try {
            ResultSet rs = kn.GetResultSet("SinhVien");//Table Name

            while (rs.next()) {
                System.out.println(rs.getString("MaSV"));//Field Name
            }
            kn.Close();
        } catch (SQLException ex) {
            Logger.getLogger(KetNoiSQL.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(KetNoiSQL.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
