package hello;

import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

/**
 * Created by Pradeep Chandra on 2/26/2017.
 */
public interface CustomerRepository extends MongoRepository<Customer, String> {
    public Customer findByFirstName(String firstName);
    public List<Customer> findByLastName(String lastName);
}
