<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: juliaszumowska
  Date: 20/05/2021
  Time: 10:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en" xmlns:th="http://www.thymeleaf.org/" >
<head>
    <title>Character Creator</title>
</head>
<body>
<h1 th:text="${title}">Character Creator</h1>
<nav th:replace="fragments :: navigation" ></nav>
<form method="post" th:object="${form}" action="add-class">
    <div class="form-group">
        <label th:for="classId">Class</label>
        <select name = "classId">
            <option th:each="characterclass : *{characterclasses}"
            th:text="${characterclass.name}"
            th:value="${characterclass.classId}"></option>
        </select>
    </div>
<input type="hidden" name="classId" th:value="*{characterclass.classId}"/>
    <input type="submit" value="Add Class" />

</form>

</body>
</html>
