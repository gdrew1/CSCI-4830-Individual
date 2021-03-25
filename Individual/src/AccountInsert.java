import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/AccountInsert")
public class AccountInsert extends HttpServlet implements Info {
   private static final long serialVersionUID = 1L;

   public AccountInsert() {
      super();
   }

   protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      int customer_id = Integer.parseInt(request.getParameter("customer_id").trim());
      String account_type = request.getParameter("account_type").trim();
      float balance = Float.parseFloat(request.getParameter("balance").trim());
    		  
      UtilDBDrew.createAccount(customer_id, account_type, balance);

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
      out.println("<li> Customer ID: " + customer_id);
      out.println("<li> Account Type: " + account_type);
      out.println("<li> Balance: " + balance);
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

   protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      doGet(request, response);
   }
}
