import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/CustomerSearch")
public class CustomerSearch extends HttpServlet implements Info {
   private static final long serialVersionUID = 1L;

   public CustomerSearch() {
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

      List<Customer> listCustomers = null;
      if (keyword != null && !keyword.isEmpty()) {
         listCustomers = UtilDBDrew.listCustomers(keyword);
      } else {
         listCustomers = UtilDBDrew.listCustomers();
      }
      display(listCustomers, out);
      out.println("</ul>");
      out.println("<a href=\"/Individual/AccountInsert.html\">Create New Account</a> <br>\n" + 
      		"<a href=\"/Individual/AccountSearch.html\">Search Accounts By Account Number</a> <br>\n" + 
      		"<a href=\"/Individual/AccountSearchByID.html\">Search Accounts By Customer ID</a> <br>\n" + 
      		"<a href=\"/Individual/CustomerInsert.html\">Create New Customer</a> <br>\n" + 
      		"<a href=\"/Individual/CustomerSearch.html\">Search Customers</a> <br>\n" + 
      		"<a href=\"/Individual/Deposit.html\">Deposit to Account</a> <br>\n" + 
      		"<a href=\"/Individual/Transfer.html\">Transfer between Accounts</a> <br>\n" + 
      		"<a href=\"/Individual/Withdraw.html\">Withdraw from Account</a> <br>");
      out.println("</body></html>");
   }

   void display(List<Customer> listCustomers, PrintWriter out) {
      for (Customer customer : listCustomers) {
         System.out.println("[DBG] " + customer.getId() + ", " //
               + customer.getFirst_name() + ", " //
               + customer.getMiddle_name() + ", " 
               + customer.getLast_name() + ", " //
               + customer.getPhone_number() + ", "
               + customer.getMain_branch());

         out.println("<li>" + customer.getId() + ", " //
                 + customer.getFirst_name() + ", " //
                 + customer.getMiddle_name() + ", " 
                 + customer.getLast_name() + ", " //
                 + customer.getPhone_number() + ", "
                 + customer.getMain_branch()+ "</li>");
      }
   }

   protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      doGet(request, response);
   }
}
