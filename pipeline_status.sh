#!/bin/zsh

FILE=README.md

echo "# Pipeline status" > $FILE
echo "Component | Build | Test | Repo " >> $FILE
echo "|:-----|:-------|:-----|:-----" >> $FILE

while IFS='|' read -r line; do
  arrIN=(${(s[;])line})
  REPO=${arrIN[1]}
  ALUMNO=${arrIN[2]}

  BADGE="[![Build](https://github.com/${REPO}/dsy1103-for-books/actions/workflows/build.yml/badge.svg)](https://github.com/${REPO}/dsy1103-for-books/actions/workflows/build.yml)"
  BADGE_PRUEBAS="[![Build](https://github.com/${REPO}/dsy1103-for-books/actions/workflows/tests.yml/badge.svg)](https://github.com/${REPO}/dsy1103-for-books/actions/workflows/tests.yml)"
  echo "|${ALUMNO}|${BADGE}|${BADGE_PRUEBAS}|[${REPO}](https://github.com/${REPO}/dsy1103-for-books)" >> $FILE

  BADGE="[![Build](https://github.com/${REPO}/dsy1103-for-loans/actions/workflows/build.yml/badge.svg)](https://github.com/${REPO}/dsy1103-for-loans/actions/workflows/build.yml)"
  BADGE_PRUEBAS="[![Build](https://github.com/${REPO}/dsy1103-for-loans/actions/workflows/tests.yml/badge.svg)](https://github.com/${REPO}/dsy1103-for-loans/actions/workflows/tests.yml)"
  echo "|${ALUMNO}|${BADGE}|${BADGE_PRUEBAS}|[${REPO}](https://github.com/${REPO}/dsy1103-for-loans)" >> $FILE

  BADGE="[![Build](https://github.com/${REPO}/dsy1103-for-users/actions/workflows/build.yml/badge.svg)](https://github.com/${REPO}/dsy1103-for-users/actions/workflows/build.yml)"
  BADGE_PRUEBAS="[![Build](https://github.com/${REPO}/dsy1103-for-users/actions/workflows/tests.yml/badge.svg)](https://github.com/${REPO}/dsy1103-for-users/actions/workflows/tests.yml)"
  echo "|${ALUMNO}|${BADGE}|${BADGE_PRUEBAS}|[${REPO}](https://github.com/${REPO}/dsy1103-for-users)" >> $FILE

done < grupos.txt

