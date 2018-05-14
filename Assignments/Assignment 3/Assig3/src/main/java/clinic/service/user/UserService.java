package clinic.service.user;

import clinic.dto.UserDto;
import clinic.entity.User;

import java.util.List;

public interface UserService {

    void saveUser(UserDto userDto);
    boolean updateUser(UserDto userDto);
    List<UserDto> findAll();
    boolean removeUser(String username);
    List<User> findByRole(String role);
    User findById(long id);
}
