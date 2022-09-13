package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import database.DbConnect;

public final class Editdistrict_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("        <title>Edit District</title>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        <center>\n");
      out.write("        <h1>Edit District </h1>\n");
      out.write("           ");

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




        
      out.write("\n");
      out.write("        <form>\n");
      out.write("            <input type=\"hidden\" name=\"check\"/>\n");
      out.write("            <input value=\"");
      out.print(Stateno);
      out.write("\" type=\"hidden\" name=\"Stateno\"/>\n");
      out.write("            <input  value=\"");
      out.print(Districtno);
      out.write("\"  type=\"hidden\" name=\"Districtno\"/>\n");
      out.write("            <input type=\"text\" name=\"Districtname\" value=\"");
      out.print(Districtname);
      out.write("\">\n");
      out.write("            <input type=\"submit\" value=\"Save\"/>\n");
      out.write("        </center>\n");
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
