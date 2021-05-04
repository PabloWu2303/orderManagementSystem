package pl.edu.pjatk.System.zarzadzania.zamowieniami.model;

import java.util.List;

import javax.persistence.*;

@Entity
@Table(name="material")
public class Material {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	
	@OneToMany(mappedBy = "material", cascade = { CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH,
			CascadeType.REFRESH })
    private List<OnOrderMaterial> onOrderMaterialList;
	
	@Column(name = "name")
    private String name;
	
	@Column(name = "unitCost")
    private double unitCost;

	public Material(int id, List<OnOrderMaterial> onOrderMaterialList, String name, double unitCost) {
		this.id = id;
		this.onOrderMaterialList = onOrderMaterialList;
		this.name = name;
		this.unitCost = unitCost;
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

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getUnitCost() {
		return unitCost;
	}

	public void setUnitCost(double unitCost) {
		this.unitCost = unitCost;
	}
	
	
}
