package com.designpattern.creational;

/**
 * It gives us family of objects.
 * 
 * 
 */
public class AbstractFactoryPatternClient {
	public static void main(String[] args) {
		@SuppressWarnings("rawtypes")
		AbstractFactory abstractFactory = AbstractFactoryProvider.getAbstractFactory("victorian");
		VictorianFurniture victorianFurniture = (VictorianFurniture) abstractFactory.getFurnitureType("chair");
		System.out.println(victorianFurniture.getItem());

	}

}

class AbstractFactoryProvider {
	public static AbstractFactory getAbstractFactory(String type) {
		if ("victorian".equals(type)) {
			return new VictorianFurnitureFactory();
		}
		if ("mordern".equalsIgnoreCase(type)) {
			return new ModernFurnitureFactory();
		} else {
			return null;
		}
	}
}

interface AbstractFactory<T> {
	T getFurnitureType(String type);
}

class VictorianFurnitureFactory implements AbstractFactory<VictorianFurniture> {

	@Override
	public VictorianFurniture getFurnitureType(String type) {
		if ("chair".equalsIgnoreCase(type)) {
			return new VictorianChair();
		} else if ("Table".equalsIgnoreCase(type)) {
			return new VictorianTable();
		} else {
			return null;
		}
	}

}

interface VictorianFurniture {
	String getItem();
}

class VictorianTable implements VictorianFurniture {

	@Override
	public String getItem() {
		return "VictorianTable";
	}

}

class VictorianChair implements VictorianFurniture {

	@Override
	public String getItem() {
		return "VictorianChair";
	}

}

class ModernFurnitureFactory implements AbstractFactory<ModernFurniture> {
	@Override
	public ModernFurniture getFurnitureType(String type) {
		if ("chair".equalsIgnoreCase(type)) {
			return new ModernChair();
		} else if ("Table".equalsIgnoreCase(type)) {
			return new ModernTable();
		} else {
			return null;
		}
	}
}

interface ModernFurniture {
	String getItem();
}

class ModernTable implements ModernFurniture {

	@Override
	public String getItem() {
		return "ModernTable";
	}

}

class ModernChair implements ModernFurniture {

	@Override
	public String getItem() {
		return "ModernChair";
	}

}
