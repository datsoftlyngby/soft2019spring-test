#!/bin/bash

echo "DigitalOcean.sh script executed..."

mkdir -p testfolder

touch "testfolder/logfile$(date +%Y%m%d_%H%M%S)"

#$0 = bash
#$1 = TOMCAT_USERNAME
#$2 = TOMCAT_PASSWORD

curl -v -u $1:$2 -T ~/testfolder/TestProjectCICD.war 'http://localhost:8080/manager/text/deploy?path=/TestProjectCICD&update=true'