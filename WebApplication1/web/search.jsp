<%-- 
    Document   : search
    Created on : 8 Sep, 2022, 12:00:17 PM
    Author     : Lenovo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Search data</title>
    </head>
    <%
    String check=request.getParameter("Check");
    boolean ispostback;
    if(check==null)
    {
        ispostback=false;
    
    }
    else
    {
            ispostback=true;
            }
    String serialno="",task="",description="",status="",result="";
    System.out.println("ispostback");
            if(ispostback){
               
            }
            
                    
                    
                
            
    
    
    
    
    
    %>
    <body>
        <h1><border="2">Search data</h1>
    </body>
</html>
