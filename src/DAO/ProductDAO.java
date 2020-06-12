package DAO;

import DBConnection.DBConnection;
import model.Product;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ProductDAO implements IProductDAO {

    private DBConnection dbConnection;

    private static final String SELECT_ALL_PRODUCTS = "SELECT * FROM product";
    private static final String SELECT_PRODUCT = "SELECT * FROM product where productId=?";
    private static final String UPDATE_PRODUCT = "update product set name = ?,price= ?, amount =?,color=?,description=?,category where productId = ?;";
    private static final String INSERT_Product = "insert into product values (?,?,?,?,?,?)";

    public ProductDAO(DBConnection dbConnection) {
        this.dbConnection = dbConnection;
    }
    @Override
    public List<Product> getAllProduct() {
        List<Product> products = new ArrayList<>();
        try {
            Statement statement = dbConnection.getConnection().createStatement();
            ResultSet resultSet = statement.executeQuery(SELECT_ALL_PRODUCTS);
            while (resultSet.next()) {
                int id = resultSet.getInt("productId");
                String name = resultSet.getString("name");
                float price = resultSet.getFloat("price");
                int amount = resultSet.getInt("amount");
                String color = resultSet.getString("color");
                String description = resultSet.getString("description");
                String category = resultSet.getString("category");
                Product product = new Product(id, name, price, amount, color, description, category);
                products.add(product);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return products;
    }

    @Override
    public Product selectProduct(int id) {
        Product product = null;
        try {
            PreparedStatement statement = dbConnection.getConnection().prepareStatement(SELECT_PRODUCT);
            statement.setInt(1,id);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()){

                String name = resultSet.getString("name");
                float price = resultSet.getFloat("price");
                int amount = resultSet.getInt("amount");
                String color = resultSet.getString("color");
                String description = resultSet.getString("description");
                String category = resultSet.getString("category");
                product = new Product(id, name, price, amount, color, description, category);
            }
            return product;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return null;
    }

    @Override
    public void updateProduct(Product product) {
        try {
            PreparedStatement statement = dbConnection.getConnection().prepareStatement(UPDATE_PRODUCT);
            statement.setString(1, product.getName());
            statement.setFloat(2, product.getPrice());
            statement.setInt(3, product.getAmount());
            statement.setString(1, product.getColor());
            statement.setString(1, product.getDescription());
            statement.setString(1, product.getCategory());
            statement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    public void addProduct(Product product) {
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = dbConnection.getConnection().prepareStatement(INSERT_Product);
            preparedStatement.setString(1, product.getName());
            preparedStatement.setFloat(2, product.getPrice());
            preparedStatement.setInt(5, product.getAmount());
            preparedStatement.setString(4, product.getColor());
            preparedStatement.setString(3, product.getDescription());
            preparedStatement.setString(3, product.getCategory());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
