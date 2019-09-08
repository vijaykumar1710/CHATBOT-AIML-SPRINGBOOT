@echo off

echo -------------------------------------------
echo               simian report
echo -------------------------------------------
java -jar .\lib\simian.jar -threshold=3 .\src\**\*.java -excludes=**\*Test.java
echo -------------------------------------------
call mvn clean
call mvn install
pause
