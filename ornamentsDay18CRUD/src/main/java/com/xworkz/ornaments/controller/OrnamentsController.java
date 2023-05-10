package com.xworkz.ornaments.controller;

import java.util.Arrays;
import java.util.List;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import javax.validation.ConstraintViolation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.xworkz.ornaments.dto.OrnamentsDTO;
import com.xworkz.ornaments.entity.OrnamentsEntity;
import com.xworkz.ornaments.repository.OrnamentsRepository;
import com.xworkz.ornaments.service.OrnamentsService;

@Controller
@RequestMapping("/")
public class OrnamentsController {
	@Autowired
	private OrnamentsService ornamentsService;

	@Autowired
	private OrnamentsRepository repository;

	@Autowired
	private EntityManagerFactory entity;

	private List<String> type = Arrays.asList("Gold", "Silver", "Plantium", "Ruby", "Diamond", "Pearl");
	private List<String> places = Arrays.asList("Banglore", "New York", "London", "Paris", "Tokyo", "Mumbai",
			"Los Angeles", "Chennai", "Bangkok", "Karachi", "Chicago", "Los Vegas");

	public OrnamentsController() {
		System.out.println("Constructor is Created in : " + this.getClass().getSimpleName());
	}

	@GetMapping("/Ornaments")
	public String onOrnaments(Model model) {
		System.out.println("Running onValentine Get Method :");
		List<String> type = Arrays.asList("Gold", "Silver", "Plantium", "Ruby", "Diamond", "Pearl");
		List<String> places = Arrays.asList("Banglore", "New York", "London", "Paris", "Tokyo", "Mumbai", "Los Angeles",
				"Chennai", "Bangkok", "Karachi", "Chicago", "Los Vegas");

		model.addAttribute("type", type);
		model.addAttribute("places", places);
		System.out.println("Violation in Ornaments Controller");
		return "Ornaments";
	}

	@PostMapping("/Ornaments")
	public String onOrnaments(Model model, OrnamentsDTO dto) {
		System.out.println("---------------------------------------------");
		System.out.println("Running onOrnaments Post method : " + dto);
		Set<ConstraintViolation<OrnamentsDTO>> violations = this.ornamentsService.validateAndSave(dto);
		if (violations.isEmpty()) {
			System.out.println("No violations found in controler, then proceding to Display Success page");
			return "DisplaySuccess";
		}
		model.addAttribute("places", places);
		model.addAttribute("type", type);
		model.addAttribute("errors", violations);
		return "Ornaments";
	}

	@GetMapping("/search")
	public String onSearch(@RequestParam int id, Model model) {
		System.out.println("Running onSearch for id : " + id);
		OrnamentsDTO dto = this.ornamentsService.findById(id);
		if (dto != null) {
			model.addAttribute("dto", dto);
		} else {
			model.addAttribute("message", "Data Not Found");
		}
		return "OrnamentsSearch";
	}

	@GetMapping("/searchbyname")
	public String onSearchByName(@RequestParam String name, Model model) {
		System.out.println("Search onSearchByName in Controller ::" + name);
		List<OrnamentsDTO> list = this.ornamentsService.findByName(name);
		model.addAttribute("list", list);

		return "NameSearch";
	}

	@GetMapping("/update")
	public String onUpdate(@RequestParam int id, Model model) {
		System.out.println("Running onUpdate() GetMapping in Controller : " + id);
		OrnamentsDTO dto = this.ornamentsService.findById(id);
		model.addAttribute("dto", dto);
		// model.addAttribute("function", functionDay);
		model.addAttribute("type", type);
		model.addAttribute("places", places);

		return "UpdateOrnaments";
	}

	@PostMapping("/update")
	public String onUpdate(OrnamentsDTO dto, Model model) {
		System.out.println("Running onUpdate() PostMapping in Controller : " + dto);
		Set<ConstraintViolation<OrnamentsDTO>> constraintViolations = this.ornamentsService.validateAndUpdate(dto);
		if (constraintViolations.size() > 0) {
			model.addAttribute("errors", constraintViolations);

		} else {
			model.addAttribute("message", "Ornaments Updated Success");
		}

		return "UpdateOrnaments";

	}

	@GetMapping("/delete")
	public String onDelete(@RequestParam int id, Model model) {
		System.out.println("Running on delete in post ");
		OrnamentsDTO dto = this.ornamentsService.deleteById(id);
		if (dto != null) {
			model.addAttribute("delete", dto);
			return "Delete";
		} else {
			model.addAttribute("message3", "Data not found");
			return "UpdateOrnaments";
		}
	}

	@GetMapping("/findAll")
	public String getAll(Model model) {
		System.out.println("Running on delete in post ");

		EntityManager manager = this.entity.createEntityManager();
		// Decide : 1)Transaction , 2) Query ?
		Query query = manager.createNamedQuery("findAll");
		//List<OrnamentsDTO> list = this.ornamentsService.findByName(name);
//			query.setParameter("nam", name); 

		List<OrnamentsEntity> list = query.getResultList();

		System.out.println(" list ++++ " + list);

		model.addAttribute("list", list);
		return "NameSearch";
	}

}
