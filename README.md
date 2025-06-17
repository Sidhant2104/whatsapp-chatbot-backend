# Leo - WhatsApp Chatbot Backend 🤖

**Leo** is a smart, command-based WhatsApp-style chatbot backend built using **Java**, **Spring Boot**, and **Firebase Firestore**. It’s designed to demonstrate clean architecture, real-time data logging, and human-friendly bot interactions. Ideal for learning backend development, showcasing skills in interviews, or using as a base for advanced chatbot systems.

---

## 🚀 Features

- ✅ REST API endpoint to receive and respond to messages
- ✅ Command-based smart reply system (like /hi, /help, /about, /time)
- ✅ Stores all messages securely in Firebase Firestore
- ✅ Professional and human-style responses
- ✅ Modular structure: Controller → Service → DTO
- ✅ Deployment-ready (tested on Render.com)

---

## 🧠 Available Commands

| Command         | Description                              |
|-----------------|------------------------------------------|
| `/hi` or `hi`     | Greet the user and show available commands |
| `/help` or `help` | List all commands and what they do       |
| `/about` or `about` | Information about the bot (Leo)          |
| `/time` or `time`   | Current server time (human-friendly)     |

---

## 📂 Project Structure

```
src/
 └── main/
     └── java/
         └── com.leo.whatsappbot/
              ├── controller/
              │    └── WebhookController.java
              ├── dto/
              │    └── MessageDTO.java
              ├── service/
              │    └── MessageService.java
              └── config/
                   └── FirebaseConfig.java
     └── resources/
         └── application.properties
         └── firebase-service-account.json (local only)

```

## 🛠️ Tech Stack
- Java 17
- Spring Boot 3.x
- Firebase Admin SDK
- Render Deployment
- Postman for testing
- GitHub for Version Control

---

## 📥 API Usage

### `POST /webhook`

Send a message to this endpoint using Postman or any client:

#### Sample Request:
```json
{
  "from": "918888888888",
  "message": "hi"
}
```

#### Sample Response:
```
Hey there! 👋 How can I assist you today?
```

---

## 🔐 Firebase Setup (for local run)

1. Create a Firebase project in [Firebase Console](https://console.firebase.google.com/)
2. Go to **Project Settings > Service Accounts**
3. Generate a private key (JSON)
4. Rename the file to:  
   `firebase-service-account.json`
5. Place it inside:  
   `src/main/resources/`

---

## 🌐 Live Deployment (Render)

🔗 Live URL
https://whatsapp-chatbot-b8pf.onrender.com/webhook

📦 GitHub Repository
https://github.com/Sidhant2104/whatsapp-chatbot-backend.git

🧪 Deployment Status

Working ✅ (Tested with Postman, returns correct responses via webhook)

---

## ⚠️ Meta API Info
> Tried setting up WhatsApp Business Cloud API but account got disabled during Meta business review stage. Backend system remains functional & ready to integrate once account is restored.

---

## ✨ Developed By

**Sidhant Singh (Leo)**  
Backend Developer | Java | Spring Boot  
📍 Ranchi, Jharkhand  
🌐 [GitHub Profile](https://github.com/Sidhant2104)  
🔗 [LinkedIn](www.linkedin.com/in/sidhant-singh-47198b2a6)

