package clinic.controller;


import clinic.dto.ConsultationDto;
import clinic.entity.Consultation;
import clinic.service.consultation.ConsultationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.List;

@Controller
public class DoctorController {

    private ConsultationService consultationService;


    @Autowired
    public DoctorController(ConsultationService consultationService)
    {
        this.consultationService=consultationService;
    }

    @GetMapping("/doctorView")
     public String showView()
    {
        return "doctorView";
    }

    @GetMapping("/viewConsultations")
    public ModelAndView showConsultations()
    {
        List<Consultation> consultations=consultationService.findAll();
        ModelAndView modelAndView = new ModelAndView("showConsults");
        modelAndView.addObject("consultList", consultations);
        return modelAndView;
    }

    @PostMapping("/returnDoctor")
    public String returnBack()
    {
        return "doctorView";
    }

    @GetMapping("/addMessages")
    public String showAddMessage(Model model)
    {
        List<Consultation> consultations=consultationService.findAll();
        model.addAttribute("consultation",new Consultation());
        model.addAttribute("consultList",consultations);

        return "addMessage";
    }

    @PostMapping("/addMsg")
    public String addMessage( @ModelAttribute("id") long id, @ModelAttribute("description") String description, BindingResult bindingResult, Model model)
    {

        if(consultationService.findById(id).size()==0)
        {
            List<Consultation> consultations=consultationService.findAll();
            model.addAttribute("consultation",new Consultation());
            model.addAttribute("consultList",consultations);
            return "addMessage";

        }
        else {
            consultationService.updateMessage(id, description);

            return "successDoctor";
        }
    }





}
