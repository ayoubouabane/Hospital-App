package net.ouabane.hospitalapp;

import net.ouabane.hospitalapp.entities.Patient;
import net.ouabane.hospitalapp.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Date;
import java.util.List;

@SpringBootApplication
public class HospitalAppApplication{

    public static void main(String[] args) {
        SpringApplication.run(HospitalAppApplication.class, args);
    }

    @Bean // Execute methode in start of app
    public CommandLineRunner start(PatientRepository patientRepository){
        return args -> {
            // this code will be run at the start of the app
            Patient p1 = new Patient();
            p1.setNom("OUABANE");
            p1.setPrenom("Ayoub");
            p1.setScore(120);
            p1.setMalade(false);
            //p1.setDateNaissance(new Data());

            Patient p2 = new Patient(null,"ALAOUI","Amine",new Date(),1500,false);
            Patient p4 = new Patient(null,"HACHIMI","Aymane",new Date(),2500,true);
            Patient p5 = new Patient(null,"ZNIBER","Alae",new Date(),3500,false);
            Patient p6 = new Patient(null,"HAFIDI","Adam",new Date(),4500,true);

            Patient p3 = Patient.builder()
                    .nom("HAMIDI")
                    .prenom("Anas")
                    .score(110)
                    .build();

            patientRepository.save(p1);
            patientRepository.save(p2);
            patientRepository.save(p3);
            patientRepository.save(p4);
            patientRepository.save(p5);
            patientRepository.save(p6);

            List<Patient> patients= patientRepository.findAll();
            patients.forEach(p -> {
                System.out.println(p.toString());
            });
        };
    }

    @Bean
    PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();

    }

}
