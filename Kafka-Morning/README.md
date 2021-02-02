# Spring-AU-21-Assignment Question
Kafka Assignment:

1. Copy the messages from one topic to another:
a) Using Spring Boot, create a topic “BeforePass”.
b) Whenever a new messages arrives in “BeforePass” topic, it has to be
passed to another topic “AfterPass”
c) Attach the program and screenshot of “BeforePass” producer window
and “AfterPass” consumer window.


2. Setup a Kafka-Connect Data Pipeline to migrate the data from one bucket
to another. Below are the steps to be followed:
a) In Couchbase, import “travel-sample” bucket.And create a new bucket
“data”. travel-sample -&gt; “data”
b) Please find the Kafka-Connect jar in the Materials
c) Place the “connectconfig” folder inside C:/stateful/kafka_2.11-2.1.0 in
your local machine and place “kafka-connect-couchbase-3.4.8.jar” in
the libs folder
d) Modify the topic name as “KafkaDemo” in the source &amp; sink
connectors.
e) Change the connector name, bucket name &amp; credentials in source &amp;
sink properties files accordingly.
f) Run the below command from bin directory:
connect-standalone.bat ../../config/connect-standalone.properties
../../connectconfig/source.properties ../../connectconfig/sink.properties
g) You can see the messages flowing to the data (new bucket).
h) Attach the screenshot of the connector status and couchbase bucket
status, once counts are matched.