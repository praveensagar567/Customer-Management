package com.CustomerDetails.repository;

import com.CustomerDetails.entity.Authentication;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AuthenticationRepository extends JpaRepository<Authentication, Long> {
    Optional<Authentication> findByLoginIdAndPassword(String loginId, String password);
}
