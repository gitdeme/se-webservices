
package org.wldu.webservices.services.imp;
import java.util.List;
import java.util.UUID;


import dto.ItemDTO;
import jakarta.persistence.criteria.Predicate;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import org.springframework.web.server.ResponseStatusException;
import org.wldu.webservices.enities.CategoriesEntity;
import org.wldu.webservices.enities.ItemsEntity;
import org.wldu.webservices.repositories.CategoriesRepository;
import org.wldu.webservices.repositories.ItemsRepository;
import org.wldu.webservices.services.contracts.ItemService;


@Service
public class ItemServiceImpl implements ItemService {
   private final CategoriesRepository categoriesRepository;

    private final ItemsRepository itemsRepository;
    public ItemServiceImpl(CategoriesRepository categoriesRepository, ItemsRepository itemsRepository) {
        this.categoriesRepository = categoriesRepository;
         this.itemsRepository = itemsRepository;
    }

    @Override
    public ItemsEntity createItems(ItemDTO request) {

        CategoriesEntity category = categoriesRepository.findById(request.getCategoryId())
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST, "Category name not found"));

        ItemsEntity item = new ItemsEntity();
        item.setName(request.getName());
     //   item.setCategory(category);
        item.setSalesCode(request.getSalesCode());
        item.setManufactureDate(request.getManufactureDate());
        item.setExpiryDate(request.getExpiryDate());
        item.setPrice(request.getPrice());
        item.setPurchasePrice(request.getPurchasePrice());
        item.setQuantityInStock(request.getQuantityInStock());
        item.setRemainingQuantity(request.getQuantityInStock());
        item.setReorder_level(request.getReorder_level());

        return itemsRepository.save(item);
    }

    @Override
    public List<ItemsEntity> getAllItems() {
        return itemsRepository.findAll();
    }

    @Override
    public ItemsEntity getItemsById(UUID id) {
        return itemsRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Medicine not found"));
    }


    @Override
    public ItemsEntity updateItems(UUID id, ItemDTO request) {

        ItemsEntity existing = itemsRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Medicine not found"));


        CategoriesEntity category = categoriesRepository.findById(request.getCategoryId())
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST, "Category not found"));
          existing.setName(request.getName());
    //    existing.setCategory(category);

        existing.setInvoiceNumber(request.getInvoiceNumber());
        existing.setSalesCode(request.getSalesCode());
        existing.setManufactureDate(request.getManufactureDate());
        existing.setExpiryDate(request.getExpiryDate());
        existing.setPrice(request.getPrice());
        existing.setPurchasePrice(request.getPurchasePrice());
        existing.setQuantityInStock(request.getQuantityInStock());

        return itemsRepository.save(existing);
    }



    @Override
    public void deleteItems(UUID id) {
        itemsRepository.deleteById(id);
    }

    @Override
    public Page<ItemsEntity> getItems(String search, int page, int size, String sortBy, String sortDir) {
        Pageable pageable = PageRequest.of(page, size,
                sortDir.equalsIgnoreCase("asc") ? Sort.by(sortBy).ascending()
                        : Sort.by(sortBy).descending());
        if (search != null && !search.isEmpty()) {
            return itemsRepository.findAll((root, query, criteriaBuilder) ->
                    criteriaBuilder.or(
                            criteriaBuilder.like(root.get("name"), "%" + search + "%"),
                            criteriaBuilder.like(root.get("genericName"), "%" + search + "%"),
                            criteriaBuilder.like(root.get("supplier"), "%" + search + "%")

                    ), pageable);
        } else {
            return itemsRepository.findAll(pageable);
        }
    }
    @Override
    public Page<ItemsEntity> getItemsByReOrderLevel(String search, int page, int size, String sortBy, String sortDir) {
        Pageable pageable = PageRequest.of(page, size,
                sortDir.equalsIgnoreCase("asc") ? Sort.by(sortBy).ascending()
                        : Sort.by(sortBy).descending());
        return itemsRepository.findAll((root, query, criteriaBuilder) -> {
            Predicate reorderPredicate = criteriaBuilder.lessThanOrEqualTo(
                    root.get("remainingQuantity"), root.get("reorder_level"));

            if (search != null && !search.isEmpty()) {
                Predicate searchPredicate = criteriaBuilder.or(
                        criteriaBuilder.like(criteriaBuilder.lower(root.get("name")), "%" + search.toLowerCase() + "%"),
                        criteriaBuilder.like(criteriaBuilder.lower(root.get("category")), "%" + search.toLowerCase() + "%")

                );
                return criteriaBuilder.and(reorderPredicate, searchPredicate);
            } else {
                return reorderPredicate;
            }
        }, pageable);
    }


    }

