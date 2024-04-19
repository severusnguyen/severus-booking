package severusnguyen.severusbooking.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import severusnguyen.severusbooking.dto.MenuDTO;
import severusnguyen.severusbooking.entity.Menu;
import severusnguyen.severusbooking.entity.MenuCategory;
import severusnguyen.severusbooking.repository.MenuRepository;
import severusnguyen.severusbooking.service.imp.FileServiceImp;
import severusnguyen.severusbooking.service.imp.MenuServiceImp;

import java.util.ArrayList;
import java.util.List;

@Service
public class MenuService implements MenuServiceImp {

    @Autowired
    MenuRepository menuRepository;

    @Autowired
    FileServiceImp fileServiceImp;

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

    @Override
    public boolean insertMenu(MultipartFile file, String title, String subtitle, String description, double price, boolean special_dish, int cate_menu_id) {
        boolean isInsertSuccess = false;
        try {
            boolean isSaveFileSuccess = fileServiceImp.saveFile(file);
            if (isSaveFileSuccess){
                Menu menu = new Menu();
                menu.setTitle(title);
                menu.setSubtitle(subtitle);
                menu.setDescription(description);
                menu.setPrice(price);
                menu.setImage(file.getOriginalFilename());
                menu.setSpecialDish(special_dish);

                MenuCategory menuCategory = new MenuCategory(); //68-14
                menuCategory.setId(cate_menu_id);
                menu.setCateMenuId(menuCategory);

                menuRepository.save(menu);
                isInsertSuccess = true;
            }
        }catch (Exception e){
            System.out.println("Error insert menu: " + e.getMessage());
        }

        return isInsertSuccess;
    }
}
