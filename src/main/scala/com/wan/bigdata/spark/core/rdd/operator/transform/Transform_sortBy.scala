package com.wan.bigdata.spark.core.rdd.operator.transform

import org.apache.spark.{SparkConf, SparkContext}

/**
 * Author: wanyingfei
 * Date: 2022/5/30 19:34
 * Description:
 * Version: 1.0
 */
object Transform_sortBy {
  def main(args: Array[String]): Unit = {
    val sparkConf = new SparkConf().setMaster("local[*]").setAppName("transform_sortBy")
    val sc = new SparkContext(sparkConf)

    val rdd = sc.makeRDD(List(1, 2, 3, 4, 5, 6, 7, 8, 9),2)
    val value = rdd.sortBy(num => num)

    value.collect().foreach(println)

    sc.stop()

  }
}
