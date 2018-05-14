package clinic.service.user;

import clinic.mapper.UserMapper;
import clinic.dto.UserDto;
import clinic.entity.User;
import clinic.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;
    private UserMapper userMapper;

    @Autowired
    public UserServiceImpl(UserRepository userRepository)
    {
        this.userRepository=userRepository;
        this.userMapper=new UserMapper();
    }

    public void saveUser(UserDto userDto)
    {
        BCryptPasswordEncoder encoder=new BCryptPasswordEncoder();
       User u=userMapper.mapFrom(userDto);
       u.setPassword(encoder.encode(u.getPassword()));
       userRepository.save(u);
    }

    public boolean updateUser(UserDto userDto)
    {
        BCryptPasswordEncoder encoder=new BCryptPasswordEncoder();
        if(userRepository.findAllByUsername(userDto.getUsername()).size()==0)
        {
            return false;
        }
        else
        {
            userRepository.updateUser(encoder.encode(userDto.getPassword()),userDto.getRole(),userDto.getUsername());
            return true;
        }
    }

    public List<UserDto> findAll()
    {
        List<User> users=userRepository.findAll();
        List<UserDto> userDtos=new ArrayList<UserDto>();

        for(User u:users)
        {
            userDtos.add(userMapper.mapTo(u));
        }
        return userDtos;
    }

    public boolean removeUser(String username)
    {
        if(userRepository.findAllByUsername(username).size()==0)
        {
            return false;
        }
        else
        {
            userRepository.deleteByUsername(username);
            return true;
        }
    }

    public List<User> findByRole(String role)
    {
        return userRepository.findAllByRole(role);
    }

    public User findById(long id)
    {
        return userRepository.findById(id);
    }






}
