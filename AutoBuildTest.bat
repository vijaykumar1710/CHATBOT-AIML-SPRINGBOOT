@echo off

echo -------------------------------------------
echo               simian report
echo -------------------------------------------
java -jar .\lib\simian.jar -threshold=3 .\src\**\*.java -excludes=**\*Test.java
echo -------------------------------------------
call mvn clean
call mvn install
start /min "" .\target\jacoco-ut\index.html
echo press Ctrl + c to stop the server

call mvn spring-boot:run
pause
