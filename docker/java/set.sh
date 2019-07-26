#!/bin/bash
echo "test"
while !nc -z ${ip} ${sqlport}; do sleep 3; done
echo "${ip}:${sqlport}"
CHCP 65001
java -jar javaTest4.jar
