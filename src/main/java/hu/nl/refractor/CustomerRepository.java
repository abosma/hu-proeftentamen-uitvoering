package hu.nl.refractor;

import java.util.ArrayList;
import java.util.List;

public class CustomerRepository implements Repository<Customer>{

    private List<Customer> customers = new ArrayList<>();
    private int autoincrementId = 1;

    public Customer getCustomer(String klantId)
    {
        return customers.stream()
                .filter(customer -> customer._id.equals(klantId))
                .findAny()
                .orElse(null);
    }

    @Override
    public void add(Customer item) {
        if(!customers.contains(item))
        {
            item._id = String.valueOf(autoincrementId);

            customers.add(item);

            autoincrementId++;
        }
    }

    @Override
    public void add(Iterable<Customer> items) {
        for(Customer item : items)
        {
            if(!customers.contains(item))
            {
                item._id = String.valueOf(autoincrementId);

                customers.add(item);

                autoincrementId++;
            }
        }
    }

    @Override
    public void remove(Customer item) {
        if(customers.contains(item))
        {
            customers.remove(item);
        }
    }
}
