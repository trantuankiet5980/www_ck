package vn.edu.iuh.fit;

import net.datafaker.Faker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import vn.edu.iuh.fit.backend.entities.Candidate;
import vn.edu.iuh.fit.backend.entities.Experience;
import vn.edu.iuh.fit.backend.entities.Roles;
import vn.edu.iuh.fit.backend.repositories.CandidateRepository;
import vn.edu.iuh.fit.backend.repositories.ExperienceRepository;

import java.time.LocalDate;
import java.util.List;

@SpringBootApplication
public class Ck03Application  {

    public static void main(String[] args) {
        SpringApplication.run(Ck03Application.class, args);
    }

    @Autowired
    private CandidateRepository candidateRepository;
    @Autowired
    private ExperienceRepository experienceRepository;
//    @Bean
    CommandLineRunner seedDatabase(CandidateRepository candidateRepository) {
        return args -> {
            Faker faker = new Faker();

            for (int i = 0; i < 3; i++) {
                // Tạo Candidate
                Candidate candidate = new Candidate();
                candidate.setPhone(faker.phoneNumber().phoneNumber());
                candidate.setEmail(faker.internet().emailAddress());
                candidate.setFullName(faker.name().fullName());

                // Tạo Experience cho Candidate
                Experience experience = new Experience();
                experience.setCompanyName(faker.company().name());
                experience.setFromDate(LocalDate.now().minusYears(faker.number().numberBetween(1, 10)));
                experience.setToDate(LocalDate.now());
                experience.setWorkDescription(faker.job().field());
                experience.setRole(Roles.values()[faker.number().numberBetween(0, Roles.values().length)]);
                experience.setCandidate(candidate);

                // Gắn Experience vào Candidate
                candidate.setExperiences(List.of(experience));

                // Lưu Candidate và Experience
                candidateRepository.save(candidate);
            }
        };
    }
}
