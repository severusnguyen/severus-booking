package severusnguyen.severusbooking.service.imp;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import severusnguyen.severusbooking.dto.EventDTO;

import java.util.List;

public interface EventServiceImp {
    List<EventDTO> getHomeEvent();
    boolean insertEvent( MultipartFile file,
                         String title,
                         String subtitle,
                         String description,
                         double price);
}
