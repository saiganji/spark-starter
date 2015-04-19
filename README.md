# Spark Starter

Use this as a starter template for writing Spark applications.

## What's included

* `build.sbt` with required dependencies
* `assembly.sbt` link to assembly plugin
* `WordCount` spark application
* `WordCountSpec` test suite for Spark 

## Packaging the jar

You would need sbt installed on your system to build the application:

```
sbt package
```

## Packaging a uber-jar

To build an uber-jar:

```
sbt assembly
```

## Running the test suite

```
sbt test
```

## Running the application in local mode

```
spark-submit --class com.cloudwick.spark.WordCountRunner \
    --master "local[*]" \
    target/scala-2.10/spark-starter_2.10-1.0.jar \
    [input_path]
    [output_path]
```

## Running the application in the cluster

```
spark-submit --class com.cloudwick.spark.WordCountRunner \
    --master "local[*]" \
    [path_to_jar]/spark-starter_2.10-1.0.jar \
    [input_path]
    [output_path]
```

> Assuming you have copied the jar file to the gateway node from where you will be submitting the spark job from.