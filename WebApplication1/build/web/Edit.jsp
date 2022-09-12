<%-- 
    Document   : update
    Created on : 12 Sep, 2022, 12:22:03 PM
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
        <title>Update</title>
    </head>
    <body>
        <h1>Update</h1>
        <%
             String courseno=request.getParameter("courseno");
             //out.println(courseno);
        PreparedStatement ps=DbConnect.connect().prepareStatement("select * from course_students where courseno=? order by studentname");
        ps.setString(1, courseno);
        ResultSet rs=ps.executeQuery();
        %>
        <table border="1">
            <tr><th>Roll No</th><th>Student Name</th><th>Edit</th></tr>
            
        
        
        <%
        while(rs.next())
        {
           String   rollno="" + rs.getObject("rollno");
            String studentname="" + rs.getObject("studentname");
            %>
            <tr><td><%=rollno%></td><td><%=studentname%></td><td><a target="Edit" href="Edit.jsp?rollno=<%=rollno%>&courseno=<%=courseno%>">Edit</a></td></tr>
            
            <%
        }
        %>
        </table>
    </body>
</html>
