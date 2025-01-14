package com.ach.app.service;

import com.ach.app.dto.auth.GearChangeRequestDto;
import com.ach.app.entity.ManualCar;
import com.ach.app.entity.Vehicle;

public interface VehicleService {
	void gearChange(GearChangeRequestDto requestDto, Vehicle manualCar);
}
