package br.skynar.api.Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table(name= TeamList.tableName)
public class TeamList  extends AbstractEntity {
	
	
	protected static final String tableName = "team_list";
	
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idList;
	
	@Column(nullable=false, unique=true)
	private String boardListId;
	
	@Column(nullable=false)
	private String listName;
	
	@ManyToOne
	@JoinColumn(name="teamId")
	private Team teamId;

	public String getBoardListId() {
		return boardListId;
	}

	public void setBoardListId(String boardListId) {
		this.boardListId = boardListId;
	}

	public String getListName() {
		return listName;
	}

	public void setListName(String listName) {
		this.listName = listName;
	}
	
	
	
	
}
