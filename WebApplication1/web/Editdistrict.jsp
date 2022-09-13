<%-- 
    Document   : updatedistrict
    Created on : 13 Sep, 2022, 1:20:31 AM
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
        <title>Edit District</title>
    </head>
    <body>
        <center>
        <h1>Edit District </h1>
           <%
              String check = request.getParameter("check");
            boolean ispostback;
            if (check == null) {
                ispostback = false;
            } else {
                ispostback = true;
            }
            
            String Stateno = request.getParameter("Stateno");
             String Districtno = request.getParameter("Districtno");
         
          String Districtname="";
            if(!ispostback)
            {
                  PreparedStatement ps = DbConnect.connect().prepareStatement("select * from   District_State where Districtno=? and Stateno=? ");
            ps.setString(2, Stateno);
             ps.setString(1, Districtno);
            ResultSet rs = ps.executeQuery();
            
            if(rs.next())
            {
                Districtname="" + rs.getObject("Districtname");
            }
            }
            else
            
            {
                Districtname=request.getParameter("Districtname");
                  Stateno = request.getParameter("Stateno");
              Districtno = request.getParameter("Districtno");

              PreparedStatement ps= DbConnect.connect().prepareStatement("update    District_State  set Districtname=? where Districtno=? and Stateno=?");
                ps.setString(1, Districtname );
                ps.setString(2, Districtno );
                ps.setString(3, Stateno );
                ps.executeUpdate();
            }




        %>
        <form>
            <input type="hidden" name="check"/>
            <input value="<%=Stateno%>" type="hidden" name="Stateno"/>
            <input  value="<%=Districtno%>"  type="hidden" name="Districtno"/>
            <input type="text" name="Districtname" value="<%=Districtname%>">
            <input type="submit" value="Save"/>
        </center>
    </body>
</html>
