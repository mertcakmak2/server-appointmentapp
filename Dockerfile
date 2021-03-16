#JDK kurulumunu yapıyoruz
FROM openjdk:11

#Projemizin olduğu yeri gösteriyoruz ve kopyalıyoruz
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} springbootdockerapplication.jar

#Çalışacağı portu belirliyoruz
EXPOSE 5000

#Projemizi calistıracak komutu yazıyoruz.
ENTRYPOINT ["java","-jar","/springbootdockerapplication.jar"]