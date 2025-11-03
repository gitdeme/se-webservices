package org.wldu.webservices.services.imp;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.wldu.webservices.enities.CategoriesEntity;
import org.wldu.webservices.repositories.CategoriesRepository;
import org.wldu.webservices.services.contracts.CategoryService;

import java.util.List;
import java.util.UUID;
@Service
public class CategoriesServiceImpl implements CategoryService {

    public CategoriesServiceImpl(CategoriesRepository categoriesRepository) {
        this.categoriesRepository = categoriesRepository;
    }

    private final CategoriesRepository categoriesRepository;
    public Page<CategoriesEntity> getCategories(String search, int page, int size, String sortBy, String sortDir) {
        Pageable pageable = PageRequest.of(page, size,
                sortDir.equalsIgnoreCase("asc") ? Sort.by(sortBy).ascending()
                        : Sort.by(sortBy).descending());
        if (search != null && !search.isEmpty()) {
            return categoriesRepository.findAll((root, query, criteriaBuilder) ->
                    criteriaBuilder.or(
                            criteriaBuilder.like(root.get("catName"), "%" + search + "%"),
                            criteriaBuilder.like(root.get("catType"), "%" + search + "%"),
                            criteriaBuilder.like(root.get("description"), "%" + search + "%")
                    ), pageable);
        } else {
            return categoriesRepository.findAll(pageable);
        }
    }


    @Override
    public CategoriesEntity getCategoryById(long id) {
        return categoriesRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Category not found"));
    }
    @Override
    public CategoriesEntity createCategory(CategoriesEntity categoriesModel) {
        return categoriesRepository.save(categoriesModel);
    }
    @Override
    public List<CategoriesEntity> getAllCategoryNames() {
        return categoriesRepository.findAll();
    }

    @Override
    public CategoriesEntity updateCategory(long id, CategoriesEntity categoriesModel) {
        CategoriesEntity existingCategory = getCategoryById(id);
        existingCategory.setCatName(categoriesModel.getCatName());
        return categoriesRepository.save(existingCategory);
    }

    @Override
    public void deleteCategory(long id) {
        categoriesRepository.deleteById(id);
    }
}
