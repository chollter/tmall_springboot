package service;

import dao.CategoryDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import pojo.Category;
import until.Page4Navigator;

import java.util.List;

@Service
public class CategoryService {
    @Autowired
    CategoryDAO categoryDAO;

    public Page4Navigator<Category> list(int start, int size, int navigatePages) {
        Sort sort = new Sort(Sort.Direction.DESC, "id");
        Pageable pageable = new PageRequest(start, size,sort);
        Page pageFromJPA =categoryDAO.findAll(pageable);

        return new Page4Navigator<>(pageFromJPA,navigatePages);
    }

    public List<Category> list(){
        Sort sort = new Sort(Sort.Direction.DESC,"id"); //springboot2.x版本上会报错（sort）
        return categoryDAO.findAll(sort);
    }


    public void add(Category bean) {
         categoryDAO.save(bean);
    }

    public void delete(int id){
        categoryDAO.delete(id);
    }

    public Category getOne(int id){
        return categoryDAO.findOne(id);
    }

    public Category update(Category bean){
        return categoryDAO.save(bean);
    }
}

