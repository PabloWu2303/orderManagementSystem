package pl.edu.pjatk.System.zarzadzania.zamowieniami.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.edu.pjatk.System.zarzadzania.zamowieniami.model.Address;

import java.awt.print.Pageable;
import java.util.List;
import java.util.Optional;

@Repository
public interface AddressRepository extends JpaRepository<Address, Integer> {
    List<Address> findAll();

//    Page<Address> findAll(Pageable page);
//
//    Optional<Address> findById(Integer id);
//
//    boolean existsById(Integer id);

    Address save(Address address);
}
