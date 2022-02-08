# Avro Extract

Curl Request

```
curl --location --request POST 'localhost:2602/demo/getFileContent' \
--header 'Content-Type: application/json' \
--data-raw '{	"schema": "{\"type\":\"record\",\"namespace\":\"com.surveyfunky\",\"name\":\"User\",\"fields\":[{\"name\":\"user_id\",\"type\":\"int\",\"doc\":\"Uniqueidentifieroftheuser\"},{\"name\":\"first_name\",\"type\":\"string\",\"doc\":\"FirstNameofUser\"},{\"name\":\"last_name\",\"type\":\"string\",\"doc\":\"LastNameofUser\"},{\"name\":\"created_date\",\"type\":[\"null\",{\"type\":\"string\",\"logicalType\":\"date\"}],\"doc\":\"Dateonwhichthisrecordiscreated\"},{\"name\":\"last_updated_time\",\"type\":[\"null\",{\"type\":\"string\",\"logicalType\":\"TimestampMillis\"}],\"doc\":\"Timestampwhenthisrecordwasmostrecentlyupdated\"},{\"name\":\"last_login\",\"type\":[\"null\",{\"type\":\"string\",\"logicalType\":\"TimestampMillis\"}],\"doc\":\"Timestampofthelatesttimetheuserhasloggedin\"}]}",	"schemaType": "AVRO"	}'
```

