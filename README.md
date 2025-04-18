![Static Badge](https://img.shields.io/badge/java-21-brightgreen?style=flat&logoColor=red) ![Static Badge](https://img.shields.io/badge/springBoot-3.4.4.-brightgreen?style=flat&logoColor=red) ![Static Badge](https://img.shields.io/badge/spring.framework.boot-spring.boot.starter.data.jpa-brightgreen?style=flat&logoColor=red) ![Static Badge](https://img.shields.io/badge/spring.framework.boot-spring.boot.starter.web-brightgreen?style=flat&logoColor=red) ![Static Badge](https://img.shields.io/badge/org.postgresql-postgresql-brightgreen?style=flat&logoColor=red)
![Static Badge](https://img.shields.io/badge/org.projectlombok-lombok-brightgreen?style=flat&logoColor=red) ![Static Badge](https://img.shields.io/badge/org.springframework.boot-spring.boot.starter.test-brightgreen?style=flat&logoColor=red) ![Static Badge](https://img.shields.io/badge/maven-blue?style=flat&logoColor=red) ![Static Badge](https://img.shields.io/badge/postgresql-17-blue?style=flat&logoColor=red) ![Static Badge](https://img.shields.io/badge/jackson%20core-2.18.3-green)

## Description 
This microservice works together with remitly2 repository project as part of one application. The microservice is responsible for dowlnoading swift codes data from https://swiftcodefinder.org mapp them on java POJO and save them in PostgreSQL table if swiftcode does not exist in table. 
This operation will be executed every time service starts running and every 30 days after that. 

## How to Install and Run 
Downola Project and unpack.
Use Spring Boot to run application. You can use Visual Studio Code with Spring Boot Dashboard for VS Code extension or navigate to the root of the project via command line and execute the command mvn spring-boot:run.I presume you have maven installed and correctly added maven to your environment variable.
