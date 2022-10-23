package com.example.RestAPI;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/mock")
public class MockRestAPI {

    private static final Map<Long, Username> users;
    private static Long nextID = 1L;

    static {
        users = new HashMap<>();
        users.put(nextID, new Username(nextID++,"mavu","123"));
        users.put(nextID, new Username(nextID++,"vuma","123456"));

    }

    @GetMapping("/{id}")
    public Username getUsername(@PathVariable Long id) {
        Optional<Username> username = Optional.ofNullable(users.get(id));
        return username.orElse(null);
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Username> create(@RequestBody Username user) {
        users.put(user.getId(), user);

        return ResponseEntity.status(HttpStatus.CREATED)
                .header("Location", "/rest/employees/" + user.getUsername())
                .body(user);
    }

    @PutMapping(path = "/{id}",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Username> update(@PathVariable long id, @RequestBody Username request) {
        if (!users.containsKey(id)) {
            return ResponseEntity.notFound().build();
        } else {
            Username user = users.get(id);
            user.setUsername(request.getUsername());
            user.setPassword(request.getPassword());


            return ResponseEntity.ok(user);
        }
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable long id) {
        Username removeUser = users.remove(id);

        return removeUser != null ? ResponseEntity.ok().build() : ResponseEntity.notFound().build();
    }
}
