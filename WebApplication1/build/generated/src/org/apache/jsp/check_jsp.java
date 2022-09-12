package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.sql.PreparedStatement;

public final class check_jsp extends org.apache.jasper.runtime.HttpJspBase
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

      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html>\r\n");
      out.write("    <head>\r\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\r\n");
      out.write("    <center><title>Insert</title>\r\n");
      out.write("    </head>\r\n");
      out.write("    <body>\r\n");
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
                    PreparedStatement ps = database.DbConnect.connect().prepareStatement("insert into TrainEnquiry values(?,?,?,?)");
                    ps.setString(1, Sno);
                    ps.setString(2, Task);
                    ps.setString(3, Description);
                    ps.setString(4, Status);
                    int n = ps.executeUpdate();
                    result = "Inserted " + n + " records";
                } catch (Exception ex) {
                    System.out.println(ex);
                    result = ex.getMessage();
                }
            }

        
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("        <h1>Train Enqury</h1>\r\n");
      out.write("        <form>\r\n");
      out.write("            <h3>");
      out.print(result);
      out.write("</h3>\r\n");
      out.write("            <input type=\"hidden\" name=\"check\" value=\"1\">\r\n");
      out.write("            Sno<input value=\"");
      out.print(Sno);
      out.write("\" name=\"Sno\" type=\"number\">\r\n");
      out.write("            Task<input name=\"Task\" value=\"");
      out.print(Task);
      out.write("\" type=\"text\">\r\n");
      out.write("            Description<input name=\"Description\" value=\"");
      out.print(Description);
      out.write("\" type=\"text\">\r\n");
      out.write("            Status<input name=\"Status\" value=\"");
      out.print(Status);
      out.write("\" type=\"text\">\r\n");
      out.write("            <br>\r\n");
      out.write("            <br>\r\n");
      out.write("            <input type=\"submit\">\r\n");
      out.write("            </body>\r\n");
      out.write("        </form>\r\n");
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
