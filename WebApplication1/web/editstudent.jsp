<%-- 
    Document   : editstudent
    Created on : 12 Sep, 2022, 12:36:19 PM
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
        <title>Edit Student</title>
    </head>
    <body>
        <h1>Edit Student </h1>
        <%
              String check = request.getParameter("check");
            boolean ispostback;
            if (check == null) {
                ispostback = false;
            } else {
                ispostback = true;
            }
            
            String courseno = request.getParameter("courseno");
             String rollno = request.getParameter("rollno");
            //out.println(courseno);
          String studentname="";
            if(!ispostback)
            {
                  PreparedStatement ps = DbConnect.connect().prepareStatement("select * from   course_students where rollno=? and courseno=? ");
            ps.setString(2, courseno);
             ps.setString(1, rollno);
            ResultSet rs = ps.executeQuery();
            
            if(rs.next())
            {
                studentname="" + rs.getObject("studentname");
            }
            }
            else
            
            {
                studentname=request.getParameter("studentname");
                  courseno = request.getParameter("courseno");
              rollno = request.getParameter("rollno");

              PreparedStatement ps= DbConnect.connect().prepareStatement("update    course_students set studentname=? where rollno=? and courseno=?");
                ps.setString(1, studentname );
                ps.setString(2, rollno );
                ps.setString(3, courseno );
                ps.executeUpdate();
            }




        %>
        <form>
            <input type="hidden" name="check"/>
            <input value="<%=courseno%>" type="hidden" name="courseno"/>
            <input  value="<%=rollno%>"  type="hidden" name="rollno"/>
            <input type="text" name="studentname" value="<%=studentname%>">
            <input type="submit" value="Save"/>
            
        </form>
    </body>
</html>
