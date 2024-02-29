<%@ page import="com.jspcrudapp.service.IUserService" %>
<%@ page import="com.jspcrudapp.service.UserService" %>
<jsp:useBean id="u" class="com.jspcrudapp.model.UserAccount"></jsp:useBean>
<jsp:setProperty property="*" name="u"/>

<%
    IUserService userService = new UserService();

    int i=userService.update(u);
response.sendRedirect("viewusers.jsp");
%>
