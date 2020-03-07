/**
 * 
 */
package com.development.spring.model;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author Sanjib Bhadra
 *
 */
@Entity
@Table(name = "PRODUCT")
public class Product implements Serializable {
	
	@Id
	@Column(name = "ID")
	private int id;
	
	@Column(name = "PRODUCT_CODE")
	private int prodCode;
	
	@Column(name = "CATEGORY")
	private String category;
	
	@Column(name = "NAME")
	private String name;
	
	@Column(name = "PROD_DESC")
	private String prodDesc;
	
	@Column(name = "SYS_CREATION_DATE")
	private Date creationDate;
	
	
	public Product(int id, int prodCode, String category, String name, String prodDesc, Date creationDate) {
		super();
		this.id = id;
		this.prodCode = prodCode;
		this.category = category;
		this.name = name;
		this.prodDesc = prodDesc;
		this.creationDate = creationDate;
	}
	
	
	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public int getProdCode() {
		return prodCode;
	}


	public void setProdCode(int prodCode) {
		this.prodCode = prodCode;
	}


	public String getCategory() {
		return category;
	}


	public void setCategory(String category) {
		this.category = category;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getProdDesc() {
		return prodDesc;
	}


	public void setProdDesc(String prodDesc) {
		this.prodDesc = prodDesc;
	}


	public Date getCreationDate() {
		return creationDate;
	}


	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((category == null) ? 0 : category.hashCode());
		result = prime * result + ((creationDate == null) ? 0 : creationDate.hashCode());
		result = prime * result + id;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + prodCode;
		result = prime * result + ((prodDesc == null) ? 0 : prodDesc.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Product other = (Product) obj;
		if (category == null) {
			if (other.category != null)
				return false;
		} else if (!category.equals(other.category))
			return false;
		if (creationDate == null) {
			if (other.creationDate != null)
				return false;
		} else if (!creationDate.equals(other.creationDate))
			return false;
		if (id != other.id)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (prodCode != other.prodCode)
			return false;
		if (prodDesc == null) {
			if (other.prodDesc != null)
				return false;
		} else if (!prodDesc.equals(other.prodDesc))
			return false;
		return true;
	}
	
	

}
