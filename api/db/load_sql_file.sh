#!/bin/bash

set -e

DB_NAME=$1
SQL_FILE=$2

PGPASSWORD=postgres psql -U postgres -h localhost -d $DB_NAME -f ${SQL_FILE}
