package com.dronicfore.java;

import java.io.File;
import java.io.FileInputStream;

/**
 * A Robot is an {@link Object} that can do <b>anything</b> for you <b>:)</b> .
 *
 * <h1>And Guess What!</h1>
 *
 * You may use {@link #comeHere()} to call this robot from <b>anywhere! at anytime!</b> in your code.
 *
 * <p>
 * A Robot represents servant in a project created by YOU or The Company
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
 * <i>Here's <b>The Buzzwords</b> about Robots:</i>
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
 * <br><b>Robots will make it plain!</b>
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
 * <br>That's the style of Java!
 * </li>
 * </ul>
 *
 * <p>
 * So what're you still waiting for??
 * </p>
 * Go ahead and start building yours to make our future lives easier! :)
 *
 * <h1>How Robots are named?</h1>
 *
 * For example, <b>MyCompanyNameRobot, FirebaseRobot, GoogleRobot, FacebookRobot,
 * AndroidRobot, WhatsAppRobot, TwitterRobot, YoutubeRobot,</b> and so on...
 * These are Robots solving problems related to and maintained by those companies!
 *
 * <ul>
 * <li>A Brilliant Company will have only <b>One</b> Robot that does the whole job for us.
 * <br>For example, The {@code FirebaseRobot} ;).
 * </li>
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
 * @since Jan/14/2019, 12:43 AM, GMT +1 (Morning)
 *
 * @author <a href="https://web.facebook.com/kling360">Moses Katsina</a>
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
     * The users (programmers) will use {@code comeHere()} to call a Robot.
     * </p>
     *
     * @see #comeHere()
     */
    protected Robot() {}

    /**
     * Allows you to interact with this robot.
     *
     * @return A {@link Robot}.
     * That can do <b>anything</b> on a project.
     */
    public static Robot comeHere() {
        return me != null ? me : (me = new Robot());
    }

    /**
     * For example, You can use this to <b>Animate</b> or <b>Simulate</b> the process of an Object.
     *
     * <br>
     * This spawns another {@link Thread} to run the given code.
     *
     * <ul>
     * <li>The Thread dies automatically when {@link Runnable#run()} execution is completed
     * or when the invoking Program terminates!
	 * </li>
     *
	 * <li>You should call {@link Thread#interrupt() Thread.currentThread().interrupt()} for
     * a given condition inside {@link Runnable#run() run()}
     * Only if you want that running Thread to be killed immediately.
	 * </li>
	 * </ul>
     *
     * @param delay The milliseconds to wait before the given <b>code</b> executes.
     * Passing a value of {@code 0} (zero) is the same as {@link #doInAnotherThread(Runnable)}.
     *
     * @param code The code that will run.
     * 
     * @return The executing Thread.
     */
    public Thread doInAnotherThread(final long delay, final Runnable code) {
        Thread thread = new Thread(code) {
            @Override
            public void run() {
                try {
                    sleep(delay);
                    super.run();
//                    join(delay);
                } catch (InterruptedException e) {
                    // we should not do anything here when interrupted exception was caught on this Thread
//                    e.printStackTrace();
                }
            }
        };
        thread.start();
        return thread;
    }

    /**
     * This spawns another {@link Thread} to run the given code immediately.
     *
     * <ul>
     * <li>The Thread dies automatically when {@link Runnable#run()} execution is completed
     * or when the invoking Program terminates!
     * </li>
     * </ul>
     *
     * @param code The code that will run.
     * 
     * @return The executing Thread.
     *
     * @see #doInAnotherThread(long, Runnable)
     */
    public final Thread doInAnotherThread(Runnable code) {
        return this.doInAnotherThread(0L, code);
    }

    /**
     * For example, You can only use this to <b>pause</b> or <b>resume</b> execution of a running Java Program.
     *
     * @param thread The Thread to Pause or Resume.
     *
     * @see Thread
     */
    public void doPauseOrResume(Thread thread) {
        switch (thread.getState()) {
            case RUNNABLE:
                synchronized (thread) {
                    try {
                        thread.wait();
                    } catch (InterruptedException e) {
//                        e.printStackTrace();
                    }
                }
                break;

            case WAITING:
                thread.interrupt();
                break;
        }
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
     */
    public final <Object> Object goTo(Object object) {
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
