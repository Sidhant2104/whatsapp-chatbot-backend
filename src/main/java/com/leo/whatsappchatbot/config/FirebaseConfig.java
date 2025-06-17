package com.leo.whatsappchatbot.config;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.io.IOException;
import java.io.InputStream;

@Component
public class FirebaseConfig {

    @PostConstruct
    public void initialize() {
        try {
            String firebaseConfig = System.getenv("FIREBASE_CONFIG");
            if (firebaseConfig == null) {
                throw new IllegalArgumentException("FIREBASE_CONFIG env variable not found");
            }

            byte[] decodedBytes = java.util.Base64.getDecoder().decode(firebaseConfig);
            InputStream serviceAccount = new java.io.ByteArrayInputStream(decodedBytes);

            FirebaseOptions options = FirebaseOptions.builder()
                    .setCredentials(GoogleCredentials.fromStream(serviceAccount))
                    .build();

            if (FirebaseApp.getApps().isEmpty()) {
                FirebaseApp.initializeApp(options);
                System.out.println("Firebase connected successfully using env config!");
            }
        } catch (Exception e) {
            System.err.println("Firebase init failed: " + e.getMessage());
            e.printStackTrace();
        }
    }

}
