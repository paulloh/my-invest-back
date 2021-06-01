package br.com.myinvest.myinvest.domain;

import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class InvestmentResponse {

    private Long code;

    private String activeCode;

    private Double quoteValue;

    private Integer quotesQuantity;

    private LocalDate purchaseDate;

    private String category;
}
