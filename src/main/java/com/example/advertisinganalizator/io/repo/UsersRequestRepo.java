package com.example.advertisinganalizator.io.repo;

import com.example.advertisinganalizator.io.entity.UsersRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface UsersRequestRepo extends JpaRepository<UsersRequest, Long> {

   // @Query(value = "SELECT count(*) FROM USERS_REQUESTS u where u.USER_ID = :userId", nativeQuery=true)
   Optional<Long> countByUserId(@Param("userId") String userId);

    @Query(value = "select u.session_id from users_requests u where u.user_id = :userId", nativeQuery=true)
    List<Object[]> findAllSessionIdByUserId(@Param("userId") String userId);
    //TODO need additional functionality for choose by user_id, no need to return all columns

    @Query(value = "select avg(u.bid) from users_requests u where u.user_id = :userId and u.is_win = true", nativeQuery=true)
    Optional<Double> countAvgBidByUserIdAndWinTrue(@Param("userId") String userId);

}
