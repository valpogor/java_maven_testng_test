package oop;

import org.testng.annotations.Test;
import pages.InterfacesOOP;
import pages.LoginPage;

//    Interfaces
public class InterfacesOOPTest extends LoginPage{
    @Test
    public static void myEagle() {
        InterfacesOOP.Eagle myEagle = new InterfacesOOP.Eagle();
        myEagle.eat();
        myEagle.sound();
        myEagle.fly();
        System.out.println("Number of legs: " + InterfacesOOP.Bird.numberOfLegs);
        System.out.println("Outer covering: " + InterfacesOOP.Bird.outerCovering);
    }
}
