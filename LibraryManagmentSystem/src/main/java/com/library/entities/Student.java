package com.library.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Builder;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Builder
public class Student {
	@Id
	@GeneratedValue
	private int sId;
	private String sName;
	private String sContact;
	private String sEmail;
	@OneToOne
	@JoinColumn(name="bid")
	private Book sBook;
	
	

}

