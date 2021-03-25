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
  PRIMARY KEY (customer_id));
 */
@Table(name = "Customer")
@javax.persistence.Entity(name = "Customer")
public class Customer {

   public String getMiddle_name() {
		return middle_name;
	}

	public void setMiddle_name(String middle_name) {
		this.middle_name = middle_name;
	}

	public String getPhone_number() {
		return phone_number;
	}

	public void setPhone_number(String phone_number) {
		this.phone_number = phone_number;
	}

	public String getMain_branch() {
		return main_branch;
	}

	public void setMain_branch(String main_branch) {
		this.main_branch = main_branch;
	}

@Id  // primary key
   @GeneratedValue(strategy = GenerationType.IDENTITY)
@Column(name = "customer_id")
private int customer_id;


   @Column(name = "first_name")
   private String first_name;
   
   @Column(name = "middle_name")
   private String middle_name;
   
   @Column(name = "last_name")
   private String last_name;

   @Column(name = "phone_number")
   private String phone_number;
   
   @Column(name = "main_branch")
   private String main_branch;

   public Customer() {
   }

   public Customer(String first_name, String middle_name, String last_name, String phone_number, String main_branch) {
      this.first_name = first_name;
      this.last_name = last_name;
      this.middle_name = middle_name;
      this.phone_number = phone_number;
      this.main_branch = main_branch;
   }


   public Integer getId() {
      return this.customer_id;
   }

   public void setId(Integer id) {
      this.customer_id = id;
   }

   public String getFirst_name() {
	return first_name;
}

public void setFirst_name(String first_name) {
	this.first_name = first_name;
}

public String getLast_name() {
	return last_name;
}

public void setLast_name(String last_name) {
	this.last_name = last_name;
}

@Override
public String toString() {
	return "Customer [customer_id=" + customer_id + ", first_name=" + first_name + ", middle_name=" + middle_name + ", last_name="
			+ last_name + ", phone_number=" + phone_number + ", main_branch=" + main_branch + "]";
}

}