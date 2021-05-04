package pl.edu.pjatk.System.zarzadzania.zamowieniami.model;

import java.time.LocalDate;

import javax.persistence.*;

@Entity
@Table(name = "vacationRequest")
public class VacationRequest {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int requestId;
	
	@ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH, CascadeType.REFRESH})
    @JoinColumn(name = "employeeFullTimeId")
    private EmployeeFullTime employeeFullTime;

	@Column(name = "startDate")
    private LocalDate startDate;
	
	@Column(name = "duration")
    private int duration;

	private VacationRequest(EmployeeFullTime employeeFullTime, LocalDate startDate, int duration) {
		this.employeeFullTime = employeeFullTime;
		this.startDate = startDate;
		this.duration = duration;
	}
	
	public VacationRequest createVacationRequest(EmployeeFullTime employeeFullTime, LocalDate startDate, int duration) {
		VacationRequest vacationRequest = new VacationRequest(employeeFullTime, startDate, duration);
		return vacationRequest;
	}

	public int getRequestId() {
		return requestId;
	}

	public void setRequestId(int requestId) {
		this.requestId = requestId;
	}

	public EmployeeFullTime getEmployeeFullTime() {
		return employeeFullTime;
	}

	public void setEmployeeFullTime(EmployeeFullTime employeeFullTime) {
		this.employeeFullTime = employeeFullTime;
	}

	public LocalDate getStartDate() {
		return startDate;
	}

	public void setStartDate(LocalDate startDate) {
		this.startDate = startDate;
	}

	public int getDuration() {
		return duration;
	}

	public void setDuration(int duration) {
		this.duration = duration;
	}
	
	
}
