# Prime Number API

API which returns the list of primes for the given number

## Installation
Pull the git project from this git repo and run maven command to buid the jar

```bash
mvn clean install
```

## Usage

1. Run the Spring Boot Application

``` bash
java -jar primenumber-0.0.1-SNAPSHOT.jar
```

2. Send a GET request 

    a. (using curl) ` curl  "http://localhost:8080/api/primeNumbers?value=10" `
    
    b. through browser ` http://localhost:8080/api/primeNumbers?value=10`
    
    c. API will return with the JSON which contains the prime values
    
    ```json
   {
      "maxNumber": 10,
      "timestamp": "18-04-2021 06:31:45",
      "primeNumberList": [ 2, 3, 5, 7 ]
   }
    
    ```
