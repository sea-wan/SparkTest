package com.wan.bigdata.spark.core.rdd.operator.transform

import org.apache.spark.{SparkConf, SparkContext}

/**
 * Author: wanyingfei
 * Date: 2022/5/30 01:45
 * Description:
 * Version: 1.0
 */
object Transform_groupBy_2 {
  def main(args: Array[String]): Unit = {
    val sparkConf = new SparkConf().setMaster("local[*]").setAppName("transform_groupBy_2")
    val sc = new SparkContext(sparkConf)

    val rdd = sc.makeRDD(List("Hello", "Spark", "Scala", "Hadoop"))
    val value = rdd.groupBy(_.charAt(0))

    value.collect().foreach(println)

    sc.stop()
  }
}
