#!/bin/bash

BIN="$(cd "$(dirname "$0")" ; pwd)"
PROJECT="$(dirname "${BIN}")"

source "${BIN}/settings-local.sh"

docker run --rm -ti \
    -v "${STACK}_axon-data:/opt/axonframework/data" \
    -v "${PROJECT}:${PROJECT}" -w '/opt/axonframework/data' \
    alpine:latest /bin/sh -c "tar -cvzf - . > '${PROJECT}/data/backup.tar.gz'"
