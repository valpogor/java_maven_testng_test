package oop;

import common.Utility;
import org.openqa.selenium.By;
import org.testng.annotations.Test;
import pages.LoginPage;

public class StaticPolymorphism_OOP extends LoginPage{
    class Bird {
        public void fly() {
            System.out.println("The bird is flying.");
        }
        public void fly(int height) {
            System.out.println("The bird is flying " + height + " feet high.");
        }
        public void fly(String name, int height) {
            System.out.println("The " + name + " is flying " + height + " feet high.");
        }
    }
    @Test
        public void TestBirdStaticPolym() {
            Bird myBird = new Bird();
            myBird.fly();
            myBird.fly(10000);
            myBird.fly("eagle", 10000);
    }


        public void size(String text) {
            Integer size = text.length();
            System.out.println("\n" + ANSI_CYAN + "Text contain characters : "+ size+ ANSI_RESET+"\n");
        }

    @Test
    public void TestBirdStaticPolym2() {
        size("vajfdhkajsvdfkvaskfdasvkjfdhvakjsvbk");
        size("kjbvkglkblgblibhlihblblblblblbnlbnlblblblblblkbjk");
        size("kjbvkglljblkbhlkhblhblkbl;hnl;hnlkhnkblgblibhlihblblblblblbnlbnlblblblblblkbjk");
    }
}
