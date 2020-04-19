<%--
  Created by IntelliJ IDEA.
  User: Alex
  Date: 2019/11/23
  Time: 18:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>ADD</title>
</head>
<body>
<form action="add" method="post">
    <table align="center" border="0"  cellpadding="0" cellspacing="5">
        <caption>添加知识</caption>

        <tr>
            <td>知识标题：</td>
            <td> <input type="text" name="title" /></td>
        </tr>

        <tr>
            <td>是否发布：</td>
            <td><input type="radio" name="isPublish" value="0"/>发布&nbsp;
            <input type="radio" name="isPublish" value="1"/> 停止
            </td>
        </tr>

        <tr>
            <td>知识来源：</td>
            <td><input type="checkbox" name="fromName" value="网络">网络&nbsp;
            <input type="checkbox" name="fromName" value="杂志"/>杂志&nbsp;
            <input type="checkbox" name="fromName" value="投稿"/>投稿</td>
        </tr>

        <tr>
            <td>知识类别：
            </td>
            <td><select name="typeld">
                <option value="1">Java编程基础</option>
                <option value="2">java面向对象</option>
                <option value="3">MySQL</option>
            </select></td>
        </tr>

        <tr>
            <td>知识内容：</td>
            <td><textarea name="content"></textarea></td>
        </tr>

        <tr align="center">
            <td><button>添加知识</button></td>
        </tr>

    </table>
</form>

</body>
</html>
