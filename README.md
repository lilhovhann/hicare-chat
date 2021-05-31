# Telegram Bot: Spring boot application with MongoDB

Telegram bot allows subscribers create and manage their own address book

## Actions

**1. /help** - shows all available commands<br><br>
![image](https://user-images.githubusercontent.com/58720754/119659228-06216100-be3f-11eb-8487-c181f222e85d.png)

**2. /register** - registers new user with chat ID<br>
**3. /login** - logins the user with chat ID<br><br>
![image](https://user-images.githubusercontent.com/58720754/119660249-1554de80-be40-11eb-93dc-20a584be2cba.png)

**3. /contact create firstname lastname phone zoomID** - creates new contact<br><br>
![image](https://user-images.githubusercontent.com/58720754/119660629-87c5be80-be40-11eb-87c5-852f5ae93f3a.png)

**4. /contact all**  - shows all contacts that you've created<br><br>
![image](https://user-images.githubusercontent.com/58720754/119660836-bcd21100-be40-11eb-8fd2-ec56bbad0f65.png)

**5. /contact update email contactId email** - updates email of that contact <br><br>
![image](https://user-images.githubusercontent.com/58720754/119661275-2d792d80-be41-11eb-9d0a-e449fd1e8cb0.png)

**6. /contact update zoom contactId zoomID** - updates zoom of that contact <br><br>
![image](https://user-images.githubusercontent.com/58720754/119661396-513c7380-be41-11eb-880d-2ecc29338e4c.png)

**7. /contact delete contactID** - deletes that contact<br><br>
![image](https://user-images.githubusercontent.com/58720754/119661557-77621380-be41-11eb-8dea-007953238358.png)

**8. /contact search firstname lastname** -  searches by name of contact
![image](https://user-images.githubusercontent.com/58720754/119661737-a5dfee80-be41-11eb-93d0-c024081528a8.png)


# How to run

### Run with docker with typing this command in terminal

       sudo docker-compose  up -d --build 

### See the output logs with running this script

       sudo ./look.sh addressbook

### Clean docker containers with running this script

     sudo ./clean.sh 
     
### Restart the application with running this script     
      sudo ./restart.sh addressbook

# Telegram bot token

Generate your own bot token with @BotFather (search this in telegram) and put it in Bot.java file
**/newbot**
![image](https://user-images.githubusercontent.com/58720754/119662742-c3fa1e80-be42-11eb-9490-201e07695f67.png)


