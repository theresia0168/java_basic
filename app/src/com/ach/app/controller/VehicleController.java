package com.ach.app.controller;

import com.ach.app.dto.auth.GearChangeRequestDto;
import com.ach.app.entity.ManualCar;
import com.ach.app.entity.Vehicle;

public interface VehicleController {
	void gearChange(GearChangeRequestDto requestDto, Vehicle manualCar);
}
