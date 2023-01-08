package io.marabezzi.jwtsecuritycrud.user;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;


@Entity
@Table(name = "roles")
public class Role extends AbstractEntity {
	
	@Column(name = "description", nullable = false, unique = true)
	private String desc;

	public String getDesc() {
		return desc;
	}
    
	public Role() {
		super();
	}
	
	public Role(Long id) {
		super.setId(id);
	}
	
	public void setDesc(String desc) {
		this.desc = desc;
	}	
	
}
