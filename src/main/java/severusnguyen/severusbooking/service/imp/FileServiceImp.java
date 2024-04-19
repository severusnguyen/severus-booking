package severusnguyen.severusbooking.service.imp;

import org.springframework.core.io.Resource;
import org.springframework.web.multipart.MultipartFile;

//1
public interface FileServiceImp {
    boolean saveFile(MultipartFile file);
    Resource loadFile(String fileName);

}
