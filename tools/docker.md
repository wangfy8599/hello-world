# commands
```
# list docker images
docker images

# create a docker image
docker build . -f ./Dockerfile -t <my-app-name>

# remove images
docker rmi <image_id>
docker image rm <image_id>

# Remove all dangling images. If -a is specified, will also remove all images not referenced by any container. 
docker image prune

# run a new container from image
docker run -it <image_id> bash

# remove the container after it exits
docker run -it --rm <image_id> bash

# define an environment variable
docker run -it --rm -e KEY_1=2 <image_id> bash

# mapping a directory to container
docker run -it --rm -v /home/...:/host_dir <image_id> bash

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

# Best Prictise
## Don't fetch dependencies on docker start. They should be included in images.
