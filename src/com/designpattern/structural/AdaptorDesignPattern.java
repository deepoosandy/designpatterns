package com.designpattern.structural;

/*
for reference use below urls:
https://www.geeksforgeeks.org/adapter-pattern/
https://javarevisited.blogspot.com/2016/08/adapter-design-pattern-in-java-example.html

*/

public class AdaptorDesignPattern {
	public static void main(String[] args) {
		Sparrow sparrow = new Sparrow();
		ToyDuck toyDuck = new PlasticToyDuck();

		// Wrap a bird in a birdAdapter so that it
		// behaves like toy duck
		ToyDuck birdAdapter = new BirdAdapter(sparrow);

		System.out.println("Sparrow...");
		sparrow.fly();
		sparrow.makeSound();

		System.out.println("ToyDuck...");
		toyDuck.squeak();

		// Now client wants toyduck should make sound like sparrow.
		// toy duck behaving like a bird
		System.out.println("BirdAdapter...");
		birdAdapter.squeak();

	}
}

// Adaptee
interface Bird {
	// birds implement Bird interface that allows

	void fly();

	// them to fly and make sounds adaptee interface
	void makeSound();
}

class Sparrow implements Bird {

	@Override
	public void fly() {
		System.out.println("Fly!!!");

	}

	@Override
	public void makeSound() {
		System.out.println("Chirp Chirp!!!");
	}

}

// Target interface
interface ToyDuck {

	public void squeak();
}

class PlasticToyDuck implements ToyDuck {

	@Override
	public void squeak() {
		System.out.println("Squeak ");
	}

}

class BirdAdapter implements ToyDuck {
	private Bird bird;

	public BirdAdapter(Bird bird) {
		this.bird = bird;
	}

	@Override
	public void squeak() {
		bird.makeSound();
	}

}
