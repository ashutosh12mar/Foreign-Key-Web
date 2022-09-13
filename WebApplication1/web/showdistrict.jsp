<%-- 
    Document   : showdistrict
    Created on : 13 Sep, 2022, 12:29:38 AM
    Author     : Lenovo
--%>

<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="database.DbConnect"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>show District</title>
    </head>
    <body>
        <center>
        <h1>show District</h1>
     <%
            String Stateno = request.getParameter("Stateno");
         
            PreparedStatement ps = DbConnect.connect().prepareStatement("select * from District_State where Stateno=? order by Districtname");
            ps.setString(1, Stateno);
            ResultSet rs = ps.executeQuery();
        %>
        <table border="1">
            <tr><th>District No</th><th>District Name</th><th>Edit</th></tr>



            <%
                while (rs.next()) {
                    String Districtno = "" + rs.getObject("Districtno");
                    String Districtname = "" + rs.getObject("Districtname");
            %>
            <tr><td><%=Districtno%></td><td><%=Districtname%></td><td><a target="edit" href="editDistrict.jsp?districtno=<%=Districtno%>&Stateno=<%=Stateno%>">Edit</a></td></tr>

            <%
                }
            %>
            </center>
    </body>
</html>
