Write a java program, how to implement serialization for a given object. Use required classes and process to complete the serialization. for example take Customer(id, name, contactNo and address) class, use should write the java code, how to serialize Customer object to JavaObject.txt file.


import java.io.*;

class Customer implements Serializable {
    private int id;
    private String name;
    private String contactNo;
    private String address;

    public Customer(int id, String name, String contactNo, String address) {
        this.id = id;
        this.name = name;
        this.contactNo = contactNo;
        this.address = address;
    }
    public void serialize(String fileName) {
        try (ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(fileName))) {
            outputStream.writeObject(this);
            System.out.println("Serialization successful.");
        }
       catch (IOException e) {
            System.err.println("Serialization failed: " + e.getMessage());
        }
    }

}

public class SerializationExample {
    public static void main(String[] args) {
        Customer customer = new Customer(1, "Manasa", "8546545871", "Vijayawada");

        customer.serialize("JavaObject.txt");
    }
}