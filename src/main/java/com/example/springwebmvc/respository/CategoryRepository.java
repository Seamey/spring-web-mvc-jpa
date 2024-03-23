package com.example.springwebmvc.respository;

import com.example.springwebmvc.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;


// no need to mark annotation repo again it's already know cus CrudRepo extend form Repo but if u want to mark @Repo it's ok no problem
                                            // need to dfines you class
public interface CategoryRepository extends JpaRepository<Category,Integer> {
    // it's the feature derived Query method or Auto Generated Query
    boolean existsByName(String name);
    // existsByName is strtic by field in model example if your field names ,so need use existsByNames
    // exists it's need write  that can't change
}
