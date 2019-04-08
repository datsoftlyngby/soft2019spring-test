#!/usr/bin/env bash

sudo apt-get update

echo "**********EXPORTING DEBIAN_FRONTEND**********"
export DEBIAN_FRONTEND="noninteractive";

echo "**********INSTALLING DEBCONF**********"
sudo apt-get install -y debconf-utils

echo "**********INSTALLING VIM**********"
sudo apt-get install -y vim

echo "**********INSTALLING CURL**********"
sudo apt-get install -y curl

echo "**********SETTING DEBCONF**********"
sudo debconf-set-selections <<< 'mysql-apt-config mysql-apt-config/select-server select mysql-8.0'
sudo debconf-set-selections <<< 'mysql-apt-config mysql-apt-config/select-product select Ok'
sudo debconf-set-selections <<< 'mysql-server mysql-server/root_password password root'
sudo debconf-set-selections <<< 'mysql-server mysql-server/root_password_again password root'
sudo debconf-set-selections <<< 'mysql-community-server mysql-community-server/root-pass password root'
sudo debconf-set-selections <<< 'mysql-community-server mysql-community-server/re-root-pass password root'

echo "**********GETTING DEBCONF**********"
sudo wget -c https://dev.mysql.com/get/mysql-apt-config_0.8.12-1_all.deb
sudo -E dpkg -i mysql-apt-config_0.8.12-1_all.deb

echo "**********UPDATING APT**********"
sudo apt-get update

echo "**********INSTALLING MYSQL**********"
sudo -E apt-get install -y mysql-server
sudo sed -i "s/^bind-address/#bind-address/" /etc/mysql/my.cnf
echo "bind-address = 127.0.0.1" | sudo tee -a /etc/mysql/conf.d/mysql.cnf

echo "**********INITIALIZING MYSQL**********"
sudo mysql -uroot -proot -e "CREATE USER 'mysqluser'@'localhost' IDENTIFIED BY 'mysql1234'; CREATE USER 'mysqluser'@'%' IDENTIFIED BY 'mysql1234'; GRANT ALL PRIVILEGES ON *.* TO 'mysqluser'@'localhost' WITH GRANT OPTION; GRANT ALL PRIVILEGES ON *.* TO 'mysqluser'@'%' WITH GRANT OPTION; FLUSH PRIVILEGES; SET GLOBAL max_connect_errors=10000; create database mysqldb;"

echo "**********RESTARTING MYSQL**********"
sudo service mysql restart

echo "**********INSTALLING OPENJDK**********"
sudo -E apt-get install -y openjdk-11-jdk

echo "**********INSTALLING TOMCAT**********"
sudo curl -O http://dk.mirrors.quenda.co/apache/tomcat/tomcat-9/v9.0.17/bin/apache-tomcat-9.0.17.tar.gz
sudo mkdir /opt/tomcat
sudo tar xzvf apache-tomcat-9*tar.gz -C /opt/tomcat --strip-components=1
sudo cp /vagrant/Tomcat9Files/context.xml /opt/tomcat/webapps/manager/META-INF/context.xml
sudo cp /vagrant/Tomcat9Files/context.xml /opt/tomcat/webapps/host-manager/META-INF/context.xml
sudo cp /vagrant/Tomcat9Files/tomcat-users.xml /opt/tomcat/conf/tomcat-users.xml
sudo cp /vagrant/Tomcat9Files/tomcat.service /etc/systemd/system/
sudo systemctl daemon-reload
sudo systemctl enable tomcat
sudo systemctl start tomcat

echo "root:vagrant1234" | sudo chpasswd

sudo useradd -m vagrantuser
echo "vagrantuser:vagrant1234" | sudo chpasswd