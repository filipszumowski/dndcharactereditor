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
<ul>
    <li> th:each = "class : ${characterclasses}" th:text=${characterclass.name}" </li>
</ul>
<p th:unless="${characterclass.size()}"><i>No class yet</i></p>
<p><a th:href="'createcharacter/add-class'+${characterId}">Add class</a></p>



</body>
</html>