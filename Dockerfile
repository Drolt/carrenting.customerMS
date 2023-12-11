FROM mariadb:latest

ENV MARIADB_ROOT_PASSWORD=password
ENV MARIADB_DATABASE=Customers

ADD setup.sql /docker-entrypoint-initdb.d/