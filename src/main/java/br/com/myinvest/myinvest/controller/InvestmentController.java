package br.com.myinvest.myinvest.controller;

import br.com.myinvest.myinvest.domain.Investment;
import br.com.myinvest.myinvest.domain.InvestmentRequest;
import br.com.myinvest.myinvest.domain.InvestmentResponse;
import br.com.myinvest.myinvest.repository.InvestmentRepository;
import br.com.myinvest.myinvest.service.InvestmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/investment")
@CrossOrigin("http://localhost:3000")
public class InvestmentController {

    @Autowired
    private InvestmentRepository repository;

    @Autowired
    InvestmentService service;


    @PostMapping
    public void createInvestment(@RequestBody InvestmentRequest request){

        service.createNewInvestment(request);
    }

    @GetMapping
    public ResponseEntity<List<InvestmentResponse>> searchAllInvestments(){

        return ResponseEntity.ok(service.getAllInvestments());
    }

    @GetMapping("/{code}")
    public ResponseEntity<Investment> findInvestmentById(@PathVariable Long code){

        return ResponseEntity.ok(repository.findById(code).orElseThrow());
    }

    @DeleteMapping("/{code}")
    public void deleteInvestment(@PathVariable Long code){

        repository.deleteById(code);
    }

}
