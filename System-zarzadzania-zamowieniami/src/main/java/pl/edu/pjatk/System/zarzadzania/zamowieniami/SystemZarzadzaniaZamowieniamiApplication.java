package pl.edu.pjatk.System.zarzadzania.zamowieniami;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;
import pl.edu.pjatk.System.zarzadzania.zamowieniami.model.*;

import javax.validation.Validator;

@SpringBootApplication
@EnableAutoConfiguration(exclude = {DataSourceAutoConfiguration.class})
public class SystemZarzadzaniaZamowieniamiApplication {

	public static void main(String[] args) {
		SpringApplication.run(SystemZarzadzaniaZamowieniamiApplication.class, args);
	}

    SessionFactory factory = new Configuration()
            .configure()
            .addAnnotatedClass(Address.class)
            .addAnnotatedClass(Benefit.class)
            .addAnnotatedClass(ConstructionSite.class)
            .addAnnotatedClass(Employee.class)
            .addAnnotatedClass(EmployeeFullTime.class)
            .addAnnotatedClass(EmployeeOnComision.class)
            .addAnnotatedClass(Material.class)
            .addAnnotatedClass(MaterialOrder.class)
            .addAnnotatedClass(OnOrderMaterial.class)
            .addAnnotatedClass(ServiceOrder.class)
            .addAnnotatedClass(Subconstractor.class)
            .addAnnotatedClass(SubconstractorConstractor.class)
            .addAnnotatedClass(SubconstractorSupplier.class)
            .addAnnotatedClass(VacationRequest.class)
            .buildSessionFactory();

    // create session
    Session session;

    {
        session = factory.getCurrentSession();
    }


    @Bean
    Validator validator() {
        return new LocalValidatorFactoryBean();
    }

}


