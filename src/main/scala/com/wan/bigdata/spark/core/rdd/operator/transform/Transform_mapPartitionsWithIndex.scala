package com.wan.bigdata.spark.core.rdd.operator.transform

import org.apache.spark.{SparkConf, SparkContext}

/**
 * Author: wanyingfei
 * Date: 2022/5/24 02:18
 * Description:
 * Version: 1.0
 */
object Transform_mapPartitionsWithIndex {
  def main(args: Array[String]): Unit = {
    val sparkConf = new SparkConf().setMaster("local").setAppName("transform_mapPartitionsWithIndex")
    val sc = new SparkContext(sparkConf)

    val value = sc.makeRDD(List(1, 2, 3, 4, 5))
    value.mapPartitionsWithIndex((index, iterator) => {
      println("index:" + index)
      iterator.map(x => x + index)
    }).collect().foreach(println)

    sc.stop()
  }

}
