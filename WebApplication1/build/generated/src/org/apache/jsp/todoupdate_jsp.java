package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.sql.PreparedStatement;

public final class todoupdate_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("    <center><title>update</title>\n");
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
            String Sno = "", Task = "", Description = "", Status = "", result = "";
            System.out.println(ispostback);

            if (ispostback) {
                try {
                    Sno = request.getParameter("Sno");
                    Task = request.getParameter("Task");
                    Description = request.getParameter("Description");
                    Status = request.getParameter("Status");
                    PreparedStatement ps = database.DbConnect.connect().prepareStatement("insert into todo List values(todosno.nextval,?,?,?,?)");
                    ps.setString(1, Sno);
                    ps.setString(2, Task);
                    ps.setString(3, Description);
                    ps.setString(4, Status);
                    int n = ps.executeUpdate();
                    result = "Inserted " + " records";
                } catch (Exception ex) {
                    System.out.println(ex);
                    result = ex.getMessage();
                }
            }

        
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("        <h1>todo List</h1>\n");
      out.write("        <form>\n");
      out.write("            <h3>");
      out.print(result);
      out.write("</h3>\n");
      out.write("            <input type=\"hidden\"  name=\"check\" value=\"1\">\n");
      out.write("            Sno<input value=\"");
      out.print(Sno);
      out.write("\" autocomplete=\"off\" name=\"Sno\" type=\"number\">\n");
      out.write("            Task<input name=\"Task\" autocomplete=\"off\" value=\"");
      out.print(Task);
      out.write("\" type=\"text\">\n");
      out.write("            Description<input name=\"Description\" autocomplete=\"off\" value=\"");
      out.print(Description);
      out.write("\" type=\"text\">\n");
      out.write("            Status<input name=\"Status\" autocomplete=\"off\" value=\"");
      out.print(Status);
      out.write("\" type=\"text\">\n");
      out.write("            <br>\n");
      out.write("            <br>\n");
      out.write("            <input type=\"submit\">\n");
      out.write("            </body>\n");
      out.write("        </form>\n");
      out.write("        </html>");
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
