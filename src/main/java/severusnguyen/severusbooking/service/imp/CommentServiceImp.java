package severusnguyen.severusbooking.service.imp;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import severusnguyen.severusbooking.dto.CommentDTO;

import java.util.List;

public interface CommentServiceImp {
    List<CommentDTO> getHomeComment();
    boolean insertComment( MultipartFile file,
                           String name,
                           String subject,
                           String message);
}
