package com.library.dto;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import com.library.entities.Book;
import com.library.entities.Student;
import lombok.Builder;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class StudentDto {
	
		private int sId;
		@NotNull(message = "Name number can not be null")
		@NotBlank(message = "Name number can't be Blank")
		private String sName;
		@NotNull(message = "Contact number can not be null")
		@NotBlank(message = "Contact number can't be Blank")
		@Pattern(regexp = "\\d{10}$", message = " Invalid phone number ")
		private String sContact;
		@Email
		private String sEmail;
		@OneToOne
		@JoinColumn(name="bid")
		@NotNull(message = "Book can not be null")
		private Book sBook;
		
		

	}


