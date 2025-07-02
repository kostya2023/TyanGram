#!/bin/bash

while IFS=: read -r filepath rest; do
  # Проверяем, что файл существует
  if [[ -f "$filepath" ]]; then
    echo "→ Обрабатываю $filepath"

    # Применяем все замены в файле
    sed -i \
      -e 's/org\.telegram\.messenger/org.konstantin.tyangram/g' \
      -e 's/org_telegram_messenger/org_konstantin_tyangram/g' \
      -e 's/ORG_TELEGRAM_MESSENGER/ORG_KONSTANTIN_TYANGRAM/g' \
      -e 's/org\.telegram/org.konstantin/g' \
      -e 's/org_telegram/org_konstantin/g' \
      -e 's/ORG_TELEGRAM/ORG_KONSTANTIN/g' \
      "$filepath"
  else
    echo "⚠️  Пропускаю: файл '$filepath' не найден"
  fi
done < hell.txt
