#!/usr/bin/env bash
set -xeuo pipefail

docker run \
	-it --rm \
	-v "$PWD":/testapp \
	packsdkandroiddocker.image \
    sh -c "$@"