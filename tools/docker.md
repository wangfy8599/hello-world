docker images

# run a new container from image
docker run -it <image_id> bash

## remove the container after it exits
docker run -it --rm image_id> bash

# list all containers
docker ps -a

# convert a container into image
docker commit <container_id> <image_name>

