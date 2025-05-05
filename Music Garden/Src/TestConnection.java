import java.sql.Connection;
import java.sql.DriverManager;

public class TestConnection {
    private static final String URL = "jdbc:mysql://localhost:3306/user_database?useSSL=false&serverTimezone=UTC&allowPublicKeyRetrieval=true";
    private static final String USER = "root"; // 替換為你的資料庫帳
    private static final String PASSWORD = "music147!"; // 替換為你的資料庫密碼

    public static void main(String[] args) {
        System.out.println("🚀 嘗試建立資料庫連接...");
        try {
            System.out.println("🚧 準備使用 DriverManager 進行連線...");
            Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
            System.out.println("🎉 完成 DriverManager.getConnection()");
            if (conn != null) {
                System.out.println("✅ 成功連線到 MySQL 資料庫！");
            } else {
                System.out.println("❌ 連線失敗，Connection 為 null。");
            }
            conn.close(); // 關閉連線
            System.out.println("🔌 資料庫連線已關閉。");
        } catch (Exception e) {
            System.out.println("❌ 發生例外錯誤：");
            e.printStackTrace();
        }
        System.out.println("🏁 程式執行結束。");
    }
}