package io.marabezzi.jwtsecuritycrud.user;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Index;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "_user", indexes = {@Index(name = "idx_user_email", columnList = "email")})
@AllArgsConstructor
@NoArgsConstructor
public class User extends AbstractEntity{

	@Column(name = "email", unique = true, nullable = false)
	private String email;
	
	@JsonIgnore
	@Column(name = "password", nullable = false)
	private String password;
	
	@ManyToMany
	@JoinTable(
		name = "users_with_roles", 
        joinColumns = { @JoinColumn(name = "user_id", referencedColumnName = "id") }, 
        inverseJoinColumns = { @JoinColumn(name = "role_id", referencedColumnName = "id") }
	)
	private List<Role> roles;
	
	@Column(name = "active", nullable = false, columnDefinition = "TINYINT(1)")
	private boolean active;
	
	    // add list of roles
		public void addRole(RoleType type) {
			if (this.roles == null) {
				this.roles= new ArrayList<>();
			}
			this.roles.add(new Role(type.getCod()));
		}
}
