package controller;

import DAO.IProductDAO;
import DAO.ProductDAO;
import DBConnection.DBConnection;
import model.Product;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "ProductServlet", urlPatterns = "/Product")
public class ProductServlet extends HttpServlet {
    IProductDAO productDAO;
    DBConnection dbConnection = DBConnection.getInstance();

    @Override
    public void init() throws ServletException {
        super.init();
        productDAO = new ProductDAO(dbConnection);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String action=request.getParameter("action");
        if (action==null){
            action="";
        }
        switch (action){
            case "update":
                editInfor(request,response);
                break;
            case "add":
                saveAddProduct(request,response);
                break;
        }
    }

    private void saveAddProduct(HttpServletRequest request, HttpServletResponse response) {
        String name=request.getParameter("name");
        Float price=Float.parseFloat(request.getParameter("price"));
        int amount=Integer.parseInt(request.getParameter("quantity"));
        String color=request.getParameter("color");
        String description=request.getParameter("description");
        String category=request.getParameter("category");
        Product product=new Product(1,name,price,amount,color,description,category);
        productDAO.addProduct(product);

    }

    private void editInfor(HttpServletRequest request, HttpServletResponse response) {

        String name=request.getParameter("name");
        Float price=Float.parseFloat(request.getParameter("price"));
        int amount=Integer.parseInt(request.getParameter("quantity"));
        String color=request.getParameter("color");
        String description=request.getParameter("description");
        String category=request.getParameter("category");
        Product product=new Product(1,name,price,amount,color,description,category);
        productDAO.updateProduct(product);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "edit":
                showEditForm(request,response);
                break;
            case "delete":

                break;
            case "search":
                searchProduct(request,response);
                break;
            case "add":
                addProduct(request,response);
                break;
            default:
                getAllProduct(request,response);
                break;

        }
    }

    private void searchProduct(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id=Integer.parseInt(request.getParameter("search"));
        Product product=productDAO.selectProduct(id);
        request.setAttribute("productSearch",product);
        RequestDispatcher dispatcher=request.getRequestDispatcher("/result_search.jsp");
        dispatcher.forward(request,response);

    }

    private void addProduct(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispatcher=request.getRequestDispatcher("/add_form.jsp");
        dispatcher.forward(request,response);
    }

    private void showEditForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id=Integer.parseInt(request.getParameter("idEdit"));
        Product product=productDAO.selectProduct(id);
        request.setAttribute("productEdit",product);
        RequestDispatcher dispatcher=request.getRequestDispatcher("/edit_form.jsp");
        dispatcher.forward(request,response);
    }

    private void getAllProduct(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Product> list=productDAO.getAllProduct();
        request.setAttribute("products",list);
        RequestDispatcher dispatcher=request.getRequestDispatcher("/home_page.jsp");
        dispatcher.forward(request,response);
    }


}

