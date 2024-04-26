package com.jsp.jdbc_project_architecture_with_prepared_statement.dto;

public class Phone {
	
	private int id;
	private String name;
	private long imeino;
	private String ram;
	private String camera;
	private String color;
	
	
	public Phone() {
		super();
	}


	public Phone(int id, String name, long imeino, String ram, String camera, String color) {
		super();
		this.id = id;
		this.name = name;
		this.imeino = imeino;
		this.ram = ram;
		this.camera = camera;
		this.color = color;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public long getImeino() {
		return imeino;
	}


	public void setImeino(long imeino) {
		this.imeino = imeino;
	}


	public String getRam() {
		return ram;
	}


	public void setRam(String ram) {
		this.ram = ram;
	}


	public String getCamera() {
		return camera;
	}


	public void setCamera(String camera) {
		this.camera = camera;
	}


	public String getColor() {
		return color;
	}


	public void setColor(String color) {
		this.color = color;
	}


	@Override
	public String toString() {
		return "Phone [id=" + id + ", name=" + name + ", imeino=" + imeino + ", ram=" + ram + ", camera=" + camera
				+ ", color=" + color + "]";
	}
}
