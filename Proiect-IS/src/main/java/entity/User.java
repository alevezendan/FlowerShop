package entity;

//import lombok.Data;

import javax.persistence.*;

@Entity
//@Data
@Table(name = "user")
public class User {

	@Id
	//@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(name = "name")
	private String name;

	@Column(name = "role")
	private String role;

	@Column(name = "username")
	private String username;

	@Column(name = "password")
	private String password;

	@ManyToOne
	@JoinColumn(name = "id_flowerShop")
	private FlowerShop flowerShop;
	//private int flowerShopId;

	@Column(name = "language")
	private String language;

	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	/*public int getFlowerShopId() {
            return flowerShopId;
        }

        public void setFlowerShopId(int flowerShopId) {
            this.flowerShopId = flowerShopId;
        }*/
	public User(){}
	public User(int id, String name, String role, String username, String password, FlowerShop flowerShop) {
		this.id = id;
		this.name = name;
		this.role = role;
		this.username = username;
		this.password = password;
		this.flowerShop = flowerShop;
	}

	public User(int id, String name, String role, String username, FlowerShop flowerShop) {
		this.id = id;
		this.name = name;
		this.role = role;
		this.username = username;
		this.flowerShop = flowerShop;
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

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public FlowerShop getFlowerShop() {
		return flowerShop;
	}

	public void setFlowerShop(FlowerShop flowerShop) {
		this.flowerShop = flowerShop;
	}


}
