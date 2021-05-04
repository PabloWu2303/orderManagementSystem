package pl.edu.pjatk.System.zarzadzania.zamowieniami.model;
import javax.persistence.*;

@Entity
@Table(name="employeeOnComision")
public class EmployeeOnComision {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
    private int id;
	
	@OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "employee")
    private Employee employee;
	
	@Column(name = "ratePerHour")
    private int ratePerHour;

	public EmployeeOnComision(Employee employee, int ratePerHour) {
		this.employee = employee;
		this.ratePerHour = ratePerHour;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	public int getRatePerHour() {
		return ratePerHour;
	}

	public void setRatePerHour(int ratePerHour) {
		this.ratePerHour = ratePerHour;
	}
	
	
}
