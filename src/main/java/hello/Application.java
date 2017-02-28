package hello;

        import org.springframework.beans.factory.annotation.Autowired;
        import org.springframework.boot.CommandLineRunner;
        import org.springframework.boot.SpringApplication;
        import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application implements CommandLineRunner {

    @Autowired
    private CustomerRepository repository;

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

        repository.deleteAll();

        // save a couple of customers
        repository.save(new Customer("pradeep", "chandra"));
        repository.save(new Customer("bablu", "nikhil"));

        // fetch all customers
        System.out.println("Customers found with findAll():");
        System.out.println("-------------------------------");
        for (Customer customer : repository.findAll()) {
            System.out.println(customer);
        }
        System.out.println();

        // fetch an individual customer
        System.out.println("Customer found with findByFirstName('pradeep'):");
        System.out.println("--------------------------------");
        System.out.println(repository.findByFirstName("pradeep"));

        System.out.println("Customers found with findByLastName('nikhil'):");
        System.out.println("--------------------------------");
        for (Customer customer : repository.findByLastName("nikhil")) {
            System.out.println(customer);
        }

    }

}