package clinic.controller;

import clinic.mapper.PatientMapper;
import clinic.dto.ConsultationDto;
import clinic.dto.PatientDto;
import clinic.entity.Consultation;
import clinic.entity.Patient;
import clinic.entity.User;
import clinic.service.Patient.PatientService;
import clinic.service.consultation.ConsultationService;
import clinic.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Controller
public class SecretaryController {

    private PatientService patientService;
    private UserService userService;
    private ConsultationService consultationService;

    @Autowired
    public SecretaryController(PatientService patientService,UserService userService,ConsultationService consultationService)
    {

        this.patientService=patientService;
        this.userService=userService;
        this.consultationService=consultationService;
    }

    @GetMapping("/secretaryView")
    public String showView()
    {
        return "secretaryView";
    }

    @PostMapping("/createPatient")
    public String showCreatePatient(Model model)
    {
        model.addAttribute("patientDto",new PatientDto());
        return "createPatient";
    }

    @PostMapping("/updatePatient")
    public String showUpdatePatient(Model model)
    {
        model.addAttribute("patientDto",new PatientDto());
        model.addAttribute("patientLst",patientService.findAll());
        return "updatePatient";
    }

    @PostMapping("crtPatient")
    public String createPatient(@Valid PatientDto patientDto, BindingResult bindingResult) {
        if (bindingResult.hasErrors())
            return "createPatient";
        else {
            patientService.savePatient(patientDto);
            return "success";
        }
    }

    @PostMapping("updPatient")
    public String updatePatient(@Valid PatientDto patientDto,BindingResult bindingResult)
    {
        if (bindingResult.hasErrors())
            return "updatePatient";
        else {
            patientService.updatePatient(patientDto);
            return "success";
        }
    }

    @PostMapping("ret")
    public String returnBack()
    {
        return "secretaryView";
    }



    @PostMapping("showPatients")
    public ModelAndView getAllBooks() {

        List<PatientDto> patients;

        patients = patientService.findAll();

        ModelAndView modelAndView = new ModelAndView("showPatients");

        modelAndView.addObject("patientList", patients);

        return modelAndView;
    }

    @InitBinder
    public void initBinder(WebDataBinder binder){
        binder.registerCustomEditor(Date.class,
                new CustomDateEditor(new SimpleDateFormat("yyyy-MM-dd"), true, 10));
    }

    @GetMapping("/createConsultation")
    public String showCreateConsulatation(Model model)
    {
        PatientMapper mapper=new PatientMapper();
        List<User> doctors=userService.findByRole("doctor");
        List<Patient> pat=patientService.find();

        model.addAttribute("consultation",new ConsultationDto());
        model.addAttribute("doctorList",doctors);
        model.addAttribute("cons",new Consultation());
        model.addAttribute("patientList",pat);
        model.addAttribute("messages",new ArrayList<String>());
        return "createConsultation";
    }

   @PostMapping(value = "/crtConsultation")
    public String createConsultation(@Valid ConsultationDto consultationDto, Model model,BindingResult bindingResult)
    {



        if(bindingResult.hasErrors()) {
            List<User> doctors = userService.findByRole("doctor");
            List<Patient> pat=patientService.find();

            model.addAttribute("doctorList", doctors);
            model.addAttribute("patientList", pat);
            model.addAttribute("consultation",new ConsultationDto());
            return "createConsultation";
        }
        else
        {
            Date date=consultationDto.getDate();
            User doctor=consultationDto.getDoctor();
            if(consultationService.findByDoctorAndDate(doctor,date)!=null)
            {
                List<String> messages=new ArrayList<>();
                messages.add("Doctor is not free on this date");
                List<User> doctors = userService.findByRole("doctor");
                List<Patient> pat=patientService.find();
                model.addAttribute("consultation",new ConsultationDto());
                model.addAttribute("doctorList", doctors);
                model.addAttribute("patientList", pat);
                model.addAttribute("messages",messages);

                return "createConsultation";
            }
            else
            {
                consultationService.addConsultation(consultationDto);
                return "success";
            }
        }

    }

    @GetMapping("/removeConsultation")
    public String showRemoveConsultation(Model model)
    {
         model.addAttribute("consultList",consultationService.findAll());
         model.addAttribute("consultation",new Consultation());
         model.addAttribute("messages",new ArrayList<String>());
         return "removeConsultation";
    }

    @PostMapping("delConsult")
    public String removeConsultation(@ModelAttribute("id") long id,Model model)
    {
        if(consultationService.findById(id).size()==0)
        {
            List<String> messages=new ArrayList<String>();
            messages.add("The id does not correspond to any consultation");
            model.addAttribute("consultList",consultationService.findAll());
            model.addAttribute("consultation",new Consultation());
            model.addAttribute("messages",messages);
            return "removeConsultation";
        }
        else
        {
            consultationService.removeById(id);
            return "success";
        }
    }




















}
