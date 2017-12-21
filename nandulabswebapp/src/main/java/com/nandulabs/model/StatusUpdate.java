package com.nandulabs.model;

import java.util.Date;

import javax.annotation.PreDestroy;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity(name = "Status")
@Table(name = "STATUS_UPDATE")
public class StatusUpdate {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "STATUS_ID")
	private Long id;

	@Column(name = "STATUS")
	private String text;

	@Column(name = "ADDED_DATETIME")
	@Temporal(TemporalType.TIMESTAMP)
	private Date added;

	@PrePersist
	protected void onCreate() {
		if (added == null) {
			added = new Date();
		}
	}

	public StatusUpdate() {
	}

	public StatusUpdate(String text) {
		this.text = text;
	}

	public StatusUpdate(String text, Date added) {
		this.text = text;
		this.added = added;
	}

	public Date getAdded() {
		return added;
	}

	public Long getId() {
		return id;
	}

	public String getText() {
		return text;
	}

	public void setAdded(Date added) {
		this.added = added;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setText(String text) {
		this.text = text;
	}

}
