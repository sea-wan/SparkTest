package com.wan.bigdata.spark.core.rdd.operator.transform

import org.apache.spark.{SparkConf, SparkContext}

/**
 * Author: wanyingfei
 * Date: 2022/5/30 02:32
 * Description:
 * Version: 1.0
 */
object Transform_filter {
  def main(args: Array[String]): Unit = {
    val sparkConf = new SparkConf().setMaster("local[*]").setAppName("transform_filter")
    val sc = new SparkContext(sparkConf)

    val rdd = sc.makeRDD(List(1, 2, 3, 4, 5, 6))
    val value = rdd.filter(_ % 2 == 0)

    value.collect().foreach(println)
    sc.stop()
  }
}
