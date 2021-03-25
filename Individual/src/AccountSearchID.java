import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/AccountSearchID")
public class AccountSearchID extends HttpServlet implements Info {
   private static final long serialVersionUID = 1L;

   public AccountSearchID() {
      super();
   }

   protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      String keyword = request.getParameter("keyword").trim();

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

      List<Accounts> listAccounts = null;
      if (keyword != null && !keyword.isEmpty()) {
         listAccounts = UtilDBDrew.listAccountsID(keyword);
      } else {
         listAccounts = UtilDBDrew.listAccounts();
      }
      display(listAccounts, out);
      out.println("</ul>");
      out.println("<a href=/" + projectName + "/" + accountSearchWebName + ">Search Data</a> <br>");
      out.println("</body></html>");
   }

   void display(List<Accounts> listAccounts, PrintWriter out) {
      for (Accounts Account : listAccounts) {
         System.out.println("[DBG] " + Account.getAccount_number() + ", " //
               + Account.getCustomer_id() + ", " //
               + Account.getAccount_type() + ", "
               + Account.getBalance());

         out.println("<li>" + Account.getAccount_number() + ", " //
                 + Account.getCustomer_id() + ", " //
                 + Account.getAccount_type() + ", "
                 + Account.getBalance()+ "</li>");
      }
   }

   protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      doGet(request, response);
   }
}
