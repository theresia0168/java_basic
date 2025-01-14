	package com.ach.app.entity;

public class ManualCar extends Car{
	private int gear;
	
	public ManualCar(String vin, String color, boolean isStart, int gear) {
		super(vin, color, isStart);
		this.gear = gear;
	}
	
	public int getGear() {
		return gear;
	}

	@Override
	public void accelerate() {
		System.out.println("수동 변속기 자동차가 가속합니다!");
		return;
	}

	@Override
	public void stop() {
		System.out.println("수동 변속기 자동차가 정차합니다!");
		return;
	}
	
	public void setGear(int gear) {
		this.gear = gear;
		return;
	}
}
