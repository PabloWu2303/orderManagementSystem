package pl.edu.pjatk.System.zarzadzania.zamowieniami.model;

import java.time.LocalDate;

import javax.persistence.*;


@MappedSuperclass
@Inheritance(strategy=InheritanceType.TABLE_PER_CLASS)
public abstract class Order {

    private static final String STATUS_UTWORZONE = "UTWORZONE";
    private static final String STATUS_W_TRAKCIE_REALIZACJI = "W TRAKCIE REALIZACJI";
    private static final String STATUS_ZREALIZOWANE = "ZREALIZOWANE";
    private static final String STATUS_ANULOWANE = "ANULOWANE";

    @Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;

    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH, CascadeType.REFRESH})
    @JoinColumn(name = "subconstractorId")
    private Subconstractor subconstractor;
	
    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH, CascadeType.REFRESH})
    @JoinColumn(name = "constructionSiteId")
    private ConstructionSite constructionSite;
	
	@Column(name = "registerDate")
    private LocalDate registerDate;
	
	@Column(name = "realizationDate")
    private LocalDate realizationDate;
	
	@Column(name = "status")
    private String status;
	
	@Column(name = "nearingCompletionDateFlag")
    private String nearingCompletionDateFlag;

	public Order(Subconstractor subconstractor, ConstructionSite constructionSite, LocalDate registerDate,
			LocalDate realizationDate, String status, String nearingCompletionDateFlag) {
		this.subconstractor = subconstractor;
		this.constructionSite = constructionSite;
		this.registerDate = registerDate;
		this.realizationDate = realizationDate;
		this.status = status;
		this.nearingCompletionDateFlag = nearingCompletionDateFlag;
	}

	public Subconstractor getSubconstractor() {
		return subconstractor;
	}

	public void setSubconstractor(Subconstractor subconstractor) {
		this.subconstractor = subconstractor;
	}

	public ConstructionSite getConstructionSite() {
		return constructionSite;
	}

	public void setConstructionSite(ConstructionSite constructionSite) {
		this.constructionSite = constructionSite;
	}

	public LocalDate getRegisterDate() {
		return registerDate;
	}

	public void setRegisterDate(LocalDate registerDate) {
		this.registerDate = registerDate;
	}

	public LocalDate getRealizationDate() {
		return realizationDate;
	}

	public void setRealizationDate(LocalDate realizationDate) {
		this.realizationDate = realizationDate;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String isNearingCompletionDateFlag() {
		return nearingCompletionDateFlag;
	}

	public void setNearingCompletionDateFlag(String nearingCompletionDateFlag) {
		this.nearingCompletionDateFlag = nearingCompletionDateFlag;
	}
	
	
}
