package com.example.adoptions.dogs;

import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@Transactional
@Controller
@ResponseBody
class DogsController {

    private final DogsService dogsService;

    DogsController(DogsService dogsService) {
        this.dogsService = dogsService;
    }

    @GetMapping("/dogs")
    Collection<Dog> dogs() {
        return this.dogsService.all();
    }

    @PostMapping("/dogs/{dogId}/adoptions")
    void adopt(@PathVariable int dogId, @RequestParam String owner) {
        this.dogsService.adopt(dogId, owner);
    }
}
