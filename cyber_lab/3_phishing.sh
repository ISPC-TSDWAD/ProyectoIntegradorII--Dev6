#!/bin/bash
echo "=== í¾£ DETECTOR PHISHING ==="
read -p "Pega el link: " url
peligro=0
[[ $url != *"https"* ]] && ((peligro+=2))
[[ $url == *"bit.ly"* || $url == *"tinyurl"* ]] && ((peligro+=2))
[[ $url == *"-"*"-"*"-"* ]] && ((peligro+=1))
[[ $url == *"@ "* || $url == *"@ "* ]] && ((peligro+=2))
[[ $url == *"login"* || $url == *"free"* ]] && ((peligro+=1))

if [ $peligro -ge 3 ]; then echo "íº¨ ALERTA PHISHING! NO ENTRES"
else echo "âœ… Parece seguro"; fi
