<%@ page language="java" import="java.util.*" pageEncoding="utf-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
    <base href="<%=basePath%>">

    <title>My JSP 'manageUsers.jsp' starting page</title>

    <meta http-equiv="pragma" content="no-cache">
    <meta http-equiv="cache-control" content="no-cache">
    <meta http-equiv="expires" content="0">
    <meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
    <meta http-equiv="description" content="This is my page">
<%--    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css"--%>
<%--          integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2" crossorigin="anonymous">--%>
    <link rel="stylesheet" href="./css/bootstrap.min.css">
</head>

<body>
<div class="container">
    <%@include file="layout/header.jsp" %>
    <%--<%--%>
    <%--    List<Article> articleList = (List<Article>) request.getAttribute("articleList");--%>
    <%--%>--%>
    <h1>管理我的求助</h1>
    <table class="table table-hover">
        <thead>
        <tr>
            <th>求助者ID</th>
            <th>求助ID</th>
            <th>求助时间</th>
            <th>求助内容</th>
            <th>求助地点</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${helpRequests}" var="helpRequest">
            <tr>
                <td>${helpRequest.helpSeekerId}</td>
                <td>${helpRequest.helpRequestId}</td>
                <td>${helpRequest.helpRequestCreateTime}</td>
                <td>${helpRequest.helpRequestContent}</td>
                <td>${helpRequest.helpRequestLocation}</td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
    <%@include file="layout/footer.jsp" %>
</div>
</body>
</html>