FROM eclipse-temurin:21
WORKDIR /app
COPY . /app
RUN javac -d out scr/*.java
RUN jar cfe app.jar scr.Server -C out .
EXPOSE 8080
CMD ["java", "-jar", "app.jar"]