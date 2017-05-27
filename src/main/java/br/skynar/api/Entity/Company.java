package br.skynar.api.Entity;

import java.util.Date;

import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Embeddable
@Table(name = Company.tableName)
public class Company extends AbstractEntity {
	
	public static final String tableName = "company";
	
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id_company;
	
	private String company;
	
	private String contact;
	
	private String comments;
	
	private Date entry;

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public String getContact() {
		return contact;
	}

	public void setContact(String contact) {
		this.contact = contact;
	}

	public String getComments() {
		return comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}

	public Date getEntry() {
		return entry;
	}

	public void setEntry(Date entry) {
		this.entry = entry;
	}
}
