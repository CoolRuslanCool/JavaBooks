<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/main.css"/>"/>
    <title>Books Test</title>
</head>

<body>
<% request.setCharacterEncoding("UTF-8"); %>

<div class="wrapper">

    <div class="header">
        <h1 style="text-align: center">Books shelf.</h1>
    </div>

    <div class="search_panel">
        <p>

            <form:form modelAttribute="searchFilter" action="/search" method="post">

                <form:input path="searchString" type="text" name="search_string" value="" size="30"/>
                <input class="btn" type="submit" value="Поиск"/>

                <form:select path="restrictionSearch" name="search_option">
                    <form:options items="${searchFilter.restrictionSearchMap}"/>
                </form:select>

                <form:input path="year" type="text" value="" size="4"/>

                <form:select path="restrictionYear" name="search_option">
                    <form:options items="${searchFilter.restrictionYearMap}"/>
                </form:select>

                <form:select path="restrictionAlready" name="search_option">
                    <form:options items="${searchFilter.restrictionAlreadyMap}"/>
                </form:select>

            </form:form>

            <form:form cssClass="add_book" method="post" action="/create">
                <input type="submit" value="Добавить книгу">
            </form:form>

        </p>
    </div>

    <div class="content">
        <div>
            <p>
                <strong>Всего найдено книг: ${searchFilter.totalBook} книг.</strong>

                <c:if test="${searchFilter.totalBook > 10}">

                    <c:if test="${searchFilter.showPrev}">
                        <a href="<c:url value="/prev"/>"><strong><<< Назад</strong></a>
                    </c:if>

                    <c:if test="${searchFilter.showNext}">
                        <a href="<c:url value="/next"/>"><strong> Вперед >>></strong></a>
                    </c:if>

                </c:if>
            </p>
        </div>
        <table style="border: solid;">
            <c:forEach items="${books}" var="b">
                <tr>

                    <td style="width: 200px;border: solid;padding: 10px;">
                        <p>
                        <h3>${b.title}</h3><br>
                        <strong>Автор:</strong>${b.author}<br>
                        <strong>Год:</strong>${b.printYear}<br>
                        <strong>Isbn:</strong>${b.isbn}<br>
                        <strong>${(b.readAlready == 0) ? 'Не прочитана.' : 'Прочитана.'}</strong>
                        </p>
                    </td>

                    <td style="width: 200px;border: solid;padding: 10px;">
                        <p><strong>Огисание: </strong>${b.description}</p>
                    </td>

                    <td style="width: 100px;border: solid;padding: 10px;">
                        <p>
                            <form:form action="/read?bookId=${b.id}" method="post">
                                <input class="btn" value="Читать" type="submit"/><br><br>
                            </form:form>

                            <form:form method="post" action="/update?bookId=${b.id}">
                                <input value="Редактировать" type="submit" class="btn"/><br><br>
                            </form:form>

                            <form:form action="/delete?bookId=${b.id}" method="post">
                                <input class="btn" type="submit" value="Удалить"/>
                            </form:form>

                        </p>
                    </td>

                </tr>
            </c:forEach>
        </table>
    </div>

    <div class="footer">
        <span style="text-align: center;padding: 5px;"><strong>Developer:</strong>Pivovarov Ruslan.  2017 year.</span>
    </div>

</div>
</body>
</html>