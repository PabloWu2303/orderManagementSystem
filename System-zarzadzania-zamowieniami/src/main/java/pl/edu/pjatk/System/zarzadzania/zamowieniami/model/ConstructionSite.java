package pl.edu.pjatk.System.zarzadzania.zamowieniami.model;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.*;

@Entity
@Table(name = "constructionSite")
public class ConstructionSite {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;

	@OneToMany(mappedBy = "constructionSite", cascade = { CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH,
			CascadeType.REFRESH })
	private List<ServiceOrder> serviceOrderList;

	@OneToMany(mappedBy = "constructionSite", cascade = { CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH,
			CascadeType.REFRESH })
	private List<Employee> employeeList;

	@Column(name = "name")
	private String name;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "addressId")
	private Address adress;

	@Column(name = "budget")
	private double budget;

	@Column(name = "startDate")
	private LocalDate startDate;

	@Column(name = "endDate")
	private LocalDate endDate;
	
	public ConstructionSite() {};

	public ConstructionSite(String name, Address adress, double budget, LocalDate startDate, LocalDate endDate) {
		this.name = name;
		this.adress = adress;
		this.budget = budget;
		this.startDate = startDate;
		this.endDate = endDate;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public List<ServiceOrder> getOrderList() {
		return serviceOrderList;
	}

	public void setOrderList(List<ServiceOrder> serviceOrderList) {
		this.serviceOrderList = serviceOrderList;
	}

//	public List<Employee> getEmployeeList() {
//		return employeeList;
//	}
//
//	public void setEmployeeList(List<Employee> employeeList) {
//		this.employeeList = employeeList;
//	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Address getAdress() {
		return adress;
	}

	public void setAdress(Address adress) {
		this.adress = adress;
	}

	public double getBudget() {
		return budget;
	}

	public void setBudget(double budget) {
		this.budget = budget;
	}

	public LocalDate getStartDate() {
		return startDate;
	}

	public void setStartDate(LocalDate startDate) {
		this.startDate = startDate;
	}

	public LocalDate getEndDate() {
		return endDate;
	}

	public void setEndDate(LocalDate endDate) {
		this.endDate = endDate;
	}

}
