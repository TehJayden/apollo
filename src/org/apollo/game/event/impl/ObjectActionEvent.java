package org.apollo.game.event.impl;

import org.apollo.game.event.Event;
import org.apollo.game.model.Position;

/**
 * An {@link Event} sent by the client that represents some sort of action on an object. Note that the actual event sent
 * by the client is one of the five object action events, but this is the event that should be intercepted (and the
 * option verified).
 * 
 * @author Graham
 */
public abstract class ObjectActionEvent extends Event {

	/**
	 * The object's id.
	 */
	private final int id;

	/**
	 * The option number (1-3).
	 */
	private final int option;

	/**
	 * The object's position.
	 */
	private final Position position;

	/**
	 * Creates a new object action event.
	 * 
	 * @param option The option number.
	 * @param id The id of the object.
	 * @param position The position of the object.
	 */
	public ObjectActionEvent(int option, int id, Position position) {
		this.option = option;
		this.id = id;
		this.position = position;
	}

	/**
	 * Gets the id of the object.
	 * 
	 * @return The id of the object.
	 */
	public int getId() {
		return id;
	}

	/**
	 * Gets the option number.
	 * 
	 * @return The option number.
	 */
	public int getOption() {
		return option;
	}

	/**
	 * Gets the position of the object.
	 * 
	 * @return The position of the object.
	 */
	public Position getPosition() {
		return position;
	}

}