package com.dvk.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Transient;

import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.annotation.JsonIgnore;



@Entity
public class Product implements Serializable{
	//class is implementing serializable as it will be user in webflow
	private static final long serialVersionUID = 2730829470825071864L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	private String productName;
	private double productPrice;
	private String productCategory;
	private String productCondition;
	
	@OneToMany(mappedBy="product",cascade=CascadeType.ALL,fetch=FetchType.EAGER)
	@JsonIgnore 
	private List<CartItem> cartItems;
	
	public List<CartItem> getCartItems() {
		return cartItems;
	}
	public void setCartItems(List<CartItem> cartItems) {
		this.cartItems = cartItems;
	}
	//the image will not be persisted in database,
	//it will  be stored in resources folder.
	@Transient
	private MultipartFile productImage;
	
	public int getId() {
		return id;
	}
	public double getProductPrice() {
		return productPrice;
	}
	public void setProductPrice(double productPrice) {
		this.productPrice = productPrice;
	}
	public String getProductCategory() {
		return productCategory;
	}
	public void setProductCategory(String productCategory) {
		this.productCategory = productCategory;
	}
	public String getProductCondition() {
		return productCondition;
	}
	public void setProductCondition(String productCondition) {
		this.productCondition = productCondition;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public MultipartFile getProductImage() {
		return productImage;
	}
	public void setProductImage(MultipartFile productImage) {
		this.productImage = productImage;
	}
	
	/*public String getImagePath() {
		return imagePath;
	}
	public void setImagePath(String imagePath) {
		this.imagePath = imagePath;
	}
	*/

}
