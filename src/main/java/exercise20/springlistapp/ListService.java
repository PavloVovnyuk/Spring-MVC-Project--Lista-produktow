package exercise20.springlistapp;

import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.List;

public class ListService {
    ArrayList<Product> productList = new ArrayList<>();

    public void addProd(Product product) {
        productList.add(product);
        System.out.println(product.toString());
    }

    public List getList() {
        return productList;
    }

    public int priceSum() {
        int suma = 0;
        for (Product tmpProd : productList) {
            suma = suma + tmpProd.getPrice();
        }
        System.out.println(suma);
        return suma;
    }
}

