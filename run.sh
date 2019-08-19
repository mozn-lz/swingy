#!/bin/bash

mvn clean package

clear

java -cp target/swingy-1.0-SNAPSHOT.jar za.wethinkcode.swingy.App


