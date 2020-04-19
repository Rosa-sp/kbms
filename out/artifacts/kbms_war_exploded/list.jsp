<%@ page import="com.itlaobing.kms.models.TblKnowledgeModel" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.List" %>
<%@ page import="com.itlaobing.kms.services.TblKnowledgeService" %>
<%--
  Created by IntelliJ IDEA.
  User: Alex
  Date: 2019/11/24
  Time: 15:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>list</title>
</head>
<body>
<%
    List<TblKnowledgeModel> list = new ArrayList<TblKnowledgeModel>();
    TblKnowledgeService service = new TblKnowledgeService();
    list = service.findAll();
    request.setAttribute("list",list);
%>
<form action="like" method="get">
<table align="center">
    <tr>
        <td ><a href="count.jsp" />数据统计</td>
        <td ><a href="add.jsp" />添加知识</td>
        <td ><input type="search" name="search" /> <button>搜索</button></td>
    </tr>
</table>
</form>

<table align="center" border="1" cellspacing="0" cellpadding="0" >
    <caption align="center">知识列表</caption>
    <thead>
    <tr>
        <th>编号</th>
        <th>标题</th>
        <th>是否发布</th>
        <th>知识来源</th>
        <th>知识类别</th>
        <th>创建日期</th>
        <th>编辑</th>
        <th>删除</th>
        <th>详细</th>
    </tr>
    </thead>

    <% for(int i = 0 ; i < list.size();i++){%>
    <tr>
    <td> <%=i+1%></td>
    <td> <%= list.get(i).getTitle() %></td>
    <td> <%= list.get(i).getIsPublish() == 0 ? "发布" :"停止"%></td>
    <td> <%= list.get(i).getFromName()%></td>
    <td> <%= list.get(i).getTypeld() == 1 ? "Java编程基础":list.get(i).getTypeld()== 2 ? "Java面向对象":"MySQL"%></td>
    <td> <%= list.get(i).getCreateDate()%></td>
    <td><a href="edit.jsp?id=<%= list.get(i).getId()%>"/>编辑</td>
    <td><a href="delete?id=<%= list.get(i).getId()%>" />删除</td>
    <td><a href="detail.jsp?id=<%= list.get(i).getId()%>" />详细</td>
    </tr>
    <%}%>

</table>

</body>
</html>
