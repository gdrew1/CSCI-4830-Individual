import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/CustomerInsert")
public class CustomerInsert extends HttpServlet implements Info {
   private static final long serialVersionUID = 1L;

   public CustomerInsert() {
      super();
   }

   protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      String first_name = request.getParameter("first_name").trim();
      String middle_name = request.getParameter("middle_name").trim();
      String last_name = request.getParameter("last_name").trim();
      String phone = request.getParameter("phone").trim();
      String main_branch = request.getParameter("main_branch").trim();
    		  
      UtilDBDrew.createCustomer(first_name, middle_name, last_name, phone, main_branch);

      response.setContentType("text/html");
      PrintWriter out = response.getWriter();
      String title = "Database Result";
      String docType = "<!doctype html public \"-//w3c//dtd html 4.0 transitional//en\">\n"; //
      out.println(docType + //
            "<html>\n" + //
            "<head><title>" + title + "</title></head>\n" + //
            "<body bgcolor=\"#f0f0f0\">\n" + //
            "<h1 align=\"center\">" + title + "</h1>\n");
      out.println("<ul>");
      out.println("<li> First Name: " + first_name);
      out.println("<li> Middle Name: " + middle_name);
      out.println("<li> Last Name: " + last_name);
      out.println("<li> Phone: " + phone);
      out.println("<li> Main Branch: " + main_branch);
      out.println("</ul>");
      out.println("<a href=/" + projectName + "/" + customerSearchWebName + ">Search Data</a> <br>");
      out.println("</body></html>");
   }

   protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      doGet(request, response);
   }
}
