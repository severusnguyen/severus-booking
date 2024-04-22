package severusnguyen.severusbooking.service.imp;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import severusnguyen.severusbooking.dto.ChefDTO;

import java.util.List;

public interface ChefServiceImp {
    List<ChefDTO> getHomeChef();
    boolean insertChef( MultipartFile file,
                        String name,
                        String position);
}
