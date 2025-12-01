package org.wldu.webservices.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.wldu.webservices.enities.CategoriesEntity;


import java.util.List;

public interface CategoriesRepository  extends JpaRepository<CategoriesEntity, Long> , JpaSpecificationExecutor<CategoriesEntity> {

}
