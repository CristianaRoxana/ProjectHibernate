package com.booking.persistence.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="admin")
public class Admin implements Serializable{
	private static final long serialVersionUID = 1L;
	//private Set<Agent> agent = new HashSet<Agent>(0);	
    @Id
    @Column(name="AdminId")
    @GeneratedValue(strategy=GenerationType.AUTO)
    private int id;
 
    @Column(name="Email")
    private String email;
 
    @Column(name="Password")
    private String pass;
 
    
 
    public int getIdAdmin() {
        return id;
    }
 
    public void setIdAdmin(int id) {
        this.id = id;
    }
 
    public String getEmailAdmin() {
        return email;
    }
 
    public void setEmailAdmin(String email) {
        this.email = email;
    }
 
    public String getPasswordAdmin() {
        return pass;
    }
 
    public void setPasswordAdmin(String pass) {
        this.pass = pass;
    }
    public Admin() {
    	super();
    }

   
  
    @Override
    public String toString() {
        return "Admins Details= Id: " + this.id + ", Email: " + this.email + ", Password: " + this.pass;
    }
}

