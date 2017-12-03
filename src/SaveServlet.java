import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;

public class SaveServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");

        SimpleDateFormat format1 = new SimpleDateFormat("dd.MM.yyyy");

        MyObject object = new MyObject();
        HashMap<String, Boolean> errorsView = new HashMap<String, Boolean>();
        errorsView.put("emptyField", false);
        errorsView.put("wrongDuration", false);

        try {
            object.setId(Integer.parseInt(req.getParameter("id")));
        } catch(NumberFormatException e) {}
        if(object.getId() == null) {
            Storage.create(object);
        } else {
            Storage.update(object);
        }


        object.setAuthor(req.getParameter("author"));
        object.setName(req.getParameter("name"));

        if (object.getName().trim().length() == 0 || object.getAuthor().trim().length() == 0) {
            object = null;
            errorsView.replace("emptyField", true);
            redirect(req, resp, errorsView, object);
            return;
        }
        String durate[] = req.getParameter("duration").split(":");// ======to do(шаблон) =======
        DurationTime duration = new DurationTime();

        for(int i = 0; i < durate.length; i++){
            try {
                Integer.parseInt(durate[i]);
            } catch (NumberFormatException e) {
                errorsView.replace("wrongDuration", true);
                redirect(req, resp, errorsView, object);
                return;
            }
        }

        if (durate.length > 3 || durate.length < 2) {
            errorsView.replace("wrongDuration", true);
            redirect(req, resp, errorsView, object);
            return;
        }

        if (durate.length == 3) {
            duration.setTwoParam(false);
            duration.setHours(Integer.parseInt(durate[durate.length - 3]));
        }
        duration.setMinutes(Integer.parseInt(durate[durate.length - 2]));
        duration.setSeconds(Integer.parseInt(durate[durate.length - 1]));
        errorsView.replace("wrongDuration", !duration.correctTime());


        if (errorsView.get("wrongDuration")) {
            redirect(req, resp, errorsView, object);
            return;
        }

        object.setDuration(duration);//====to do (маска ввода)===

        try {
            object.setPublication(format1.parse(format1.format( new Date() )));
        } catch (ParseException e) {
            e.printStackTrace();
        }

        resp.sendRedirect(req.getContextPath() + "/index.html");
    }

    private void redirect(HttpServletRequest req, HttpServletResponse resp, HashMap flag, MyObject object) throws ServletException, IOException {
        req.setAttribute("errorsView",flag);
        req.setAttribute("object", object);
        getServletContext().getRequestDispatcher("/WEB-INF/edit.html").forward(req, resp);
    }
}