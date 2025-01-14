package com.ach.app;

import com.ach.app.controller.VehicleController;
import com.ach.app.controller.implement.VehicleControllerImplement;
import com.ach.app.dto.auth.GearChangeRequestDto;
import com.ach.app.entity.AutomaticCar;
import com.ach.app.entity.FreightTrain;
import com.ach.app.entity.ManualCar;
import com.ach.app.entity.PassangerTrain;
import com.ach.app.entity.Vehicle;
import com.ach.app.service.VehicleService;
import com.ach.app.service.implement.VehicleServiceImplement;

public class App {

	public static void main(String[] args) {
		VehicleService vehicleService = new VehicleServiceImplement();
		VehicleController vehicleController = new VehicleControllerImplement(vehicleService);
		
		Vehicle manualCar = new ManualCar("10가 1234", "blue", false, 0);
		Vehicle automaticCar = new AutomaticCar("10가 1234", "blue", false);
		Vehicle passangerTrain = new PassangerTrain("KTX001", "서울", "부산", false, 200);
		Vehicle freightTrain = new FreightTrain("Cargo001", "부산", "구미", true, 100.0);

		GearChangeRequestDto requestDto = new GearChangeRequestDto();
		vehicleController.gearChange(requestDto, manualCar);
		System.out.println(((ManualCar) manualCar).getGear());
	}

}
