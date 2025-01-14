package com.ach.app.entity;

abstract public class Train implements Vehicle {
	private String trainNumber;
	private String departureStation;
	private String arrivalStation;
	private boolean isStart;
	
	public Train(String trainNumber, String departureStation, String arrivalStation, boolean isStart) {
		this.trainNumber = trainNumber;
		this.departureStation = departureStation;
		this.arrivalStation = arrivalStation;
		this.isStart = isStart;
	}

	public String getTrainNumber() {
		return trainNumber;
	}

	public String getDepartureStation() {
		return departureStation;
	}

	public String getArrivalStation() {
		return arrivalStation;
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
