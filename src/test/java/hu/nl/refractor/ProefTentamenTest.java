package hu.nl.refractor;

import static org.easymock.EasyMock.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ProefTentamenTest
{
    ProductRepository productRepository;
    CustomerRepository customerRepository;
    ProefTentamen proefTentamen;

    @BeforeEach
    void initialize()
    {
        proefTentamen = new ProefTentamen();

        productRepository = mock(ProductRepository.class);
        customerRepository = mock(CustomerRepository.class);

        proefTentamen.setcRep(customerRepository);
        proefTentamen.setRepo(productRepository);
    }

    @Test
    void productHasVatCustomerIsNotTypeOneTest()
    {
        expect(productRepository.getProduct("1")).andReturn(new Product(true, 10, 1.09));
        expect(customerRepository.getCustomer("1")).andReturn(new Customer("2"));

        replay(productRepository, customerRepository);

        double returnPrice = proefTentamen.getPrice("1", "1");

        assertEquals(returnPrice, 14.04, 0.001);

        verify(productRepository, customerRepository);
    }

    @Test
    void productHasVatCustomerIsTypeOneTest()
    {
        expect(productRepository.getProduct("1")).andReturn(new Product(true, 10, 1.09));
        expect(customerRepository.getCustomer("2")).andReturn(new Customer("1"));

        replay(productRepository, customerRepository);

        double returnPrice = proefTentamen.getPrice("1", "2");

        assertEquals(returnPrice, 10.9, 0.001);

        verify(productRepository, customerRepository);
    }

    @Test
    void productHasNoVatCustomerIsNotTypeOneTest()
    {
        expect(productRepository.getProduct("2")).andReturn(new Product(false, 10, 1.00));
        expect(customerRepository.getCustomer("1")).andReturn(new Customer("2"));

        replay(productRepository, customerRepository);

        double returnPrice = proefTentamen.getPrice("2", "1");

        assertEquals(returnPrice, 10.0, 0.001);

        verify(productRepository, customerRepository);
    }

    @Test
    void productHasNoVatCustomerIsTypeOneTest()
    {
        expect(productRepository.getProduct("2")).andReturn(new Product(false, 10, 1.00));
        expect(customerRepository.getCustomer("2")).andReturn(new Customer("1"));

        replay(productRepository, customerRepository);

        double returnPrice = proefTentamen.getPrice("2", "2");

        assertEquals(returnPrice, 10, 0.001);

        verify(productRepository, customerRepository);
    }
}
