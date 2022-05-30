package com.wan.bigdata.spark.core.rdd.operator.transform

import org.apache.spark.{SparkConf, SparkContext}

/**
 * Author: wanyingfei
 * Date: 2022/5/30 19:34
 * Description:
 * Version: 1.0
 */
object Transform_sortBy_2 {
  def main(args: Array[String]): Unit = {
    val sparkConf = new SparkConf().setMaster("local[*]").setAppName("transform_sortBy2")
    val sc = new SparkContext(sparkConf)

    val rdd = sc.makeRDD(List(("44",1), ("11",2), ("66",3), ("99",4)),2)
    val value = rdd.sortBy(num => num._1.toInt,false)

    value.collect().foreach(println)

    sc.stop()

  }
}
