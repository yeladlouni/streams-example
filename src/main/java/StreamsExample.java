import org.apache.avro.generic.GenericRecord;
import org.apache.kafka.streams.StreamsBuilder;
import org.apache.kafka.streams.Topology;
import org.apache.kafka.streams.kstream.KStream;
import org.apache.kafka.streams.kstream.Materialized;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;
import java.util.stream.Stream;

public class StreamsExample {
    public StreamsExample() {
        StreamsBuilder streamsBuilder = new StreamsBuilder();
        KStream<String, GenericRecord> stream = streamsBuilder.stream("customers");
        stream.groupByKey()
                .count(Materialized.as("count-store"))
                .toStream()
                .to("output-customers");

    }

    public static void main(String[] args) {
        new StreamsExample();
    }
}
