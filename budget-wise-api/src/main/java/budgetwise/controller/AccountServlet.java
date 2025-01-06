package budgetwise.controller;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;


@WebServlet("/api/v1/account-info")
public class AccountServlet extends HttpServlet {

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setHeader("Access-Control-Allow-Origin", "http://127.0.0.1:5500"); // Разрешить доступ только с этого домена
        resp.setHeader("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE"); // Разрешенные методы
        resp.setHeader("Access-Control-Allow-Headers", "Content-Type, Accept"); // Разрешенные заголовки

        // Если это preflight запрос (OPTIONS), ответим сразу
        if ("OPTIONS".equals(req.getMethod())) {
            resp.setStatus(HttpServletResponse.SC_OK);
            return;
        }

        resp.setContentType("application/json");


        PrintWriter out = resp.getWriter();

        out.println("""
                {
                    "name": "John Doe",
                    "age": 30,
                    "isStudent": false,
                    "hobbies": ["reading", "travelling", "coding"],
                    "address": {
                        "street": "123 Main St",
                        "city": "New York",
                        "state": "NY",
                        "zip": "10001"
                    }
                }
                """);
    }
}
