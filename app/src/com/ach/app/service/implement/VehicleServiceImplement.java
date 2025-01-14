package com.ach.app.service.implement;

import com.ach.app.dto.auth.GearChangeRequestDto;
import com.ach.app.entity.ManualCar;
import com.ach.app.entity.Vehicle;
import com.ach.app.service.VehicleService;

public class VehicleServiceImplement implements VehicleService {
	
	@Override
	public void gearChange(GearChangeRequestDto requestDto, Vehicle manualCar) {
		((ManualCar) manualCar).setGear(requestDto.getGear());
		System.out.println("기어가 변속되었습니다.");
	}
}
