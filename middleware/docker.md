# Docker Proxy 
at /etc/systemd/system/docker.service.d/http-proxy.conf or /etc/systemd/system/docker.service.d/https-proxy.conf
```
[Service]
Environment="HTTP_PROXY=http://10.23.28.130:8080/"
```

# Docker image location
/var/lib/docker/...

# Config file
https://docs.docker.com/engine/reference/commandline/dockerd/#daemon-configuration-file

# Commands
```
docker info

# remove container
docker rm <container-id>

# remove image
docker rmi <image-id>

# 
docker container run --it --rm --name xxx -p xxx:xxx -e xxx=xxx -d image
docker container logs image
docker container logs -f image

# for debug purpose to use the local files
docker container run --it --rm --name xxx -p xxx:xxx -e xxx=xxx -v $PWD:/app -d image

# attach to a container
docker container exec -it <container> bash

```
