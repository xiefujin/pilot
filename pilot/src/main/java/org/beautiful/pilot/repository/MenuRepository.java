package org.beautiful.pilot.repository;

import java.util.List;

import org.beautiful.pilot.entity.Menu;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface MenuRepository extends JpaRepository<Menu, Long> {
	@Query("Select menu From Role role JOIN role.users user JOIN role.menus menu where user.username=?1")
	List<Menu> findByUsername(String username);

}
