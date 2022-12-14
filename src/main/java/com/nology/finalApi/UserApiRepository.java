package com.nology.finalApi;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserApiRepository extends JpaRepository<User, Long> {

    @Query(value="SELECT DISTINCT id FROM user ", nativeQuery = true)
    List<Long> getDistinctIds();

    @Query(value="SELECT * FROM user ORDER BY RAND() LIMIT 1", nativeQuery = true)
    User getRandomUser();

    @Query(value="SELECT * FROM user WHERE email_id=:email", nativeQuery = true)
    User getUserByEmail(@Param("email") String email);

    @Query(value="SELECT * FROM user WHERE email_id like :email OR postcode like :postcode OR address like :address", nativeQuery = true)
    List<User> getUserBySearch(@Param("email") String email, @Param("postcode") String postcode, @Param("address") String address);


    @Query(value="SELECT * FROM user WHERE date(book_date) = curdate()", nativeQuery = true)
    List<User> getUserByDate();

    @Query(value="SELECT * FROM user", nativeQuery = true)
    List<User> getAllUsers();

    // DELETE
    void deleteUserById(long id);

}
