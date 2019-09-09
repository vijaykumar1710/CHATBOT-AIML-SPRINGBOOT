# CHATBOT-AIML-SPRINGBOOT
# PMS suggesting ChatBot

We'll look at a ChatBot that will suggest a PMS (Patient Monetoring System). It can be integrated in a web application with Java. Chatbot collects the preferences from customer and based on the customer preferences, It suggests the appropriate product. This Project is built on Spring Boot and AIML. This is a FOSS project and open for contributions. So expect more features to come soon.

## Framework and Libraries
- [AIML- Artificial Intelligence Markup Language](http://www.aiml.foundation/doc.html)
- [Spring Boot](https://spring.io/projects/spring-boot)

### What is AIML
Lets talk about AIML. AIML stands for Artificial Intelligence Markup Language. AIML was developed by the Alicebot free software community and Dr. Richard S. Wallace during 1995-2000. AIML is used to create or customize Alicebot which is a chat-box application based on A.L.I.C.E. (Artificial Linguistic Internet Computer Entity) free software.

<aiml version = "1.0.1" encoding = "UTF-8"?> </br>
   <category></br>
      <pattern> HELLO ALICE </pattern></br>
      <template>Hello User!</template></br>
   </category></br>
</aiml>
    
## Flow of control

* 1. COLLECTING USER DETAILS
* 2. CHATTING WITH BOT
* 3. PRODUCT SUGGESTION
* 4. DATA OF THE USER AND CHAT STORIN IN DATA.CSV FILE For the use of SALES SERVICES.

In the project first we collect the user data and then user enters the ChatBot. ChatBot asks the product related questions and collects the answers from user. Where all the user preferences(JSONObject) for the product are compared to the existing products(JSONArray) and the most matching product is suggested. At the end depending on users interest of contacting the salesperson, SalesService interface is provided by storing the user data and user preferences in the data.csv and data from the DB Is deleted or retained.

## Standards SET for the project :

* Code Coverage : 75% ( JUNIT test cases are run to prove)
* Size of a function : limited by SonarLint
* Cyclomatic Complexity : 4
* Duplication : 0 (Threshold = 3)

## Ease of update or modifications :

### During modification : 
No major changes in the existing code are required. As We have tried to fulfill the Single Responsibility. 


### During update : 
Database should not be effected.(Should Follow previous tables schema). If Database is changing. Please change carefully all the effecting DAO classes. All new functionalities can be implemented without changing existing code.


## Database
- [SQL Database](https://www.mysql.com/)

Setting up Chatbot
-----------------------------

Being a Spring Boot application. Its very easy to deploy this project. Go to the github [repo](https://github.com/vijaykumar1710/CHATBOT-AIML-SPRINGBOOT).
Download the .zip file, extract it and import the extracted folder into your Eclipse. There is `pom.xml` in the project. Open that file into your eclipse. Right click on any blank area and click `Maven Install` from the drop down list. Done.!!
