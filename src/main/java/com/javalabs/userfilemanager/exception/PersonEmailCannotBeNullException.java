package com.javalabs.userfilemanager.exception;

/**
 * PersonEmailCannotBeNull Exception
 * 
 * @author Alexandre Tavares - JavaLabs
 * @since Feb 2021
 * 
 */
public class PersonEmailCannotBeNullException extends Throwable {

	private static final long serialVersionUID = 3704227096575176771L;

	public PersonEmailCannotBeNullException(final String message) {
        super(message);
    }

}