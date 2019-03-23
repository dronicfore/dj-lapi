package com.dronicfore.java;

// (This class was formerly kept in the "package com.dronicfore.java.humanoid.Robot;")

import java.util.Collection;
import java.util.Date;
import java.util.Map;

/**
 * A Robot is an {@link Object} that can do <b>anything!</b> for you <b>:)</b> .
 *
 * <h1>And Guess What!</h1>
 *
 * You may use {@link #comeHere()} to call this robot from <b>anywhere! or anytime!</b> in your code.
 *
 * <p>
 * A Robot represents servant in a project created by YOU or Someone
 * just to finally highlight important parts in the 'Source Code' or 'API'
 * and satisfy the users (programmers) outside that may interact with them.
 * </p>
 *
 * <b>Subclasses may Override {@link #comeHere()} to return their own kind of static
 * {@code Robot#comeHere()} instance</b>.
 *
 * <br>{@link #comeHere()} is the starting point for all Robots APIs.</br>
 *
 * <p>
 * Since Java is a step/by/step programing language
 * </p>
 *
 * <p>
 * <b>MAY the {@code Robot}s BE WITH YOU AND LET THOSE {@code Robot}s DO THE JOB!</b>
 * </p>
 *
 * <h1>Why Use Robots?</h1>
 *
 * <i>Here's <b>The Buzz Words</b> about Robots:</i>
 *
 * <ul>
 * <li>Robots will <b>show the way you started!</b></li>
 * <li>Robots will give you idea on <b>where to place your next code!</b></li>
 * <li>Robots will give you idea on <b>what to do next!</b></li>
 *
 * <li>Robots are <b>easy to control</b>.</li>
 * <li>Robots will not <b>make you suffer!</b></li>
 *
 * <li>Since Java is an Object Oriented Programming Language (OOP)
 * <br><b>Robots will make it plain!</b></br>
 * </li>
 *
 * <li>Computers follow instructions, That's why you <b>Command a Robot to {@link #comeHere()}!</b></li>
 * <li>With Robots, <b>Java is Simple!</b></li>
 *
 * <li>Robots will <b>Hide Confusing Grammars</b> in your code.</li>
 *
 * <li>Some Robots will require you to talk much (writing more lines of code a.k.a boilerplate codes) before
 * they can get your job done.
 * <br>But who cares? <i>¯\_(ツ)_/¯</i> <b>Just accept the fact it must be written</b>.
 * That's the style of Java!</br>
 * </li>
 * </ul>
 *
 * <p>
 * So what're you still waiting forr??
 * </p>
 * Go ahead and start building yours to make our future lives easier! :)
 *
 * <h1>How Robots are named?</h1>
 *
 * For example, <b>MyCompanyNameRobot</b>, <b>FirebaseRobot, GoogleRobot, FacebookRobot,
 * AndroidRobot, WhatsAppRobot, TwitterRobot, YoutubeRobot,</b> and so on...
 * These are all Robots solving a lot of problems related to and maintained by those companies!
 *
 * <ul>
 * <li>A Brilliant Company will have only <b>One</b> Robot.</li>
 * For example, The <b>FirebaseRobot</b> ;).
 * </ul>
 *
 * Please do not use this class directly (unless there is a special reason for doing so).
 * You should only extend it and use that one instead.
 *
 * <p>
 * <b>Robot Keywords::::::></b>
 * <pre>
 *     Robot.comeHere()
 *     #goTo(*)
 *     #enter(*)
 *     #create(*)
 *     #doInBackground(*)
 *     #then(*)
 * </pre>
 * </p>
 *
 * <h1>WARNING!</h1>
 *
 * If you're building a low level API then please reserve these keywords
 * for those that may subclass your Robot:
 * <pre>
 *     #goTo(*)
 *     #enter(*)
 * </pre>
 *
 * But if you're smart enough, then you may come up with a unique reasonable signature ;)
 *
 * <center>
 *     <table border=2 summary="Thank Yo!">
 *         <tr>
 *             <th>------- Thank You for Reaching this Place :) -------</th>
 *         </tr>
 *     </table>
 * </center>
 *
 * @since Jan/14/2019, 12:43 AM, GMT +1 (Night)
 *
 * @author Moses Katsina
 */
/* reservedDocs::
 * <p>Since Java didn't allowed static generics,
 * For Example: {@code public static T comeHere(){...};} isn't possible.
 * But assuming they did, All you have to do is extend this Robot and you'll get the comeHere() method
 * magically returning your own Robot class instance directly for free!.
 * Well, maybe they have a good reason for not allowing that.
 * </p>
 *
 * Please See the Java Language Specification "Hiding Methods"
 * or Google "How to Override Static Methods" to learn how to override static methods.
 */
// reservedDocs:: @param <T> What type of robot.
public class Robot/*<T extends Robot>*/ {

    /**
     * A variable holding single instance of this {@link Robot}.
     */
    private static Robot me = null;

    /**
     * Robot Constructors should not be made <b>public</b> or <b>private</b>
     * unless you have a special reason for doing so.
     *
     * <p>
     * The Users (programmers) will use {@code comeHere()} to call a Robot!
     * </p>
     *
     * @see #comeHere()
     */
    /*reservedDocs::
     * To avoid confusions, only one instance of each Robot should exist in our project.
     * That's why we're making this class a Singleton, By hiding Constructors.
     * This will prevent developers (like us) from creating multiple Robots (instances) of This
     * Same Type in our projects ;).
     */
    protected Robot() {}

    /**
     * Allows you to interact with this robot.
     *
     * @return A {@link Robot}.
     * That can do <b>anything!</b> on a project.
     */
//   Before it was -> public static <R extends Robot> R comeHere() {
    public static Robot comeHere() {

        // Check if such class instance haven't been created by the class loader already. (memory managing stuffs)
//        if(me == null) {
            // since this is the First time this method is called, then we should bring this Robot to Live!!!! (instantiate).
//            me = new Robot();
//        }
//        return me;

        return me != null ? me : (me = new Robot());
    }

    /**
     * Spawns another {@link Thread} to handle the given code.
     *
     * <ul>
	 * <li>The Thread automatically ends when {@link Runnable#run()} execution
     * returns (completes) or when the invoking Program terminates!
	 * </li>
	 * </ul>
     *
     * @param butWaitTillMillis How long to wait in background before the given <b>code</b>
     * executes (in milliseconds).
     * Passing a value of {@code 0} <b>(Zero)</b> means no delay it should be done immediately.
     *
     * @param code The code that will run.
     */
    // reservedDocs:: @return {@link Robot}.
    public void doInBackground(final long butWaitTillMillis, final Runnable code/*, final boolean repeatWhenDone*/) {
        new Thread(code) {
            @Override
            public void run() {
                try {
                    sleep(butWaitTillMillis);
                    super.run();
//                    if (repeatWhenDone) run(); WARNING: This line sometimes throws java.lang.StackOverflowError. (DO NOT USE!)
//                    if (repeatWhenDone) doInBackground(this, waitTillMillis, repeatWhenDone); WARNING: This line Hangs! and never returns once execution is done. (DO NOT USE!)
//                    if (repeatWhenDone) doInBackground(code, waitTillMillis, true);
                } catch (InterruptedException e) {
					// we should'nt do anything here when interrupted exception was caught on this Thread
                    e.printStackTrace();
//                    Logger.getLogger(Robot.class.getName()).log(Level.SEVERE, null, e);
//                    Logger.getLogger(getClass().getName()).log(Level.SEVERE, null, e);
                }
            }
        }.start();

//        return this;
    }

    /**
     * <p>
     * <b>An operation that sends this Robot to an {@link Object}.</b>
     * </p>
     *
     * @param object The object this Robot will be sent to.
     * @param <Object> Specifies the type of object this Robot can be sent to.
     *
     * @return The object this Robot was sent to.
     *
     * @throws IllegalArgumentException If object refers to this same robot instance.
     *
     * @see Collection
     * @see Map
     * @see Date
     * @see Thread
     */
    public <Object> Object goTo(Object object) {
//        if(object.equals(this)) throw new UnsupportedOperationException("This robot cannot goto that Robot because they're both the same robots. Instead use the other robot directly.");
//        if(this == object) throw new UnsupportedOperationException();
        if(this == object) throw new IllegalArgumentException();
        return object;
    }

    /**
     * <b>Yay! I'm here So what can i do for you again? <i>¯\_(ツ)_/¯</i></b>.
     */
    public Robot then(Runnable... continueWithAction) {

        // This loop will only execute if (continueWithAction[].length > 0)! (or was provided)
        for (Runnable v: continueWithAction) {
            // invoke each runnable run() method on continueWithAction[] one by one
            v.run();
        }

        return this;
    }

}

// Whew!! This little code wasn't easy at ALL!! :)
