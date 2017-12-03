import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Collection;
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

        String durate[] = req.getParameter("duration").split(":");// ======to do(шаблон) =======
        DurationTime duration = new DurationTime();
        Boolean flag = true;
        flag = duration.correctTime(Integer.parseInt(durate[0]));
        if (flag)
            flag = duration.correctTime(Integer.parseInt(durate[1]));
        if (!flag) {
            object.setDuration(null);
            req.setAttribute("flag",flag);
            req.setAttribute("object", object);
            getServletContext().getRequestDispatcher("/WEB-INF/edit.html").forward(req, resp);
            return;
        }
        duration.setMinutes(Integer.parseInt(durate[0]));
        duration.setSeconds(Integer.parseInt(durate[1]));
        object.setDuration(duration);//====to do (маска ввода)===

        try {
            object.setPublication(format1.parse(format1.format( new Date() )));
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