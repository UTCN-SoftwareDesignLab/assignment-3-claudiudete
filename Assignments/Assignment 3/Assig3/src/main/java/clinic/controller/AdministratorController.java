package clinic.controller;


import clinic.dto.PatientDto;
import clinic.dto.UserDto;
import clinic.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@Controller
public class AdministratorController {

    private UserService userService;

    @Autowired
    public AdministratorController(UserService userService)
    {
        this.userService=userService;
    }

    @GetMapping("/administratorView")
    public String showForm()
    {
        return "administratorView";
    }

    public List<String> createRoleList()
    {
        List<String> roles=new ArrayList<String>();
        roles.add("doctor");
        roles.add("administrator");
        roles.add("secretary");
        return roles;
    }

    @GetMapping("/createUser")
    public String showCreatePatient(Model model)
    {

        model.addAttribute("userDto",new UserDto());
        model.addAttribute("roles",createRoleList());
        return "createUser";
    }

    @PostMapping("crtUser")
    public String createUser(@Valid UserDto userDto, BindingResult bindingResult,Model model)
    {
        if (bindingResult.hasErrors()) {

            model.addAttribute("roles",createRoleList());
            return "createUser";
        }
        else {
            userService.saveUser(userDto);
            return "successAdmin";
        }
    }

    @GetMapping("/updateUser")
    public String showUpdatePatient(Model model)
    {
        model.addAttribute("userDto",new UserDto());
        model.addAttribute("userLst",userService.findAll());
        model.addAttribute("roles",createRoleList());
        return "updateUser";
    }
    @PostMapping("/updUser")
    public String updateUser(@Valid UserDto userDto,BindingResult bindingResult,Model model)
    {
        if (bindingResult.hasErrors()) {

            model.addAttribute("roles",createRoleList());
            model.addAttribute("userLst",userService.findAll());
            return "updateUser";
        }
        else {
            userService.updateUser(userDto);
            return "successAdmin";
        }
    }

    @GetMapping("/removeUser")
    public String showRemoveUser(Model model)
    {
        model.addAttribute("userDto",new UserDto());
        model.addAttribute("userLst",userService.findAll());

        return "removeUser";
    }

    @PostMapping("/delUser")
    public String removeUser(@ModelAttribute("username") String username)
    {
        userService.removeUser(username);
        return "successAdmin";
    }

    @PostMapping("/showUsers")
    public ModelAndView displayUsers()
    {
        List<UserDto> userDtos;

        userDtos = userService.findAll();

        ModelAndView modelAndView = new ModelAndView("showUsers");

        modelAndView.addObject("userList", userDtos);

        return modelAndView;
    }


    @GetMapping("/return")
    public String returnBack()
    {
        return "administratorView";
    }

    @GetMapping("/login")
    public String displayLogin()
    {
        return "login";
    }



}
