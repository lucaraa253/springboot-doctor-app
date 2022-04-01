package com.training.pms.model;


import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
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
    
    private String doctorName;
    
    private Date date;
    
    private String time;
    
   
}