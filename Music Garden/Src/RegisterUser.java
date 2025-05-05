import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class RegisterUser {
    private static final String URL = "jdbc:mysql://localhost:3306/user_database?useSSL=false&serverTimezone=UTC";
    private static final String USER = "root";
    private static final String PASSWORD = "music147!";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // 輸入使用者資料
        System.out.print("請輸入使用者名稱：");
        String username = scanner.nextLine();

        System.out.print("請輸入電子郵件：");
        String email = scanner.nextLine();

        System.out.print("請輸入密碼：");
        String password = scanner.nextLine();

        try {
            // 確保載入 MySQL 驅動
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);

            // 準備 SQL 插入語句
            String sql = "INSERT INTO users (username, email, password) VALUES (?, ?, ?)";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, username);
            stmt.setString(2, email);
            stmt.setString(3, password);

            // 執行插入
            stmt.executeUpdate();
            conn.close();

            System.out.println("✅ 註冊成功！");
        } catch (Exception e) {
            System.out.println("❌ 註冊失敗：" + e.getMessage());
        }
    }
}