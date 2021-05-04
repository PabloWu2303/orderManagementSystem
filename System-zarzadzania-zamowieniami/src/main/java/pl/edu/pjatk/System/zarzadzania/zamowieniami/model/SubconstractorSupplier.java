package pl.edu.pjatk.System.zarzadzania.zamowieniami.model;

import javax.persistence.*;

@Entity
@Table(name = "subconstractorSupplier")
public class SubconstractorSupplier {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;

	@OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "subconstractor")
	private Subconstractor subconstractor;

	@Column(name = "deliveryMethod")
	private String deliveryMethod;

	private SubconstractorSupplier(Subconstractor subconstractor, String deliveryMethod) {
		this.subconstractor = subconstractor;
		this.deliveryMethod = deliveryMethod;
	}

	public SubconstractorSupplier createSubconstractorSupplier(Subconstractor subconstractor, String deliveryMethod) {

		SubconstractorSupplier subconstractorSupplier = new SubconstractorSupplier(subconstractor, deliveryMethod);

		return subconstractorSupplier;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Subconstractor getSubconstractor() {
		return subconstractor;
	}

	public void setSubconstractor(Subconstractor subconstractor) {
		this.subconstractor = subconstractor;
	}

	public String getDeliveryMethod() {
		return deliveryMethod;
	}

	public void setDeliveryMethod(String deliveryMethod) {
		this.deliveryMethod = deliveryMethod;
	}

}
