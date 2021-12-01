FROM openjdk:8
ADD target/demospring-academic.jar demospring-academic.jar
ENTRYPOINT ["java","-jar","demospring-academic.jar"]