<%@page import="java.sql.ResultSet"%>
<%@page import="database.DbConnect"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Search and Update</title>
    </head>
    <body>
        <%
            String check = request.getParameter("check");
            boolean ispostback;
            if (check == null) {
                ispostback = false;
            } else {
                ispostback = true;
            }
//out.println(ispostback);
            String option = "", sno = "", status = "", description = "", task = "",result="";
            if (ispostback) {
                option = request.getParameter("option");
                // out.println(option);
                if (option.equals("Search")) {
                    out.println("Search Code");
                    sno = request.getParameter("sno");
                    PreparedStatement ps = DbConnect.connect().prepareStatement("select * from todo where sno=?");
                    ps.setString(1, sno);
                    ResultSet rs = ps.executeQuery();
                    if (rs.next()) {
                        task = "" + rs.getObject("task");
                        description = "" + rs.getObject("description");
                        status = "" + rs.getObject("status");
                    }
                }
                if (option.equals("Update")) {
                    out.println("Update Code");
                    
                    sno = request.getParameter("sno");
                    PreparedStatement ps = DbConnect.connect().prepareStatement("Update from todo where sno=?");
                    ps.setString(1, sno);
                    int n=ps.executeUpdate();
                     result="Update " + n + " records";
                   
            }
            }
        %>
    <center>
        <%=result%>
        <h1> Todo List Search and Update </h1>

        <form method="post">
            <input type="hidden" name="check"/>
            <br>
            <br>
            sno<input value="<%=sno%>" name="sno" type="number">
            <br>
            task<input value="<%=task%>"  name="task" type="text">
            <br>
            description<input value="<%=description%>"  name="description" type="text">
            <br>
            status<input value="<%=status%>"  name="status" type="text">
            <br>
            <br>

            <input type="submit" name="option" value="Search"/>

            <input type="submit" name="option" value="Delete"/>
        </form>
    </center>
</body>
</html>