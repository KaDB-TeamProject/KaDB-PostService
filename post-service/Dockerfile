FROM openjdk:17-jdk
EXPOSE 8080
ADD ./build/libs/*.jar post-service.jar
ENTRYPOINT ["java", "-jar", "-Duser.timezone=Asia/Seoul", "/post-service.jar"]