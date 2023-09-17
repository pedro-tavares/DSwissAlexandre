package com.javalabs.userfilemanager.exception;

/**
 * PersonAuthentication Exception
 * 
 * @author Alexandre Tavares - JavaLabs
 * @since Feb 2021
 * 
 */
public class PersonAuthenticationException extends Throwable {

	private static final long serialVersionUID = 4167206872810410602L;

	public PersonAuthenticationException(final String message) {
        super(message);
    }

}
