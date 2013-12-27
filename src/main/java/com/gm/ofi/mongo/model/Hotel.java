package com.gm.ofi.mongo.model;

import org.bson.types.ObjectId;

import com.github.jmkgreen.morphia.annotations.Embedded;
import com.github.jmkgreen.morphia.annotations.Entity;
import com.github.jmkgreen.morphia.annotations.Id;

@Entity
public class Hotel {
	@Id
	private ObjectId id;
	private String name;
	private int stars;
	@Embedded
	private Address address;
	public ObjectId getId() {
		return id;
	}
	public void setId(ObjectId id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getStars() {
		return stars;
	}
	public void setStars(int stars) {
		this.stars = stars;
	}
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
}
