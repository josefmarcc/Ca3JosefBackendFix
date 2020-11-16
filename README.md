[![Build Status](https://travis-ci.org/dahlfrederik/ca3_backend.svg?branch=main)](https://travis-ci.org/dahlfrederik/ca3_backend)

*This project is meant as start code for upcoming projects which will use an endomondo like structure"*

The projects will be using most of the following technologies:

- JPA and REST
- Testing, including database test
- Testing, including tests of REST-API's
- CI and CONTINUOUS DELIVERY

Remember to read the preconditions part before using this startcode. 

### HOW TO USE 
1. Open up the project in your IDE, refactor the project name and give a name that matches your new project.
2. Setup your travis pipeline (for automated test and deployment) 
3. Change remoteserver in  POM.xml file to asure you're using the correct server (all other dependencies is fixed). 
4. Make sure you have setup a database on the remote server in the docker-compose.yml file, so that you have a connection_str and password variables that matches the values on your online database. Likewise asure that you are using a database that exist and is created for the project you are supposed to be working on. 
5. Run a clean and build.
6. Run the setupUserTest to create users in the database on localhost.
**IMPORTANT** Delete the SetupTestUsers class or add it to .gitignore. THIS MUST NOT BE USED IN PRODUCTION. Remember that all passwords will be hashed using bCrypt for storing in the database.  
7. Setup your enitity classes (if you need data in your own database) by refactoring the renameMe enitity class. DO NOT TOUCH ROLE or USER if you want a login system. 
8. Create DTO's for your newly created enityclasses. The DTO can be designed to only contain the data that you want from your database and depending on what you want to be shown on the frontend, choose wisely. 
9. In the datafetcher class add the api's that you want to fetch from (since we are using a momondo like structure). Draw inspiration from the parallel fetching example shown in the startcode. You will also have to do step 10 for this to work. 
10. Create DTO's to store the fetched data in java objects. Again, you get to choose which data you want in the DTO so make your choice depending on what you want shown on the frontend. 
11. Create REST endpoints in the REST-package. These should be corresponding with what URL you want to fetch from. Remember, the notation on top of the REST functions determine which type of request you are making (GET POST PUT DELETE). 
12. Run the project from your choosen IDE, you are now ready to go to the frontend part of the project. 


### Preconditions
*In order to use this code, you should have a local developer setup + a "matching" droplet on Digital Ocean as described in the 3. semester guidelines* 
### Getting Started (documents from the teachers) 

This document explains how to setup the travis pipeline (build, test and deploy), locally with maven, and remotely with maven controlled by Travis. It does also contains links to setup a digitalocean droplet and the local test enviroment that is needed. 
 - [How to use](https://docs.google.com/document/d/1K6s6Tt65bzB8bCSE_NUE8alJrLRNTKCwax3GEm4OjOE/edit?usp=sharing)
