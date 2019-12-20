import org.datavec.api.records.reader.impl.csv.CSVRecordReader;
import org.datavec.api.split.FileSplit;
import org.datavec.api.transform.analysis.DataAnalysis;
import org.datavec.api.transform.schema.Schema;
import org.datavec.spark.transform.AnalyzeSpark;


import java.io.File;
import java.io.IOException;
import java.util.Random;

public class arm {
    public static void start() throws IOException, InterruptedException {
        Random random = new Random();
        random.setSeed(0xC0FFEE);
        FileSplit inputSplit = new FileSplit(new File("C:/Users/Christian/OneDrive - ZHAW/integration/Arbeit/Code/hs19-integration-ARM-TZb07/src/main/resources/sampleData/filtered/combing/trainingData"), random);

        Schema schema = new Schema.Builder()
                .addColumnsInteger("ID","X","Y","Z")
                .build();

        CSVRecordReader recordReader = new CSVRecordReader();
        recordReader.initialize(inputSplit);
        DataAnalysis analüysis = AnalyzeLocal.analyze(schema, recordReader);
    }
    public static void main(String args[]) throws IOException, InterruptedException {
        arm.start();
    }
}



