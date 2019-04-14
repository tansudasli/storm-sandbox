package movie;

import org.apache.storm.spout.SpoutOutputCollector;
import org.apache.storm.task.TopologyContext;
import org.apache.storm.topology.OutputFieldsDeclarer;
import org.apache.storm.topology.base.BaseRichSpout;
import org.apache.storm.tuple.Fields;
import org.apache.storm.tuple.Values;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Map;

import static java.nio.charset.StandardCharsets.ISO_8859_1;
import static java.nio.charset.StandardCharsets.UTF_8;

public class fileReaderMovieSpout extends BaseRichSpout {

    private SpoutOutputCollector collector;
    private String movieFilePath;
    private List<String> lines;

    @Override
    public void open(Map conf, TopologyContext context, SpoutOutputCollector collector) {
        this.collector = collector;

        movieFilePath = conf.get("movieFilePath").toString();

        //Step -1 : read file as lines
        try {
           lines = Files.readAllLines(Paths.get(movieFilePath), ISO_8859_1);


        } catch (IOException e) {
            System.out.println("Error reading file\n");
            System.out.println(Paths.get(movieFilePath).toAbsolutePath());
            e.printStackTrace();
        }

    }

    @Override
    public void nextTuple() {

        /**Data structure for movies
         * movie-id|movie-name|movie-date|imdb-url|0|0|0|1|1|1|0|0|0|0|0|0|0|0|0|0|0|0|0
         */

        //Step -2 : emit message, use new Values() w/ comma separated list of strings
        for (String line : lines)
            this.collector.emit(new Values(line.split("|")));

    }

    @Override
    public void declareOutputFields(OutputFieldsDeclarer declarer) {

        //Step -3: declare new Fields() w/ comma separated list of strings
        declarer.declare(new Fields("movie-id","movie-name","movie-date","imdb-url","genreArray"));

    }
}
