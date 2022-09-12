<%@page import="java.sql.ResultSet"%>
<%@page import="database.DbConnect"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <!--
    variable myvariablename
    CONSTANT MYCONSTANTNAME
    class    MyClassName
    method  myMethodName
    package mypackagename
    
    
    
    -->
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <center><title>Search</title>
        <style>
            img{
                width: 50px;
            }
            
        </style>
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
            String serialno = "", task = "", description = "", status = "", result = "", imgsrc = "";
            System.out.println(ispostback);
            if (ispostback) {
                try {

                    serialno = request.getParameter("SERIALNO");
                    PreparedStatement ps = DbConnect.connect().prepareStatement("select * from todo where SERIALNO=?");
                    ps.setString(1, serialno);
                    ResultSet rs = ps.executeQuery();
                    if (!rs.next()) {
                        result = "Sno " + serialno + " not found";
                        imgsrc = "images/wrong.jpg.png";
                    } else {
                        result = "Record Found ";
                        imgsrc = "images/right.jpg";

                        task = "" + rs.getObject("task");
                        description = "" + rs.getObject("description");
                    }

                } catch (Exception ex) {
                    System.out.println(ex);
                    result = ex.getMessage();
                }
            }

        %>
        <h1>todolist</h1>
        <form>
            <img src="<%=imgsrc%>">
            <h3><%=result%></h3>
            <h3><%=task%></h3>
            <h3><%=description%></h3>
            <form>
                <input type="hidden" name="check" value="2">
                SERIALNO.<input value="<%=serialno%>" name="SERIALNO" type="number">
                <br>
                <br>
                <input type="submit" value="Search"/>
            </form>
    </body>
</form>
</html>
