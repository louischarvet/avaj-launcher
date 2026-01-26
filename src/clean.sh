#!/bin/sh

find * -name  "*.class" > classes.txt
while IFS= read -r line; do
	rm -rf "$line"
done < classes.txt ;
rm -rf classes.txt sources.txt