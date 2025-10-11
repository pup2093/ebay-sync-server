// package com.neutroware.ebaysyncserver.encryption;

// import org.springframework.boot.CommandLineRunner;
// import org.springframework.boot.SpringApplication;
// import org.springframework.boot.autoconfigure.SpringBootApplication;
// import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
// import org.springframework.boot.autoconfigure.jdbc.DataSourceTransactionManagerAutoConfiguration;
// import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
// import org.springframework.boot.autoconfigure.sql.init.SqlInitializationAutoConfiguration;
// import org.springframework.context.annotation.Bean;
// import org.springframework.beans.factory.annotation.Value;
// import org.springframework.security.crypto.encrypt.Encryptors;
// import org.springframework.security.crypto.encrypt.TextEncryptor;

// @SpringBootApplication(
//     // scanning starts at this package, so only encryption classes are picked up
//     exclude = {
//         DataSourceAutoConfiguration.class,
//         DataSourceTransactionManagerAutoConfiguration.class,
//         HibernateJpaAutoConfiguration.class,
//         SqlInitializationAutoConfiguration.class
//     }
// )
// public class EncryptionRunner implements CommandLineRunner {

//     private final EncryptionService encryptionService;

//     public EncryptionRunner(EncryptionService encryptionService) {
//         this.encryptionService = encryptionService;
//     }

//     public static void main(String[] args) {
//         SpringApplication.run(EncryptionRunner.class, args);
//     }

//     // Provide the TextEncryptor bean used by EncryptionService
//     @Bean
//     public static TextEncryptor  textEncryptor(
//         @Value("${encrypt.password}") String password,
//         @Value("${encrypt.salt}") String salt
//     ) {
//         return Encryptors.text(password, salt);
//     }

//     @Override
//     public void run(String... args) {
//         if (args.length == 0) {
//             System.out.println("Usage: <ciphertext>");
//             System.exit(1);
//         }
//         System.out.println("Decrypted: " + encryptionService.decrypt(args[0]));
//         System.exit(0);
//     }
// }
