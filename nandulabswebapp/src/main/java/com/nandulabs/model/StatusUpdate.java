package com.nandulabs.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

@Entity(name = "Status")
@Table(name = "STATUS_UPDATE")
public class StatusUpdate {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "STATUS_ID")
	private Long id;

	@NotNull
	@Size(min=5, max=50, message="{addstatus.text.size}")
	@Column(name = "STATUS")
	private String text;

	@Column(name = "ADDED_DATETIME")
	@Temporal(TemporalType.TIMESTAMP)
	@DateTimeFormat(pattern="yyyy/MM/dd  hh:mm:ss")
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
