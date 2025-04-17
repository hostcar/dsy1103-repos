#!/bin/zsh

PIPELINE_DIR=pipeline/uno/

if [ ! -d "alumnos" ]; then
    echo "alumnos does not exist."
    mkdir alumnos
  fi

while IFS='|' read -r line; do
  cd /Users/oscar/duocProjects/clases

  arrIN=(${(s[;])line})
  REPO=${arrIN[1]}
  echo "https://github.com/${REPO}/dsy1103-usuario"

  DIRECTORY=alumnos/$REPO
  if [ -d "$DIRECTORY" ]; then
    rm -R $DIRECTORY
    rmdir $DIRECTORY
  fi

  mkdir $DIRECTORY

  git clone git@github.com:${REPO}/dsy1103-usuario.git $DIRECTORY

  cp -R $PIPELINE_DIR $DIRECTORY

  cd $DIRECTORY

  pwd
  ls -l

  git add -A
  git commit -m "pipeline"
  git push origin main

done < repos.txt
