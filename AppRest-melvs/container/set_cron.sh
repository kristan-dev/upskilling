#!/bin/sh

PWD="/usr/app"
APP=rest_client_utility.jar
URL="${#}"


if [[ "${URL}" -lt 1 ]]
then
	echo "RUN with: ${0} [http://localhost:8080/endpoint]"
	exit 1
fi


echo "*       *       *       *       *       java -jar ${PWD}/${APP} ${1} >> /var/log/url.log 2>&1" >> /var/spool/cron/crontabs/root
