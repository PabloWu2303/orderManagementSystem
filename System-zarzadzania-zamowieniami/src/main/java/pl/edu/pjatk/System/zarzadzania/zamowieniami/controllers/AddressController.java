package pl.edu.pjatk.System.zarzadzania.zamowieniami.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.edu.pjatk.System.zarzadzania.zamowieniami.model.Address;
import pl.edu.pjatk.System.zarzadzania.zamowieniami.repositories.AddressRepository;

import javax.annotation.PostConstruct;
import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
public class AddressController {
    private AddressRepository repository;
    private static final Logger logger = LoggerFactory.getLogger(AddressController.class);

//    AddressController(){ };
//
//    AddressController(final AddressRepository repository) {
//        this.repository = repository;
//    }

    @GetMapping(value = "/addresses", params = {"!sort", "!size", "!page"})
    ResponseEntity<List<Address>> readAllAddresses() {
        logger.warn("Exposing all addresses!");
        return ResponseEntity.ok(repository.findAll());
    }

    @GetMapping(value = "/addresses")
    ResponseEntity<List<Address>> readAllAddresses(Pageable page) {
        logger.warn("Exposing all addresses!");
        return ResponseEntity.ok(repository.findAll(page).getContent());
    }
//
//    @GetMapping("/addresses/{id}")
//    ResponseEntity<Address> readTask(@PathVariable int id) {
//        logger.info("Exposing address id: " + id);
//        return repository.findById(id)
//                .map(address -> ResponseEntity.ok(address))
//                .orElse(ResponseEntity.notFound().build());
//    }
//
    @PostMapping("/addresses")
    ResponseEntity<?> postAddress(@RequestBody Address address) {
        repository.save(address);
        return ResponseEntity.status(201).build();
    }
//
//    @PutMapping("/addresses/{id}")
//    ResponseEntity<?> updateAddress(@PathVariable int id, @RequestBody @Valid Address addressToUpdate){
//        if(!repository.existsById(id)){
//            return ResponseEntity.notFound().build();
//        }
//        addressToUpdate.setId(id);
//        repository.save(addressToUpdate);
//        return ResponseEntity.noContent().build();
//    }
}
