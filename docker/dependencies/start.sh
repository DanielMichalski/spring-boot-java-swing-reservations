#!/bin/bash

# This script can be used to rebuild a frontend project and refresh/restart the docker container in one go.
# Database will be dropped on each run of this script.

docker-compose rm -f -s -v
docker-compose build
docker-compose up -d
