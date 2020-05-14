# Start in backend
change daemonize from no to yes in redis.conf  
`redis-server /etc/redis/redis.conf`

# Stop
`redis-cli shutdown`

# Scan all keys
`redis-cli --scan --pattern '*'`
