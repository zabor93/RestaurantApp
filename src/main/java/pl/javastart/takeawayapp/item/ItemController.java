package pl.javastart.takeawayapp.item;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import sun.awt.ModalExclude;

import java.util.Optional;

public class ItemController {
    private ItemRepository itemRepository;

    @Autowired
    public ItemController(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }

    @GetMapping("/danie/{name}")
    public String getItem(@PathVariable String name, Model model) {
        Optional<Item> item = itemRepository.findByNameIgnoreCase(name.replace("-", " "));
        item.ifPresent(item1 -> model.addAttribute("item", item1));
        return item.map(item1 -> "item").orElse("redirect:/");

    }


}
