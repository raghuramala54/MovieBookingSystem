package com.raghu.mbs.services;
import com.raghu.mbs.entities.UserType;
import com.raghu.mbs.exceptions.UserTypeDetailsNotFoundException;

import java.util.List;
public interface UserTypeService {
    public UserType acceptUserTypeDetails(UserType userType);
    public UserType getUserTypeDetails(int id) throws UserTypeDetailsNotFoundException;
    public UserType getUserTypeDetailsFromUserTypeName(String userType) throws UserTypeDetailsNotFoundException;
    public boolean deleteUserType(int id) throws UserTypeDetailsNotFoundException;
    public List<UserType> getAllUserTypeDetails();
}
