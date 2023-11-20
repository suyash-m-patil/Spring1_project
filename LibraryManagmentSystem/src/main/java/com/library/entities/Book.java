package com.library.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;


import javax.persistence.GenerationType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Builder;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Builder
public class Book {
	@Id
	@GeneratedValue(strategy =GenerationType.AUTO)
	int bId;
	String bName;
	int bPrice;
	String bAuthorName;

}
