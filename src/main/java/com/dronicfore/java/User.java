package com.dronicfore.java;

import java.io.Serializable;
import java.net.InetAddress;
import java.util.Calendar;
import java.util.UUID;
import java.net.ConnectException;
import java.net.URL;
import java.net.URLConnection;

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
 * @param <T> The user to represent.
 * 
 * @see Serializable
 *
 * @author Moses Katsina
 */
public class User<T extends User> extends Person implements Serializable, Comparable<T> {

    private CharSequence myName = null;
    private String myID = null;

    /**
     * Creates a User.
     *
     * @param userName The name of the User.
     * @param userID The User ID.
     *
     * @throws IllegalArgumentException If an argument contains no value.
     */
    public User(CharSequence userName, String userID) {
        if(userName == null || userName.toString().isEmpty()) throw new IllegalArgumentException("A User name is required");
        if(userID == null || userID.isEmpty()) throw new IllegalArgumentException(this+" does not have an ID, Please provide one");

        this.myName = userName;
        this.myID = userID;
    }

    /**
     * Creates a User with generated ID.
     * @param userName The name of the User.
     */
    public User(CharSequence userName) {
        this(userName, UUID.randomUUID().toString());
    }

    /**
     * Creates a User representing the given InetAddress.
     *
     * @param address The InetAddress.
     */
    public User(InetAddress address) {
        this(address.getHostName(), address.getHostAddress());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public CharSequence getName() {
        return this.myName;
    }
    
    /**
     * A Unique ID differentiating this user from other users.
     *
     * @return This User ID.
     *
     * @see #hashCode()
     */
    public String getID() {
        return this.myID;
    }

    /**
     * @return My Current Time.
     */
    protected Calendar getCalendar() {
        return Calendar.getInstance();
    }

    /**
     * @return true If the User has connected or has an active internet connection.
     */
    public boolean hasNetworkConnection() {
        try {
            URL url = new URL("https://www.google.com"); // throws MalformedURLException
	    URLConnection urlConnection = url.openConnection(); // throws IOException
	    urlConnection.setConnectTimeout(1);
	    urlConnection.connect(); // throws IOException
	    return true; // connected
	} catch (ConnectException e) {
	    return true; // connected
	} catch (Exception e) {
	    return false; // not connected
	}
    }

    /**
     * Tests If both users are the same.
     *
     * @return true If the invoking {@code User} is equal to that given <b>user</b>
     * object, otherwise false.
     */
    @Override
    public final boolean equals(Object user) {
        return user instanceof User && user.hashCode() == this.hashCode();
    }

    /**
     * @return The unique {@link Object#hashCode()} representation of this user.
     *
     * @see #getID()
     */
    @Override
    public final int hashCode() {
        return this.getID().hashCode();
    }

    /**
     * Calling this method is the same as calling {@link #getName()}.
     * @return The name of this user.
     */
    @Override
    public String toString() {
        return this.getName().toString();
    }

    /**
     * Compares the User by name.
     */
    @Override
    public int compareTo(T user) {
        return this.getName().toString().compareTo(user.getName().toString());
    }
}
