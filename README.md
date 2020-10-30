#Parcel storage

## Installation
Checkout the project.

Install with Maven: mvn clean package

## Run
Navigate to target folder.

Run: java -jar bsc-test-1.0-SNAPSHOT.jar

Type "quit" to exit the application.

## Options
To initialize storage from a file, run the application with a parameter - absolute path to the initial file

example: java -jar bsc-test-1.0-SNAPSHOT.jar C:\work\bsc-test\src\main\resources\parcels.txt

Only .txt files are supported. Only the valid records will be placed into the storage, others will be skipped.

Valid parcel format is "[WEIGHT] [POSTAL_CODE]"

WEIGHT format: XX.XXX (3 decimal digits are required)

POSTAL_CODE format: exactly 5 digits

## Disclaimer
The application is not fully covered with tests due to a demonstrative purpose of the application. 
