package com.leo.whatsappchatbot.config;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.Base64;

@Component
public class FirebaseConfig {

    @PostConstruct
    public void initialize() {
        try {
            // Read the environment variable
            String firebaseConfigBase64 = System.getenv("FIREBASE_CONFIG");

            if (firebaseConfigBase64 == null) {
                throw new RuntimeException("FIREBASE_CONFIG environment variable not found");
            }

            // Decode it
            byte[] decodedBytes = Base64.getDecoder().decode(firebaseConfigBase64);
            InputStream serviceAccount = new ByteArrayInputStream(decodedBytes);

            FirebaseOptions options = FirebaseOptions.builder()
                    .setCredentials(GoogleCredentials.fromStream(serviceAccount))
                    .build();

            if (FirebaseApp.getApps().isEmpty()) {
                FirebaseApp.initializeApp(options);
                System.out.println("Firebase connected successfully!");
            }

        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Firebase initialization failed: " + e.getMessage());
        }
    }
}
