#!/bin/bash
echo "=== Ì¥ê LAB CONTRASE√ëAS ==="
read -p "Escrib√≠ una contrase√±a: " pass
len=${#pass}

score=0
[[ $len -ge 8 ]] && ((score++))
[[ $pass =~ [A-Z] ]] && ((score++))
[[ $pass =~ [0-9] ]] && ((score++))
[[ $pass =~ [@#\$%^\&*] ]] && ((score++))

echo ""
if [ $score -le 1 ]; then echo "Ì¥¥ MUY DEBIL - Se hackea en 2 seg"
elif [ $score -eq 2 ]; then echo "Ìø† DEBIL - 5 horas"
elif [ $score -eq 3 ]; then echo "Ìø° MEDIA - 3 meses"
else echo "Ìø¢ FUERTE - 400 a√±os"
fi

echo "Generada segura: $(cat /dev/urandom | tr -dc 'A-Za-z0-9@#$%' | head -c 16)"
