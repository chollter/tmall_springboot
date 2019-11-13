package dao;

import org.springframework.data.jpa.repository.JpaRepository;
import pojo.Category;

public interface CategoryDAO extends JpaRepository<Category, Integer> {
}
