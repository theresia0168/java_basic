package com.ach.app.entity;

abstract public class Car implements Vehicle {
	private String vin;
	private String color;
	private boolean isStart;

	Car(String vin, String color, boolean isStart){
		this.vin = vin;
		this.color = color;
		this.isStart = isStart;
	}
	
	public String getVin() {
		return vin;
	}

	public String getColor() {
		return color;
	}

	public boolean isStart() {
		return isStart;
	}

	@Override
	abstract public void accelerate();

	@Override
	abstract public void stop();

	@Override
	public void setStart() {
		this.isStart = !this.isStart;
		return;
	}

}
