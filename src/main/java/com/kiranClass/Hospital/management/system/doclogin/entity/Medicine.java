package com.kiranClass.Hospital.management.system.doclogin.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="medicines")
public class Medicine {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY )
	private long id;
	
	
	private String drug_name;
	
	
	private String stock;


	public long getId() {
		return id;
	}


	public void setId(long id) {
		this.id = id;
	}


	public String getDrug_name() {
		return drug_name;
	}


	public void setDrug_name(String drug_name) {
		this.drug_name = drug_name;
	}


	public String getStock() {
		return stock;
	}


	public void setStock(String stock) {
		this.stock = stock;
	}


	@Override
	public String toString() {
		return "Medicine [id=" + id + ", drug_name=" + drug_name + ", stock=" + stock + "]";
	}


	public Medicine() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Medicine(long id, String drug_name, String stock) {
		super();
		this.id = id;
		this.drug_name = drug_name;
		this.stock = stock;
	}
	
	



	
	

}
