# Start in backend
redis-server /etc/redis/redis.conf

# Stop
redis-cli shutdown

# Scan all keys
redis-cli --scan --pattern '*'
