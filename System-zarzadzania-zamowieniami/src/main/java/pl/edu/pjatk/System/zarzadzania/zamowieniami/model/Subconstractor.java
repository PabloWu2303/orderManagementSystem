package pl.edu.pjatk.System.zarzadzania.zamowieniami.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;


@Entity
@Table(name="subconstractor")
public class Subconstractor {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="name")
    private String name;
	
	@OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "addressId")
    private Address address;
    
    @Column(name="nip")
    private String NIP;
    
    @Column(name="cooperationRate")
    private int cooperationRate; //opcjonalne
    
    
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "subconstractorSupplierId")
    private SubconstractorSupplier subconstractorSupplier; //opcjonalne
    
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "subconstractorConstractorId")
    private SubconstractorConstractor subconstractorConstractor; //opcjonalne
    
    @OneToMany(mappedBy = "subconstractor", cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH, CascadeType.REFRESH})
    private List<ServiceOrder> serviceOrderList;
    
//	@OneToMany(mappedBy = "subconstractor", cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH, CascadeType.REFRESH})
//    private List<Order> orderList;

    
	public Subconstractor(String name, Address address, String NIP, int cooperationRate) {
		this.name = name;
		this.address = address;
		this.NIP = NIP;
		this.cooperationRate = cooperationRate;
	}
	

	public Subconstractor() {
}

	public void addOrderToList(ServiceOrder order) {
		if(serviceOrderList == null) {
			serviceOrderList = new ArrayList<ServiceOrder>();
		}
		
		if(!serviceOrderList.contains(order)) {
			serviceOrderList.add(order);
			order.setSubconstractor(this);
		}
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address adress) {
		this.address = adress;
	}

	public String getNIP() {
		return NIP;
	}

	public void setNIP(String nIP) {
		NIP = nIP;
	}

	public int getCooperationRate() {
		return cooperationRate;
	}

	public void setCooperationRate(int cooperationRate) {
		this.cooperationRate = cooperationRate;
	}

	public SubconstractorSupplier getSubconstractorSupplier() {
		return subconstractorSupplier;
	}

	public void setSubconstractorSupplier(SubconstractorSupplier subconstractorSupplier) {
		this.subconstractorSupplier = subconstractorSupplier;
	}

	public SubconstractorConstractor getSubconstractorConstractor() {
		return subconstractorConstractor;
	}

	public void setSubconstractorConstractor(SubconstractorConstractor subconstractorConstractor) {
		this.subconstractorConstractor = subconstractorConstractor;
	}
//
//	public List<Order> getOrderList() {
//		return orderList;
//	}
//
//	public void setOrderList(List<Order> orderList) {
//		this.orderList = orderList;
//	}

    public List<ServiceOrder> getServiceOrderList() {
		return serviceOrderList;
	}

	public void setServiceOrderList(List<ServiceOrder> serviceOrderList) {
		this.serviceOrderList = serviceOrderList;
	}

    
}
