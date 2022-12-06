package com.nology.finalApi;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FinalApiRepository extends JpaRepository<User, Long> {

    @Query(value="SELECT DISTINCT id FROM user ", nativeQuery = true)
    List<Long> getDistinctIds();

    @Query(value="SELECT * FROM user ORDER BY RAND() LIMIT 1", nativeQuery = true)
    User getRandomUser();

    @Query(value="SELECT * FROM user", nativeQuery = true)
    List<User> getAllUsers();

    // DELETE
    void deleteUserById(long id);

}
