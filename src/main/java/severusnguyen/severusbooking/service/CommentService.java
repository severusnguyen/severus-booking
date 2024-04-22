package severusnguyen.severusbooking.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import severusnguyen.severusbooking.dto.CommentDTO;
import severusnguyen.severusbooking.entity.Comment;
import severusnguyen.severusbooking.repository.CommentRepository;
import severusnguyen.severusbooking.service.imp.CommentServiceImp;
import severusnguyen.severusbooking.service.imp.FileServiceImp;

import java.util.ArrayList;
import java.util.List;

@Service
public class CommentService implements CommentServiceImp {

    @Autowired
    CommentRepository commentRepository;

    @Autowired
    FileServiceImp fileServiceImp;

    @Override
    public List<CommentDTO> getHomeComment() {

        List<Comment> commentList = commentRepository.findAll();
        List<CommentDTO> commentDTOList = new ArrayList<>();

        for (Comment comment : commentList) {

            CommentDTO commentDTO = new CommentDTO();
            commentDTO.setName(comment.getName());
            commentDTO.setSubject(comment.getSubject());
            commentDTO.setImage(comment.getImage());

            commentDTOList.add(commentDTO);
        }
        return commentDTOList;
    }

    @Override
    public boolean insertComment(MultipartFile file, String name, String subject, String message) {

        boolean isInsertSuccess = false;
        try {
            boolean isSaveFileSuccess = fileServiceImp.saveFile(file);
            if (isSaveFileSuccess){
                Comment comment = new Comment();

                comment.setName(name);
                comment.setSubject(subject);
                comment.setMessage(message);
                comment.setImage(file.getOriginalFilename());

                commentRepository.save(comment);
                isInsertSuccess = true;
            }

        } catch (Exception e) {
            System.out.println("Error insert comment: " + e.getMessage());

        }
        return isInsertSuccess;
    }
}
