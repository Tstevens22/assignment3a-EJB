package beans;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.validation.constraints.Size;
import org.hibernate.validator.constraints.NotEmpty;

@ManagedBean
@SessionScoped
public class User {

	@NotEmpty(message = "First name cannot be empty")
	@Size(min = 5, max = 15, message = "Size of first name must be between 5 and 15 characters")
	private String firstName;
	@NotEmpty(message = "Last name cannot be empty")
	@Size(min = 5, max = 15, message = "Size of last name must be between 5 and 15 characters")
	private String lastName;

	public User() {
		firstName = "Marcus";
		lastName = "Brown";
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

}
