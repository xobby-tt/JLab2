import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class SaveServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");

        SimpleDateFormat format1 = new SimpleDateFormat("dd.MM.yyyy");

        MyObject object = new MyObject();
        object.setAuthor(req.getParameter("author"));
        object.setName(req.getParameter("name"));

        String durate[] = req.getParameter("duration").split(":");
        object.setDuration(new DurationTime(Integer.parseInt(durate[0]), Integer.parseInt(durate[1])));//====to do (маска ввода)===

        try {
            object.setPublication(format1.parse(req.getParameter("publication")));//======to do(адекватное создание даты)========
        } catch (ParseException e) {
            e.printStackTrace();
        }

        try {
            object.setId(Integer.parseInt(req.getParameter("id")));
        } catch(NumberFormatException e) {}
        if(object.getId() == null) {
            Storage.create(object);
        } else {
            Storage.update(object);
        }

        resp.sendRedirect(req.getContextPath() + "/index.html");
    }
}