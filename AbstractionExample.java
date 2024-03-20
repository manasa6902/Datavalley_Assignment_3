/* 3. What is abstraction in java, how many ways can we implement abstraction, write proper java program and how to implement abstraction.*/

/*Abstraction: Abstraction in java is defined as a process in which we only show essential functionality or details to the user and non essential implementation details are not displayed to the user.
There are 2 ways to achieve abstraction in java they are:
1.Abstraction classes
2.Interfaces*/
 
abstract class Shape {
    public abstract double area();
  
    public void display() {
        System.out.println("This is a shape.");
    }
}
class Circle extends Shape {
    private double radius;
    
    public Circle(double radius) {
        this.radius = radius;
    }
    public double area() {
        return Math.PI * radius * radius;
    }
}
interface Vehicle {
    void start();
    void stop();
}
class Car implements Vehicle {
    public void start() {
        System.out.println("Car started.");
    }
    public void stop() {
        System.out.println("Car stopped.");
    }
}

public class AbstractionExample {
    public static void main(String[] args) {
        Shape circle = new Circle(5);
        circle.display();
        System.out.println("Area of circle: " + circle.area());
        
        Vehicle car = new Car();
        car.start();
        car.stop();
    }
}
