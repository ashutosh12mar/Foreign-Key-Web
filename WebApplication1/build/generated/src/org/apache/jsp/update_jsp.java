package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import database.DbConnect;

public final class update_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>Update</title>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        <h1>Update</h1>\n");
      out.write("        ");

             String courseno=request.getParameter("courseno");
             //out.println(courseno);
        PreparedStatement ps=DbConnect.connect().prepareStatement("select * from course_students where courseno=? order by studentname");
        ps.setString(1, courseno);
        ResultSet rs=ps.executeQuery();
        
      out.write("\n");
      out.write("        <table border=\"1\">\n");
      out.write("            <tr><th>Roll No</th><th>Student Name</th><th>Update</th></tr>\n");
      out.write("            \n");
      out.write("        \n");
      out.write("        \n");
      out.write("        ");

        while(rs.next())
        {
           String   rollno="" + rs.getObject("rollno");
            String studentname="" + rs.getObject("studentname");
            
      out.write("\n");
      out.write("            <tr><td>");
      out.print(rollno);
      out.write("</td><td>");
      out.print(studentname);
      out.write("</td><td><a target=\"Update\" href=\"update.jsp?rollno=");
      out.print(rollno);
      out.write("&courseno=");
      out.print(courseno);
      out.write("\">Update</a></td></tr>\n");
      out.write("            \n");
      out.write("            ");

        }
        
      out.write("\n");
      out.write("        </table>\n");
      out.write("    </body>\n");
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
