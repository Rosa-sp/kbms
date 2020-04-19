<%@ page import="com.itlaobing.kms.models.TblKnowledgeModel" %>
<%@ page import="com.itlaobing.kms.services.TblKnowledgeService" %><%--
  Created by IntelliJ IDEA.
  User: Alex
  Date: 2019/11/24
  Time: 15:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>edit</title>
</head>
<body>
<%
    session.setAttribute("id",request.getParameter("id"));
//    System.out.println(session.getAttribute("id"));
    TblKnowledgeService service = new TblKnowledgeService();
    TblKnowledgeModel model = new TblKnowledgeModel();
    model = service.findById(Integer.parseInt(request.getParameter("id")));
%>
<form action="edit" method="post">
    <table align="center" border="0"  cellpadding="0" cellspacing="1">
        <caption>修改知识</caption>

        <tr>
            <td>知识标题：</td>
            <td> <input type="text" name="title" value="<%=model.getTitle()%>"/></td>
        </tr>

        <tr>
            <td>是否发布：</td>
            <% if(model.getIsPublish() == 0){%>
            <td><input type="radio" name="isPublish" value="0" checked="checked"/>发布&nbsp;
                <input type="radio" name="isPublish" value="1" /> 停止</td>
                <%}else{%>
            <td><input type="radio" name="isPublish" value="0" />发布&nbsp;
                <input type="radio" name="isPublish" value="1" checked="checked"/> 停止</td>
            <%}%>
        </tr>

        <tr>
            <td>知识来源：</td>
            <td>
            <% String [] str = model.getFromName().split("、"); %>
            <%if(service.flag(str,"网络")){%>
            <input type="checkbox" name="fromName" value="网络" checked>网络&nbsp;
            <%}else {%>
            <input type="checkbox" name="fromName" value="网络">网络&nbsp;
            <%}%>

            <%if(service.flag(str,"杂志")){%>
                <input type="checkbox" name="fromName" value="杂志" checked/>杂志&nbsp;
            <%}else{%>
                <input type="checkbox" name="fromName" value="杂志" />杂志&nbsp;
            <%}%>

            <%if(service.flag(str,"投稿")){%>
                <input type="checkbox" name="fromName" value="投稿" checked/>投稿
                <%}else{%>
                <input type="checkbox" name="fromName" value="投稿" />投稿
                <%}%>
            </td>
        </tr>

        <tr>
            <td>知识类别：
            </td>
                <% if(model.getTypeld() == 1){%>
            <td><select name="typeld">
                <option value="1" selected>Java编程基础</option>
                <option value="2" >java面向对象</option>
                <option value="3" >MySQL</option>
            </select></td>
                <% }else if(model.getTypeld() == 2){%>
            <td><select name="typeld">
                <option value="1">Java编程基础</option>
                <option value="2" selected>java面向对象</option>
                <option value="3" >MySQL</option>
            </select></td>
                <%}else{%>
            <td><select name="typeld">
                <option value="1">Java编程基础</option>
                <option value="2" >java面向对象</option>
                <option value="3" selected>MySQL</option>
            </select></td>
            <%}%>
        </tr>

        <tr>
            <td>知识内容：</td>
            <td><textarea name="content"><%=model.getContent()%></textarea></td>
        </tr>

        <tr>
            <td><button>修改知识</button></td>
        </tr>

    </table>
</form>

</body>
</html>
