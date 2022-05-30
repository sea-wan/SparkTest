package com.wan.bigdata.spark.core.rdd.operator.transform

import org.apache.spark.{SparkConf, SparkContext}

/**
 * Author: wanyingfei
 * Date: 2022/5/24 02:05
 * Description:
 * Version: 1.0
 */
object Transform_mapPartitions {
  def main(args: Array[String]): Unit = {
    val sparkConf = new SparkConf().setMaster("local").setAppName("transform_mapPartitions")
    val sc = new SparkContext(sparkConf)

    val rdd = sc.textFile("datas/Untitled Export.txt")
    val value = rdd.mapPartitions(
      a => {
        a.map(_ * 2)
      }
    )

    value.collect().foreach(println)
    sc.stop()
  }

}
