#!/bin/bash

# This script can be used to rebuild a reservations project and refresh/restart the docker container in one go
# This script should preserve your database

docker-compose build
docker-compose up -d
