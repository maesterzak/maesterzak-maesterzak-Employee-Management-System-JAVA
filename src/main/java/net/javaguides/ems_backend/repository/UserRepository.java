package net.javaguides.ems_backend.repository;

import net.javaguides.ems_backend.entity.Unit;
import net.javaguides.ems_backend.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {


//    @Query("""
//    SELECT u FROM User u
//    WHERE u.username = :identifier
//       OR u.email = :identifier
//""")
    Optional<User> findByUsername(@Param("username") String identifier);

    boolean existsByUsername(String username);

    boolean existsByEmail(String email);


}
