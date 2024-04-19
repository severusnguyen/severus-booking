package severusnguyen.severusbooking.service.imp;

import org.springframework.web.multipart.MultipartFile;
import severusnguyen.severusbooking.dto.MenuDTO;

import java.util.List;

public interface MenuServiceImp {
    List<MenuDTO> getHomeMenu();
    boolean insertMenu( MultipartFile file,
                        String title,
                        String subtitle,
                        String description ,
                        double price,
                        boolean special_dish ,
                        int cate_menu_id);

}
