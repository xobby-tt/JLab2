import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;

import java.util.Collection;

@WebServlet(name = "ViewListServlet")
public class ViewListServlet extends HttpServlet {

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        Collection<MyObject> objects = (Collection<MyObject>)req.getAttribute("objects");
        resp.setCharacterEncoding("UTF-8");

        SimpleDateFormat format1 = new SimpleDateFormat("dd.MM.yyyy");

        PrintWriter w = resp.getWriter();
        w.println("<HTML>");
        w.println("<HEAD>");
        w.println("<META http-equiv=\"Content-Type\"");
        w.println("content=\"text/html; charset=UTF-8\">");
        w.println("<TITLE>Тест</TITLE>");
        w.println("<STYLE>");
        w.println("TABLE {");
        w.println("border-collapse: collapse;");
        w.println("}");
        w.println("TH, TD {");
        w.println("border: 1px solid black;");
        w.println("padding: 5px 30px 5px 10px;");
        w.println("}");
        w.println("</STYLE>");
        w.println("</HEAD>");
        w.println("<BODY>");
        w.println("<TABLE>");
        w.println("<TR><TH>id</TH><TH>Автор(группа)</TH><TH>Название</TH><TH>Продолжительность</TH><TH>Дата публикации</TH><TH>Популярность</TH><TH>Скачиваний</TH><TH></TH></TR>");
        for(MyObject object : objects) {
            w.print("<TR>");
            w.printf("<TD>%s</TD>", object.getId());//=====to do(явная передача индеска)=====
            w.printf("<TD><A href=\"edit.html?id=%d\">%s</A></TD>",//==========to do( клик на всю строку)=============
                    object.getId(), object.getAuthor());
            w.printf("<TD>%s</TD>", object.getName());
            w.printf("<TD>%s</TD>", object.getDuration().toString());
            w.printf("<TD>%s</TD>", format1.format(object.getPublication()));
            object.setPopularity();
            w.printf("<TD>%d</TD>", object.getPopularity());
            w.printf("<TD>%d</TD>", object.getDownloads());
            w.printf("<TD><A href=\"download.html?id=%d\">Скачать</A></TD>", object.getId());
            w.println("</TR>");
        }
        w.println("</TABLE>");

        w.println("<P><A href=\"edit.html\">Добавить</A></P>");

        w.println("</BODY>");
        w.println("</HTML>");
    }
}
