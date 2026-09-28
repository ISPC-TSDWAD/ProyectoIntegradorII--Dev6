#!/bin/bash
echo "=== HASH LAB ==="
read -p "Texto: " txt
echo -n "$txt" | md5sum
echo -n "$txt" | sha256sum
echo -n "$txt" | base64
echo ""
