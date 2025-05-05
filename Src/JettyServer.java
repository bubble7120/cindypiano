import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;

public class JettyServer {
    public static void main(String[] args) throws Exception {
        // 啟動 Jetty 伺服器在埠 8080
        Server server = new Server(8080);
        
        // 設置 Servlet 處理路徑
        ServletContextHandler handler = new ServletContextHandler();
        handler.addServlet(new ServletHolder(new TestServlet()), "/test");
        server.setHandler(handler);

        // 啟動伺服器
        server.start();
        System.out.println("伺服器啟動成功，請訪問 http://localhost:8080/test");
        server.join();
    }
}
