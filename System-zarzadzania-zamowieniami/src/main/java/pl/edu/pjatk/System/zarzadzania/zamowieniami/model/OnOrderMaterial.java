package pl.edu.pjatk.System.zarzadzania.zamowieniami.model;

import javax.persistence.*;

@Entity
@Table(name = "onOrderMaterial")
public class OnOrderMaterial {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int positionId;

	@ManyToOne(cascade = { CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH, CascadeType.REFRESH })
	@JoinColumn(name = "materialId")
	private Material material;

	@ManyToOne(cascade = { CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH, CascadeType.REFRESH })
	@JoinColumn(name = "materialOrderId")
	private MaterialOrder materialOrder;

	@ManyToOne(cascade = { CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH, CascadeType.REFRESH })
	@JoinColumn(name = "serviceOrderId")
	private ServiceOrder serviceOrder;
	
	@Column(name = "quantity")
	private double quantity;


	public OnOrderMaterial(int positionId, Material material, MaterialOrder materialOrder, ServiceOrder serviceOrder,
			double quantity) {
		this.positionId = positionId;
		this.material = material;
		this.materialOrder = materialOrder;
		this.serviceOrder = serviceOrder;
		this.quantity = quantity;
	}

	public int getPositionId() {
		return positionId;
	}

	public void setPositionId(int positionId) {
		this.positionId = positionId;
	}

	public Material getMaterial() {
		return material;
	}

	public void setMaterial(Material material) {
		this.material = material;
	}

	public MaterialOrder getMaterialOrder() {
		return materialOrder;
	}

	public void setMaterialOrder(MaterialOrder materialOrder) {
		this.materialOrder = materialOrder;
	}

	public ServiceOrder getServiceOrder() {
		return serviceOrder;
	}

	public void setServiceOrder(ServiceOrder serviceOrder) {
		this.serviceOrder = serviceOrder;
	}

	public double getQuantity() {
		return quantity;
	}

	public void setQuantity(double quantity) {
		this.quantity = quantity;
	}

	
}
