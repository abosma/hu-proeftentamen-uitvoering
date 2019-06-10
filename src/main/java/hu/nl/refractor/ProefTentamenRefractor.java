package hu.nl.refractor;

public class ProefTentamenRefractor {

    private static final double productToeslag = 3.14;

    private ProductRepository productRepository;
    private CustomerRepository customerRepository;

    private Product product;
    private Customer customer;

    public double getPrice(String productId, String customerId)
    {
        product = productRepository.getProduct(productId);
        customer = customerRepository.getCustomer(customerId);

        if(product == null)
        {
            throw new NullPointerException("Product not found.");
        }

        if(customer == null)
        {
            throw new NullPointerException("Customer not found.");
        }

        return calculateProductPrice();
    }

    private double calculateProductPrice()
    {
        double productPrice = product.getPrice() * product.getVatPercentage();

        if(productHasVatAndPremiumCustomer())
        {
            productPrice += productToeslag;
        }

        return productPrice;
    }

    private boolean productHasVatAndPremiumCustomer()
    {
        return product.hasVat() && !customer.getType().equals("1");
    }

    public void setProductRepository(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public void setCustomerRepository(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }
}
