The Factory Method pattern

Is a creational design pattern that provides an interface for creating objects in a superclass
but allows subclasses to alter the type of objects that will be created. This pattern encapsulates
the instantiation of objects and defers their creation to subclasses, promoting loose coupling between
the client code and the classes being instantiated.

The code consists of creating an object of a Class or creating another object of another Class, because
you may want one or the other, depending on a context. Therefore there is no longer a problem of coupling
or growth, if there is a new specific construction type there will be a new intermediate class and a new
derived class that does not have a great coupling, is focused on the new type of vehicle and serves the
beginning Open / Closed, where all that remains is to compare Barbara Liskov in the context in which you are.

In summary, we have that the Factory Method is a specific case of the Template Method, that is, it is 
dedicated to the creation of new objects.

Pattern Structure:

1. Product: Defines the interface of objects created by the factory method.
2. Concrete Product: Implements the interface of the Product.
3. Creator: Declares the factory method, which returns an object of type Product.
   May include common methods that use the Product.
4. Concrete Creator: Implements the factory method to return a specific instance of the Product.
   Customizes the creation of the product.

Roles and Responsibilities:

Product:

Defines the interface of objects created by the Factory Method.
May include methods common to all concrete product classes.

Concrete Product: 

Implements the interface of the Product.
Represents different types of objects that can be created.

Creator:

Declares the factory method, which subclasses implement to create instances of Product.
May contain common code shared by all Concrete Creators.

Concrete Creator:

Implements the factory method to return a specific instance of Product.
Customizes the creation of the product.

Advantages of the Factory Method Pattern:

1. Decoupling:
   Client code using the Factory Method does not need to know the concrete classes,
   only the interface of the Product.

2. Extensibility:
   Facilitates the addition of new subclasses without modifying existing code.

3. Subclass Control:
   Allows subclasses to decide which concrete classes to instantiate, delegating the 
   responsibility of object creation to subclasses.

UML Diagram Class for this project:

      +----------------------------------------+
      |              Class  Main               |
      +----------------------------------------+
      |    + {static} void main(String[])      |
      +----------------------------------------+

      +----------------------------------------+
      |           <Interface> Price            |
      |----------------------------------------|
      | ~ double getPrice()                    |
      +----------------------------------------+
      |     ^     ^    ^
      |     |     |    |
      |     |     |    |             +--------------------+
      |     |     |    |             |   Class PriceEur   |
      |     |     |    +-------------|--------------------|
      |     |     |                  | + double getPrice()|
      |     |     |                  +--------------------+
      |     |     |
      |     |     |
      |     |     |
      |     |     |              +--------------------+
      |     |     |              |   Class PriceUsd   |
      |     |     +--------------|--------------------|
      |     |                    | + double getPrice()|
      |     |                    +--------------------+
      |     |
      |     |    
      |     |              +--------------------+
      |     |              |   Class PriceGbp   |
      |     +--------------|--------------------|
      |                    | + double getPrice()|
      |                    +--------------------+
      |
      |
      |     +----------------------------------------+
      |     |          Class PriceFactory            |
      |     |----------------------------------------|
      +--<> | ~ Price price                          |
            | - <<Create>> PriceFactory()            |
            | + <<Create>> PriceFactory(String)      |
            | + double getPrice()                    |
            +----------------------------------------+


Java Code Example:

    // Product
    interface Product {
    void operation();
    }

    // Product Concrete
    class ConcreteProduct implements Product {
    @Override
    public void operation() {
    System.out.println("ConcreteProduct operation");
     }
    }

    // Creator Class Factory
    abstract class Creator {
    public abstract Product factoryMethod();

    public void someOperation() {
        Product product = factoryMethod();
        product.operation();
     }
    }

    // Creator Concrete
    class ConcreteCreator extends Creator {
    @Override
    public Product factoryMethod() {
    return new ConcreteProduct();
     }
    }

    // Client
    public class Client {
    public static void main(String[] args) {
    Creator creator = new ConcreteCreator();
    creator.someOperation();
     }
    }

-------------------------------------------------------------
UML Diagram:

                            +------------------------+
                            |       <<Interface>>    |
                            |         Product        |
                            +------------------------+
                            |  + operation()         |   <-- Encapsulation
                            +------------------------+
                            ^
                            |
                            +------------------------+
                            |       Creator          |
                            +------------------------+
                            |  + factoryMethod()     |   <-- Encapsulation
                            |  + someOperation()     |   <-- Encapsulation
                            +------------------------+
                            ^
                            |
                            +------------------------+
                            | <<ConcreteClass>>      |
                            | ConcreteProduct        |
                            +------------------------+
                            |  + operation()         |   <-- Encapsulation
                            +------------------------+

                            +------------------------+
                            | <<ConcreteClass>>      |
                            | ConcreteCreator        |
                            +------------------------+
                            |  + factoryMethod()     |   <-- Encapsulation
                            +------------------------+

                            +------------------------+
                            |      Client            |
                            +------------------------+
                            |  + main()              |   <-- Encapsulation
                            +------------------------+

In this ASCII UML diagram, I have marked the methods that represent encapsulation with the + symbol.
These methods are part of interfaces or concrete classes, and their public visibility indicates how 
other components of the system can interact with them. Encapsulation reflects the idea of hiding 
internal details and exposing only the public interface necessary for the system to function.

The encapsulation in the Factory Method pattern is highlighted through the interfaces and classes. 
The Product interface encapsulates the operation that concrete products must provide. The factoryMethod
in the Creator encapsulates the details of creating products, and the someOperation method in the 
Creator encapsulates the usage of the product.

The concrete classes, ConcreteProduct and ConcreteCreator, encapsulate the implementation details of 
the product and the creation process, respectively. Clients interact with the system through the public
interfaces, and the internal complexities are encapsulated within the concrete classes.

In summary, encapsulation in the Factory Method pattern allows for the hiding of implementation details,
exposing only the necessary interfaces for interaction. This promotes a clear separation of concerns and
enhances the flexibility and maintainability of the codebase.


------------------------------------------------------------------------
In the case of a graphical user interface or console generator, we have a Class that is going to 
start a graphical interface or a text interface, because there are clients who want it to be 
displayed in one way and others want it in another. That is to say that we have a Class that has 
an interface and a business or application logic and then in the derived Classes the one that 
starts with graphics new vistaGrafica() while the other will do newvistaTexto() and then I already
have two systems, the business It is common to both and everything is perfect and the graphic 
launcher will be in the graphic package and the text launcher will be in the text package. I can 
deploy one or both to a client, the point is that I have flexibility...





