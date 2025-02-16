# LumiMind(Mood Booster AI-Chatbot)

A real-time AI-powered chatbot built with Java Spring Boot. It integrates with the Ollama AI server, provides a web-based UI, and stores chat data in MySQL.

Prerequisites
	1.	Ollama: Download and install Ollama.
	2.	Java: JDK 11 or later installed.
	3.	MySQL: Set up a MySQL database.

Installation and Setup
1. Set Up Ollama
	1.	Download and install Ollama.
	2.	Run the following commands:
ollama pull mistral  
ollama serve  
This pulls the Mistral AI model and starts the server.

2. Set Up the Spring Boot Application
	1.	Clone the repository:
git clone https://github.com/your-repo-name.git  
cd your-repo-name  
	2.	Configure application.properties:
	•	MySQL Database:
spring.datasource.url=jdbc:mysql://localhost:3306/your_database  
spring.datasource.username=your_username  
spring.datasource.password=your_password  
	•	Ollama Server Endpoint (if different):
ollama.server.url=http://localhost:11434  
	3.	Build and run the application:
mvn clean install  
mvn spring-boot:run

3. Access the Chatbot
	1.	Open your browser and navigate to:
https://localhost:8080/chat  
	2.	Type your mood in the chat window, and the bot will respond.

4. View Saved Data in MySQL
	•	Chat data (mood and responses) is stored in MySQL.
	•	Use a database client or query directly:
SELECT * FROM chat_data;  

Features
	•	Real-Time Chat: Provides mood-based responses.
	•	Sentiment Analysis: Detects mood using AI for personalized interactions.
	•	Data Storage: Saves chat data for future use in MySQL.
