package com.xworkz.ornaments.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import lombok.Data;

@Data
public class OrnamentsDTO {
	private int id;
	
	@NotBlank(message = "Name Should Be filled, Cannot be blank")
	@Size(min = 3, max = 20, message = "Name Cannot less than 3 or Greator than 20")
	private String name;

	@NotBlank(message = "Function Day Should Be filled, Cannot be blank")
	@Size(min = 3, max = 20, message = "Function Day Cannot less than 3 or Greator than 20")
	private String functionDay;

	@NotBlank(message = "Type Should be Selected")
	private String type;   //Select Options in Webpage

	@NotBlank(message = "Place Should be Selected")
	private String place;  //Select Options in Webpage

}
