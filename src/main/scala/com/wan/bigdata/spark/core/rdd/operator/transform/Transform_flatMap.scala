package com.wan.bigdata.spark.core.rdd.operator.transform

import org.apache.spark.{SparkConf, SparkContext}

/**
 * Author: wanyingfei
 * Date: 2022/5/24 16:05
 * Description:
 * Version: 1.0
 */
object Transform_flatMap {
  def main(args: Array[String]): Unit = {
    val sparkConf = new SparkConf().setMaster("local[*]").setAppName("transform_flatMap")
    val sc = new SparkContext(sparkConf)

    val rdd = sc.parallelize(List(List(1, 2, 3), List(4, 5, 6), List(7, 8, 9)))
    val value = rdd.flatMap(
      list => {
        list
      }
    )

    val rdd2 = sc.makeRDD(List("hi his", "hello spark"))
    val value1 = rdd2.flatMap(_.split(" "))

    value.collect().foreach(println)
    value1.collect().foreach(println)
    sc.stop()
  }
}
