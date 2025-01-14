package com.ach.app.entity;

public class FreightTrain extends Train{
	double cargoWeight;

	public FreightTrain(String trainNumber, String departureStation, String arrivalStation, boolean isStart, double cargoWeight) {
		super(trainNumber, departureStation, arrivalStation, isStart);
		this.cargoWeight = cargoWeight;
	}
	
	public double getCargoWeight() {
		return cargoWeight;
	}

	@Override
	public void accelerate() {
		System.out.println("화물 열차가 느리게 가속합니다!");
		return;
	}

	@Override
	public void stop() {
		System.out.println("화물 열차가 느리게 정차합니다!");
		return;
	}

}
