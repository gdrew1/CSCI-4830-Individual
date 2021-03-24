import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @since J2SE-1.8
 CREATE TABLE Customer (
  customer_id INT NOT NULL AUTO_INCREMENT,    
  first_name VARCHAR(30) NOT NULL, 
  middle_name VARCHAR(30) NOT NULL,
  last_name VARCHAR(30) NOT NULL,  
  phone_number VARCHAR(30) NOT NULL,
  main_branch VARCHAR(30) NOT NULL,    
  PRIMARY KEY (id));
 */
@Table(name = "accounts")
@javax.persistence.Entity(name = "account")
public class Accounts {
	
	@Id  // primary key
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   @Column(name = "account_number") // specify the column name. Without it, it will use method name
   private Integer account_number;

   public Integer getCustomer_id() {
		return customer_id;
	}

	public void setCustomer_id(Integer customer_id) {
		this.customer_id = customer_id;
	}

	public String getAccount_type() {
		return account_type;
	}

	public void setAccount_type(String account_type) {
		this.account_type = account_type;
	}

	public Float getBalance() {
		return balance;
	}

	public void setBalance(Float balance) {
		this.balance = balance;
	}

	public Integer getAccount_number() {
		return account_number;
	}

@Column(name = "customer_id")
   private Integer customer_id;
   
   @Column(name = "account_type")
   private String account_type;
   
   @Column(name = "balance")
   private Float balance;

   public Accounts() {
   }

   public Accounts(int customer_id, String account_type, float balance) {
      this.customer_id = customer_id;
      this.account_type = account_type;
      this.balance = balance;
   }


   

}