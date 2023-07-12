#!/bin/bash
psql -c 'create user postgres createdb' postgres
psql -c 'create database world;' -U postgres
psql -U postgres -d world -f /raw/data/world.sql
psql -d world -c "create type myenum as enum ('foo', 'bar')" -U postgres
psql -d world -c "create extension postgis" -U postgres
