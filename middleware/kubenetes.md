# Installation

1. Create /etc/yum.repos.d/kubernetes.repo with the following content.
```
[kubernetes]
name=Kubernetes
baseurl=https://packages.cloud.google.com/yum/repos/kubernetes-el7-x86_64
enabled=1
gpgcheck=1
repo_gpgcheck=1
gpgkey=https://packages.cloud.google.com/yum/doc/yum-key.gpg
        https://packages.cloud.google.com/yum/doc/rpm-package-key.gpg
```

2. Run the commands
```
yum install kubeadm docker -y
systemctl restart docker && systemctl enable docker
systemctl  restart kubelet && systemctl enable kubelet
```

3. Kubernetes Init
```
kubeadm init
```

If it is failed during pulling image, please add proxy to docker https://docs.docker.com/config/daemon/systemd/#httphttps-proxy
