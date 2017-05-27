package br.skynar.api.Entity;

import javax.persistence.Entity;
import javax.persistence.Id;

import org.springframework.security.core.GrantedAuthority;

@Entity
public class Role implements GrantedAuthority{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	private String role_name;

	public String getRole() {
		return role_name;
	}

	public void setRole(String role_name) {
		this.role_name = role_name;
	}

	@Override
	public String getAuthority() {
		return this.role_name;
	}
	
	@Override
	public String toString() {
		return this.role_name;
	}
	
	
}
