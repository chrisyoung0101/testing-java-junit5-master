package guru.springframework.sfgpetclinic.controllers;

import guru.springframework.sfgpetclinic.fauxspring.Model;
import guru.springframework.sfgpetclinic.services.VetService;

// TODO : 59
// VetController simply takes in a model and returns back a string
// Note that this is the view but intelliJ knows this is the view somehow
// maybe because we are returning "vets/index"?

public class VetController {

    private final VetService vetService;

    public VetController(VetService vetService) {
        this.vetService = vetService;
    }

    public String listVets(Model model){

        model.addAttribute("vets", vetService.findAll());

        return "vets/index";
    }
}
