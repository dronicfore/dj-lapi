package com.dronicfore.java;

// (This class was formerly kept in the "package com.dronicfore.java.humanoid.Robot;")

import java.io.File;
import java.io.FileInputStream;
import java.util.Calendar;
import java.util.Collection;
import java.util.Map;

/**
 * A Robot is an {@link Object} that can do <b>anything!</b> for you <b>:)</b> .
 *
 * <h1>And Guess What!</h1>
 *
 * You may use {@link #comeHere()} to call this robot from <b>anywhere! at anytime!</b> in your code.
 *
 * <p>
 * A Robot represents servant in a project created by YOU or Someone
 * just to finally highlight important parts in the 'Source Code' or 'API'
 * and satisfy the users (programmers) outside that may interact with them.
 * </p>
 *
 * <b>Subclasses may Override {@link #comeHere()} to return their own kind of static
 * {@link #comeHere() Robot#comeHere()} instance</b>.
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
     * The single instance of this {@link Robot}.
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
    public static Robot comeHere() {
        return me != null ? me : (me = new Robot());
    }

    /**
     * For example, You can use this to animate or simulate the process of an Object.
     *
     * <p>
     * This spawns another {@link Thread} to handle the given code.
     * </p>
     *
     * <ul>
	 *
     * <li>The Thread dies automatically when {@link Runnable#run()} execution is completed
     * or when the invoking Program terminates!
	 * </li>
     *
     * <ul>
	 * <li>You should call {@link Thread#interrupt() Thread.currentThread().interrupt()} for
     * a given condition inside {@link Runnable#run() run()}
     * If and only if you want that running Thread to be killed immediately.
	 * </li>
	 * </ul>
     *
     * @param wait How long to delay in background before the given <b>code</b>
     * executes (in milliseconds).
     * Passing a value of {@code 0} (zero) means no delay it should be done immediately.
     *
     * @param code The code that will run.
     */
    public void doInBackground(final long wait, final Runnable code) {
        new Thread(code) {
            @Override
            public void run() {
                try {
                    sleep(wait);
                    super.run();
                } catch (InterruptedException e) {
					// we should'nt do anything here when interrupted exception was caught on this Thread
                    e.printStackTrace();
                }
            }
        }.start();
    }

    /**
     * <p>
     * <b>An operation that sends this Robot to a Folder in your computer.</b>
     * </p>
     *
     * Use {@link FileInputStream}(s) to read a File in that folder.
     *
     * @param folder The File this Robot should enter.
     *
     * @return The {@link File} this robot was sent to.
     *
     * @see File
     * @see File#createTempFile(String, String)
     */
    public File enter(File folder, String... continueWithPath) {
        // initialize a root reference to return if (continueWithPath[].length == 0)
        String pathString = "";

        // This loop will only execute if (continueWithPath[].length > 0)! (or was provided)
        for (String v: continueWithPath) {
            // modify pathString since continueWithPath was provided
            // pathString = pathString+"/"+"v";
            // pathString += "/"+"v";
            pathString = pathString.concat(File.separatorChar+v);
        }

        return new File(folder, pathString);
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
     * @throws IllegalArgumentException If object is the same robot.
     *
     * @see Collection
     * @see Map
     * @see Calendar
     * @see Thread
     */
    public <Object> Object goTo(Object object) {
        if(this == object) throw new IllegalArgumentException();
        return object;
    }

    /*
     * <b>Yay! I'm here So what can i do for you again? <i>¯\_(ツ)_/¯</i></b>.
     */
//    public Robot then(Runnable... continueWithAction) {
        // This loop will only execute if (continueWithAction[].length > 0)! (or was provided)
//        for (Runnable v: continueWithAction) {
            // invoke each runnable run() method on continueWithAction[] one by one
//            v.run();
//        }
//        return this;
//    }

}

// Whew!! This little code wasn't easy at ALL!! :)
