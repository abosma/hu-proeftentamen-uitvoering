package hu.nl.refractor;

public class Customer {

    String _id;
    String _type;

    public Customer(String type)
    {
        _type = type;
    }

    public String getType()
    {
        return _type;
    }
}
