package org.helb.baseproject.service;

import org.helb.baseproject.model.user.User;
import org.helb.baseproject.repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    //this method return list of users
    public List<User> getUsers (){
        return userRepository.findAll();
    }

    public void addNewUser(User user) {
        Optional<User> userOptional = userRepository.findUserByMail(user.getMail());
        if (userOptional.isPresent()){
            throw new IllegalStateException("email already exists");
        }
        userRepository.save(user);
    }

    public void deleteUser(Long userId) {
        boolean exists = userRepository.existsById(userId);
        if (!exists){
            throw new IllegalStateException("user with this id: " + userId + ", does not exists");
        }
        userRepository.deleteById(userId);


    }

    @Transactional
    public void updateUser(Long userId,
                           String lastName,
                           String firstName,
                           String pseudo,
                           String mail)
    {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new IllegalStateException("user with id: " + userId + ", does not exist"));

        if(lastName != null && lastName.length()>0 && !Objects.equals(user.getLastName(), lastName)){
            user.setLastName(lastName);
        }

        if(firstName != null && firstName.length()>0 && !Objects.equals(user.getFirstName(), firstName)){
            user.setFirstName(firstName);
        }

        if(pseudo != null && pseudo.length()>0 && !Objects.equals(user.getPseudo(), pseudo)){
            user.setPseudo(pseudo);
        }

        if(mail != null && mail.length()>0 && !Objects.equals(user.getMail(), mail)){
            Optional<User> userOptional = userRepository.findUserByMail(mail);
            if (userOptional.isPresent()){
                throw new IllegalStateException("mail taken");
            }
            user.setMail(mail);
        }
    }
}
