package movierating;

import org.apache.storm.topology.BasicOutputCollector;
import org.apache.storm.topology.OutputFieldsDeclarer;
import org.apache.storm.topology.base.BaseBasicBolt;
import org.apache.storm.tuple.Fields;
import org.apache.storm.tuple.Tuple;
import org.apache.storm.tuple.Values;

public class mapMovieRatingReduceColumnsBolt extends BaseBasicBolt {
    private String userId;
    private Integer movieId;
    private Integer rating;
    private String timespamp;

    @Override
    public void execute(Tuple input, BasicOutputCollector collector) {
        //implement transformation logic
        userId = input.getStringByField("user-id");
        movieId = input.getIntegerByField("movie-id");
        rating = input.getIntegerByField("rating");
        timespamp = input.getStringByField("timespamp");


        //toDo: emit message, use new Values(input.getInteger(0)) w/ comma separated list of strings
        collector.emit(new Values(movieId, 1));

    }

    @Override
    public void declareOutputFields(OutputFieldsDeclarer declarer) {
        //toDo: declare new Fields() w/ comma separated list of strings
        declarer.declare(new Fields("movie-id", "counter"));
    }
}
