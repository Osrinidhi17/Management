package in.hcl.jpafinalassignment.domain;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;



@Entity
@Table(name="food")
public class Food {
@Id
@GeneratedValue(strategy= GenerationType.AUTO)
@Column(name = "food_id")
private int foodId;
@Column(name="food_name")
private String name;
@Column(name="food_cost")
private int cost;
@ManyToMany(mappedBy = "foods")
private List<User> users = new ArrayList<>();

public Food() {
super();
}


public int getId() {
return foodId;
}

public void setId(int id) {
this.foodId = id;
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


public List<User> getUsers() {
	return users;
}


public void setUsers(List<User> users) {
	this.users = users;
}


public Food(int foodId, String name, int cost, List<User> users) {
	super();
	this.foodId = foodId;
	this.name = name;
	this.cost = cost;
	this.users = users;
}



}