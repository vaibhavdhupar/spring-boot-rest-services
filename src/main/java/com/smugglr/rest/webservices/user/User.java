package com.smugglr.rest.webservices.user;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(description = "User structure")
@Entity
public class User {

	@Id
	@GeneratedValue
	private int id;

	@Size(min = 2, message = "Name should have atleast 2 characters.")
	@ApiModelProperty(notes = "Name should be atleast 2 characters")
	private String name;

	@Past
	@ApiModelProperty(notes = "Birth date should be before current time.")
	private Date bithDate;

	@OneToMany(mappedBy = "user")
	private List<Post> posts;

	public User() {
		super();
	}

	public User(int id, String name, Date bithDate) {
		super();
		this.id = id;
		this.name = name;
		this.bithDate = bithDate;
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

	public Date getBithDate() {
		return bithDate;
	}

	public void setBithDate(Date bithDate) {
		this.bithDate = bithDate;
	}

	public List<Post> getPosts() {
		return posts;
	}

	public void setPosts(List<Post> posts) {
		this.posts = posts;
	}

	@Override
	public String toString() {
		return String.format("User [id=%s, name=%s, bithDate=%s]", id, name, bithDate);
	}

}
