package com.ach.app.dto.auth;

import java.util.Scanner;

public class GearChangeRequestDto {
	private int gear;
	
	public GearChangeRequestDto() {
		Scanner scanner = new Scanner(System.in);
		this.gear = scanner.nextInt();
	}

	public int getGear() {
		return gear;
	}
	
	public boolean validate() {
		if(!isInRange()) {
			System.out.println("Gear value must be between 0 and 6.");
			return false;
		}
		return true;
	}
	
	private boolean isInRange() {
		return (this.gear>=0 && this.gear<=6);
	}
}
