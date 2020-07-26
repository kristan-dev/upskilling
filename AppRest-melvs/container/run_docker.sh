#!/bin/bash

docker build -t melbsmelbs/mavenalpine:latest .

docker run -d -p 8080:8080 --name maven-alpine melbsmelbs/mavenalpine

