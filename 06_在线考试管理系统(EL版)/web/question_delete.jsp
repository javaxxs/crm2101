<%--
  Created by IntelliJ IDEA.
  User: lizhe
  Date: 2021/12/6
  Time: 13:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    Integer result = (Integer)request.getAttribute("key");
    if (result == 1){

%>
<font style="color: red;font-size: 40px">试题删除成功</font>
<%}else {
%>
<font style="color: red;font-size: 40px">试题删除失败</font>
<%
    }
%>
