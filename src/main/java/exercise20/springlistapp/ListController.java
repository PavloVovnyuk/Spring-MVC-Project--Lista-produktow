package exercise20.springlistapp;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Controller
public class ListController {
    ListService listService = new ListService();


    @PostMapping("/createProd")
    public String createProduct(@RequestParam(name = "price") int price, @RequestParam(name = "name") String name) {
        Product product = new Product(name, price);
        listService.addProd(product);
        return "products";
    }
    @GetMapping("/")
    public String showForm(){
        return "form";
    }


    @GetMapping("/list")
    public String shovList(Model model) {
        List list = listService.getList();
        model.addAttribute("listAtrr", list);
        int priseSum = listService.priceSum();
        model.addAttribute("suma", priseSum);

        return "shovProduct";
    }

    @GetMapping("/tablica")
    public String tableList(Model model) {
        List list = listService.getList();
        model.addAttribute("arrayAtribute", list);
        int priseSum = listService.priceSum();
        model.addAttribute("suma", priseSum);
        return "shovArray";
    }


}



