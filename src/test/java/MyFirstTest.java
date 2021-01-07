import org.junit.Test;
import static org.junit.Assert.*;

import org.junit.Before;
import java.util.ArrayList;
import java.util.List;


public class MyFirstTest {
    //The @Test Annotation
    //The @Test annotation tells JUnit that the public void method to which it is attached can be
    // run as a test case. To run the method, JUnit first constructs a fresh instance of the class
    // then invokes the annotated method. Any exceptions thrown by the test will be reported by
    // JUnit as a failure. If no exceptions are thrown, the test is assumed to have succeeded.


    //Assertions
    //In the following code examples we will use assertions to test our code, most of these methods
    // have an optional message as a parameter but in practice the process of "finding out what's
    // wrong" usually involves enough detail that an extra message isn't going to make much difference.
    // Consider time saved by having a message vs time spent thinking of customized messages for simple
    // yes/no questions, we won't be using them in these code examples.


    //assertEquals
    //The assertEquals assertion verifies that the expected, and the actual values are equal:
    @Test
    public void testIfNamesAreEqual(){
        String name = "Jane";
        String input = "jane";

        assertEquals(name,input); //the test fails
    }

    @Test
    public void  testIfNumbersAreEqual(){
        int myNumber = 4;
        int userInput = 4;

        assertEquals(myNumber, userInput);
    }

    // When you're using floating points values a third parameter is REQUIRED (Delta) which represents a positive margin of error of decimals.
    //On StackOverFlow, you may see Delta refer to as Epsilon

    //Good idea to do this b/c of round off errors and errors due to data types
    @Test
    public void testIfChangeIsCorrect() {
        Double price = 10.0;
        Double discount = 4.5;

        //assertEquals(expected, actual, delta);

        //10 - 4.5 = 5.5; with 0 margin of error, the only way to make the test pass is if the answer is EXACTLY the same
        assertEquals(5.5, price - discount, 0); //the test will pass

        //5.5; .5 delta means we can go from 5 - 6
        assertEquals(5.1, price - discount, 0.5); //the test will pass

        //5.5; .5 delta (we can go from 5 - 6 ); the test will pass b/c 4.9 is out of the 5 - 6 range
        assertNotEquals(4.9, price - discount, 0.5); //the test will pass
    }


    //assertNotSame
    //With assertNotSame, it's possible to verify if two variables DON'T
    // refer to the same object.

    //assertSame
    // Otherwise, when we want to verify that two variables refer
    // to the same object, we can use the assertSame assertion.
    @Test
    public void testIfObjectsAreDifferent() {
        Object dog = new Object();
        Object sheep = new Object();
        Object clonedSheep = sheep;

        assertNotSame(sheep, dog); //will pass b/c they are NOT the same object

        assertSame(sheep, clonedSheep); //will pass b/c clonedSheep = sheep;
    }


    //assertArrayEquals
    //The assertArrayEquals method checks that two object arrays are equal or not. If they are not, it throws an AssertionError.
    @Test
    public void testIfArrayEquals() {
        char[] expected = {'J','u','n','i','t'};
        char[] actual = "Junit".toCharArray();

        assertArrayEquals(expected, actual); //test will pass b/c actual is converting "Junit" to a character array
    }


    //assertTrue and assertFalse
    //In case we want to verify that a certain condition is true or false, we can respectively
    // use the assertTrue assertion or the assertFalse one:
    @Test
    public void testIfGreaterOrLesserThanWorks() {

        boolean learningTDD = true;

        assertTrue(learningTDD);
        assertTrue("5 is greater than 4", 5 > 4);
        assertFalse("5 is not greater than 6", 5 > 6);
    }

    //assertNull and assertNotNull
    //The following methods are useful to check if an object has been instantiated or not.
    @Test
    public void testIfInstanceIsNull() {
        Object phone = new Object();
        Object laptop = null;

        assertNull(null);
        assertNotNull(phone);
        assertNull(laptop);
    }

    //NULL means the absence of a value;
    //      just a placeholder to denote values that are missing or that we do not know


    //The @Before Annotation
    //When writing tests, it is common to find that several tests need similar objects or variables
    // created before they can be run. Annotating a public void method with @Before causes that
    // method to be run before the @Test method. The @Before methods of superclasses will be run
    // before those of the current class. It's like a default constructor for a Plain Java Object
    // Class, and the name of the method does not really matter, but we suggest to use setUp().
    private List<String> names;

    @Before
    public void setUp(){
        this.names = new ArrayList<>();
        this.names.add("Fer");
    }

    // We can verify that the names list is not longer null because it was initialized in the setUp() method with the following test:
    @Test
    public void testIfNamesIsInitialized(){
        assertNotNull(names);
    }

    @Test
    public void testIfANameCanBeAdded(){
        assertEquals(1, this.names.size());
        this.names.add("Zach");
        assertEquals(2, this.names.size());
        assertSame("Fer", this.names.get(0));
        assertSame("Zach", this.names.get(1));
    }
}