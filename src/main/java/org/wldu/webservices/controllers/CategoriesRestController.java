package org.wldu.webservices.controllers;


import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.wldu.webservices.enities.CategoriesEntity;
import org.wldu.webservices.services.contracts.CategoryService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/categories")

public class CategoriesRestController {

    private final CategoryService categoriesService;

    public CategoriesRestController(CategoryService categoriesService) {

        this.categoriesService = categoriesService;
    }

    @GetMapping("/list")
    public Map<String, Object> getCategories(
            @RequestParam(required = false) String search,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size,
            @RequestParam(defaultValue = "catId") String sortBy,
            @RequestParam(defaultValue = "asc") String sortDir) {
        Page<CategoriesEntity> categoryPage = categoriesService.getCategories(search, page, size, sortBy, sortDir);
        Map<String, Object> response = new HashMap<>();

        response.put("data", categoryPage.getContent());
        response.put("recordsTotal", categoryPage.getTotalElements());
        response.put("recordsFiltered", categoryPage.getTotalElements());
        response.put("currentPage", categoryPage.getNumber());
        response.put("totalPages", categoryPage.getTotalPages());
        response.put("pageSize", categoryPage.getSize());

        return response;
    }

    @GetMapping("/{id}")
    public ResponseEntity<CategoriesEntity> getCategoryById(@PathVariable Integer id) {
        CategoriesEntity category = categoriesService.getCategoryById(id);
        return ResponseEntity.ok(category);
    }

    @PostMapping("saveCategory")
    public ResponseEntity<CategoriesEntity> createCategory(@RequestBody CategoriesEntity category) {
        CategoriesEntity createdCategory = categoriesService.createCategory(category);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdCategory);
    }

    @PutMapping("/{id}")
    public ResponseEntity<CategoriesEntity> updateCategory(@PathVariable Integer id, @RequestBody CategoriesEntity category) {
        CategoriesEntity updatedCategory = categoriesService.updateCategory(id, category);
        return ResponseEntity.ok(updatedCategory);
    }

    @GetMapping

    public List<CategoriesEntity> getAll() {
        return categoriesService.getAllCategoryNames();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCategory(@PathVariable Integer id) {
        categoriesService.deleteCategory(id);
        return ResponseEntity.noContent().build();
    }
}

