#!/bin/bash
mysql -uroot "ALTER USER 'root'@'localhost' IDENTIFIED BY 'mysql';"
mysql -uroot -pmysql -e "CREATE DATABASE IF NOT EXISTS world;"
mysql -uroot -pmysql world < /raw/data/world.sql
