package br.skynar.api.Entity;

import java.util.Date;
import java.util.List;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = Story.tableName)
public class Story extends AbstractEntity {
	
	public static final String tableName = "story";
	
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id_story;
	
	private String story;
	
	private Date begin;
	
	private Date end;
	
	@ElementCollection
	private List<Company> company;

	public String getStory() {
		return story;
	}

	public void setStory(String story) {
		this.story = story;
	}

	public Date getEnd() {
		return end;
	}

	public void setEnd(Date end) {
		this.end = end;
	}

	public Date getBegin() {
		return begin;
	}

	public void setBegin(Date begin) {
		this.begin = begin;
	}
	
	
}
