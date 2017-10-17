<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Read Book</title>
</head>

<body>
<% request.setCharacterEncoding("UTF-8"); %>
<div style="width: 500px;margin: 50px;">

    <div style="margin: 20px;">

        <form:form method="post" action="/search">
            <input type="submit" value="Назад">
        </form:form>

    </div>

    <p>
        <strong>${book.title}</strong><br>${book.description}
    </p>

</div>
</body>
</html>