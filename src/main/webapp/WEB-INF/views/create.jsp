<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Create</title>
</head>
<body>
<% request.setCharacterEncoding("UTF-8"); %>
<div class="create_book">
    <p>

        <form:form modelAttribute="book" action="/save?newBook=true" method="post">

            <strong>Название:</strong><br>
            <form:input path="title" type="text" name="title" value="${book.title}" size="100"/><br>

            <strong>Автор:</strong><br>
            <form:input path="author" type="text" name="author" value="${book.author}" size="100"/><br>

            <strong>Описание:</strong><br>
            <form:textarea path="description" type="text" name="description" value="${book.description}" rows="5"
                           cols="100"/><br>

            <strong>ISBN:</strong><br>
            <form:input path="isbn" type="text" name="isbn" value="${book.isbn}" size="30"/><br>

            <strong>Год издания:</strong><br>
            <form:input path="printYear" type="text" name="printYear" value="${book.printYear}" size="10"/><br>

            <input class="btn" type="submit" value="Сохранить"/>
            <input class="btn" type="reset" value="Сбросить"/>

        </form:form>

        <form:form modelAttribute="book" action="/search" method="post">
            <input class="btn" type="submit" value="Отменить и вернуться"/>
        </form:form>

    </p>
</div>
</body>
</html>
