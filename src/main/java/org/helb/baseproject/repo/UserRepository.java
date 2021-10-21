package org.helb.baseproject.repo;

import org.helb.baseproject.model.user.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
