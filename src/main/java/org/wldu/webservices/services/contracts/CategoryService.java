package org.wldu.webservices.services.contracts;

import dto.ItemDTO;
import org.springframework.data.domain.Page;
import org.wldu.webservices.enities.CategoriesEntity;


import java.util.List;
import java.util.UUID;

public interface CategoryService {
    public Page<CategoriesEntity> getCategories(String search, int page, int size, String sortBy, String sortDir);
    CategoriesEntity getCategoryById(long id);
    List<CategoriesEntity> getAllCategoryNames();
    CategoriesEntity createCategory(CategoriesEntity categoriesModel);
    CategoriesEntity updateCategory(long id, CategoriesEntity categoriesModel);
    void deleteCategory(long id);

}
