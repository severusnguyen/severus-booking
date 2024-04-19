package severusnguyen.severusbooking.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import severusnguyen.severusbooking.dto.EventDTO;
import severusnguyen.severusbooking.entity.Event;
import severusnguyen.severusbooking.repository.EventRepository;
import severusnguyen.severusbooking.service.imp.EventServiceImp;
import severusnguyen.severusbooking.service.imp.FileServiceImp;

import java.util.ArrayList;
import java.util.List;

@Service
public class EventService implements EventServiceImp {

    @Autowired
    EventRepository eventRepository;

    @Autowired
    FileServiceImp fileServiceImp;

    @Override
    public List<EventDTO> getHomeEvent() {

        List<Event> eventList = eventRepository.findAll();
        List<EventDTO> eventDTOList = new ArrayList<>();

        for (Event event : eventList) {
            EventDTO eventDTO = new EventDTO();

            eventDTO.setTitle(event.getTitle());
            eventDTO.setSubtitle(event.getSubtitle());
            eventDTO.setDescription(event.getDescription());
            eventDTO.setImage(event.getImage());
            eventDTO.setPrice(event.getPrice());

            eventDTOList.add(eventDTO);
        }

        return eventDTOList;
    }

    @Override
    public boolean insertEvent(MultipartFile file, String title, String subtitle, String description, double price) {

        boolean isInsertSuccess = false;
        try {
            boolean isSaveFileSuccess = fileServiceImp.saveFile(file);
            if (isSaveFileSuccess){
                Event event = new Event();

                event.setTitle(title);
                event.setSubtitle(subtitle);
                event.setDescription(description);
                event.setPrice(price);
                event.setImage(file.getOriginalFilename());

                eventRepository.save(event);
                isInsertSuccess = true;
            }
        }catch (Exception e){
            System.out.println("Error save event: " + e.getMessage());
        }
        return isInsertSuccess;
    }


}
