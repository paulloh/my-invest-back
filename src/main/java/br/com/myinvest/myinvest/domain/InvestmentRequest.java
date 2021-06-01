package br.com.myinvest.myinvest.domain;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class InvestmentRequest {

    private Long code;

    private String activeCode;

    private Double quoteValue;

    private Integer quotesQuantity;

    private LocalDate purchaseDate;

    private Long category;
}
