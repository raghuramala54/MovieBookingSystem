package com.raghu.mbs.services;
import com.raghu.mbs.entities.User;
import com.raghu.mbs.exceptions.UserDetailsNotFoundException;
import com.raghu.mbs.exceptions.UserNameAlreadyExistsException;
import com.raghu.mbs.exceptions.UserTypeDetailsNotFoundException;
public interface UserService {
    public User acceptUserDetails(User user)
            throws UserNameAlreadyExistsException, UserTypeDetailsNotFoundException;

    public User getUserDetails(int id) throws UserDetailsNotFoundException;

    public User getUserDetailsByUsername(String username) throws UserDetailsNotFoundException;

    public User updateUserDetails(int id, User user)
            throws UserNameAlreadyExistsException, UserDetailsNotFoundException, UserTypeDetailsNotFoundException;
}
