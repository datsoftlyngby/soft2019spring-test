#!/bin/bash

echo "Maven.sh script executed..."

curl -v -u tomcatuser:tomcat1234 -T ./target/TestProjectCICD-1.0.war 'http://10.19.17.12:8080/manager/text/deploy?path=/TestProjectCICD&update=true'