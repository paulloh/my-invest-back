package br.com.myinvest.myinvest.controller;

import br.com.myinvest.myinvest.domain.Category;
import br.com.myinvest.myinvest.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/category")
@CrossOrigin("http://localhost:3000")
public class CategoryController {

    @Autowired
    private CategoryRepository repository;

    @PostMapping
    public void createCategory(@RequestBody Category request){
        repository.save(request);
    }

    @GetMapping
    public ResponseEntity<List<Category>> findAllCategories(){

        return ResponseEntity.ok(repository.findAll());
    }

    @GetMapping("/{code}")
    public ResponseEntity<Category> findAllCategories(@PathVariable Long code){

        return ResponseEntity.ok(repository.findById(code).orElseThrow());
    }
}
