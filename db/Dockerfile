# Use the latest MySQL image
FROM mysql
COPY world.sql /docker-entrypoint-initdb.d
ENV MYSQL_ROOT_PASSWORD group2

# Or pull kevinsim/world and start container with options -e MYSQL_ROOT_PASSWORD=example -p 33060:3306