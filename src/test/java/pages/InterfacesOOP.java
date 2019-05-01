package pages;
//    Interfaces

public class InterfacesOOP extends LoginPage {
    interface Animal {
        public void eat();
        public void sound();
    }

    public interface Bird {
        int numberOfLegs = 2;
        String outerCovering = "feather";

        public void fly();
    }

    public static class Eagle implements Animal, Bird {
        public void eat() {
            System.out.println("Eats reptiles and amphibians.");
        }
        public void sound() {
            System.out.println("Has a high-pitched whistling sound.");
        }
        public void fly() {
            System.out.println("Flies up to 10,000 feet.");
        }
    }
}
