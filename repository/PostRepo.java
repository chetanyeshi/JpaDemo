package com.codekul.jpaDemo6818.repository;

import com.codekul.jpaDemo6818.domain.Post1;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostRepo extends JpaRepository<Post1,Integer> {
//
//    @Query(value = "SELECT * FROM post1 WHERE city='Nagar'", nativeQuery = true)
//    List@Query("SELECT u FROM User u WHERE u.status = ?1 and u.name = ?2")
//User findUserByStatusAndName(Integer status, String name);
//
@Query(value = "SELECT * FROM post1 WHERE id = ?1 or name = ?2",nativeQuery = true)
List<Post1> findPost1ByIdOrName(Integer id, String name);

    /*@Query(value = "SELECT * FROM Post1 ORDER BY id")
    Page<Post1>findAllPost1WithPagination(Pageable pageable);*/

    @Query("SELECT u FROM Post1 u WHERE u.id=?1")
    Post1 findPost1ById(Integer id);

    @Query(value = "SELECT * FROM post1 WHERE id=?1",nativeQuery = true)
    Post1 findByPost1Id(Integer id);
}
