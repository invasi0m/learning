#!/bin/bash
/opt/ignite/apache-ignite/bin/sqlline.sh -u 'jdbc:ignite:thin://127.0.0.1/' --outputformat=vertical --run=/raw/data/world.sql
