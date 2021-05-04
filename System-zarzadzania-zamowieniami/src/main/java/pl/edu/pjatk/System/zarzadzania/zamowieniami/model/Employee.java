package pl.edu.pjatk.System.zarzadzania.zamowieniami.model;

import java.time.LocalDate;

import javax.persistence.*;

@Entity
@Table(name="employee")
public class Employee {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
    private int employeeId;

	@Column(name="personalData")
    private String personalData;

	@Column(name="contactData")
    private String contactData;

	@Column(name="accessCardId")
    private int accessCardId;

	@Column(name="position")
    private String position;

	@Column(name="entitlementNumber")
    private String entitlementNumber; //opcjonalne

	@Column(name="seniority")
    private LocalDate seniority; //opcjonalne
	
	@ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH, CascadeType.REFRESH})
    @JoinColumn(name = "constructionSiteId")
    private ConstructionSite constructionSite;
	
	@OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "employeeFullTimeId")
    private EmployeeFullTime employeeFullTime;
	
	@OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "employeeOnComisionId")
    private EmployeeOnComision employeeOnComision;

}
