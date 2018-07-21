@echo off
color 0a
prompt Rex:$g 
REM runs only if javac command is added to the path variable
:label
cls
javac Vote.java
java rex.vote.Vote
pause
goto label