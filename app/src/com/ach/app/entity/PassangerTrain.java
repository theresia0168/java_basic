package com.ach.app.entity;

public class PassangerTrain extends Train{
	private int passengerCount;
	
	public PassangerTrain(String trainNumber, String departureStation, String arrivalStation, boolean isStart, int passengerCount) {
		super(trainNumber, departureStation, arrivalStation, isStart);
		this.passengerCount = passengerCount;
	}

	public int getPassengerCount() {
		return passengerCount;
	}

	@Override
	public void accelerate() {
		System.out.println("여객 열차가 느리게 가속합니다!");
		return;
	}

	@Override
	public void stop() {
		System.out.println("여객 열차가 느리게 정차합니다!");
		return;
	}

}
