import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

public class TestServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        // 設定回應內容
        response.setContentType("text/plain");
        response.getWriter().println("✅ Jakarta Servlet API 已成功引用！");
    }
}

