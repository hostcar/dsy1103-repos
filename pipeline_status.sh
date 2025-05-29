#!/bin/zsh

FILE=README.md

echo "# Pipeline status" > $FILE
echo "Biblioteca | Build | Test | Repo " >> $FILE
echo "|:-----|:-------|:-----|:-----" >> $FILE

while IFS='|' read -r line; do
  arrIN=(${(s[;])line})
  REPO=${arrIN[1]}
  ALUMNO=${arrIN[2]}

  BADGE="[![Build](https://github.com/${REPO}/dsy1103-salas-bibliotecas/actions/workflows/build.yml/badge.svg)](https://github.com/${REPO}/dsy1103-salas-bibliotecas/actions/workflows/build.yml)"
  BADGE_PRUEBAS="[![Build](https://github.com/${REPO}/dsy1103-salas-bibliotecas/actions/workflows/tests.yml/badge.svg)](https://github.com/${REPO}/dsy1103-salas-bibliotecas/actions/workflows/tests.yml)"

  echo "|${ALUMNO}|${BADGE}|${BADGE_PRUEBAS}|[${REPO}](https://github.com/${REPO}/dsy1103-salas-bibliotecas)" >> $FILE

done < repos.txt

