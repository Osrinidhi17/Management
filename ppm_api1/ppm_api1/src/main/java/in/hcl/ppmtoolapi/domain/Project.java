package in.hcl.ppmtoolapi.domain;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
public class Project {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotBlank(message = "projectName is required")
	private String projectName;

	@NotBlank(message = "projectIdentifier is required")
	@Size(min = 4, max = 5, message = "Please use 4 to 5 characters only")
	@Column(updatable = false, unique = true) // making unique without duplicate data
	private String projectIdentifier;

	@NotBlank(message = "description is required")
	private String description;

	@JsonFormat(pattern = "yyyy-mm-dd")
	private String start_date;

	@JsonFormat(pattern = "yyyy-mm-dd")
	private String end_date;

	//OneToOne with backlog class and mapped with project ref
	@OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL, mappedBy = "project")
	private Backlog backlog;

	@JsonFormat(pattern = "yyyy-mm-dd")
	private Date create_At;

	@JsonFormat(pattern = "yyyy-mm-dd")
	private Date updated_At;

	public Project() {
		super();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getProjectName() {
		return projectName;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}

	public String getProjectIdentifier() {
		return projectIdentifier;
	}

	public void setProjectIdentifier(String projectIdentifier) {
		this.projectIdentifier = projectIdentifier;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

    public String getStart_date() {
		return start_date;
	}

	public void setStart_date(String start_date) {
		this.start_date = start_date;
	}

	public String getEnd_date() {
		return end_date;
	}

	public void setEnd_date(String end_date) {
		this.end_date = end_date;
	}

	public Date getCreate_At() {
		return create_At;
	}

	public void setCreate_At(Date create_At) {
		this.create_At = create_At;
	}

	public Date getUpdated_At() {
		return updated_At;
	}

	public void setUpdated_At(Date updated_At) {
		this.updated_At = updated_At;
	}

	public Backlog getBacklog() {
		return backlog;
	}

	public void setBacklog(Backlog backlog) {
		this.backlog = backlog;
	}

	@PrePersist
	public void onCreate() {
		this.create_At = new Date();
	}

	@PreUpdate
	public void onUpdate() {
		this.updated_At = new Date();
	}
}
