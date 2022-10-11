package com.holverReto3.reto3.service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.holverReto3.reto3.model.Category;
import com.holverReto3.reto3.repository.CategoryRepository;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;
   
   public List<Category> getCategoryAll(){
        return categoryRepository.getCategoryAll();
   }
   public Optional<Category> getCategoryId(Integer id){
        return categoryRepository.getCategoryId(id);
   }

   public Category save(Category category){
    if (category.getId()==null){
        return categoryRepository.save(category);
    }
    else{
        Optional <Category> categoryAuxiliar=categoryRepository.getCategoryId(category.getId());
        if (categoryAuxiliar.isEmpty()){
            return categoryRepository.save(category);
        }
        else{
            return category;
        }
    }
}
}



