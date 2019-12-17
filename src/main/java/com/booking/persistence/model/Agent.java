package com.booking.persistence.model;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "agent")

public class Agent implements java.io.Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "AgentId")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int idAgent;

	@Column(name = "AgentName")
	private String agentName;

	@Column(name = "AgentDetails")
	private String agentDetails;

	@Column(name = "AdminId")
	private int idAdmin;

	@JoinColumn(name = "AdminId", referencedColumnName = "AdminId")
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private Set<Admin> admini = new HashSet<Admin>(0);

	public Agent() {
		super();
	}

	public int getIdAgent() {
		return idAgent;
	}

	public void setIdAgent(int idAgent) {
		this.idAgent = idAgent;
	}

	public String getNameAgent() {
		return agentName;
	}

	public void setNameAgent(String nameAgent) {
		this.agentName = nameAgent;
	}

	public String getDetailsAgent() {
		return agentDetails;
	}

	public void setDetailsAgent(String agentDetails) {
		this.agentDetails = agentDetails;
	}

	public int getIdAdmin() {
		return idAdmin;
	}

	public void setIdAdmin(int idAdmin) {
		this.idAdmin = idAdmin;
	}

	public Set<Admin> getAdmins() {
		return admini;
	}
}