package DAO;

import model.Product;

import java.util.List;

public interface IProductDAO {
    List<Product> getAllProduct();

    Product selectProduct(int id);

    void updateProduct(Product product);

    void addProduct(Product product);


}
