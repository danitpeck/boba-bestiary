aws dynamodb query `
  --table-name BobaBestiary `
  --index-name GSI1 `
  --key-condition-expression "GSI1PK = :pk" `
  --expression-attribute-values '{":pk":{"S":"SUMMON#YES"}}' `
  --endpoint-url http://localhost:8000 `
  --profile boba-local