package clinic.mapper;

import clinic.dto.UserDto;
import clinic.entity.User;

public class UserMapper {


    public UserDto mapTo(User user)
    {
        return new UserDto(user.getUsername(),
                user.getPassword(),
                user.getRole());

    }

    public User mapFrom(UserDto userDto)
    {
        return new User(userDto.getUsername(),
                userDto.getPassword(),
                userDto.getRole());
    }
}
