<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: arek
  Date: 18.05.2021
  Time: 14:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h3>Dodawanie Autora</h3>
<form:form method="post" modelAttribute="author">

    Imię: <br/><form:input path="firstName"/>
    <form:errors path="firstName"/>
    <br/>
    Nazwisko: <br/><form:input path="lastName"/>
    <form:errors path="lastName"/>
    <br/>
    PESEL: <br/><form:input path="pesel"/>
    <form:errors path="pesel"/>
    <br/>

    email:<br/><form:input path="email"/>
    <form:errors path="email"/>
    <br/>

    <form:hidden path="id"/>
    <br/>
    <input type="submit" value="Dodaj">
</form:form>

<table>
    <form:form modelAttribute="charactercreates" method="post">
        Name: <form:input path="name"/>
        Spells: <form:select path="characterclass" items="${characterclass}"></form:select>
        Spells: <form:select multiple="true" path="spells" items="${spell}"></form:select>
        Equipment: <form:select multiple="true" path="equipment" items="${equipment}"></form:select>
        Proficiency: <form:select multiple="true" path="proficiency" items="${proficiency}"></form:select>
        Race: <form:select path="race" items="${race}"></form:select>
        Traits: <form:select multiple="true" path="traits" items="${traits}"></form:select>

        <input type="submit" value="Submit"/>

    </form:form>

</table>
</body>
</html>
