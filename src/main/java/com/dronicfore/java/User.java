package com.dronicfore.java;

// (This class was formerly kept in the "package com.dronicfore.java.social.User;")

import java.io.Serializable;

/**
 * A User is a well known {@link Person} that exists or is <b>accepted</b> to be in a platform.
 *
 * <p>
 * For example, this user could represent the sender name of a message.
 * </p>
 *
 * <b>Optional:</b> You can add the {@code transient} Java keyword on a field variable
 * written in your own {@code User} to protect sensitive information from being <b>Serialized</b>.
 * Just maybe in case someone tries to serialize your user in the future.
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
/* reservedDocs::
 * <p>
 * <b>HEY!</b> there's no way we can magically get the details of the user
 * you want without an official known approach.
 *
 * <p>
 * It will be <b>yours</b> or <b>their</b> responsibility to provide the details
 * of this user by any means (either directly or indirectly from a <b>Server</b> or coming from a <b>User Interface</b>).
 * </p>
 */
public class User extends Person implements Serializable {

    private String myName = null;
    private String myId = null;

    /**
     * Creates a User.
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
    protected String getUid() {
        return this.myId;
    }

    /**
     * Tests If both users are the same.
     *
     * @return true If the invoking {@code User} is equal to that given {@code user}</b>
     * object, otherwise false.
     */
    @Override
    public final boolean equals(Object user) {
        return user instanceof User && user.hashCode() == this.hashCode();
    }

    /**
     * @return The unique {@link Object#hashCode()} representation of this user.
     *
     * @see #getUid()
     */
    @Override
    public final int hashCode() {
        return this.getUid().hashCode();
    }

    /**
     * Calling this method is the same as calling {@link #getName()}.
     * @return The name of this user.
     */
    @Override
    public String toString() {
        return this.getName();
    }

    // Java Object Serialization starts [HERE]
//    private void writeObject(ObjectOutputStream os) throws IOException {
//        os.writeLong(this.getTimeImpl());
//        User me = this;
//        os.writeObject(me);
//        os.defaultWriteObject();
//    }

//    private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException {
//        this.fastTime = var1.readLong();
//        in.defaultReadObject();
//    }
    // @see How java.util.Date implements Serializable (In Source code)
    // Java Object Serialization ends [HERE]

}