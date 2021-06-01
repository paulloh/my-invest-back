package br.com.myinvest.myinvest.repository;

import br.com.myinvest.myinvest.domain.Investment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InvestmentRepository extends JpaRepository<Investment, Long> {
}
