import java.util.List;
import java.util.ArrayList;
import java.util.Iterator;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 * @since JavaSE-1.8
 */
public class UtilDBDrew {
   static SessionFactory sessionFactory = null;

   public static SessionFactory getSessionFactory() {
      if (sessionFactory != null) {
         return sessionFactory;
      }
      Configuration configuration = new Configuration().configure();
      StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties());
      sessionFactory = configuration.buildSessionFactory(builder.build());
      return sessionFactory;
   }

   public static List<Customer> listCustomers() {
      List<Customer> resultList = new ArrayList<Customer>();

      Session session = getSessionFactory().openSession();
      Transaction tx = null;  // each process needs transaction and commit the changes in DB.

      try {
         tx = session.beginTransaction();
         List<?> employees = session.createQuery("FROM Customer").list();
         for (Iterator<?> iterator = employees.iterator(); iterator.hasNext();) {
            Customer employee = (Customer) iterator.next();
            resultList.add(employee);
         }
         tx.commit();
      } catch (HibernateException e) {
         if (tx != null)
            tx.rollback();
         e.printStackTrace();
      } finally {
         session.close();
      }
      return resultList;
   }

   public static List<Customer> listCustomers(String keyword) {
      List<Customer> resultList = new ArrayList<Customer>();

      Session session = getSessionFactory().openSession();
      Transaction tx = null;

      try {
         tx = session.beginTransaction();
         System.out.println((Customer)session.get(Customer.class, 1)); // use "get" to fetch data
        // Query q = session.createQuery("FROM Employee");
         List<?> employees = session.createQuery("FROM Customer").list();
         for (Iterator<?> iterator = employees.iterator(); iterator.hasNext();) {
            Customer employee = (Customer) iterator.next();
            if (employee.getLast_name().startsWith(keyword)) {
               resultList.add(employee);
            }
         }
         tx.commit();
      } catch (HibernateException e) {
         if (tx != null)
            tx.rollback();
         e.printStackTrace();
      } finally {
         session.close();
      }
      return resultList;
   }
   
   public static List<Accounts> listAccounts() {
	      List<Accounts> resultList = new ArrayList<Accounts>();

	      Session session = getSessionFactory().openSession();
	      Transaction tx = null;  // each process needs transaction and commit the changes in DB.

	      try {
	         tx = session.beginTransaction();
	         List<?> employees = session.createQuery("FROM Accounts").list();
	         for (Iterator<?> iterator = employees.iterator(); iterator.hasNext();) {
	            Accounts employee = (Accounts) iterator.next();
	            resultList.add(employee);
	         }
	         tx.commit();
	      } catch (HibernateException e) {
	         if (tx != null)
	            tx.rollback();
	         e.printStackTrace();
	      } finally {
	         session.close();
	      }
	      return resultList;
	   }

	   public static List<Accounts> listAccounts(String keyword) {
	      List<Accounts> resultList = new ArrayList<Accounts>();

	      Session session = getSessionFactory().openSession();
	      Transaction tx = null;

	      try {
	         tx = session.beginTransaction();
	         System.out.println((Accounts)session.get(Accounts.class, 1)); // use "get" to fetch data
	        // Query q = session.createQuery("FROM Employee");
	         List<?> employees = session.createQuery("FROM Accounts").list();
	         for (Iterator<?> iterator = employees.iterator(); iterator.hasNext();) {
	            Accounts employee = (Accounts) iterator.next();
	            if (String.valueOf((employee.getAccount_number())).equals(keyword)) {
	               resultList.add(employee);
	            }
	         }
	         tx.commit();
	      } catch (HibernateException e) {
	         if (tx != null)
	            tx.rollback();
	         e.printStackTrace();
	      } finally {
	         session.close();
	      }
	      return resultList;
	   }
	   
	   public static List<Accounts> listAccountsID(String keyword) {
		      List<Accounts> resultList = new ArrayList<Accounts>();

		      Session session = getSessionFactory().openSession();
		      Transaction tx = null;

		      try {
		         tx = session.beginTransaction();
		         System.out.println((Accounts)session.get(Accounts.class, 1)); // use "get" to fetch data
		        // Query q = session.createQuery("FROM Employee");
		         List<?> employees = session.createQuery("FROM Accounts").list();
		         for (Iterator<?> iterator = employees.iterator(); iterator.hasNext();) {
		            Accounts employee = (Accounts) iterator.next();
		            if (String.valueOf((employee.getCustomer_id())).equals(keyword)) {
		               resultList.add(employee);
		            }
		         }
		         tx.commit();
		      } catch (HibernateException e) {
		         if (tx != null)
		            tx.rollback();
		         e.printStackTrace();
		      } finally {
		         session.close();
		      }
		      return resultList;
		   }
	   
	   public static Float DepositAccount(int id, float amount) {
		   List<Accounts> resultList = new ArrayList<Accounts>();

		      Session session = getSessionFactory().openSession();
		      Transaction tx = null;
		      float balance = -2;

		      try {
		         tx = session.beginTransaction();
		         System.out.println((Accounts)session.get(Accounts.class, 1)); // use "get" to fetch data
		        // Query q = session.createQuery("FROM Employee");
		         
		         List<Accounts> listAccount = session.createQuery("FROM Accounts WHERE account_number = " + id).list();
		         if(listAccount.size() > 0) {
			         Accounts account = listAccount.get(0);
			         account.deposit(amount);
			         balance = account.getBalance();
			         session.createQuery("UPDATE Accounts SET balance = " + balance + " where account_number = " + id);
		         }
		         else
		         {
		        	 balance = -2;
		         }
		         tx.commit();
		      } catch (HibernateException e) {
		         if (tx != null)
		            tx.rollback();
		         e.printStackTrace();
		      } finally {
		         session.close();
		      }
		      return balance;
	   }
	   
	   public static Float TransferAccount(int idTo, int idFrom, float amount) {
		   List<Accounts> resultList = new ArrayList<Accounts>();

		      Session session = getSessionFactory().openSession();
		      Transaction tx = null;
		      float balance = -2;

		      try {
		         tx = session.beginTransaction();
		         System.out.println((Accounts)session.get(Accounts.class, 1)); // use "get" to fetch data
		        // Query q = session.createQuery("FROM Employee");
		         List<Accounts> listAccountTo = session.createQuery("FROM Accounts where account_number = " + idTo).list();
		         List<Accounts> listAccountFrom = session.createQuery("FROM Accounts where account_number = " + idFrom).list();
		         if(listAccountTo.size() > 0 && listAccountFrom.size() > 0) {
			         Accounts accountTo = listAccountTo.get(0);
			         Accounts accountFrom = listAccountFrom.get(0);
			         balance = accountFrom.transfer(accountTo, amount);
			         if(balance >= 0)
			         {
			        	 session.createQuery("UPDATE Accounts SET balance = " + balance + " where account_number = " + idFrom);
			        	 session.createQuery("UPDATE Accounts SET balance = " + accountTo.getBalance() + " where account_number = " + idTo);
			         }
			         
			        	 
		         }
		         else
		         {
		        	 balance = -2;
		         }
		         tx.commit();
		      } catch (HibernateException e) {
		         if (tx != null)
		            tx.rollback();
		         e.printStackTrace();
		      } finally {
		         session.close();
		      }
		      return balance;
	   }
	   
	   public static Float WithdrawAccount(int id, float amount) {
		   List<Accounts> resultList = new ArrayList<Accounts>();

		      Session session = getSessionFactory().openSession();
		      Transaction tx = null;
		      float balance = -2;

		      try {
		         tx = session.beginTransaction();
		         System.out.println((Accounts)session.get(Accounts.class, 1)); // use "get" to fetch data
		        // Query q = session.createQuery("FROM Employee");
		         List<Accounts> listAccount = session.createQuery("FROM Accounts where account_number = " + id).list();
		         if(listAccount.size() > 0) {
			         Accounts account = listAccount.get(0);
			         balance = account.withdraw(amount);
			         if(balance >= 0)
			         {
			        	 session.createQuery("UPDATE Accounts SET balance = " + balance + " where account_number = " + id);
			         }	 
		         }
		         else
		         {
		        	 balance = -2;
		         }
		         tx.commit();
		      } catch (HibernateException e) {
		         if (tx != null)
		            tx.rollback();
		         e.printStackTrace();
		      } finally {
		         session.close();
		      }
		      return balance;
	   }

   public static void createCustomer(String first_name, String middle_name, String last_name, String phone, String branch) {
      Session session = getSessionFactory().openSession();
      Transaction tx = null;
      try {
         tx = session.beginTransaction();
         session.save(new Customer(first_name, middle_name, last_name, phone, branch));
         tx.commit();
      } catch (HibernateException e) {
         if (tx != null)
            tx.rollback();
         e.printStackTrace();
      } finally {
         session.close();
      }
   }
   
   public static void createAccount(int customer_id, String account_type, float balance) {
	      Session session = getSessionFactory().openSession();
	      Transaction tx = null;
	      try {
	         tx = session.beginTransaction();
	         session.save(new Accounts(customer_id, account_type, balance));
	         tx.commit();
	      } catch (HibernateException e) {
	         if (tx != null)
	            tx.rollback();
	         e.printStackTrace();
	      } finally {
	         session.close();
	      }
	   }
}
