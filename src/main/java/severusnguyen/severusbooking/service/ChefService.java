package severusnguyen.severusbooking.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import severusnguyen.severusbooking.dto.ChefDTO;
import severusnguyen.severusbooking.entity.Chef;
import severusnguyen.severusbooking.repository.ChefRepository;
import severusnguyen.severusbooking.service.imp.ChefServiceImp;
import severusnguyen.severusbooking.service.imp.FileServiceImp;

import java.util.ArrayList;
import java.util.List;

@Service
public class ChefService implements ChefServiceImp {

    @Autowired
    ChefRepository chefRepository;

    @Autowired
    FileServiceImp fileServiceImp;

    @Override
    public List<ChefDTO> getHomeChef() {

        List<Chef> chefList = chefRepository.findAll();
        List<ChefDTO> chefDTOList = new ArrayList<>();

        for (Chef chef : chefList) {

            ChefDTO chefDTO = new ChefDTO();
            chefDTO.setName(chef.getName());
            chefDTO.setPosition(chef.getPosition());
            chefDTO.setImage(chef.getImage());

            chefDTOList.add(chefDTO);
        }
        return chefDTOList;
    }

    @Override
    public boolean insertChef(MultipartFile file, String name, String position) {

        boolean isInsertSuccess = false;
        try {
            boolean isSaveFileSuccess = fileServiceImp.saveFile(file);
            if (isSaveFileSuccess){
                Chef chef = new Chef();

                chef.setName(name);
                chef.setPosition(position);
                chef.setImage(file.getOriginalFilename());

                chefRepository.save(chef);

            }
            isInsertSuccess = true;
        }catch (Exception e) {
            System.out.println("Error insert chef: " + e.getMessage());
        }
        return isInsertSuccess;
    }
}
