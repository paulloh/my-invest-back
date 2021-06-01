package br.com.myinvest.myinvest.service;

import br.com.myinvest.myinvest.domain.Category;
import br.com.myinvest.myinvest.domain.Investment;
import br.com.myinvest.myinvest.domain.InvestmentRequest;
import br.com.myinvest.myinvest.domain.InvestmentResponse;
import br.com.myinvest.myinvest.repository.CategoryRepository;
import br.com.myinvest.myinvest.repository.InvestmentRepository;
import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class InvestmentService {

    @Autowired
    InvestmentRepository investmentRepository;

    @Autowired
    CategoryRepository categoryRepository;

    public void createNewInvestment(InvestmentRequest request){

        Category category = categoryRepository.findById(request.getCategory()).orElseThrow(RuntimeException::new);

        Investment entity = mapEntity(request);
        entity.setCategory(category);

        investmentRepository.save(entity);
    }

    public List<InvestmentResponse> getAllInvestments(){

        List<Investment> response = investmentRepository.findAll();

        return  response.stream().map(this::mapResponseInvestment).collect(Collectors.toList());
    }

    private Investment mapEntity(InvestmentRequest dto){
        ModelMapper modelMapper = new ModelMapper();

        return modelMapper.map(dto, Investment.class);
    }

    private InvestmentResponse mapResponseInvestment(Investment entity){
        ModelMapper modelMapper = new ModelMapper();

        modelMapper.addMappings(new PropertyMap<Investment, InvestmentResponse>() {

            @Override
            protected void configure() {
                String categoryName = source.getCategory().getName();
                map().setCategory(categoryName);
            }
        });

        return modelMapper.map(entity, InvestmentResponse.class);
    }

}
