package pl.edu.pjatk.System.zarzadzania.zamowieniami.model;

import javax.persistence.*;

@Entity
@Table(name = "subconstractorConstractor")
public class SubconstractorConstractor {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;

	@OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "subconstractor")
	private Subconstractor subconstractor;

	@Column(name = "quality")
	private String quality;

	private SubconstractorConstractor(Subconstractor subconstractor, String quality) {
		this.subconstractor = subconstractor;
		this.quality = quality;
	}

	public SubconstractorConstractor createSubconstractorConstractor(Subconstractor subconstractor,
			String deliveryMethod) {

		SubconstractorConstractor subconstractorConstractor = new SubconstractorConstractor(subconstractor,
				deliveryMethod);

		return subconstractorConstractor;
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

	public String getQuality() {
		return quality;
	}

	public void setQuality(String quality) {
		this.quality = quality;
	}

	
}
