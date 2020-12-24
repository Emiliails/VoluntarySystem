<%@ page language="java" import="java.util.*" pageEncoding="utf-8" %>
<%@ page import="java.time.format.DateTimeFormatter" %>
<%@ page import="java.time.LocalDateTime" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
    <base href="<%=basePath%>">

    <title>My JSP 'login.jsp' starting page</title>

    <meta http-equiv="pragma" content="no-cache">
    <meta http-equiv="cache-control" content="no-cache">
    <meta http-equiv="expires" content="0">
    <meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
    <meta http-equiv="description" content="This is my page">
    <link rel="stylesheet" href="./css/bootstrap.min.css">

</head>

<body>
<div class="container">
    <%@include file="layout/header.jsp" %>
    <h1>发布求助</h1>

    <form action="addHelpRequest" method="POST">
        <div class="form-group">
            <label for="helpSeekerId">求助者ID</label>
            <input type="text" class="form-control" id="helpSeekerId" name="helpSeekerId"
                   value="${helpSeekerId}" readonly>
        </div>
        <%--        <div class="form-group">--%>
        <%--            <label for="articleName">文章名</label>--%>
        <%--            <input type="articleName" class="form-control" id="articleName" name="articleName"--%>
        <%--                   value=${article.articleName}>--%>
        <%--        </div>--%>
        <%--        <div class="form-group">--%>
        <%--            <label for="articleTypeName">文章类型</label>--%>
        <%--            <select multiple class="form-control" id="articleTypeName" name="articleTypeName">--%>
        <%--                <c:forEach items="${articleTypeList}" var="articleType">--%>
        <%--                    <option>${articleType.articleTypeName}</option>--%>
        <%--                </c:forEach>--%>
        <%--            </select>--%>
        <%--        </div>--%>
        <div class="form-group">
            <label for="helpRequestCreateTime">求助时间</label>
            <input type="text" class="form-control" id="helpRequestCreateTime" name="helpRequestCreateTime"
                   value="<%=DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss").format(LocalDateTime.now())%>" readonly>
        </div>
        <div class="form-group">
            <label for="helpRequestLocation">求助地点</label>
            <input type="text" class="form-control" id="helpRequestLocation" name="helpRequestLocation"
                   value="${helpRequest.helpRequestLocation}">
        </div>
        <div class="form-group">
            <label for="helpRequestContent">求助内容</label>
            <textarea class="form-control" id="helpRequestContent" name="helpRequestContent">
                ${helpRequest.helpRequestContent}
            </textarea>
        </div>
        <span style="color:red">${errorMessage}</span><br>
        <button type="submit" class="btn btn-primary">发布</button>
    </form>
    <%@include file="layout/footer.jsp" %>
</div>
</body>
</html>
