```
# list docker images
docker images

# create a docker image
docker build . -f ./Dockerfile -t <my-app-name>

# remove images
docker rmi <image_id>
docker image rm <image_id>

# run a new container from image
docker run -it <image_id> bash

# remove the container after it exits
docker run -it --rm image_id> bash

# list all containers
docker ps -a

# kill container
docker kill <container_id>

# remove container
docker rm <containter_id>

# convert a container into image
docker commit <container_id> <image_name>

# Execute a command in a running container
docker exec -it 
```
