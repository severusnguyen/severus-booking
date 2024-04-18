package severusnguyen.severusbooking.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import severusnguyen.severusbooking.dto.MenuDTO;
import severusnguyen.severusbooking.entity.Menu;
import severusnguyen.severusbooking.repository.MenuRepository;
import severusnguyen.severusbooking.service.imp.MenuServiceImp;

import java.util.ArrayList;
import java.util.List;

@Service
public class MenuService implements MenuServiceImp {

    @Autowired
    MenuRepository menuRepository;

    @Override
    public List<MenuDTO> getHomeMenu() {

        List<Menu> menuList = menuRepository.findAll();
        List<MenuDTO> menuDTOList = new ArrayList<>();

//        // Kiểm tra null trước khi gọi phương thức booleanValue()
//        for (Menu menu : menuList) {
//            if (menu.getSpecialDish() != null && menu.getSpecialDish()) {
//                System.out.println(menu.getTitle() + " is a special dish.");
//            } else {
//                System.out.println(menu.getTitle() + " is not a special dish.");
//            }
//        }
        //System.out.println("Helloooo");

        for (Menu menu : menuList) {
            MenuDTO menuDTO = new MenuDTO();
            menuDTO.setId(menu.getId());
            menuDTO.setTitle(menu.getTitle());
            menuDTO.setSubtitle(menu.getSubtitle());
            menuDTO.setPrice(menu.getPrice());
            menuDTO.setImage(menu.getImage());
            menuDTO.setSpecialDish(menu.isSpecialDish());

            menuDTOList.add(menuDTO);
        }
        return menuDTOList;
    }
}
