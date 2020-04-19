<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="com.itlaobing.kms.services.TblKnowledgeService" %>
<%@ page import="java.util.Map" %>
<%@ page import="java.util.HashMap" %><%--
  Created by IntelliJ IDEA.
  User: Alex
  Date: 2019/11/25
  Time: 17:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>count</title>
</head>
<body>
<%
    Map map = new HashMap();
    TblKnowledgeService service = new TblKnowledgeService();
    map = service.count();
    System.out.println(map);
    request.setAttribute("map",map);

%>
<table align="center" border="1" cellspacing="0" cellpadding="1">
    <caption align="center">统计数据</caption>
    <thead>
    <tr>
        <th>类别名称</th>
        <th>数量</th>
    </tr>
    </thead>

        <% for(Object obj : map.keySet()){%>
    <tr>
        <td> <%= (int)obj == 1 ? "Java编程基础":(int)obj == 2 ? "Java面向对象":"MySQL"%></td>
        <td> <%= (int)map.get(obj)%></td>
    </tr>
        <%}%>
</table>

</body>
</html>
