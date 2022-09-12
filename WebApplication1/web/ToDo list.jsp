<%-- 
    Document   : ToDo list
    Created on : 7 Sep, 2022, 1:37:26 PM
    Author     : Lenovo
--%>

<%@page import="java.sql.ResultSetMetaData"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="database.DbConnect"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>To Do List</title>
    </head>
    <body>
        <%
            PreparedStatement statement=DbConnect.connect().prepareStatement("select*form todo order by serial desc");
            ResultSet rs=statement.executeQuery();
            ResultSetMetaData rsmd=rs.getMetaData();
            int n=rsmd.getColumnCount();
        
        %>
        <table border="1">
            <tr>
                <%
              for(int i=1;i<=n;i++)
                    {
                        %>
                        <th><%=rsmd.getColumnLabel(i)%></th>
                        <%
                            %>
            </tr>
            <%
                while(rs.next())
                {
                    
                %>
                <tr>
                    
                    <%
                            
                   

                    
                        %>
                        <th><%=rs.getObject(i)%></th>
                        <%
                            }
                          %>
                        </th>
                        <%
                            }
                         %>
        
    


                    
           
                    }
        </table>>
    </body>
</html>
