package in.hcl.jpafinalassignment.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "user")
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "user_id")
	private int userId;
	@Column(name = "user_name")
	private String name;
	@Column(name = "user_mob")
	private String mob;
	@Column(name = "user_orderId")
	private String orderId;
	@Column(name = "user_addr")
	private String addr;
    @OneToMany
    @JoinTable(name = "userfoodmapping", joinColumns = @JoinColumn(name = "user_id"), inverseJoinColumns = @JoinColumn(name = "food_id"))
	private List<Food> foods = new ArrayList<>();

	public User() {
		super();
	}

	public User(int id, String name, String mob, String orderId, String addr, List<Food> foods) {
		super();
		this.userId = id;
		this.name = name;
		this.mob = mob;
		this.orderId = orderId;
		this.addr = addr;
		this.foods = foods;
	}

	
	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getName() {
	return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getMob() {
		return mob;
	}

	public void setMob(String mob) {
		this.mob = mob;
	}

	public String getOrderId() {
		return orderId;
	}

	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}

	public String getAddr() {
		return addr;
	}

	public void setAddr(String addr) {
		this.addr = addr;
	}

	public List<Food> getFoods() {
		return foods;
	}

	public void setFoods(List<Food> foods) {
		this.foods = foods;
	}

}