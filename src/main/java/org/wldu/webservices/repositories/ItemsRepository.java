package org.wldu.webservices.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.wldu.webservices.enities.ItemsEntity;


import java.util.UUID;

public interface ItemsRepository extends JpaRepository<ItemsEntity, UUID> , JpaSpecificationExecutor<ItemsEntity> {
}
