package org.wldu.webservices.services.contracts;

import dto.ItemDTO;
import org.springframework.data.domain.Page;
import org.wldu.webservices.enities.ItemsEntity;
import java.util.List;
import java.util.UUID;
public interface ItemService {
    List<ItemsEntity> getAllItems();
    ItemsEntity createItems(ItemDTO itemDTO);
    ItemsEntity getItemsById(UUID id);

    ItemsEntity updateItems(UUID id, ItemDTO request);
    void deleteItems(UUID id);
    public Page<ItemsEntity> getItems(String search, int page, int size, String sortBy, String sortDir);

    Page<ItemsEntity> getItemsByReOrderLevel(String search, int page, int size, String sortBy, String sortDir);
}
