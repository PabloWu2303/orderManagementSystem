package pl.edu.pjatk.System.zarzadzania.zamowieniami.model;

import java.util.List;

import javax.persistence.*;

@Entity
@Table(name = "employeeFullTime")
public class EmployeeFullTime {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "employee")
	private Employee employee;

	@OneToMany(mappedBy = "employeeFullTime", cascade = { CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH,
			CascadeType.REFRESH })
	private List<VacationRequest> vacationRequestList;

	@ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH, CascadeType.REFRESH})
    @JoinColumn(name = "benefitId")
	private Benefit benefit;

	public EmployeeFullTime(Employee employee,
			Benefit benefit) {
		this.employee = employee;
		this.benefit = benefit;
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

	public List<VacationRequest> getVacationRequestList() {
		return vacationRequestList;
	}

	public void setVacationRequestList(List<VacationRequest> vacationRequestList) {
		this.vacationRequestList = vacationRequestList;
	}

	public Benefit getBenefit() {
		return benefit;
	}

	public void setBenefit(Benefit benefit) {
		this.benefit = benefit;
	}

}
