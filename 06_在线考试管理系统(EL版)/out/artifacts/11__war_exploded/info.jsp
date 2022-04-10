<%--
  Created by IntelliJ IDEA.
  User: lizhe
  Date: 2021/12/5
  Time: 21:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%
    String result = (String)request.getAttribute("info");
%>
              <center>
                  <font style="color: red;font-size: 40px">
                      <%=result%>
                  </font>
              </center>

