#!/bin/zsh

FILE=README.md

echo "# Pipeline status" > $FILE
echo "Alumno | Status | Repo " >> $FILE
echo "|:-----|:-------|:-----" >> $FILE

while IFS='|' read -r line; do
  arrIN=(${(s[;])line})
  REPO=${arrIN[1]}
  ALUMNO=${arrIN[2]}

  BADGE="[![Compilacion](https://github.com/${REPO}/dsy1103-usuario/actions/workflows/compilacion.yml/badge.svg)](https://github.com/${REPO}/dsy1103-usuario/actions/workflows/compilacion.yml)"

  echo "${ALUMNO}|${BADGE}|[${REPO}](https://github.com/${REPO}/dsy1103-usuario)" >> $FILE

done < repos.txt

