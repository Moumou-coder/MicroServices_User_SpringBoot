package org.helb.baseproject.repo;

import org.helb.baseproject.model.user.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

   @Query("SELECT u FROM User u WHERE u.mail = ?1")
   Optional<User> findUserByMail(String mail);

}
