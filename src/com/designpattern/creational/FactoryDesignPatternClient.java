package com.designpattern.creational;

public class FactoryDesignPatternClient {
	public static void main(String []args){
		TravelAgency travelAgency=FactoryClass.getVehicle("Car");
		System.out.println(travelAgency.getType());
		TravelAgency travelAgencyTraveller=FactoryClass.getVehicle("Traveller");
		System.out.println(travelAgencyTraveller.getType());
	}
	
	
}

class FactoryClass {

	public static TravelAgency getVehicle(String type) {
		if ("car".equalsIgnoreCase(type)) {
			return new Car();
		} else if ("traveller".equalsIgnoreCase(type)) {
			return new Traveller();
		} else {
			return null;
		}
	}

}

interface TravelAgency {

	String getType();

}

class Car implements TravelAgency {

	@Override
	public String getType() {
		return "Car";
	}

}

class Traveller implements TravelAgency {

	@Override
	public String getType() {
		return "Traveller";
	}
}
