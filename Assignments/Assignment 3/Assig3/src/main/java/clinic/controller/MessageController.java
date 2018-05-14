package clinic.controller;



import clinic.webSocket.Notification;
import clinic.webSocket.OutNotification;
import clinic.entity.Patient;
import clinic.entity.User;
import clinic.service.Patient.PatientService;
import clinic.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MessageController
{
    @Autowired
    PatientService patientService;

    @Autowired
    UserService userService;

    @MessageMapping("/notification/{topic}")
    @SendTo("/topic/messages")
    public OutNotification send(@DestinationVariable("topic") String topic, Notification notification) throws Exception {
        System.out.print(notification.getPatientId());
        System.out.print(notification.getDoctorId());

        User user=userService.findById(Long.parseLong(notification.getDoctorId()));
        Patient pat=patientService.findById(Long.parseLong(notification.getPatientId()));
        return new OutNotification(pat.getName(),user.getUsername(), notification.getDateOfConsultation());
    }



}