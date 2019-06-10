package hu.nl.refractor;

import java.util.ArrayList;
import java.util.List;

public class ProductRepository implements Repository<Product>{

    private List<Product> products = new ArrayList<>();
    private int autoincrementId = 1;

    public Product getProduct(String productId)
    {
        return products.stream()
                .filter(product -> product._id.equals(productId))
                .findAny()
                .orElse(null);
    }

    @Override
    public void add(Product item) {
        if(!products.contains(item))
        {
            item._id = String.valueOf(autoincrementId);

            products.add(item);

            autoincrementId++;
        }
    }

    @Override
    public void add(Iterable<Product> items) {
        for(Product item : items)
        {
            if(!products.contains(item))
            {
                item._id = String.valueOf(autoincrementId);

                products.add(item);

                autoincrementId++;
            }
        }
    }

    @Override
    public void remove(Product item) {
        if(products.contains(item))
        {
            products.remove(item);
        }
    }
}
