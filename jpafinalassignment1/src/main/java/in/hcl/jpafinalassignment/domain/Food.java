package in.hcl.jpafinalassignment.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "food")
public class Food {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "food_id")
	private int foodId;
	@Column(name = "food_name")
	private String name;
	@Column(name = "food_cost")
	private int cost;
    @ManyToOne(fetch = FetchType.LAZY)
    private User user;

	public Food() {
		super();
	}
	
	

	public Food(int id, String name, int cost) {
		super();
		this.foodId = id;
		this.name = name;
		this.cost = cost;
	}
	

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public int getCost() {
		return cost;
	}

	public void setCost(int cost) {
		this.cost = cost;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public int getFoodId() {
		return foodId;
	}

	public void setFoodId(int foodId) {
		this.foodId = foodId;
	}

	@Override
	public String toString() {
		return "Food [foodId=" + foodId + ", name=" + name + ", cost=" + cost + "]";
	}

}