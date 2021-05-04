package pl.edu.pjatk.System.zarzadzania.zamowieniami.model;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.*;

@Entity
@Table(name="materialOrder")
public class MaterialOrder extends Order {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	int id;
	
	@OneToMany(mappedBy = "materialOrder", cascade = { CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH,
			CascadeType.REFRESH })
	private List<OnOrderMaterial> onOrderMaterialList;

	public MaterialOrder(Subconstractor subconstractor, ConstructionSite constructionSite, LocalDate registerDate,
			LocalDate realizationDate, String status, String nearingCompletionDateFlag) {
		super(subconstractor, constructionSite, registerDate, realizationDate, status, nearingCompletionDateFlag);
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public List<OnOrderMaterial> getOnOrderMaterialList() {
		return onOrderMaterialList;
	}

	public void setOnOrderMaterialList(List<OnOrderMaterial> onOrderMaterialList) {
		this.onOrderMaterialList = onOrderMaterialList;
	}

	
	
}
