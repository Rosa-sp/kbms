<%@ page import="java.util.List" %>
<%@ page import="com.itlaobing.kms.models.TblKnowledgeModel" %>
<%@ page import="com.itlaobing.kms.services.TblKnowledgeService" %>
<%@ page import="java.util.ArrayList" %><%--
  Created by IntelliJ IDEA.
  User: Alex
  Date: 2019/11/24
  Time: 20:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>detail</title>
</head>
<body>
<%
    TblKnowledgeModel model = new TblKnowledgeModel();
    TblKnowledgeService service = new TblKnowledgeService();
    model = service.findById(Integer.parseInt(request.getParameter("id")) );
    request.setAttribute("model",model);
%>

<table  width="500">
    <caption>知识详细内容</caption>
    <tr>
        <td>知识标题：<%= model.getTitle() %></td>
    </tr>
    <tr>
        <td>是否发布：<%= model.getIsPublish()== 0 ? "发布" :"停止" %></td>
    </tr>
    <tr>
        <td>知识来源：<%= model.getFromName() %></td>
    </tr>
    <tr>

        <td>知识类别：<%= model.getTypeld()  == 1 ? "Java编程基础": (model.getTypeld()== 2 ? "Java面向对象":"MySQL")%></td>
    </tr>
    <tr>

        <td>知识内容：<%= model.getContent() %></td>
    </tr>

</table>

</body>
</html>
