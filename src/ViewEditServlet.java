import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;

@WebServlet(name = "ViewEditServlet")
public class ViewEditServlet extends HttpServlet {

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
      serv(req,resp);
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
			serv(req,resp);
    
    }
	private void serv(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
		    MyObject object = (MyObject)req.getAttribute("object");
        Boolean flag = (Boolean)req.getAttribute("flag");

        resp.setCharacterEncoding("UTF-8");

        PrintWriter w = resp.getWriter();
        w.println("<HTML>");
        w.println("<HEAD>");
        w.println("<META http-equiv=\"Content-Type\"");
        w.println("content=\"text/html; charset=UTF-8\">");
        w.println("<TITLE>Тест</TITLE>");
        w.println("</HEAD>");
        w.println("<BODY>");
        w.println("<FORM action=\"save.html\" method=\"post\">");
        if(object != null &&  object.getId()!=null) {
            w.printf("<INPUT type=\"hidden\" name=\"id\" value=\"%s\">\n",
                    object.getId().toString());
        }
        w.println("<P>Автор:</P>");
        w.printf("<INPUT type=\"text\" name=\"author\" value=\"%s\">\n",
                object != null ? object.getAuthor() : new String());

        w.println("<P>Назавание:</P>");
        w.printf("<INPUT type=\"text\" name=\"name\" value=\"%s\">\n",
                object != null ? object.getName() : new String());

        w.println("<P>Длительность:</P>");
        w.printf("<INPUT type=\"text\" name=\"duration\" value=\"%s\">\n",
                object != null ? object.getDuration().toString() : new String()); //============= to do (маску) =========
        if(!flag)
            w.println("<span>Заполните поле правильно</span>");

        w.println("<BUTTON type=\"submit\">Сохранить</BUTTON>");
        w.println("<A href=\"index.html\">Назад</A>");
        w.println("</FORM>");
        w.println("</BODY>");
        w.println("</HTML>");
	}
}
