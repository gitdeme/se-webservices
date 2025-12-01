package org.wldu.webservices.repositories;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.wldu.webservices.enities.CourseEntity;

@Repository
public interface CourseRepository extends JpaRepository<CourseEntity, String> {
}
