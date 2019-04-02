# kafka-design-patterns

Playgrounding with Kafka (and general application) design patterns


## Running

```sh
docker-compose up
```

## Services

|   Service     |   Port    |
|---            |---        |
|   api         |   8080    |
|   database    |   5432    |
|   ui          |   3000    |
|   kafka       |   9092    |

### Api

### Database

### UI

### Kafka

#### Topics

- source-topic
- success-topic

#### Using Kafkacat

Producing

```sh
kafkacat -P -b localhost:9092 -t <topic>
```

Consuming

```sh
kafkacat -C -b localhost:9092 -t <topic>
```