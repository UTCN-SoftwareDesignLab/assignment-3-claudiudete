package clinic.repository;

import clinic.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;
import java.util.Date;
import java.util.List;

public interface UserRepository extends JpaRepository<User, Long> {

    List<User> findAllByUsername(String username);
    List<User> findAllByRole(String role);
    User findById(long id);

    @Transactional
    @Modifying
    @Query("update User u set u.password= ?1, u.role= ?2 where u.username= ?3")
    void updateUser(String password,String role,String username);

    @Transactional
    void deleteByUsername(String username);




}
