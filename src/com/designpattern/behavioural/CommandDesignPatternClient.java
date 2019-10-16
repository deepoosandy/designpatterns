package com.designpattern.behavioural;

import java.util.HashMap;

/**
 * 
 * https://en.wikipedia.org/wiki/Command_pattern
 * 
 */

/*
 * In object-oriented programming, the command pattern is a behavioral design
 * pattern in which an object is used to encapsulate all information needed to
 * perform an action or trigger an event at a later time. This information
 * includes the method name, the object that owns the method and values for the
 * method parameters.
 * 
 * Four terms always associated with the command pattern are command, receiver,
 * invoker and client. A command object knows about receiver and invokes a
 * method of the receiver. Values for parameters of the receiver method are
 * stored in the command. The receiver object to execute these methods is also
 * stored in the command object by aggregation. The receiver then does the work
 * when the execute() method in command is called. An invoker object knows how
 * to execute a command, and optionally does bookkeeping about the command
 * execution. The invoker does not know anything about a concrete command, it
 * knows only about the command interface. Invoker object(s), command objects
 * and receiver objects are held by a client object, the client decides which
 * receiver objects it assigns to the command objects, and which commands it
 * assigns to the invoker. The client decides which commands to execute at which
 * points. To execute a command, it passes the command object to the invoker
 * object.
 * 
 * Using command objects makes it easier to construct general components that
 * need to delegate, sequence or execute method calls at a time of their
 * choosing without the need to know the class of the method or the method
 * parameters. Using an invoker object allows bookkeeping about command
 * executions to be conveniently performed, as well as implementing different
 * modes for commands, which are managed by the invoker object, without the need
 * for the client to be aware of the existence of bookkeeping or modes.
 * 
 * The central ideas of this design pattern closely mirror the semantics of
 * first-class functions and higher-order functions in functional programming
 * languages. Specifically, the invoker object is a higher-order function of
 * which the command object is a first-class argument.
 */
// Client

public class CommandDesignPatternClient {
	public static void main(String[] args) {
		Light lamp = new Light();
		Command switchOn = new SwitchOnCommand(lamp);
		Command switchOff = new SwitchOffCommand(lamp);
        
		Switch mySwitch = new Switch();
		mySwitch.register("on", switchOn);
		mySwitch.register("off", switchOff);

		mySwitch.execute("on");
		mySwitch.execute("off");
	}
}

/** The Command interface */
interface Command {
	void execute();
}

/** The Command for turning on the light - ConcreteCommand #1 */
class SwitchOnCommand implements Command {
	private final Light light;

	public SwitchOnCommand(Light light) {
		this.light = light;
	}

	@Override // Command
	public void execute() {
		light.turnOn();
	}
}

/** The Command for turning off the light - ConcreteCommand #2 */
class SwitchOffCommand implements Command {
	private final Light light;

	public SwitchOffCommand(Light light) {
		this.light = light;
	}

	@Override // Command
	public void execute() {
		light.turnOff();
	}
}

/** The Receiver class */
class Light {
	public void turnOn() {
		System.out.println("The light is on");
	}

	public void turnOff() {
		System.out.println("The light is off");
	}
}

/** The Invoker class */
class Switch {
	private final HashMap<String, Command> commandMap = new HashMap<>();

	public void register(String commandName, Command command) {
		commandMap.put(commandName, command);
	}

	public void execute(String commandName) {
		Command command = commandMap.get(commandName);
		if (command == null) {
			throw new IllegalStateException("no command registered for " + commandName);
		}
		command.execute();
	}
}
