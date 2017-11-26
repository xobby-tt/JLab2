import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class EditServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        try {
            MyObject object = Storage.readById(Integer.parseInt(req.getParameter("id")));
            req.setAttribute("object", object);
        } catch(NumberFormatException e) {}
        getServletContext().getRequestDispatcher("/WEB-INF/edit.html").forward(req, resp);
    }
}