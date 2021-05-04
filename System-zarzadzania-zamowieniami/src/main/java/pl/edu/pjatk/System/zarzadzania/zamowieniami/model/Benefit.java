package pl.edu.pjatk.System.zarzadzania.zamowieniami.model;

import java.util.List;

import javax.persistence.*;

@Entity
@Table(name = "benefit")
public class Benefit {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int benefitId;

	@Column(name = "name")
	private String name;

	@OneToMany(mappedBy = "benefit", cascade = { CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH,
			CascadeType.REFRESH })
	private List<EmployeeFullTime> employeeFullTimeList;

	public Benefit() {
	}

	public Benefit(String name) {
		this.name = name;
	}

	public int getBenefitId() {
		return benefitId;
	}

	public void setBenefitId(int benefitId) {
		this.benefitId = benefitId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
