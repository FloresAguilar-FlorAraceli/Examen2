package edu.utvt.attendance.persistence.entities;

import java.sql.Date;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity(name = "tc_Persona")
public class Persona {
		
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
		
		@Column(nullable = false, length = 50)
		private String Nombre;
		
		@Column(nullable = false)
		private int Edad;
		
		@Column(nullable = false, length = 100)
		private String Universidad;
		
		@Column(nullable = false, length = 50)
		private String Correo;
		
		@JsonFormat(pattern = "dd/MM/yyyy")
	    private Date BirthDate;
		
		@JsonIgnore
		@OneToMany(mappedBy = "persona")
		private List<Item> item; 
		
		
	}
	

