package in.hcl.jpafinalassignment.domain;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "user")
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	@Column(name = "user_name")
	private String name;
	@Column(name = "user_mob")
	private String mob;
	@Column(name = "user_orderId")
	private String orderId;
	@Column(name = "user_addr")
	private String addr;
	@OneToOne
	private Food food;

	public User() {
		super();
	}

	

	public User(int id, String name, String mob, String orderId, String addr, Food food) {
		super();
		this.id = id;
		this.name = name;
		this.mob = mob;
		this.orderId = orderId;
		this.addr = addr;
		this.food = food;
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

	public Food getFood() {
		return food;
	}

	public void setFood(Food food) {
		this.food = food;
	}
	
}