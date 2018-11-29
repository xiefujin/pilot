package org.beautiful.pilot.repository;

import org.beautiful.pilot.entity.Sexual;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SexualRepository extends JpaRepository<Sexual,Long> {

}
