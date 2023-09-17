package com.javalabs.userfilemanager.exception;

/**
 * PersonExists Exception
 * 
 * @author Alexandre Tavares - JavaLabs
 * @since Feb 2021
 * 
 */
public class PersonExistsException extends Throwable {

	private static final long serialVersionUID = 4167206872810410602L;

	public PersonExistsException(final String message) {
        super(message);
    }

}
