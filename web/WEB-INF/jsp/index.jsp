<%--
  Created by IntelliJ IDEA.
  User: Настя
  Date: 03.12.2017
  Time: 18:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<HTML>
<HEAD>
    <META http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <TITLE>Тест JSP</TITLE>
    <STYLE>
        TABLE {
            border-collapse: collapse;
        }
        TH, TD {
            border: 1px solid black;
            padding: 5px 30px 5px 10px;
        }
    </STYLE>
</HEAD>
<BODY>
<FORM action="delete.html" method="post">
    <TABLE>
        <TR>
            <TH></TH>
            <TH>id</TH>
            <TH>Автор(группа)</TH>
            <TH>Название</TH>
            <TH>Продолжительность</TH>
            <TH>Дата публикации</TH>
            <TH>Популярность</TH>
            <TH>Скачиваний</TH>
            <TH></TH>
        </TR>

        <c:forEach var="object" items="${objects}">

            <TR>
                <TD>
                    <INPUT type="checkbox" name="id"
                           value="${object.id}">
                </TD>

                <TD>${object.id}</TD>

                <TD>
                    <A href="edit.html?id=${object.id}">
                            ${object.author}
                    </A>
                </TD>

                <TD>${object.name}</TD>
                <TD>${object.duration}</TD>
                <TD>${object.publication}</TD>
                <TD>${object.popularity}</TD>
                <TD>${object.downloads}</TD>

                <TD>
                    <A href="download.html?id=${object.id}">
                        Скачать
                    </A>
                </TD>

            </TR>
        </c:forEach>
    </TABLE>
    <P>
        <A href="edit.html">Добавить</A>
        <BUTTON type="submit">Удалить</BUTTON>
    </P>
</FORM>
</BODY>
</HTML>

