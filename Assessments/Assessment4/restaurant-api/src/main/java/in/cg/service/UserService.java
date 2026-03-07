package in.cg.service;

import in.cg.dto.UserDTO;
import in.cg.entity.User;

public interface UserService {

    User registerUser(UserDTO dto);

}