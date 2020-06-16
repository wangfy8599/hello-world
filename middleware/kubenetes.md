# Installation

## 1. Create /etc/yum.repos.d/kubernetes.repo with the following content.
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

## 2. Run the commands
```
yum install kubeadm docker -y
systemctl restart docker && systemctl enable docker
systemctl  restart kubelet && systemctl enable kubelet
```

## 3. Kubernetes Init
```
kubeadm init
```

If it is failed during pulling image, please add proxy to docker https://docs.docker.com/config/daemon/systemd/#httphttps-proxy
check proxy configuration
```
systemctl show --property Environment docker
```

## 4. Instal CNI
```
kubectl apply -f https://docs.projectcalico.org/manifests/calico.yaml
```
If installation fails on pull image, try to use the following command instead
```
docker pull calico/cni:v3.14.1
```
## Reference
https://www.linuxtechi.com/install-kubernetes-1-7-centos7-rhel7/

# Upgrade
```
# Get deployment
kubectl get deploy

# Set the new image to be deployed
kubectl set image deploy/<deployment-name> <deployment-name>=<new-image>

# Check rollout history
kubectl rollout history deploy

# Check rollout status
kubectl rollout status deploy/<deployment-name>

# Undo rollout / rollback
kubectl rollout undo deploy/<deployment-name>
```

# Run Command
```
kubectl exec -it <pod-name> -- /bin/sh
kubectl exec <pod-name> -- cat /etc/hosts
```

# Common Used
```
kubectl get nodes -o=wide
```

# PV
## create pv config file pv.yaml
```
apiVersion: v1
kind: PersistentVolume
metadata:
  name: task-pv-volume
  labels:
    type: local
spec:
  storageClassName: manual
  capacity:
    storage: 2Gi
  accessModes:
    - ReadWriteOnce
  hostPath:
    path: "/mnt/data"
```
# create pv
```
kubectl create -f pv.yaml
kubectl get pv
kubectl edit pv
```

## PVC
## create pv config file pvc.yaml
```
apiVersion: v1
kind: PersistentVolumeClaim
metadata:
  name: task-pv-claim
spec:
  storageClassName: manual
  accessModes:
    - ReadWriteOnce
  resources:
    requests:
      storage: 3Gi
```
```
kubectl create -f 
```

