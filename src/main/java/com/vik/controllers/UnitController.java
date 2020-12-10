package com.vik.controllers;

import com.vik.dao.UnitDAO;
import com.vik.model.BaseUnit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
@RequestMapping("/units")
public class UnitController {

    private UnitDAO unitDAO;

    @Autowired
    public UnitController(UnitDAO unitDAO) {
        this.unitDAO = unitDAO;
    }

    @GetMapping
    public String index(Model model){

        model.addAttribute("units",unitDAO.index());
        return "/units/index";
    }

    @GetMapping("/{id}")
    public String info(@PathVariable("id") int id, Model model){
        if (unitDAO.show(id) == null)
            return "redirect:/units/noUnit";
        model.addAttribute("unit", unitDAO.show(id));
        return "/units/info";
    }

    @GetMapping("/new")
    public String newUnit(@ModelAttribute("unit") BaseUnit baseUnit){
        return "units/new";
    }

    @PostMapping
    public String create(@ModelAttribute("unit") @Valid BaseUnit baseUnit, BindingResult bindingResult){
        if (bindingResult.hasErrors())
            return "units/new";
        unitDAO.save(baseUnit);
        return "redirect:/units";
    }

    @GetMapping("/{id}/edit")
    public String edit(Model model, @PathVariable("id") int id){
        if (unitDAO.show(id) == null)
            return "redirect:/units/noUnit";
        model.addAttribute("unit", unitDAO.show(id));
        return "/units/edit";
    }

    @GetMapping("/noUnit")
    public String wrongId(){
        return "/units/noUnit";
    }

    @PatchMapping("/{id}")
    public String update(@ModelAttribute("unit") @Valid BaseUnit baseUnit, BindingResult bindingResult,
                         @PathVariable("id") int id){
        if (bindingResult.hasErrors())
            return "units/edit";
        unitDAO.update(id, baseUnit);
        return "redirect:/units/" + id;
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable("id") int id) {
        unitDAO.delete(id);
        return "redirect:/units";
    }
}
