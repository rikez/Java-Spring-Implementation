package br.skynar.api.Entity;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

@Entity
@Table(name = User.tableName)
public class User extends AbstractEntity implements UserDetails {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public static final String tableName = "user";
	
	@Id 
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(updatable = false, nullable = false)
	private int id_user;
	
	public int getId_user() {
		return id_user;
	}

	public void setId_user(int id_user) {
		this.id_user = id_user;
	}

	public List<Role> getRoles() {
		return roles;
	}

	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}

	@Column(nullable=false)
	private String name;
	
	@Column(unique=true, nullable=false)
	private String email;
	
	@Column(nullable=false)
	@DateTimeFormat
	private Calendar dob;
	
	@Column(nullable=false)
	private String password;
	
	@OneToMany
	private List<Story> story;
	
	private String picturePath;
	
	@ManyToMany(fetch=FetchType.EAGER)
	private List<Role> roles = new ArrayList<Role>();

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Calendar getDob() {
		return this.dob;
	}

	public void setDob(Calendar dob) {
		this.dob = dob;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "User [name=" + name + ", email=" + email + ", dob=" + dob + ", password=" + password + "]";
	}
	public String getPicturePath() {
		return picturePath;
	}

	public void setPicturePath(String picturePath) {
		this.picturePath = picturePath;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return this.roles;
	}

	@Override
	public String getUsername() {
		return this.password;
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}
	
}
