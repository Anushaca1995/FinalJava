package com.nology.finalApi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
@Service
public class UserApiService {
    @Autowired
    UserApiRepository finalApiRepository;

    // CREATE

    public void addUser(User finalApi) {
        finalApiRepository.save(finalApi);
    }


    // READ

    public User getUserById(long id) {
        Optional<User> finalApi = finalApiRepository.findById(id);

        if (finalApi.isEmpty()) {
            throw new UserApiNotFoundException();
        }

        return finalApi.get();
    }
    public User getUserByEmail(String email) {
        return finalApiRepository.getUserByEmail(email);
    }

    public List<User> getUserBySearch(String search) {
        search = "%"+search+"%";
        System.out.println(search);
        return finalApiRepository.getUserBySearch(search, search, search);
    }

    public List<User> getUserByDate() {
        return finalApiRepository.getUserByDate();
    }


    public User getRandomUser() {
        return finalApiRepository.getRandomUser();
    }

    public List<Long> getUserIds() {
        return finalApiRepository.getDistinctIds();
    }


    public List<User> getAllUsers(int limit) {
        System.out.println(finalApiRepository.findAll());
        return finalApiRepository
                .findAll()
                .stream()
                .limit(limit)
                .collect(Collectors.toList());
    }

    // UPDATE

    public void updateUser(User finalApi, long id) {
        if (!finalApiRepository.existsById(id)) {
            throw new UserApiNotFoundException();
        }

        finalApi.setId(id);

        finalApiRepository.save(finalApi);
    }

    // DELETE
    @Transactional
    public void deleteUserById(long id) {
        if (!finalApiRepository.existsById(id)) {
            throw new UserApiNotFoundException();
        }

        finalApiRepository.deleteUserById(id);
    }

}
