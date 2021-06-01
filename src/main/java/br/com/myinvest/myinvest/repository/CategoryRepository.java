package br.com.myinvest.myinvest.repository;

import br.com.myinvest.myinvest.domain.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {
}
