# CRUD PROJECT 

  

This is the README for  

  

# murrderMystery 

  

## Contents 

  

1. Resources 

2. Brief 

3. Kanban Board 

4. Data Stack 

5. Front-end 

6. Testing 

7. Stretch Goals 

8. Author 

  

## Resources 

  

* Presentation [located here](https://1drv.ms/p/s!AiYMu6X1C5Xjiy0TPlep_ogTryL5?e=F30Fuu) 

* Jira Board [located here](https://democc.atlassian.net/jira/software/projects/MUR/boards/3/roadmap) 

  

## Brief 

  

To create a fully functional CRUD application encompassing a fully functional front end. The CRUD application will be biult utilising the supporting tools, methodologies, and technologies that encapsulate the concepts covered during the training. 

This project will involve concepts from all core training modules, specifically 

  

* Project Management (Kanban Board and Version COntrol) 

* Databases 

* JAVA 

* Spring Boot 

* HTML, CSS, and Javascript 

* Back-end testing (J-Unit and Mockito) 

  

## Kanban Board 

  

The Kanban board for this project is available [here](https://testjira1322.atlassian.net/jira/software/projects/ELB/boards/5). The software i used was Kanban board, i used a kanban template for my kanban board with additional features like sprint and prioity levels. 



![kanban](https://user-images.githubusercontent.com/86298594/127574706-c81197b3-7d4a-49bc-8279-5fdf85249101.png)

![kanban sprint](https://user-images.githubusercontent.com/86298594/127574833-2856b651-5c44-47e9-9c6b-1ee48e0d2b72.png)

## GitHub

i used GitHub as version control, this allowed me to create a multiple branches this allowed me to merge topic branches to Dev allowing me to check merge avalibilty to check that there was no conflics that could appear. After merding all topic branches i merged Dev to main without any issues as they would of appeared at previous merges. 

## Data Stack 

  

### Database 

For my projects i have used two databases.First is a local H2 console which was created purely for testing purposes with allowed me to drop the table inbetween testing meaning that it didnt matter what order i ran my tests in. The second database is my main MySQL database that is persistant allowing data to continue to be stored and is also populated though the front end code. 

  

### Backend 

  

My back-end is powered by Java using the Spring Boot Framework. This allows rapid and simple deployment of an integration structure between the database and conecting the front-end code. As well as the database logic, the backend recieves HTTP requests, and allows the front-end to access the database by sending requests and work with the data there. 

  

## Frontend 

  

The front end is powered by HTML, CSS and Javascript, utilising the CSS Bootstrap framework to fine tune the layout of the web page using columns and rows to provide a modal element to use with the update method in the application. HTML and CSS have been used to produce the look of the website and javascript has been used to send requests to java, to send data from and to the database allowing the user to populate the elements on the webpage. 

![front-end](https://user-images.githubusercontent.com/86298594/127574126-611f897e-384c-4183-a4fb-ca86eb7ed343.png)

![all my suspects](https://user-images.githubusercontent.com/86298594/127574323-c522403f-2984-4e1c-9841-847c06df2195.png)

![update](https://user-images.githubusercontent.com/86298594/127574378-a3e56f00-dab2-428d-b85d-c91c347492ef.png)

![updateCode](https://user-images.githubusercontent.com/86298594/127574639-bf40f6eb-51c2-4b0a-84aa-80c93c171167.png)

## Testing 

  

Extensive backend testing was carried out, including Integration testing and Mockito testing on all CRUD functionality and methods called in JAVA. This enabled the functionality in JAVA to be tested to make sure there are no possible errors in the backend. 

  

## Stretch Goals 

  

* Add more option to weapon and location options  

* Relocate the update section  

* Alerting the user when they try and search for the ID of a suspect that has been deleted 

* Allow the user to order all suspects depending on their suspect percentage 

  

## Author and Acknowledgements 

  

I would like to acknowledge the QA trainers in particular Jordan Harrison and Jordan Benbelaid for helping me with small errors that have appeared. I would also like to thank team one for keeping me company throughtout the project and making stressful times, when code goes wrong, into a fun experiance. 

  

Project by Charlotte Cartwright. 
