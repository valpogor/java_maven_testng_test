package oop;
//    Abstraction

import org.testng.annotations.Test;
import pages.LoginPage;

public class Abstraction_OOP extends LoginPage{
    abstract class Animal {
        // abstract methods
        abstract void move();

        abstract void eat();

        // concrete method
        void label() {
            System.out.println("Animal's data:");
        }
    }
    class Bird extends Animal {
        void move() {
            System.out.println("Moves by flying.");
        }
        void eat() {
            System.out.println("Eats birdfood.");
        }
    }

    class Fish extends Animal {
        void move() {
            System.out.println("Moves by swimming.");
        }
        void eat() {
            System.out.println("Eats seafood.");
        }
    }
    @Test
    public void TestBird() {
        Animal myBird = new Bird();
        myBird.label();
        myBird.move();
        myBird.eat();
    }
    @Test
    public void TestFish() {
        Animal myFish = new Fish();
        myFish.label();
        myFish.move();
        myFish.eat();
    }
}
