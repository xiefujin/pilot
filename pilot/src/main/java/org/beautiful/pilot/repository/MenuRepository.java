package org.beautiful.pilot.repository;

import java.util.List;

import org.beautiful.pilot.entity.Menu;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MenuRepository extends JpaRepository<Menu, Long> {

	List<Menu> findByUsername(String username);

}
