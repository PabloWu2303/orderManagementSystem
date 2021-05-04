package pl.edu.pjatk.System.zarzadzania.zamowieniami.model;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.*;

@Entity
@Table(name="serviceOrder")
public class ServiceOrder extends Order{

    @Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
    
    @Column(name = "crewQuantity")
    private int crewQuantity;
    
    @Column(name = "materialAmount")
    private double materialAmount;
    
    @Column(name = "laborCost")
    private double laborCost;
    
    @OneToMany(mappedBy = "materialOrder", cascade = { CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH,
			CascadeType.REFRESH })
	private List<OnOrderMaterial> onOrderMaterialList;

	public ServiceOrder(Subconstractor subconstractor, ConstructionSite constructionSite, LocalDate registerDate,
			LocalDate realizationDate, String status, String nearingCompletionDateFlag, int crewQuantity,
			double materialAmount, double laborCost) {
		super(subconstractor, constructionSite, registerDate, realizationDate, status, nearingCompletionDateFlag);
		this.crewQuantity = crewQuantity;
		this.materialAmount = materialAmount;
		this.laborCost = laborCost;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getCrewQuantity() {
		return crewQuantity;
	}

	public void setCrewQuantity(int crewQuantity) {
		this.crewQuantity = crewQuantity;
	}

	public double getMaterialAmount() {
		return materialAmount;
	}

	public void setMaterialAmount(double materialAmount) {
		this.materialAmount = materialAmount;
	}

	public double getLaborCost() {
		return laborCost;
	}

	public void setLaborCost(double laborCost) {
		this.laborCost = laborCost;
	}

	public List<OnOrderMaterial> getOnOrderMaterialList() {
		return onOrderMaterialList;
	}

	public void setOnOrderMaterialList(List<OnOrderMaterial> onOrderMaterialList) {
		this.onOrderMaterialList = onOrderMaterialList;
	}
	
	
	
}
