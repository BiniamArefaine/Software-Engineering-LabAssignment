package miu.edu.cs.cs425.springSecurityDemo.eRegitrarSecurity.repository;

import miu.edu.cs.cs425.springSecurityDemo.eRegitrarSecurity.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
    Optional<User> findByUsername(String username);

}
