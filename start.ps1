Set-Location .\src
javac .\server_logic\Main.java -d ..\build
Set-Location ..

Set-Location build
java server_logic.Main
Set-Location ..