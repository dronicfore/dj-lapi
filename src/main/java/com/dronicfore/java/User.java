package com.dronicfore.java;

import java.io.Serializable;
import java.net.InetAddress;
import java.util.Calendar;
import java.util.UUID;

/**
 * A User is a recognised {@link Person} that exists or is <b>accepted</b> to be in a platform.
 *
 * <p>
 * For example, This user could represent the sender of a message.
 * </p>
 *
 * <b>Optional:</b> You can add the {@code transient} Java keyword on a field variable
 * written in your own {@code User} to protect sensitive information from being <b>Serialized</b>.
 * Just maybe in case someone tries to Serialize your user in the future.
 *
 * <p>
 * For example:
 * <pre>public class <b>MyUser</b> extends User {
 *     // <i>MyUser details...</i>
 *     private String myNickName = "Bird Man";
 *     private <b>transient</b> String myPassword = "abc123";
 * // ...
 * }</pre>
 * </p>
 *
 * The above code syntax shows that <b>{@code MyUser}s</b> <b>password</b> will not be included
 * whenever <b>Serialization</b> takes place on the user!
 * 
 * <p>
 * <b>REMEMBER:</b> Variables that are declared as {@code transient} are not saved by the serialization facilities.
 * Also, {@code static} variables are not saved.
 * </p>
 * 
 * @see Serializable
 *
 * @author Moses Katsina
 */
public class User extends Person implements Serializable {

    private String myName = null;
    private String myId = null;

    /**
     * Creates a User.
     *
     * @param userName The name of the User.
     * @param userId The User ID.
     *
     * @throws IllegalArgumentException If an argument contains no value.
     */
    public User(String userName, String userId) {
        if(userName == null || userName.isEmpty()) throw new IllegalArgumentException("A User name is required");
        if(userId == null || userId.isEmpty()) throw new IllegalArgumentException(this+" does not have an ID, Please provide one");

        this.myName = userName;
        this.myId = userId;
    }

    /**
     * Creates a User with generated ID.
     * @param userName The name of the User.
     */
    public User(String userName) {
        this(userName, UUID.randomUUID().toString());
    }

    /**
     * Creates a User.
     *
     * @param address The Address.
     */
    public User(InetAddress address) {
        this(address.getHostName(), address.getHostAddress());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public final String getName() {
        return this.myName;
    }

    /**
     * A Unique ID differentiating this user from other users.
     *
     * @return This User ID.
     *
     * @see #hashCode()
     */
    protected String getId() {
        return this.myId;
    }

    /**
     * @return My Current Time.
     */
    protected Calendar getCurrentCalendar() {
        return Calendar.getInstance();
    }

    /**
     * Tests If both users are the same.
     *
     * @return true If the invoking {@code User} is equal to that given <b>user</b>
     * object, otherwise false.
     */
    @Override
    public boolean equals(Object user) {
        return user instanceof User && user.hashCode() == this.hashCode();
    }

    /**
     * @return The unique {@link Object#hashCode()} representation of this user.
     *
     * @see #getId()
     */
    @Override
    public int hashCode() {
        return this.getId().hashCode();
    }

    /**
     * Calling this method is the same as calling {@link #getName()}.
     * @return The name of this user.
     */
    @Override
    public String toString() {
        return this.getName();
    }

}
