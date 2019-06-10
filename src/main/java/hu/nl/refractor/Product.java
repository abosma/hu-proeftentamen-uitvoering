package hu.nl.refractor;

public class Product {

    String _id;
    boolean _hasVat;
    double _vatPercentage;
    double _price;

    public Product(boolean hasVat, double price, double vatPercentage)
    {
        _hasVat = hasVat;
        _price = price;
        _vatPercentage = vatPercentage;
    }

    public boolean hasVat()
    {
        return _hasVat;
    }

    public double getVatPercentage()
    {
        return _vatPercentage;
    }

    public double getPrice()
    {
        return _price;
    }

}
