<%-- 
    Document   : showstudents
    Created on : 12 Sep, 2022, 12:02:49 PM
    Author     : Lenovo
--%>

<%@page import="java.sql.ResultSet"%>
<%@page import="database.DbConnect"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Show Students</title>
    </head>
    <body>
    <center>
        <h1>Show Students</h1>

        <%
            String courseno = request.getParameter("courseno");
            //out.println(courseno);
            PreparedStatement ps = DbConnect.connect().prepareStatement("select * from course_students where courseno=? order by studentname");
            ps.setString(1, courseno);
            ResultSet rs = ps.executeQuery();
        %>
        <table border="1">
            <tr><th>Roll No</th><th>Student Name</th><th>Edit</th></tr>



            <%
                while (rs.next()) {
                    String rollno = "" + rs.getObject("rollno");
                    String studentname = "" + rs.getObject("studentname");
            %>
            <tr><td><%=rollno%></td><td><%=studentname%></td><td><a target="edit" href="editstudent.jsp?rollno=<%=rollno%>&courseno=<%=courseno%>">Edit</a></td></tr>

            <%
                }
            %>
        </table>










    </center>
</body>
</html>
