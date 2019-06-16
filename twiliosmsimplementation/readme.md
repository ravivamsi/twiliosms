# Twilio SMS Implementation


## Maven

### Build

```terminal 
twiliosmsimplementation $ mvn clean install
```

### Run

```terminal
twiliosmsimplementation $java -jar target/sendsms-0.0.1-SNAPSHOT.war
```

## API 

Method: POST
Endpoint: http://localhost:8080/sms/send  

## Request Body

```json
{
	"accountsid": "<accountsid>",
	"authtoken": "<authtoken>",
	"from": "+18572565048",
	"to": "+18572056865"
}
```


