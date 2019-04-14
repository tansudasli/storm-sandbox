package movierating;

import org.apache.storm.task.TopologyContext;
import org.apache.storm.topology.BasicOutputCollector;
import org.apache.storm.topology.OutputFieldsDeclarer;
import org.apache.storm.topology.base.BaseBasicBolt;
import org.apache.storm.tuple.Fields;
import org.apache.storm.tuple.Tuple;
import org.apache.storm.tuple.Values;

import java.util.Map;

public class mapMovieRatingReduceSumColumnsBolt extends BaseBasicBolt {

    private String movieId;
    private Integer counter;


    @Override
    public void execute(Tuple input, BasicOutputCollector collector) {
        //implement transformation logic

        movieId = input.getStringByField("movie-id");
        counter = input.getIntegerByField("counter");

        //toDo: emit message, use new Values(input.getInteger(0)) w/ comma separated list of strings
        collector.emit(new Values(movieId, 1));

    }

    @Override
    public void declareOutputFields(OutputFieldsDeclarer declarer) {
        //toDo: declare new Fields() w/ comma separated list of strings
        declarer.declare(new Fields("movie-id", "sumCounter"));
    }

    @Override
    public void prepare(Map stormConf, TopologyContext context) {
        //generate a fileName to write for example
        super.prepare(stormConf, context);
    }
}
