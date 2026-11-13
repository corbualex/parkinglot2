package org.parkinglot.parkinglot2.entities.ejb;

import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import org.parkinglot.parkinglot2.entities.common.UserDto;
import org.parkinglot.parkinglot2.entities.User;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

@Stateless
public class UsersBean {

    private static final Logger LOG = Logger.getLogger(UsersBean.class.getName());

    @PersistenceContext
    EntityManager entityManager;

    public List<UserDto> findAllUsers() {
        LOG.info("findAllUsers");
        try {
            TypedQuery<User> typedQuery = entityManager.createQuery("SELECT u FROM User u", User.class);
            List<User> users = typedQuery.getResultList();
            return copyUsersToDto(users);
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }

    private List<UserDto> copyUsersToDto(List<User> users) {
        List<UserDto> userDtoList = new ArrayList<>();
        for (User user : users) {
            UserDto userDto = new UserDto(
                    user.getId(),
                    user.getUsername(),
                    user.getEmail()
            );
            userDtoList.add(userDto);
        }
        return userDtoList;
    }
}