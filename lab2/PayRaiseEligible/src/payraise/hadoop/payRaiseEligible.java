package payraise.hadoop;

import java.io.IOException;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.Mapper;
import org.apache.hadoop.mapreduce.Reducer;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;
import org.apache.hadoop.util.GenericOptionsParser;

public class payRaiseEligible {
  public static class TokenizerMapper extends Mapper<Object, Text, Text, IntWritable> {
    
    private static final IntWritable one = new IntWritable(1);
       
    public void map(Object key, Text value, Mapper<Object, Text, Text, IntWritable>.Context context) throws IOException, InterruptedException {
      String line = value.toString();
      String[] employeeCount = line.split(",");
      context.write(new Text(employeeCount[5]), one);
    }
  }
  
  public static class IntSumReducer extends Reducer<Text, IntWritable, Text, IntWritable> {

    public void reduce(Text key, Iterable<IntWritable> values, Reducer<Text, IntWritable, Text, IntWritable>.Context context) throws IOException, InterruptedException {
      int eligibleCount = 0;
      for (IntWritable val : values) {
    	  eligibleCount += val.get(); 
      }
      context.write(key, new IntWritable(eligibleCount));
    }
  }
  
  public static void main(String[] args) throws Exception {
    Configuration conf = new Configuration();
    String[] otherArgs = (new GenericOptionsParser(conf, args)).getRemainingArgs();
    if (otherArgs.length < 2) {
      System.err.println("Usage: wordcount <in> [<in>...] <out>");
      System.exit(2);
    } 
    Job job = Job.getInstance(conf, "word count");
    job.setJarByClass(payRaiseEligible.class);
    job.setMapperClass(TokenizerMapper.class);
    job.setCombinerClass(IntSumReducer.class);
    job.setReducerClass(IntSumReducer.class);
    job.setOutputKeyClass(Text.class);
    job.setOutputValueClass(IntWritable.class);
    for (int i = 0; i < otherArgs.length - 1; i++)
      FileInputFormat.addInputPath(job, new Path(otherArgs[i])); 
    FileOutputFormat.setOutputPath(job, 
        new Path(otherArgs[otherArgs.length - 1]));
    System.exit(job.waitForCompletion(true) ? 0 : 1);
  }
}

