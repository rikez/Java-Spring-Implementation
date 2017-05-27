package br.skynar.api.Entity;

import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

@Entity
@Table(name = Parameter.tableName)
public class Parameter extends AbstractEntity {
	
	protected static final String tableName = "paramater";
	
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idParam;
	
	@Column(nullable=false)
	private String paramName;
	
	@Column(nullable=false)
	private String description;
	
	@Column(nullable=false)
	private String value;
	
	public int getIdParam() {
		return idParam;
	}
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
	@CreationTimestamp
	@Temporal(TemporalType.TIMESTAMP)
	private Calendar createdAt;
	
	@UpdateTimestamp
	@Temporal(TemporalType.TIMESTAMP)
	private Calendar updatedAt;
	
	public Calendar getCreatedAt() {
		return createdAt;
	}
	public Calendar getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(Calendar updatedAt) {
		this.updatedAt = updatedAt;
	}
	public String getParamName() {
		return paramName;
	}
	public void setParamName(String paramName) {
		this.paramName = paramName;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	

	

}
