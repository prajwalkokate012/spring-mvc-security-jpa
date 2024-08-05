package com.example.demo.entity;

import lombok.Data;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Data
public class Subject {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Subject(Long id, String name, Set<Student> students) {
		super();
		this.id = id;
		this.name = name;
		this.students = students;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Set<Student> getStudents() {
		return students;
	}

	public void setStudents(Set<Student> students) {
		this.students = students;
	}

	private String name;

	@ManyToMany(mappedBy = "subjects")
	private Set<Student> students = new HashSet<>();
}
