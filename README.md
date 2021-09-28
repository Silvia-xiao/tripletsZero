# tripletsZero

This project uses Springboot to perform a triplets zero service. It can receive a series of numbers and return all unique triplets that sum to zero.

## Project introduction
### Structure
* SpringBoot
  * Calculation RESTful Controller
  * Calculation Service
  * Unit Test Class
  
## Usage
### POST Data
* POST action needs to be tested through PostMan or other applications.
  * Example request body:
    * [1, 4, 3, 0, -1, -1, 2]

## Unit tests
* Calculation controller test
  * Valid request body - expect status: 200
  * Invalid request body - expect status: 400
* Calculation service test
  * Different scenarios on testing performCalculation and tripletsZero funtions
