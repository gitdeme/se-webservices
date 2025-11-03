package org.wldu.webservices.controllers;

import dto.ItemDTO;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.wldu.webservices.enities.ItemsEntity;
import org.wldu.webservices.services.imp.ItemServiceImpl;


import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
//@Slf4j
@RestController
@RequestMapping("/api/item")
public class ItemsController {

    private static final Logger log = LoggerFactory.getLogger(ItemServiceImpl.class);
    private ItemServiceImpl itemService;
    public ItemsController(ItemServiceImpl itemService) {
        this.itemService = itemService;
    }

    @PostMapping
    public ResponseEntity<ItemsEntity> createItem(@RequestBody ItemDTO request) {
        ItemsEntity created = itemService.createItems(request);
        return new ResponseEntity<>(created, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ItemsEntity> getItemById(@PathVariable UUID id) {
        ItemsEntity item = itemService.getItemsById(id);
        return ResponseEntity.ok(item);
    }

    @GetMapping("/list")
    public Map<String, Object> getAllItems(
            @RequestParam(required = false) String search,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size,
            @RequestParam(defaultValue = "name") String sortBy,
            @RequestParam(defaultValue = "asc") String sortDir,
            @RequestParam(defaultValue = "1") int draw /*added now*/ ) {
        Page<ItemsEntity> itemsNamePage = itemService.getItems(search, page, size, sortBy, sortDir);
        Map<String, Object> response = new HashMap<>();
        log.info("response object: {}", response);
        response.put("draw", draw);//added now
        response.put("data", itemsNamePage.getContent());
        response.put("recordsTotal", itemsNamePage.getTotalElements());
        response.put("recordsFiltered", itemsNamePage.getTotalElements());
        response.put("currentPage", itemsNamePage.getNumber());
        response.put("totalPages", itemsNamePage.getTotalPages());
        response.put("pageSize", itemsNamePage.getSize());

        return response;
    }

    @PutMapping("/{id}")
    public ResponseEntity<ItemsEntity> updateItem(@PathVariable UUID id, @RequestBody ItemDTO request) {
        ItemsEntity updated = itemService.updateItems(id, request);
        return new ResponseEntity<>(updated, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBranch(@PathVariable UUID id) {
        itemService.deleteItems(id);
        return ResponseEntity.noContent().build();
    }

}
