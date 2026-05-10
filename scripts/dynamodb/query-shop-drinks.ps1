aws dynamodb query `
  --table-name BobaBestiary `
  --key-condition-expression "PK = :pk AND begins_with(SK, :sk)" `
  --expression-attribute-values '{":pk":{"S":"SHOP#feng-cha"},":sk":{"S":"DRINK#"}}' `
  --endpoint-url http://localhost:8000 `
  --profile boba-local