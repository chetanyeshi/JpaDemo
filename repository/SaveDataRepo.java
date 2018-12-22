package com.codekul.jpaDemo6818.repository;

import com.codekul.jpaDemo6818.domain.SaveFileandData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SaveDataRepo extends JpaRepository<SaveFileandData,Integer> {
}
