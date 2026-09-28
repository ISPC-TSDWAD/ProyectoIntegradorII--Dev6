#!/bin/bash
echo "=== Ìºê TU RED ==="
echo "Tu IP:"
ipconfig | grep -i "IPv4"
echo ""
echo "WiFi cercanas:"
netsh wlan show networks
echo ""
echo "Puertos abiertos en tu PC:"
netstat -an | findstr LISTENING
