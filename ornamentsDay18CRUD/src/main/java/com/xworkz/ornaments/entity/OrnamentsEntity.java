package com.xworkz.ornaments.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
@Table(name = "ornaments_table")
@NamedQuery(name ="findByName", query="select ent from OrnamentsEntity  ent where ent.name=:nam " )
@NamedQuery(name ="findAll", query="from OrnamentsEntity " )
public class OrnamentsEntity {

	@Id
	@Column(name = "o_id")
	private int id;
	@Column(name = "o_name")
	private String name;
	@Column(name = "o_function")
	private String functionDay;
	@Column(name = "o_type")
	private String type;
	@Column(name = "o_place")
	private String place;

}
