# Docker Proxy at /etc/systemd/system/docker.service.d/http-proxy.conf or /etc/systemd/system/docker.service.d/https-proxy.conf
```
[Service]
Environment="HTTP_PROXY=http://10.23.28.130:8080/"
```