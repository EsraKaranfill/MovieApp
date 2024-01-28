package com.esra.repository;

import com.esra.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User,Long> {
    Optional<User> findOptionalByEmailAndPassword(String email,String password);

    List<User> findAllByOrderByName();

    Boolean existsByNameIgnoreCase(String name);

    List<User> findAllByNameContainingIgnoreCase(String name);

    Optional<User> findByEmail(String email);

    @Query(value = "select * from tbl_user as u where length(u.password) > :maxLength", nativeQuery = true)
    List<User> findUsersWithLongPasswordNative(@Param("maxLength") Integer length);


    @Query("SELECT u FROM User u WHERE LENGTH(u.password) > ?1")
    List<User> findUsersWithLongPasswordJPQL(int passwordLength);

    List<User> findAllByEmailEndsWithIgnoreCase(String name);



}
