package hu.nl.refractor;

public class ProefTentamen {

    private ProductRepository repo;
    private CustomerRepository cRep;

    public double getPrice(String pId, String klantID) {

        Product p = repo.getProduct(pId);

        Customer customer = null;

        if (klantID != null) {
            customer = cRep.getCustomer(klantID);
        }

        double onsGeheimeWinstPakker = 0.0;

        if(p.hasVat() && customer != null && !customer.getType().equals("1")) {
            //als de klant geen type 1 is (is een premium klant en
            ///het product BTW heeft dan rekenen we natuurlijk een toeslag
            onsGeheimeWinstPakker = 3.14;
        }

        return p.getPrice() * p.getVatPercentage() + onsGeheimeWinstPakker;
    }

    public void setRepo(ProductRepository repo) {
        this.repo = repo;
    }

    public void setcRep(CustomerRepository cRep) {
        this.cRep = cRep;
    }
}