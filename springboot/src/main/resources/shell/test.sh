#!/usr/bin/env bash

ssh root@centos-200 <<eeooff
    ps -ef | grep fdfs
    exit

eeooff
exit 0