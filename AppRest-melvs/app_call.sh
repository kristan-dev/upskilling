#!/bin/bash

APP=rest_client_utility.jar

read -p "Enter URL: " url
java -jar "${APP}" $url >> url.logs
