package com.dronicfore.java;

/**
 * A Person is someone you might know or see in somewhere.
 * <br>For example, Hey! who's that person? <i>¯\_(ツ)_/¯</i>.
 *
 * <h1>How To Use?</h1>
 *
 * Now this is where the {@code instanceof} Java keyword comes in handy!.. You might want to say:
 *
 * <pre>
 *     if (personObject instanceof ExpectedPerson) {
 *         // do this...
 *     }
 * </pre>
 *
 * This class was built for {@link Object}s that wants to personify or represent a
 * <a href="https://en.m.org/wiki/Person">Person</a>.
 *
 * @see User
 *
 * @author Moses Katsina
 */
public abstract class Person {

    /**
     * The name of the person.
     *
     * @return The name of this person.
     */
    protected abstract CharSequence getName();

}
