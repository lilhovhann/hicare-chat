#!/usr/bin/env bash
docker rm -f $(docker ps -a -q)
#docker rmi $(docker images -a -q)
docker rmi $(docker images | grep "^<none>" | awk "{print $3}")
docker rmi $(docker images | grep "axele" | awk "{print $3}")

docker images

# clean all target folders from PC
#sudo find . -type d -name target -prune -exec rm -r {} +
