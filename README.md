# Programming-Exercise-alaTest

## Problem
```
$ https://docs.google.com/document/d/1t8BSicFnJellmzg2tBNoAL4hoes3hkyBljowWbBeVrg/editst
```


## Convention of configuration files
```
$ drop all csv files into directory /alaTest/src/main/resources
$ for example /alaTest/src/main/resources
                                      |- Operator A.csv
                                      |- Operator B.csv

```


## Example of csv file format
```
$ 1,0.9
$ 268,5.1
$ 46,0.17
$ 4620,0.0
$ 468,0.15
$ 4631,0.15
$ 4673,0.9
$ 46732,1.1
$ <prefix>,<price>

```

## Setup Environment
```
$ [install java8](https://askubuntu.com/questions/464755/how-to-install-openjdk-8-on-14-04-lts)
$ install Apache Maven 3.6.0  
```

## How to make executable jar from this project?
```
$ git clone https://github.com/rai-prashanna/Programming-Exercise-alaTest
$ cd Programming-Exercise-alaTest/alaTest/
$ mvn clean install 
$ cd target
$ your executable jar file is TelephoneCallRouter-jar-with-dependencies.jar
```

## How to run executable jar ?
```
$ goto directory containing executable jar file
$ java -jar TelephoneCallRouter-jar-with-dependencies.jar <phoneNumber>
```
![alt text](https://github.com/rai-prashanna/Programming-Exercise-alaTest/blob/master/output.png)
