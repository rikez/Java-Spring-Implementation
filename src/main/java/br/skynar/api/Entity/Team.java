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
@Table(name = Team.tableName)
public class Team extends AbstractEntity {
	
	protected static final String tableName = "team";
	
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idTeam;
	
	@Column(nullable=false)
	private String idBoardTeam;
	
	@Column(nullable=false)
	private String teamName;
		
	@CreationTimestamp
	@Temporal(TemporalType.TIMESTAMP)
	private Calendar createdAt;
	
	@UpdateTimestamp
	@Temporal(TemporalType.TIMESTAMP)
	private Calendar updatedAt;
	
	public Calendar getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Calendar createdAt) {
		this.createdAt = createdAt;
	}

	public Calendar getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(Calendar updatedAt) {
		this.updatedAt = updatedAt;
	}

	public int getIdTeam() {
		return idTeam;
	}

	public void setIdTeam(int idTeam) {
		this.idTeam = idTeam;
	}

	public String getIdBoardTeam() {
		return idBoardTeam;
	}

	public String getTeamName() {
		return teamName;
	}

	public void setTeamName(String teamName) {
		this.teamName = teamName;
	}
	
}
