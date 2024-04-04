package com.hans.backend.backend;

import com.hans.backend.backend.appl.actors.service.dto.Player;
import com.hans.backend.backend.appl.actors.service.dto.Trainer;
import com.hans.backend.backend.appl.actors.service.service.PlayerService;
import com.hans.backend.backend.appl.actors.service.service.TrainerService;
import com.hans.backend.backend.base.testdata.ImageService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@SpringBootApplication
public class Test_Application {

//    private final DateTimeFormatter dateTimeFormatter_dd_MM_yyyy_0650712384 = DateTimeFormatter.ofPattern( "dd/MM/yyyy" );

    public static void main(String[] args) {

        ApplicationContext ctx = SpringApplication.run(Test_Application.class, args);

        ImageService imageService = (ImageService) ctx.getBean(ImageService.class);

        
        // Begin - Players
        //     DEFENDER, FORWARD, GOALKEEPER, MIDFIELDER
        PlayerService playerSrv = (PlayerService) ctx.getBean(PlayerService.class);


        Player playerdto1 = new Player();
        String playerdto1Id = playerSrv.create(playerdto1).getId();
        playerdto1 = playerSrv.getById(Long.valueOf(playerdto1Id));
        playerdto1.setName("Player" + " " + playerdto1Id);
        playerdto1.setBasePosition("DEFENDER");
        playerdto1.setBirthDate(LocalDate.of(1985,7,31));
//        playerdto1.setBirthDate("31/07/1985");
        playerdto1.setHeight(17+Integer.parseInt(playerdto1Id));
        playerdto1.setWeight(5+Integer.parseInt(playerdto1Id));
        playerdto1.setFirstName("Voornaam"+ playerdto1Id);
        playerdto1.setLastName("Achternaam"+ playerdto1Id);
        playerdto1 = imageService.addPlayerImage(playerdto1, Integer.valueOf(playerdto1Id));
        playerSrv.update(playerdto1);

        Player playerdto2 = new Player();
        String playerdto2Id = playerSrv.create(playerdto2).getId();
        playerdto2 = playerSrv.getById(Long.valueOf(playerdto2Id));
        playerdto2.setName("Player" + " " + playerdto2Id);
        playerdto2.setBasePosition("FORWARD");
        playerdto2.setBirthDate(LocalDate.of(1985,7,31));
//        playerdto2.setBirthDate("31/07/1985");
        playerdto2.setHeight(17+Integer.parseInt(playerdto2Id));
        playerdto2.setWeight(5+Integer.parseInt(playerdto2Id));
        playerdto2.setFirstName("Voornaam"+ playerdto2Id);
        playerdto2.setLastName("Achternaam"+ playerdto2Id);
        playerdto2 = imageService.addPlayerImage(playerdto2, Integer.valueOf(playerdto2Id));
        playerSrv.update(playerdto2);

        Player playerdto3 = new Player();
        String playerdto3Id = playerSrv.create(playerdto3).getId();
        playerdto3 = playerSrv.getById(Long.valueOf(playerdto3Id));
        playerdto3.setName("Player" + " " + playerdto3Id);
        playerdto3.setBasePosition("GOALKEEPER");
        playerdto3.setBirthDate(LocalDate.of(1985,7,31));
//        playerdto3.setBirthDate("31/07/1985");
        playerdto3.setHeight(17+Integer.parseInt(playerdto3Id));
        playerdto3.setWeight(5+Integer.parseInt(playerdto3Id));
        playerdto3.setFirstName("Voornaam"+ playerdto3Id);
        playerdto3.setLastName("Achternaam"+ playerdto3Id);
        playerdto3 = imageService.addPlayerImage(playerdto3, Integer.valueOf(playerdto3Id));
        playerSrv.update(playerdto3);

        Player playerdto4 = new Player();
        String playerdto4Id = playerSrv.create(playerdto4).getId();
        playerdto4 = playerSrv.getById(Long.valueOf(playerdto4Id));
        playerdto4.setName("Player" + " " + playerdto4Id);
        playerdto4.setBasePosition("MIDFIELDER");
        playerdto4.setBirthDate(LocalDate.of(1985,7,31));
//        playerdto4.setBirthDate("31/07/1985");
        playerdto4.setHeight(17+Integer.parseInt(playerdto4Id));
        playerdto4.setWeight(5+Integer.parseInt(playerdto4Id));
        playerdto4.setFirstName("Voornaam"+ playerdto4Id);
        playerdto4.setLastName("Achternaam"+ playerdto4Id);
        playerdto4 = imageService.addPlayerImage(playerdto4, Integer.valueOf(playerdto4Id));
        playerSrv.update(playerdto4);

        Player playerdto5 = new Player();
        String playerdto5Id = playerSrv.create(playerdto5).getId();
        playerdto5 = playerSrv.getById(Long.valueOf(playerdto5Id));
        playerdto5.setName("Player" + " " + playerdto5Id);
        playerdto5.setBasePosition("MIDFIELDER");
        playerdto5.setBirthDate(LocalDate.of(1985,7,31));
//        playerdto5.setBirthDate("31/07/1985");
        playerdto5.setHeight(17+Integer.parseInt(playerdto5Id));
        playerdto5.setWeight(5+Integer.parseInt(playerdto5Id));
        playerdto5.setFirstName("Voornaam"+ playerdto5Id);
        playerdto5.setLastName("Achternaam"+ playerdto5Id);
        playerdto5 = imageService.addPlayerImage(playerdto5, Integer.valueOf(playerdto5Id));
        playerSrv.update(playerdto5);



        System.out.println("All data:" + playerSrv.getAll());

        System.out.println("Get by ID:" + playerSrv.getById(Long.valueOf(playerdto5Id)));

        System.out.println("Get by ID:" + playerSrv.getById(Long.valueOf(playerdto4Id)));

        playerSrv.deleteById(Long.valueOf(playerdto4Id));

        System.out.println("Get by ID: (should be null)" + playerSrv.getById(Long.valueOf(playerdto4Id)));

//        // End - Players
//
//        // Begin - Trainers
//        // LEAD, ASSISTANT;
//
        TrainerService trainerSrv = (TrainerService) ctx.getBean(TrainerService.class);

        Trainer trainerdto1 = new Trainer();
        String trainerdto1Id = trainerSrv.create(trainerdto1).getId();
        trainerdto1 = trainerSrv.getById(Long.valueOf(trainerdto1Id));
        trainerdto1.setName("Trainer" + " " + trainerdto1Id);
        trainerdto1.setTrainerSpecialty("LEAD");
        trainerdto1.setBirthDate(LocalDate.of(1985,7,31));
//        trainerdto1.setBirthDate("31/07/1985");
        trainerdto1.setFirstName("Voornaam"+ trainerdto1Id);
        trainerdto1.setLastName("Achternaam"+ trainerdto1Id);
        trainerSrv.update(trainerdto1);

        Trainer trainerdto2 = new Trainer();
        String trainerdto2Id = trainerSrv.create(trainerdto2).getId();
        trainerdto2 = trainerSrv.getById(Long.valueOf(trainerdto2Id));
        trainerdto2.setName("Trainer" + " " + trainerdto2Id);
        trainerdto2.setTrainerSpecialty("ASSISTANT");
        trainerdto2.setBirthDate(LocalDate.of(1985,7,31));
//        trainerdto2.setBirthDate("31/07/1985");
        trainerdto2.setFirstName("Voornaam"+ trainerdto2Id);
        trainerdto2.setLastName("Achternaam"+ trainerdto2Id);
        trainerSrv.update(trainerdto2);

        Trainer trainerdto3 = new Trainer();
        String trainerdto3Id = trainerSrv.create(trainerdto3).getId();
        trainerdto3 = trainerSrv.getById(Long.valueOf(trainerdto3Id));
        trainerdto3.setName("Trainer" + " " + trainerdto3Id);
        trainerdto3.setTrainerSpecialty("ASSISTANT");
        trainerdto3.setBirthDate(LocalDate.of(1985,7,31));
//        trainerdto3.setBirthDate("31/07/1985");
        trainerdto3.setFirstName("Voornaam"+ trainerdto3Id);
        trainerdto3.setLastName("Achternaam"+ trainerdto3Id);
        trainerSrv.update(trainerdto3);

        Trainer trainerdto4 = new Trainer();
        String trainerdto4Id = trainerSrv.create(trainerdto4).getId();
        trainerdto4 = trainerSrv.getById(Long.valueOf(trainerdto4Id));
        trainerdto4.setName("Trainer" + " " + trainerdto4Id);
        trainerdto4.setTrainerSpecialty("ASSISTANT");
        trainerdto4.setBirthDate(LocalDate.of(1985,7,31));
//        trainerdto4.setBirthDate("31/07/1985");
        trainerdto4.setFirstName("Voornaam"+ trainerdto4Id);
        trainerdto4.setLastName("Achternaam"+ trainerdto4Id);
        trainerSrv.update(trainerdto4);

        Trainer trainerdto5 = new Trainer();
        String trainerdto5Id = trainerSrv.create(trainerdto5).getId();
        trainerdto5 = trainerSrv.getById(Long.valueOf(trainerdto5Id));
        trainerdto5.setName("Trainer" + " " + trainerdto5Id);
        trainerdto5.setTrainerSpecialty("ASSISTANT");
        trainerdto5.setBirthDate(LocalDate.of(1985,7,31));
//        trainerdto5.setBirthDate("31/07/1985");
        trainerdto5.setFirstName("Voornaam"+ trainerdto5Id);
        trainerdto5.setLastName("Achternaam"+ trainerdto5Id);
        trainerSrv.update(trainerdto5);

        System.out.println("All data:" + trainerSrv.getAll());

        System.out.println("Get by ID:" + trainerSrv.getById(Long.valueOf(trainerdto5Id)));

        System.out.println("Get by ID:" + trainerSrv.getById(Long.valueOf(trainerdto4Id)));

        trainerSrv.deleteById(Long.valueOf(trainerdto4Id));

        System.out.println("Get by ID: (should be null)" + trainerSrv.getById(Long.valueOf(trainerdto4Id)));
        
        
        // End - Trainers

        // Begin - Teams

        // End - Teams
        
        
    }
}