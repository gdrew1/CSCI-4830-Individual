

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Withdraw
 */
@WebServlet("/Withdraw")
public class Withdraw extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Withdraw() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int account_id = Integer.parseInt(request.getParameter("account_id").trim());
        float amount = Float.parseFloat(request.getParameter("amount").trim());
      		  
        float balance = UtilDBDrew.WithdrawAccount(account_id, amount);
        
        if(balance >= 0) {
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
        out.println("<li> New Balance from transfered account: " + balance);
        out.println("</ul>");
        out.println("<a href=\"/Individual/AccountInsert.html\">Create New Account</a> <br>\r\n" + 
        		"<a href=\"/Individual/AccountSearch.html\">Search Accounts By Account Number</a> <br>\r\n" + 
        		"<a href=\"/Individual/AccountSearchByID.html\">Search Accounts By Customer ID</a> <br>\r\n" + 
        		"<a href=\"/Individual/CustomerInsert.html\">Create New Customer</a> <br>\r\n" + 
        		"<a href=\"/Individual/CustomerSearch.html\">Search Customers</a> <br>\r\n" + 
        		"<a href=\"/Individual/Deposit.html\">Deposit to Account</a> <br>\r\n" + 
        		"<a href=\"/Individual/Transfer.html\">Transfer between Accounts</a> <br>\r\n" + 
        		"<a href=\"/Individual/Withdraw.html\">Withdraw from Account</a> <br>");
        out.println("</body></html>");
        }
        else if (balance == -2)
        {
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
            out.println("<li> One of the specified accounts doesn't exist");
            out.println("</ul>");
            out.println("<a href=\"/Individual/AccountInsert.html\">Create New Account</a> <br>\r\n" + 
            		"<a href=\"/Individual/AccountSearch.html\">Search Accounts By Account Number</a> <br>\r\n" + 
            		"<a href=\"/Individual/AccountSearchByID.html\">Search Accounts By Customer ID</a> <br>\r\n" + 
            		"<a href=\"/Individual/CustomerInsert.html\">Create New Customer</a> <br>\r\n" + 
            		"<a href=\"/Individual/CustomerSearch.html\">Search Customers</a> <br>\r\n" + 
            		"<a href=\"/Individual/Deposit.html\">Deposit to Account</a> <br>\r\n" + 
            		"<a href=\"/Individual/Transfer.html\">Transfer between Accounts</a> <br>\r\n" + 
            		"<a href=\"/Individual/Withdraw.html\">Withdraw from Account</a> <br>");
            out.println("</body></html>");
        }
        else
        {
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
            out.println("<li> There is not enough money to complete this withdrawal");
            out.println("</ul>");
            out.println("<a href=\"/Individual/AccountInsert.html\">Create New Account</a> <br>\r\n" + 
            		"<a href=\"/Individual/AccountSearch.html\">Search Accounts By Account Number</a> <br>\r\n" + 
            		"<a href=\"/Individual/AccountSearchByID.html\">Search Accounts By Customer ID</a> <br>\r\n" + 
            		"<a href=\"/Individual/CustomerInsert.html\">Create New Customer</a> <br>\r\n" + 
            		"<a href=\"/Individual/CustomerSearch.html\">Search Customers</a> <br>\r\n" + 
            		"<a href=\"/Individual/Deposit.html\">Deposit to Account</a> <br>\r\n" + 
            		"<a href=\"/Individual/Transfer.html\">Transfer between Accounts</a> <br>\r\n" + 
            		"<a href=\"/Individual/Withdraw.html\">Withdraw from Account</a> <br>");
            out.println("</body></html>");
        }
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
