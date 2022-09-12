package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.sql.ResultSet;
import database.DbConnect;
import java.sql.PreparedStatement;

public final class todosearch_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <!--\n");
      out.write("    variable myvariablename\n");
      out.write("    CONSTANT MYCONSTANTNAME\n");
      out.write("    class    MyClassName\n");
      out.write("    method  myMethodName\n");
      out.write("    package mypackagename\n");
      out.write("    \n");
      out.write("    \n");
      out.write("    \n");
      out.write("    -->\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("    <center><title>Search</title>\n");
      out.write("        <style>\n");
      out.write("            img{\n");
      out.write("                width: 50px;\n");
      out.write("            }\n");
      out.write("            \n");
      out.write("        </style>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        ");

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

        
      out.write("\n");
      out.write("        <h1>todolist</h1>\n");
      out.write("        <form>\n");
      out.write("            <img src=\"");
      out.print(imgsrc);
      out.write("\">\n");
      out.write("            <h3>");
      out.print(result);
      out.write("</h3>\n");
      out.write("            <h3>");
      out.print(task);
      out.write("</h3>\n");
      out.write("            <h3>");
      out.print(description);
      out.write("</h3>\n");
      out.write("            <form>\n");
      out.write("                <input type=\"hidden\" name=\"check\" value=\"2\">\n");
      out.write("                SERIALNO.<input value=\"");
      out.print(serialno);
      out.write("\" name=\"SERIALNO\" type=\"number\">\n");
      out.write("                <br>\n");
      out.write("                <br>\n");
      out.write("                <input type=\"submit\" value=\"Search\"/>\n");
      out.write("            </form>\n");
      out.write("    </body>\n");
      out.write("</form>\n");
      out.write("</html>\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
