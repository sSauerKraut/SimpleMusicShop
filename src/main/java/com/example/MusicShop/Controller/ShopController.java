package com.example.MusicShop.Controller;

import com.example.MusicShop.Entity.Instrument;
import com.example.MusicShop.Service.ShopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ShopController {

    @Autowired
    private ShopService shopService;

    //display list of instruments in database
    @GetMapping("/")
    public String viewHome(Model model) {
        model.addAttribute("listInstruments", shopService.getAllInstruments());
        return "index";
    }

    @GetMapping("/newProduct")
    public String newProduct(Model model) {
        Instrument instrument = new Instrument();
        model.addAttribute("instrument", instrument);
        return "new_product";
    }

    @PostMapping("/saveProduct")
    public String saveProduct(@ModelAttribute("instrument") Instrument instrument) {
        shopService.saveInstrument(instrument);
        return "redirect:/";
    }

    @GetMapping("/updateProduct/{id}")
    public String updateProduct(@PathVariable(value = "id") long id, Model model) {
        Instrument instrument = shopService.getInstrumentById(id);
        model.addAttribute("instrument", instrument);
        return "update_product";
    }

    @GetMapping("/deleteProduct/{id}")
    public String deleteProduct(@PathVariable(value = "id") long id) {
        this.shopService.deleteInstrumentById(id);
        return "redirect:/";
    }
}
