package com.training.pms.model;


import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name="appointment2")
public class Appointment {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int appointmentId;
	
	private String username;
	
	private String password;
	
    private String typeOfAppointment;
    
    private Date date;
    
    private String time;
    
   
}