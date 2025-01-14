package com.ach.app.controller.implement;

import com.ach.app.controller.VehicleController;
import com.ach.app.dto.auth.GearChangeRequestDto;
import com.ach.app.entity.ManualCar;
import com.ach.app.entity.Vehicle;
import com.ach.app.service.VehicleService;

public class VehicleControllerImplement implements VehicleController {
	
	public final VehicleService vehicleService;

	public VehicleControllerImplement(VehicleService vehicleService) {
		this.vehicleService = vehicleService;
	}

	@Override
	public void gearChange(GearChangeRequestDto requestDto, Vehicle manualCar) {
		if(requestDto == null) {	// requestDto가 null일 경우 NullException 예외 발생
			System.out.println("requestDto is null!!!");
			return;
		}
		if(manualCar == null) {
			System.out.println("manualCar is null!!!");
			return;
		}
		if(!requestDto.validate()) {
			return;
		}
		vehicleService.gearChange(requestDto, manualCar);
	}

}
