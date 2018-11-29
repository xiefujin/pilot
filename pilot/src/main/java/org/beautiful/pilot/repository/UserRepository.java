package org.beautiful.pilot.repository;

import org.beautiful.pilot.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User,Long>{
	User findOneByUsername(String username);
}
