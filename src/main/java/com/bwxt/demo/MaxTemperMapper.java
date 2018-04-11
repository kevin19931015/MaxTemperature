package com.bwxt.demo;


import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

import java.io.IOException;

public class MaxTemperMapper extends  Mapper<LongWritable,Text,Text,IntWritable> {
    private static final int MISSING =9999;

    public void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException {
        String line = value.toString();
        String year = line.substring(15,19);
        int temperature;
        if (line.substring(87,88)=="+"){
            temperature = Integer.parseInt(line.substring(88,92));
        }else{
            temperature = Integer.parseInt(line.substring(87,92));
        }
        String quality = line.substring(92,93);
        if(temperature!=MISSING&&quality.matches("[01459]")){
            context.write(new Text(year),new IntWritable(temperature));
        }
    }
}
