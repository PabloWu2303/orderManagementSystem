package pl.edu.pjatk.System.zarzadzania.zamowieniami.model;

import lombok.*;

import javax.persistence.*;

@Data
@Entity
@Table(name = "address")
public class Address {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private int id;

	@Column(name = "city")
    private String city;

	@Column(name = "street")
    private String street;

	@Column(name = "houseNumber")
    private String houseNumber;

	@Column(name = "flatNumber")
    private int flatNumber; //opcjonalny

	@Column(name = "postalCode")
    private String postalCode;
	
	public Address() {
	}
}
