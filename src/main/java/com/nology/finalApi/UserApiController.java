package com.nology.finalApi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
public class UserApiController {

    @Autowired
    private UserApiService finalApiService;

    @ExceptionHandler
    public ResponseEntity<String> handleExceptions(UserApiNotFoundException exception) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(exception.getMessage());
    }

    // CREATE

    @PostMapping("/user")
    public ResponseEntity<User> createUser(@RequestBody User finalApi) {
        finalApiService.addUser(finalApi);
        return ResponseEntity.status(HttpStatus.CREATED).body(finalApi);
    }

    // READ

    @GetMapping("/greet")
    public ResponseEntity<String> greet() {
        return ResponseEntity.status(HttpStatus.OK).body("Hello world!");
    }

    @GetMapping("/users")
    public ResponseEntity<List<User>> getUsers(@RequestParam(defaultValue = "100") int limit) {

        return ResponseEntity.status(HttpStatus.OK).body(finalApiService.getAllUsers(limit));
    }

    @GetMapping("/users/ids")
    public ResponseEntity<List<Long>> getUsersIds() {
        return ResponseEntity.status(HttpStatus.OK).body(finalApiService.getUserIds());
    }


    @GetMapping("/user/random")
    public ResponseEntity<User> getRandomUser() {
        return ResponseEntity.status(HttpStatus.OK).body(finalApiService.getRandomUser());
    }

    @GetMapping("/user/{id}")
    public ResponseEntity<User> getUserById(@PathVariable long id) {
        return ResponseEntity.status(HttpStatus.OK).body(finalApiService.getUserById(id));
    }

    @GetMapping("/user/email/{email}")
    public ResponseEntity<User> getUserByEmail(@PathVariable("email") String email_id) {
        System.out.println(email_id);
        return ResponseEntity.status(HttpStatus.OK).body(finalApiService.getUserByEmail(email_id));
    }

    @GetMapping("/user/search/{search}")
    public ResponseEntity<List<User>> getUserBySearch(@PathVariable("search") String search) {
        return ResponseEntity.status(HttpStatus.OK).body(finalApiService.getUserBySearch(search));
    }

    @GetMapping("/user/book")
    public ResponseEntity<List<User>> getUserByDate() {
        return ResponseEntity.status(HttpStatus.OK).body(finalApiService.getUserByDate());
    }



    // UPDATE

    @PutMapping("/user/{id}")
    public ResponseEntity<User> updateUser(@RequestBody User finalApi, @PathVariable long id) {
        finalApi.setId(id);
        finalApiService.updateUser(finalApi, id);
        return ResponseEntity.status(HttpStatus.OK).body(finalApi);
    }

    // DELETE

    @DeleteMapping("/user/{id}")
    public ResponseEntity<Void> deleteUserById(@PathVariable long id) {
        finalApiService.deleteUserById(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

}
